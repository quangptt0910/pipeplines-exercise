import se2526.HRCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HRCalculatorTest {
    @Test
    public void testValidMaxHR(){
        var result = HRCalculator.calculateMaxHR(25);
        assertEquals(195, result);

    }

    @Test
    public void testInvalidMinHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(500));
    }
    @Test
    public void testInvalidMinHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(-1));
    }


    @Test
    public void testWarmUpZone() {
        assertEquals("Warm-up", HRCalculator.getWorkoutZone(30, (int)(HRCalculator.calculateMaxHR(30)*0.55)));
    }

    @Test
    public void testFatBurnZone() {
        assertEquals("Fat Burn", HRCalculator.getWorkoutZone(50, (int)(HRCalculator.calculateMaxHR(50)*0.65)));
    }

    @Test
    public void testAerobicZone() {
        assertEquals("Aerobic", HRCalculator.getWorkoutZone(30, (int)(HRCalculator.calculateMaxHR(30)*0.76)));
    }

    @Test
    public void testAnaerobicZone() {
        assertEquals("Anaerobic", HRCalculator.getWorkoutZone(20, (int)(HRCalculator.calculateMaxHR(20)*0.88)));
    }

    @Test
    public void testVO2Zone() {
        assertEquals("VO2 Max", HRCalculator.getWorkoutZone(27, (int)(HRCalculator.calculateMaxHR(27)*0.95)));
    }

    @Test
    public void testInvalidZone() {
        assertEquals("Invalid", HRCalculator.getWorkoutZone(30, (int)(HRCalculator.calculateMaxHR(30)*0.4)));
    }
}