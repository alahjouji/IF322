package tests;

import static fr.inria.phoenix.diasuite.framework.mocks.Mock.TIMEOUT;
import static fr.inria.phoenix.diasuite.framework.mocks.Mock.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import fr.inria.phoenix.diasuite.framework.datatype.contact.Contact;
import fr.inria.phoenix.diasuite.framework.datatype.state.State;
import fr.inria.phoenix.diasuite.framework.mocks.*;
import fr.inria.phoenix.scenario.cuisiniere.impl.ComponentBinder;
import fr.inria.phoenix.scenario.cuisiniere.impl.Configuration;

public class Test {

	@Before
	public void setUp() throws Exception {
		TIMEOUT = 10000;
		underTest(ComponentBinder.class);
	}

	@After
	public void tearDown() throws Exception {
		shutdown();
	}
	
	@org.junit.Test
	public void test() throws InterruptedException {
		MotionDetectorMock motion = mockMotionDetector("motion", "kitchen", "user");
		CookerMock cooker = mockCooker("cooker", "kitchen", "user");
		ElectricMeterMock elec = mockElectricMeter("electricMeter", "kitchen", "user");
		PrompterMock prompter = mockPrompter("tablette", "kitchen", "user");
		MessengerMock messenger = mockMessenger("tablette", "kitchen", "user");
		TimerMock timerAlert = mockTimer(Configuration.ID_TIMER_1);
		TimerMock timerWarn = mockTimer(Configuration.ID_TIMER_2);
		TimerMock timerCook = mockTimer(Configuration.ID_TIMER_3);
		TimerMock timerAlert2 = mockTimer(Configuration.ID_TIMER_4);

		State newMotionValue = new State("true", "", "");
		State newMotionValue1 = new State("false", "", "");
		motion.motion(newMotionValue);

		State newStatusValue = new State("On", "20", "");
		State newStatusValue1 = new State("Off", "20", "");
		elec.setCurrentElectricConsumption(newStatusValue);

		assertTrue(messenger.expectSendMessage(new Contact(), "", "veuillez chercher la tablette mobile pour renseigner le temps de cuisson"));
		assertTrue(timerAlert.expectSchedule(Configuration.ID_TIMER_1));
		assertTrue(prompter.expectAskOpenQuestion(new Contact(), "1", "", "temps de cuisson?"));

		motion.motion(newMotionValue1);

		prompter.setAnswer("1200000", "1");

	    timerAlert.timerTriggered(Configuration.ID_TIMER_1, Configuration.ID_TIMER_1);

		assertTrue(timerWarn.expectSchedule(Configuration.ID_TIMER_2));
		assertTrue(timerCook.expectSchedule(Configuration.ID_TIMER_3));

		timerWarn.timerTriggered(Configuration.ID_TIMER_2, Configuration.ID_TIMER_2);

		timerCook.timerTriggered(Configuration.ID_TIMER_3, Configuration.ID_TIMER_3);
		assertTrue(messenger.expectSendMessage(new Contact(), "", "le temps de cuisson sera epuisé dans "+String.valueOf(20*60/4)+"s, veillez à etteindre votre cuisiniere"));

		assertTrue(cooker.expectOff());
		elec.setCurrentElectricConsumption(newStatusValue1);
		motion.motion(newMotionValue);
		assertTrue(messenger.expectSendMessage(new Contact(), "", "la cuisiniere a ete eteinte automatiquement veuillez la remettre à 0 pour qu'on puisse la realimenter"));

		assertTrue(timerAlert2.expectSchedule(Configuration.ID_TIMER_4));
		
		timerAlert2.timerTriggered(Configuration.ID_TIMER_4, Configuration.ID_TIMER_4);
		
		assertTrue(cooker.expectOn());
	}

}
