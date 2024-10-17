package EasyKit;

public class Console {

	private static enum State
	{
		Name,
		Message,
		Logic,
		Final
	}
	
	private static State currentPrintState = State.Message;
	
	@SuppressWarnings("unchecked")
	public static <M> void print(M... Message) 
	{
		String CompleteMessage = "";
		
		if (Message.length <= 1) 
		{
			currentPrintState = State.Message;
		}
		else 
		{
			currentPrintState = State.Name;
		}
		
		for (M Messages : Message) 
		{
			if (Message.length == 1) 
			{
				CompleteMessage = "[Unknown]: " + Messages;
			}
			else 
			{
				if (currentPrintState == State.Name) 
				{
					CompleteMessage = "[" + Message[0] + "]: ";
					currentPrintState = State.Message;
				}
				else 
				{
					CompleteMessage += Messages;
					currentPrintState = State.Final;
				}
			}
		}
		
		System.out.println(CompleteMessage);
	}
	
	@SuppressWarnings("unchecked")
	public static <M> void error(M... Message) 
	{
		String CompleteMessage = "";
		
		if (Message.length <= 1) 
		{
			currentPrintState = State.Message;
		}
		else 
		{
			currentPrintState = State.Name;
		}
		
		for (M Messages : Message) 
		{
			if (Message.length == 1) 
			{
				CompleteMessage = "[Unknown]: " + Messages;
			}
			else 
			{
				if (currentPrintState == State.Name) 
				{
					CompleteMessage = "[" + Message[0] + "]: ";
					currentPrintState = State.Message;
				}
				else 
				{
					CompleteMessage += Messages;
					currentPrintState = State.Final;
				}
			}
		}
		
		System.err.println(CompleteMessage);
	}
	
	@SuppressWarnings("unchecked")
	public static <M> void errorLogic(boolean Logic, M... Message) 
	{
		String CompleteMessage = "";
		
		if (Message.length <= 1) 
		{
			currentPrintState = State.Message;
		}
		else 
		{
			currentPrintState = State.Name;
		}
		
		int MessageAmount = 0;
		for (M Messages : Message) 
		{
			MessageAmount++;
			
			if (Message.length == 1) 
			{
				CompleteMessage = "[Unknown]: " + Messages;
			}
			else 
			{
				if (currentPrintState == State.Name) 
				{
					CompleteMessage = "[" + Message[0] + "]: ";
					currentPrintState = State.Message;
				}
				else if (currentPrintState == State.Message)
				{
					if (MessageAmount == Message.length) 
					{
						CompleteMessage += Messages + " | ";
						
						if (Logic) 
						{
							CompleteMessage += "✔️";
						}
						else 
						{
							CompleteMessage += "✖️";
						}
					}
					else if (MessageAmount > 1) 
					{
						CompleteMessage += Messages + " - ";
					}
					else 
					{
						if (Message.length == 1) 
						{
							CompleteMessage += Messages;
						}
						else 
						{
							CompleteMessage += Messages + " - ";
						}
					}
				}
			}
		}
		
		System.err.println(CompleteMessage);
	}
	
	public static void clear() 
	{
		for (int i = 0; i <= 20; i++) 
		{
			System.out.println();
		}
	}

}
