package fr.inria.phoenix.scenario.cuisiniere.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.cookercontext.AbstractCookerContext;
import fr.inria.phoenix.diasuite.framework.device.motiondetector.MotionFromMotionDetector;

public class CookerContext extends AbstractCookerContext {

	public CookerContext(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected CookerContextValuePublishable onMotionFromMotionDetector(
			MotionFromMotionDetector motionFromMotionDetector, DiscoverForMotionFromMotionDetector discover) {
		// TODO Auto-generated method stub
		DiaLog.info("CookerContext");
		if(motionFromMotionDetector.value().getState().equals("true") && discover.electricMeters().anyOne().getCurrentElectricConsumption().getState().equals("On") && Integer.parseInt(discover.electricMeters().anyOne().getCurrentElectricConsumption().getTimestamp())<10000){
			DiaLog.info("CookerContext: there is motion and cooker just turned on");
			return new CookerContextValuePublishable(true,true);
		}
		DiaLog.info("CookerContext: No motion or cooker not on or cooker on for a while");
		return new CookerContextValuePublishable(false,false);
	}



}
