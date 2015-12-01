package fr.inria.phoenix.scenario.cuisiniere.impl.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.promptercontext.PrompterContextValue;
import fr.inria.phoenix.diasuite.framework.controller.cuisinierecontroller2.AbstractCuisiniereController2;
import fr.inria.phoenix.scenario.cuisiniere.impl.Configuration;

public class CuisiniereController2 extends AbstractCuisiniereController2 {

	public CuisiniereController2(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onPrompterContext(PrompterContextValue prompterContext, DiscoverForPrompterContext discover) {
		// TODO Auto-generated method stub
		DiaLog.info("CuisineController2");
		Integer a = Integer.parseInt(prompterContext.value())*3/4;
		discover.timers().whereId(Configuration.ID_TIMER_2).schedule(Configuration.ID_TIMER_2, a );

	}

}
