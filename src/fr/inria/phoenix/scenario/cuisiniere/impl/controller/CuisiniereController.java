package fr.inria.phoenix.scenario.cuisiniere.impl.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.promptercontext.PrompterContextValue;
import fr.inria.phoenix.diasuite.framework.controller.cuisinierecontroller.AbstractCuisiniereController;
import fr.inria.phoenix.scenario.cuisiniere.impl.Configuration;

public class CuisiniereController extends AbstractCuisiniereController {

	public CuisiniereController(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onPrompterContext(PrompterContextValue prompterContext, DiscoverForPrompterContext discover) {
		// TODO Auto-generated method stub
		DiaLog.info("CuisineController");
		Integer a = Integer.parseInt(prompterContext.value())+120000;
		discover.timers().whereId(Configuration.ID_TIMER_3).schedule(Configuration.ID_TIMER_3, a );

	}

}
