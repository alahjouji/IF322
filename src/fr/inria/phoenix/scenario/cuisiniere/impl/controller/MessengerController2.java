package fr.inria.phoenix.scenario.cuisiniere.impl.controller;


import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.timercontext2.TimerContext2Value;
import fr.inria.phoenix.diasuite.framework.controller.messengercontroller2.AbstractMessengerController2;
import fr.inria.phoenix.diasuite.framework.datatype.contact.Contact;

public class MessengerController2 extends AbstractMessengerController2 {

	public MessengerController2(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onTimerContext2(TimerContext2Value timerContext2, DiscoverForTimerContext2 discover) {
		// TODO Auto-generated method stub
		DiaLog.info("MessengerController2");
		discover.messengers().anyOne().sendMessage(new Contact(), "", "le temps de cuisson sera epuise dans "+String.valueOf(Integer.parseInt(timerContext2.value())/4000)+"s, veillez a etteindre votre cuisiniere", null);
	}

}
