package fr.inria.phoenix.scenario.cuisiniere.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.timercontext2.AbstractTimerContext2;
import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredFromTimer;
import fr.inria.phoenix.scenario.cuisiniere.impl.Configuration;

public class TimerContext2 extends AbstractTimerContext2 {

	public TimerContext2(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected TimerContext2ValuePublishable onTimerTriggeredFromTimer(TimerTriggeredFromTimer timerTriggeredFromTimer,
			DiscoverForTimerTriggeredFromTimer discover) {
		// TODO Auto-generated method stub
		if(timerTriggeredFromTimer.sender().id().equals(Configuration.ID_TIMER_2)){
			DiaLog.info("TimerContext2");
	
			if(discover.electricMeters().anyOne().getCurrentElectricConsumption().getState().equals("On")){
				DiaLog.info("TimerContext2: cooker still on");
				return new TimerContext2ValuePublishable(discover.prompterContext(),true);
			}
			DiaLog.info("TimerContext2: cooker off");
			return new TimerContext2ValuePublishable("", false);
		}else
			return new TimerContext2ValuePublishable("", false);
	}






}
