package fr.inria.phoenix.scenario.cuisiniere.impl.controller;


import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.cookercontext.CookerContextValue;
import fr.inria.phoenix.diasuite.framework.controller.messengercontroller.AbstractMessengerController;
import fr.inria.phoenix.diasuite.framework.datatype.contact.Contact;
import fr.inria.phoenix.scenario.cuisiniere.impl.Configuration;

public class MessengerController extends AbstractMessengerController {

	public MessengerController(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCookerContext(CookerContextValue cookerContext,
			DiscoverForCookerContext discover) {
		// TODO Auto-generated method stub
		DiaLog.info("MessengerController");

		discover.messengers().anyOne().sendMessage(new Contact(), "", "veuillez chercher la tablette mobile pour renseigner le temps de cuisson", null);
		discover.prompters().anyOne().askOpenQuestion(new Contact(), "1", "", "temps de cuisson?");
		discover.timers().whereId(Configuration.ID_TIMER_1).schedule(Configuration.ID_TIMER_1, Integer.parseInt(Configuration.TIME_WAIT));
	}

}
