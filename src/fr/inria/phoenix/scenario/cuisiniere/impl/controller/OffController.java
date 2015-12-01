package fr.inria.phoenix.scenario.cuisiniere.impl.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.timercontext.TimerContextValue;
import fr.inria.phoenix.diasuite.framework.controller.offcontroller.AbstractOffController;

public class OffController extends AbstractOffController {

	public OffController(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onTimerContext(TimerContextValue timerContext, DiscoverForTimerContext discover) {
		// TODO Auto-generated method stub
		DiaLog.info("OffController");
		discover.cookers().anyOne().off();

	}

}
