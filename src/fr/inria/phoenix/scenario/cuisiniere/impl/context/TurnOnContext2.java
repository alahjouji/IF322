package fr.inria.phoenix.scenario.cuisiniere.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.turnoncontext2.AbstractTurnOnContext2;
import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredFromTimer;
import fr.inria.phoenix.scenario.cuisiniere.impl.Configuration;

public class TurnOnContext2 extends AbstractTurnOnContext2 {

	public TurnOnContext2(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected TurnOnContext2ValuePublishable onTimerTriggeredFromTimer(TimerTriggeredFromTimer timerTriggeredFromTimer) {
		// TODO Auto-generated method stub
		if(timerTriggeredFromTimer.sender().id().equals(Configuration.ID_TIMER_4)){
			DiaLog.info("TurnOnContext2");
			return new TurnOnContext2ValuePublishable(true,true);
		}else
			return new TurnOnContext2ValuePublishable(false,false);
	}

}
