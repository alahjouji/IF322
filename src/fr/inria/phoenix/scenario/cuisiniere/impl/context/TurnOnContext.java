package fr.inria.phoenix.scenario.cuisiniere.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.turnoncontext.AbstractTurnOnContext;
import fr.inria.phoenix.diasuite.framework.device.motiondetector.MotionFromMotionDetector;

public class TurnOnContext extends AbstractTurnOnContext {

	public TurnOnContext(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected TurnOnContextValuePublishable onMotionFromMotionDetector(
			MotionFromMotionDetector motionFromMotionDetector, DiscoverForMotionFromMotionDetector discover) {
		// TODO Auto-generated method stub
		if(discover.timerContext()!=null){
			DiaLog.info("TurnOnContext");
			if(motionFromMotionDetector.value().getState().equals("true") && discover.timerContext()){
				DiaLog.info("TurnOnContext: motion and cooker turned off automatically");
				return new TurnOnContextValuePublishable(true,true);
			}
			DiaLog.info("TurnOnContext: no motion or cooker turned off manually");
			return new TurnOnContextValuePublishable(false,false);
		}else
			return new TurnOnContextValuePublishable(false,false);

	}

}
