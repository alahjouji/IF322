package fr.inria.phoenix.scenario.cuisiniere.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.timercontext.AbstractTimerContext;
import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredFromTimer;
import fr.inria.phoenix.scenario.cuisiniere.impl.Configuration;

public class TimerContext extends AbstractTimerContext {

	public TimerContext(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected TimerContextValuePublishable onTimerTriggeredFromTimer(TimerTriggeredFromTimer timerTriggeredFromTimer,
			DiscoverForTimerTriggeredFromTimer discover) {
		// TODO Auto-generated method stub
		if(timerTriggeredFromTimer.sender().id().equals(Configuration.ID_TIMER_3)){
			DiaLog.info("TimerContext");
	
			if(discover.electricMeters().anyOne().getCurrentElectricConsumption().getState().equals("On")){
				DiaLog.info("TimerContext: cooker still on");
				return new TimerContextValuePublishable(true,true);
			}
			DiaLog.info("TimerContext: cooker off");
			return new TimerContextValuePublishable(false, false);
		}else
			return new TimerContextValuePublishable(false, false);
	}



}
