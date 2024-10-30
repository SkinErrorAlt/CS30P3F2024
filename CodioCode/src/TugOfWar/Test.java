package TugOfWar;

public class Test {

    public static double calculatePercentage(double value, double minValue, double maxValue) {
        // Clamp the value to the valid range (min to max)
        value = Math.max(minValue, Math.min(value, maxValue));

        // Calculate the percentage within the range
        double percentage;
        if (value >= minValue && value <= maxValue) 
        {
            percentage = (value - minValue) / (maxValue - minValue);
        } 
        else 
        {
            percentage = 0.0;
        }

        return percentage;
    }

    public static void main(String[] args) throws Exception{
        while (true) 
        {
            for (int i = 0; i < 50; i++) 
            {
                System.out.println();
            }

            double Temp = (150 * Math.random() + 100);
            double CurrentTemp = (150 * Math.random() + 100);
            System.out.println("Temp: [" + CurrentTemp + " | " + calculatePercentage(CurrentTemp, Temp - 2, Temp + 2) * 100 + "%");

            Thread.sleep(250);
        }
    }
}
//