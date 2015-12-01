package fr.inria.phoenix.scenario.cuisiniere.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.promptercontext.AbstractPrompterContext;
import fr.inria.phoenix.diasuite.framework.device.timer.TimerTriggeredFromTimer;
import fr.inria.phoenix.scenario.cuisiniere.impl.Configuration;

public class PrompterContext extends AbstractPrompterContext {

	public PrompterContext(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected PrompterContextValuePublishable onTimerTriggeredFromTimer(TimerTriggeredFromTimer timerTriggeredFromTimer,
			DiscoverForTimerTriggeredFromTimer discover) {
		// TODO Auto-generated method stub
		if(timerTriggeredFromTimer.sender().id().equals(Configuration.ID_TIMER_1)){
			// TODO Auto-generated method stub
			DiaLog.info("PrompterContext");
			if(discover.prompters().anyOne().getAnswer("1")!=null){
				DiaLog.info("answered");
				return new PrompterContextValuePublishable(discover.prompters().anyOne().getAnswer("1"),true);
			}
			DiaLog.info("no answer");
			return new PrompterContextValuePublishable(Configuration.TIME_AVERAGE_COOK,true);
		}else
			return new PrompterContextValuePublishable("",false);
	}




}
