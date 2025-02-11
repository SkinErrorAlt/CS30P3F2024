package MasteryData;

import java.util.HashMap;
import java.util.Map;

public class LocalBankGUI_CurrencyHandler 
{
	public static String CurrentExchangeType = "CAD"; // Default should be CAD
	private static final Map<String, Rate> ExchangeRates = new HashMap<>();
	
	public static class Rate 
	{
		public String CurrencySymbol = "???";
		public double ExchangeRate = -1.0; // Based on the USD
		
		public Rate(String CurrencySymbol, double ExchangeRate) {
			this.CurrencySymbol = CurrencySymbol;
			this.ExchangeRate = ExchangeRate;
		}
	}
	
	static 
	{
		Rate USD = new Rate("$", 1.0);
		ExchangeRates.put("USD", USD);
		
		Rate EUR = new Rate("€", 0.84);
		ExchangeRates.put("EUR", EUR);
		
		Rate GBP = new Rate("£", 0.74);
		ExchangeRates.put("GBP", GBP);
		
		Rate JPY = new Rate("¥", 115.25);
		ExchangeRates.put("JPY", JPY);
		
		Rate INR = new Rate("₹", 82.44);
		ExchangeRates.put("INR", INR);
		
		Rate AUD = new Rate("$", 1.39);
		ExchangeRates.put("AUD", AUD);
		
		Rate CAD = new Rate("$", 1.34);
		ExchangeRates.put("CAD", CAD);
		
		Rate CHF = new Rate("CHF", 0.91);
		ExchangeRates.put("CHF", CHF);
		
		Rate CNY = new Rate("¥", 6.9);
		ExchangeRates.put("CNY", CNY);
		
		Rate MXN = new Rate("$", 18.88);
		ExchangeRates.put("MXN", MXN);

		Rate BRL = new Rate("R$", 5.2);
		ExchangeRates.put("BRL", BRL);
		
		Rate RUB = new Rate("₽", 75.0);
		ExchangeRates.put("RUB", RUB);
		
		Rate ZAR = new Rate("R", 18.0);
		ExchangeRates.put("ZAR", ZAR);
		
		Rate SGD = new Rate("$", 1.35);
		ExchangeRates.put("SGD", SGD);

        // This isn't a mistake for a transfer this is for when its unable to give any so it will just call back.
		
		Rate Error = new Rate("???", -1.0);
		ExchangeRates.put("Error", Error);
    }
	
	public static double ConvertCurrency(double amount, String fromCurrency, String toCurrency) 
	{
		if (!ExchangeRates.containsKey(fromCurrency) || !ExchangeRates.containsKey(toCurrency)) 
		{
			System.err.println("[CurrencyTransfer]: Failed, Incorrect fromCurrency, or toCurrency.");
			return ExchangeRates.get("Error").ExchangeRate;
		}
		
		double amountInUSD = amount / ExchangeRates.get(fromCurrency).ExchangeRate;
		return amountInUSD * ExchangeRates.get(toCurrency).ExchangeRate;
	}
	
	public static Rate getExchangeRate(String Currency) 
	{
		if (!ExchangeRates.containsKey(Currency)) 
		{
			System.err.println("[CurrencyTransfer]: Failed, Incorrect fromCurrency, or toCurrency.");
			return ExchangeRates.get("Error");
		}
		
		return ExchangeRates.get(Currency);
	}
}
