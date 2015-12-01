package fr.inria.phoenix.scenario.cuisiniere.impl.controller;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.turnoncontext.TurnOnContextValue;
import fr.inria.phoenix.diasuite.framework.controller.turnoncontroller.AbstractTurnOnController;
import fr.inria.phoenix.diasuite.framework.datatype.contact.Contact;
import fr.inria.phoenix.scenario.cuisiniere.impl.Configuration;

public class TurnOnController extends AbstractTurnOnController {

	public TurnOnController(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onTurnOnContext(TurnOnContextValue turnOnContext, DiscoverForTurnOnContext discover) {
		// TODO Auto-generated method stub
		DiaLog.info("TurnOnController");
		discover.messengers().anyOne().sendMessage(new Contact(), "", "la cuisiniere a ete eteinte automatiquement veuillez la remettre à 0 pour qu'on puisse la realimenter", null);
		discover.timers().whereId(Configuration.ID_TIMER_4).schedule(Configuration.ID_TIMER_4, Integer.parseInt(Configuration.TIME_WAIT_1));
	}

}
