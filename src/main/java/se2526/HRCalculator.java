package se2526;

public class HRCalculator {
    public static int calculateMaxHR(int age){
        if(age>120){
            throw new IllegalArgumentException(
                    "Age out of bounds"
            );
        }
        return 220 - age;
    }
    public static String getWorkoutZone(int age, int bpm){
        return "?";
    }
}
