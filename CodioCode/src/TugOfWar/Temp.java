package TugOfWar;

//Add Phidgets Library | You added a file called phidget22 when configuring your project. Import gives you access to the Phidgets library code inside that file. 
//import com.phidget22.*;

public class Temp {

  public static void main(String[] args) throws Exception{

	  /*
      //Create | Here you have created a TemperatureSensor object. TemperatureSensor is a class in your Phidgets library that gathers temperature data from your Phidget. 
      TemperatureSensor temperatureSensor = new TemperatureSensor();
      HumiditySensor humiditySensor = new HumiditySensor();
      
      //Create | Create objects for your buttons and LEDs.
      DigitalInput redButton = new DigitalInput(); //
      DigitalOutput redLED = new DigitalOutput();
      
      DigitalInput greenButton = new DigitalInput();
      DigitalOutput greenLED = new DigitalOutput();

      //Address | Address your four objects which lets your program know where to find them.
      redButton.setHubPort(0);
      redButton.setIsHubPortDevice(true);
      
      redLED.setHubPort(1);
      redLED.setIsHubPortDevice(true);
      
      greenButton.setHubPort(5);
      greenButton.setIsHubPortDevice(true);
      
      greenLED.setHubPort(4);
      greenLED.setIsHubPortDevice(true);

      //Open | Connect your program to your physical devices.
      redButton.open(1000);
      redLED.open(1000);

      greenButton.open(1000);
      greenLED.open(1000);

      //Open | Open establishes a connection between your object and your physical Phidget. You provide a timeout value of 1000  to give the program 1000 milliseconds (1 second) to locate your Phidget. If your Phidget can't be found, an exception will be thrown.
      temperatureSensor.open(1000);
      humiditySensor.open(1000);

      //Use your Phidgets | This code will turn on the LED when the matching button is pressed and turns off the LED when the matching button is released. The sleep function slows down the loop so the button state is only checked every 150ms.
      boolean lastRedState = false;
      boolean lastGreenState = false;


      int ShowNumberMax = 150; // Basicly 150 milliseconds.

      int ButtonTemp = 21;
      int lastButtonTemp = ButtonTemp;

      while (true) 
      {
          for (int i = 0; i < ShowNumberMax; i++) 
          {
              if (ShowNumber >= ShowNumberMax || ButtonTemp != lastButtonTemp) 
              {
                  lastButtonTemp = ButtonTemp;
                  ShowNumber = 0;

                  for (int i = 0; i < 50; i++) 
                  {
                      System.out.println();
                  }

                  double CurrentTemp = temperatureSensor.getTemperature();
                  double F = (CurrentTemp * 1.8) + 32;

                  System.out.println("Button Temperature: °C [" + ButtonTemp + "] | F [" + (ButtonTemp * 1.8) + 32);
                  System.out.println("Temperature: °C [" + CurrentTemp + "] | F [" + F + "]");
                  
                  System.out.println("Humidity: " + humiditySensor.getHumidity() + " %RH");
              }

              if (redButton.getState() != lastRedState) 
          	{
          		lastRedState = redButton.getState();
          		
          		if (redButton.getState())
                  {
                  	ButtonTemp--;
                  } 
          	}
          	
          	if (greenButton.getState() != lastGreenState) 
          	{
          		lastGreenState = greenButton.getState();
          		
          		if (greenButton.getState())
                  {
              		ButtonTemp++;
                  }
          	}
              
              if ((ButtonTemp > (CurrentTemp + 2)) && (ButtonTemp < (CurrentTemp - 2))) 
              {
                  greenLED.setState(false);
                  redLED.setState(true);
              }
              else 
              {
                  greenLED.setState(true);
                  redLED.setState(false);
              }

              Thread.sleep(1);
          }
      }
      */
  }
}
