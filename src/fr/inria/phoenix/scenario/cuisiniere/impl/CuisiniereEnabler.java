package fr.inria.phoenix.scenario.cuisiniere.impl;

import java.util.Arrays;

import fr.inria.diagen.core.enabler.AbstractApplicationEnabler;
import fr.inria.diagen.core.enabler.PropertyFormat;
import fr.inria.diagen.core.enabler.PropertyInfo;
import fr.inria.diagen.log.DiaLog;

public class CuisiniereEnabler extends AbstractApplicationEnabler {

    public CuisiniereEnabler() {
        super("LightPath", Arrays.asList(
        		new PropertyInfo(Configuration.ID_PROPERTY_1,
        				"timer id", "timer id", PropertyFormat.Text,
        				Configuration.ID_TIMER_1),
        		new PropertyInfo(Configuration.ID_PROPERTY_2,
        				"timer id", "timer id", PropertyFormat.Text,
                        Configuration.ID_TIMER_2),
        		new PropertyInfo(Configuration.ID_PROPERTY_3,
        				"timer id", "timer id", PropertyFormat.Text,
                        Configuration.ID_TIMER_3),
        		new PropertyInfo(Configuration.ID_PROPERTY_4,
        				"timer id", "timer id", PropertyFormat.Text,
                        Configuration.ID_TIMER_4),
        		new PropertyInfo(Configuration.TIME_PROPERTY_1,
        				"timer delay", "timer delay", PropertyFormat.Text,
                        Configuration.TIME_WAIT),
        		new PropertyInfo(Configuration.TIME_PROPERTY_2,
        				"timer delay", "timer delay", PropertyFormat.Text,
                        Configuration.TIME_AVERAGE_COOK),
        		new PropertyInfo(Configuration.TIME_PROPERTY_3,
        				"timer delay", "timer delay", PropertyFormat.Text,
                        Configuration.TIME_WAIT_1)));
    }

    @Override
    public void propertyChanged(String propertyName, String propertyValue) {
        if (propertyName.equals(Configuration.ID_PROPERTY_1)) {
            Configuration.ID_TIMER_1 = propertyValue;
            DiaLog.info("timer1 id has changed to " + propertyValue);
        }
        if (propertyName.equals(Configuration.ID_PROPERTY_2)) {
            Configuration.ID_TIMER_2 = propertyValue;
            DiaLog.info("timer2 id has changed to " + propertyValue);
        }
        if (propertyName.equals(Configuration.ID_PROPERTY_3)) {
            Configuration.ID_TIMER_3 = propertyValue;
            DiaLog.info("timer3 id has changed to " + propertyValue);
        }
        if (propertyName.equals(Configuration.ID_PROPERTY_4)) {
            Configuration.ID_TIMER_4 = propertyValue;
            DiaLog.info("timer4 id has changed to " + propertyValue);
        }
        if (propertyName.equals(Configuration.TIME_PROPERTY_1)) {
            Configuration.TIME_WAIT = propertyValue;
            DiaLog.info("wait delay has changed to " + propertyValue);
        }
        if (propertyName.equals(Configuration.TIME_PROPERTY_2)) {
            Configuration.TIME_AVERAGE_COOK = propertyValue;
            DiaLog.info("average delay has changed to " + propertyValue);
        }
        if (propertyName.equals(Configuration.TIME_PROPERTY_3)) {
            Configuration.TIME_WAIT_1 = propertyValue;
            DiaLog.info("wait1 delay id has changed to " + propertyValue);
        }
    }

    @Override
    public boolean isValid(String propertyName, String propertyValue) {
    	
        return (propertyName.equals(Configuration.ID_PROPERTY_1)
        		|| propertyName.equals(Configuration.ID_PROPERTY_2)
        		|| propertyName.equals(Configuration.ID_PROPERTY_3)
        		|| propertyName.equals(Configuration.ID_PROPERTY_4)
        		|| propertyName.equals(Configuration.TIME_PROPERTY_1)
        		|| propertyName.equals(Configuration.TIME_PROPERTY_2)
        		|| propertyName.equals(Configuration.TIME_PROPERTY_3));
    }
}
