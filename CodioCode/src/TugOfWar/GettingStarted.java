package TugOfWar;

//Add Phidgets Library | You added a file called phidget22 when configuring your project. Import gives you access to the Phidgets library code inside that file. 
// import com.phidget22.*;

public class GettingStarted {
	public static int redPresses = 0; // This checks how many times the red button has been pressed (Almost*, it can go down if the minus value is true due to its gamemode).
	public static int greenPresses = 0; // This checks how many times the green button has been pressed (Almost*, it can go down if the minus value is true due to its gamemode).
	
	public static int winAmount = 10; // This is the win amount and what 
	public static boolean minus = true;
	
	//Handle Exceptions | Exceptions will happen in your code from time to time. These are caused by unexpected things happening. Make sure you’ve added "throws Exception" to your main method.
  public static void main(String[] args) throws Exception{
  	
	  /*
	  
      //Create | Create objects for your buttons and LEDs.
      DigitalInput redButton = new DigitalInput();
      DigitalOutput redLED = new DigitalOutput();
      
      DigitalInput greenButton = new DigitalInput();
      DigitalOutput greenLED = new DigitalOutput(); //

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

      //Use your Phidgets | This code will turn on the LED when the matching button is pressed and turns off the LED when the matching button is released. The sleep function slows down the loop so the button state is only checked every 150ms.
      boolean lastRedState = false;
      boolean lastGreenState = false;
      
      int redUntilGreenDown = 2; // How many presses red has to make before being able to minus 1 from green.
      int greenUntilRedDown = 2; // How many presses green has to make before being able to minus 1 from red.
      
      boolean roundstarted = true;
      
      while(true) 
      {
      	if (roundstarted) // Checks if the round just started again.
      	{
      		for (int i = 0; i < 50; i++) 
          	{
          		System.out.println();
          	}
      		
      		System.out.println("-_-_ 3 _-_-");
      		Thread.sleep(1 * 1000);
      		
      		for (int i = 0; i < 50; i++) 
          	{
          		System.out.println();
          	}
      		
      		System.out.println("-_-  2  -_-");
      		Thread.sleep(1 * 1000);
      		
      		for (int i = 0; i < 50; i++) 
          	{
          		System.out.println();
          	}
      		
      		System.out.println("-_   1   _-");
      		Thread.sleep(1 * 1000);
      		
      		for (int i = 0; i < 50; i++) 
          	{
          		System.out.println();
          	}
      		
      		System.out.println("-   GO!   -");
      		Thread.sleep(1 * 1000);
      		
      		roundstarted = false;
      	}
      	
      	if (minus) // If it will minus 1 from the other persons value every second input.
      	{
      		if (redButton.getState() != lastRedState) 
          	{
          		lastRedState = redButton.getState();
          		// redLED.setState(redButton.getState());
          		
          		if(redButton.getState())
                  {
                  	redPresses++;
                  	
                  	if (greenPresses > 0 && redUntilGreenDown <= 1) // Checks if the greenPresses are more then 0 because it cant go in the negitives. and also checks if the greenUntilRedDown 
                  	{
                  		redUntilGreenDown = 2;
                  		greenPresses--;
                  	}
                  	else 
                  	{
                  		redUntilGreenDown--;
                  	}
                  } 
          	}
          	
          	if (greenButton.getState() != lastGreenState) 
          	{
          		lastGreenState = greenButton.getState();
          		// greenLED.setState(greenButton.getState());
          		
          		if(greenButton.getState())
                  {
              		greenPresses++;
                  	
                  	if (redPresses > 0 && greenUntilRedDown <= 1) 
                  	{
                  		greenUntilRedDown = 2;
                  		redPresses--;
                  	}
                  	else 
                  	{
                  		greenUntilRedDown--;
                  	}
                  } 
          	}
      	}
      	else // If its based on pressing the button to get to 10 first.
      	{
      		if (redButton.getState() != lastRedState) 
          	{
          		lastRedState = redButton.getState();
          		// redLED.setState(redButton.getState());
          		
          		if (redButton.getState())
                  {
                  	redPresses++;
                  } 
          	}
          	
          	if (greenButton.getState() != lastGreenState) 
          	{
          		lastGreenState = greenButton.getState();
          		// greenLED.setState(greenButton.getState());
          		
          		if (greenButton.getState())
                  {
              		greenPresses++;
                  }
          	}
      	}
      	
      	redLED.setDutyCycle((double) redPresses / winAmount);
      	greenLED.setDutyCycle((double) greenPresses / winAmount);

          Thread.sleep(5);
          if (!CheckWin()) 
          {
          	UpdateScore();
          }
          else 
          {
          	UpdateScore();
          	Win();
          	
          	for (int i = 0; i < 7;) 
          	{
          		if (redPresses >= winAmount) 
              	{
          			if (redLED.getState()) 
          			{
          				redLED.setState(false);
          			}
          			else 
          			{
          				redLED.setState(true);
          			}
          			
          			greenLED.setState(false);
              	}
              	else if (greenPresses >= winAmount)
              	{
              		if (greenLED.getState()) 
          			{
              			greenLED.setState(false);
          			}
          			else 
          			{
          				greenLED.setState(true);
          			}

              		redLED.setState(false);
              	}
          		
          		Thread.sleep(5 * 100);
          		i++;
          	}
          	
          	for (int i = 0; i < 50; i++) 
          	{
          		System.out.println();
          	}
          	
          	System.out.println();
          	System.out.println("Red and Green please press down when your ready.");
          	
          	while (!(redButton.getState() && greenButton.getState())) 
          	{
          		Thread.sleep(1);
          	}

          	redLED.setDutyCycle(0);
          	greenLED.setDutyCycle(0);
          	
          	for (int i = 0; i < 50; i++) 
          	{
          		System.out.println();
          	}

          	redLED.setState(true);
          	greenLED.setState(true);
          
          	redPresses = 0;
          	greenPresses = 0;
          	greenUntilRedDown = 2;
          	redUntilGreenDown = 2;
          	
          	lastRedState = false;
          	lastGreenState = false;
          	roundstarted = true;
          	
          	System.out.println("Ready?");
          	Thread.sleep(5 * 100);
          	
          	redLED.setDutyCycle(0);
          	greenLED.setDutyCycle(0);
          }
      }
      
      */
  }
  
  public static void UpdateScore() 
  {
  	for (int i = 0; i < 50; i++) 
  	{
  		System.out.println();
  	}
  	
  	System.out.println("-_- Score -_-");
  	System.out.println("---------------");
  	System.out.println("Red: " + redPresses + " / " + winAmount);
  	System.out.println("Green: " + greenPresses + " / " + winAmount);
  	System.out.println("----------------");
  	System.out.println();
  }
  
  public static boolean CheckWin() 
  {
  	return (redPresses >= winAmount) || (greenPresses >= winAmount);
  }
  
  public static void Win() 
  {
  	if (redPresses >= winAmount) 
      {
      	System.out.println("Red is the winner!");
      	System.out.println("Red beat Green by: " + (redPresses - greenPresses));
      }
      else if (greenPresses >= winAmount) 
      {
      	System.out.println("Green is the winner!");
      	System.out.println("Green beat Red by: " + (greenPresses - redPresses));
      }
  }
}