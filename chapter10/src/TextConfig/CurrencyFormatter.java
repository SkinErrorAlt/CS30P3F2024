package TextConfig;

import java.util.ArrayList;
import java.util.List;

public class CurrencyFormatter 
{
    // Format string to currency format because the built in one sucks. (e.g "$1200" -> "$1,200.00")
    
    // Convert currency string to double
    public static double getAsDouble(String input) 
    {
        try 
        {
            String numbersOnly = "";
            boolean hasDecimal = false;
            
            for (char c : input.toCharArray()) 
            {
                if (Character.isDigit(c)) 
                {
                    numbersOnly += c;
                }
                else if (c == '.' && !hasDecimal) 
                {
                    numbersOnly += c;
                    hasDecimal = true;
                }
            }

            if (numbersOnly.length() == 0) 
            {
                return 0;
            }

            double number = Double.parseDouble(numbersOnly);
            return Math.round(number * 100.0) / 100.0;
            
        } 
        catch (Exception e) 
        {
            return 0; // Return default value if any error occurs
        }
    }

    public static String formatToCurrency(String input) 
    {
        String cleanedInput = input.replaceAll("[^0-9.]", "");
        
        String[] parts = cleanedInput.split("\\.");
        
        String integerPart = parts[0];
        String decimalPart = parts.length > 1 ? parts[1] : "";
        
        StringBuilder formattedInteger = new StringBuilder();
        for (int i = integerPart.length() - 1, count = 0; i >= 0; i--, count++) 
        {
            if (count > 0 && count % 3 == 0) 
            {
                formattedInteger.insert(0, ',');
            }
            
            formattedInteger.insert(0, integerPart.charAt(i));
        }
        
        String result = "$" + formattedInteger.toString() + (decimalPart.isEmpty() ? "." : "." + (decimalPart.length() > 2 ? decimalPart.substring(0, 2) : String.format("%1$-2s", decimalPart).replace(' ', '0')));
        return result;
    }
}