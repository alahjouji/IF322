package fr.inria.phoenix.scenario.cuisiniere.impl.context;

import fr.inria.diagen.core.ServiceConfiguration;
import fr.inria.diagen.log.DiaLog;
import fr.inria.phoenix.diasuite.framework.context.cookercontext.AbstractCookerContext;
import fr.inria.phoenix.diasuite.framework.device.electricmeter.CurrentElectricConsumptionFromElectricMeter;

public class CookerContext extends AbstractCookerContext {

	public CookerContext(ServiceConfiguration serviceConfiguration) {
		super(serviceConfiguration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected CookerContextValuePublishable onCurrentElectricConsumptionFromElectricMeter(
			CurrentElectricConsumptionFromElectricMeter currentElectricConsumptionFromElectricMeter,
			DiscoverForCurrentElectricConsumptionFromElectricMeter discover) {
		// TODO Auto-generated method stub
		DiaLog.info("CookerContext");
		if(discover.motionDetectors().anyOne().getMotion().getState().equals("true") && currentElectricConsumptionFromElectricMeter.value().getState().equals("On") && Integer.parseInt(currentElectricConsumptionFromElectricMeter.value().getTimestamp())<10000){
			DiaLog.info("CookerContext: there is motion and cooker just turned on");
			return new CookerContextValuePublishable(true,true);
		}
		DiaLog.info("CookerContext: No motion or cooker not on or cooker on for a while");
		return new CookerContextValuePublishable(false,false);
	}





}
