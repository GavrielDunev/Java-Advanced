package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

    @Test
    public void testCheckWithValidPressure(){
        Sensor mockedSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(19.0);
        Alarm alarm = new Alarm(mockedSensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testCheckWithPressureLowerThan17(){
        Sensor mockedSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(15.0);
        Alarm alarm = new Alarm(mockedSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testCheckWithPressureBiggerThan21(){
        Sensor mockedSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(22.0);
        Alarm alarm = new Alarm(mockedSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

}
