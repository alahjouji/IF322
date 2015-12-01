package fr.inria.phoenix.scenario.cuisiniere.impl.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.turnoncontext2.TurnOnContext2Value;
import fr.inria.phoenix.diasuite.framework.controller.turnoncontroller2.AbstractTurnOnController2;

public class TurnOnController2 extends AbstractTurnOnController2 {

	public TurnOnController2(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onTurnOnContext2(TurnOnContext2Value turnOnContext2, DiscoverForTurnOnContext2 discover) {
		// TODO Auto-generated method stub
		DiaLog.info("TurnOnController2");
		discover.cookers().anyOne().on();
	}

}
