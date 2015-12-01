package fr.inria.phoenix.scenario.cuisiniere.impl;
        

import fr.inria.phoenix.diasuite.framework.context.cookercontext.AbstractCookerContext;
import fr.inria.phoenix.diasuite.framework.context.promptercontext.AbstractPrompterContext;
import fr.inria.phoenix.diasuite.framework.context.timercontext.AbstractTimerContext;
import fr.inria.phoenix.diasuite.framework.context.timercontext2.AbstractTimerContext2;
import fr.inria.phoenix.diasuite.framework.context.turnoncontext.AbstractTurnOnContext;
import fr.inria.phoenix.diasuite.framework.context.turnoncontext2.AbstractTurnOnContext2;
import fr.inria.phoenix.diasuite.framework.controller.cuisinierecontroller.AbstractCuisiniereController;
import fr.inria.phoenix.diasuite.framework.controller.cuisinierecontroller2.AbstractCuisiniereController2;
import fr.inria.phoenix.diasuite.framework.controller.messengercontroller.AbstractMessengerController;
import fr.inria.phoenix.diasuite.framework.controller.messengercontroller2.AbstractMessengerController2;
import fr.inria.phoenix.diasuite.framework.controller.offcontroller.AbstractOffController;
import fr.inria.phoenix.diasuite.framework.controller.turnoncontroller.AbstractTurnOnController;
import fr.inria.phoenix.diasuite.framework.controller.turnoncontroller2.AbstractTurnOnController2;
import fr.inria.phoenix.diasuite.framework.misc.AppComponentBinder;
import fr.inria.phoenix.scenario.cuisiniere.impl.context.CookerContext;
import fr.inria.phoenix.scenario.cuisiniere.impl.context.PrompterContext;
import fr.inria.phoenix.scenario.cuisiniere.impl.context.TimerContext;
import fr.inria.phoenix.scenario.cuisiniere.impl.context.TimerContext2;
import fr.inria.phoenix.scenario.cuisiniere.impl.context.TurnOnContext;
import fr.inria.phoenix.scenario.cuisiniere.impl.context.TurnOnContext2;
import fr.inria.phoenix.scenario.cuisiniere.impl.controller.CuisiniereController;
import fr.inria.phoenix.scenario.cuisiniere.impl.controller.CuisiniereController2;
import fr.inria.phoenix.scenario.cuisiniere.impl.controller.MessengerController;
import fr.inria.phoenix.scenario.cuisiniere.impl.controller.MessengerController2;
import fr.inria.phoenix.scenario.cuisiniere.impl.controller.OffController;
import fr.inria.phoenix.scenario.cuisiniere.impl.controller.TurnOnController;
import fr.inria.phoenix.scenario.cuisiniere.impl.controller.TurnOnController2;

/* (non-Javadoc)
 * The binder to provides the various components of the application
 * @see fr.inria.phoenix.diasuite.framework.misc.AppComponentBinder
 */
public class ComponentBinder extends AppComponentBinder {

	@Override
	public Class<? extends AbstractCookerContext> getCookerContextClass() {
		// TODO Auto-generated method stub
		return CookerContext.class;
	}

	@Override
	public Class<? extends AbstractPrompterContext> getPrompterContextClass() {
		// TODO Auto-generated method stub
		return PrompterContext.class;
	}

	@Override
	public Class<? extends AbstractTimerContext> getTimerContextClass() {
		// TODO Auto-generated method stub
		return TimerContext.class;
	}

	@Override
	public Class<? extends AbstractCuisiniereController> getCuisiniereControllerClass() {
		// TODO Auto-generated method stub
		return CuisiniereController.class;
	}

	@Override
	public Class<? extends AbstractMessengerController> getMessengerControllerClass() {
		// TODO Auto-generated method stub
		return MessengerController.class;
	}

	@Override
	public Class<? extends AbstractOffController> getOffControllerClass() {
		// TODO Auto-generated method stub
		return OffController.class;
	}

	@Override
	public Class<? extends AbstractCuisiniereController2> getCuisiniereController2Class() {
		// TODO Auto-generated method stub
		return CuisiniereController2.class;
	}

	@Override
	public Class<? extends AbstractTimerContext2> getTimerContext2Class() {
		// TODO Auto-generated method stub
		return TimerContext2.class;
	}

	@Override
	public Class<? extends AbstractMessengerController2> getMessengerController2Class() {
		// TODO Auto-generated method stub
		return MessengerController2.class;
	}

	@Override
	public Class<? extends AbstractTurnOnContext> getTurnOnContextClass() {
		// TODO Auto-generated method stub
		return TurnOnContext.class;
	}

	@Override
	public Class<? extends AbstractTurnOnController> getTurnOnControllerClass() {
		// TODO Auto-generated method stub
		return TurnOnController.class;
	}

	@Override
	public Class<? extends AbstractTurnOnContext2> getTurnOnContext2Class() {
		// TODO Auto-generated method stub
		return TurnOnContext2.class;
	}

	@Override
	public Class<? extends AbstractTurnOnController2> getTurnOnController2Class() {
		// TODO Auto-generated method stub
		return TurnOnController2.class;
	}
}
