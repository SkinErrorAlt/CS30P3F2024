package TextConfig;

public class CurrencyFormatter 
{
    // Format string to currency format because the built in one sucks. (e.g, "$1200" -> "$1,200.00")
    public static String formatToCurrency(String input) 
    {
        try 
        {
            String numbersOnly = "";
            boolean hasDecimal = false;
            boolean isAfterDecimal = false;
            int decimalsCount = 0;
            
            for (char c : input.toCharArray()) 
            {
                if (Character.isDigit(c)) 
                {
                    numbersOnly += c;
                    
                    if (isAfterDecimal) 
                    {
                        decimalsCount++;
                    }
                }
                else if (c == '.' && !hasDecimal) 
                {
                    numbersOnly += c;
                    hasDecimal = true;
                    isAfterDecimal = true;
                }
            }

            if (numbersOnly.length() == 0) 
            {
                return "$0";
            }

            String[] parts = numbersOnly.split("\\.");
            String wholeNumber = parts[0];
            String decimals = "";

            if (parts.length > 1) 
            {
                decimals = parts[1];
            }

            if (decimals.length() > 2) 
            {
                decimals = decimals.substring(0, 2);
            } 
            else if (decimals.length() == 1) 
            {
                decimals += "0";
            }
            
            String formattedWhole = "";
            int count = 0;

            for (int i = wholeNumber.length() - 1; i >= 0; i--) 
            {
                formattedWhole = wholeNumber.charAt(i) + formattedWhole;
                count++;

                if (count == 3 && i > 0) {
                    formattedWhole = "," + formattedWhole;
                    count = 0;
                }
            }
            
            return "$" + formattedWhole + "." + decimals;
        } 
        catch (Exception e) 
        {
            return "$0";
        }
    }
    
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
}