package EasyKit;

public class Console {

	private static enum State
	{
		Name,
		Message,
		Description,
		Logic,
		Next
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
				}
			}
		}
		
		System.err.println(CompleteMessage);
	}
	
	@SuppressWarnings("unchecked")
	public static <M> void errorInTesting(M... Message) 
	{
		String CompleteMessage = "";
		String Side = "|=|";
		String TrueMark = "✔️";
		String FalseMark = "✖️";
		
		State LastState = null;
		
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
				else if (currentPrintState != State.Name)
				{
					// [Test Function Name]: |=| Message, Description | CheckStatus |=| Message | CheckStatus |
					
					if (Message[MessageAmount - 1] instanceof Boolean) 
					{
						if ((boolean) Message[MessageAmount]) 
						{
							CompleteMessage += TrueMark;
						}
						else 
						{
							CompleteMessage += FalseMark;
						}
						
						if (!(MessageAmount++ <= Message.length)) 
						{
							CompleteMessage += " " + Side;
							currentPrintState = State.Next;
							LastState = currentPrintState;
						}
						else 
						{
							CompleteMessage += " | ";
							currentPrintState = State.Next;
							LastState = currentPrintState;
						}
					}
					else 
					{
						if (MessageAmount == Message.length) 
						{
							if (currentPrintState != State.Next) 
							{
								CompleteMessage += Messages + " | ";
							}	
						}
						else if (MessageAmount > 1) 
						{
							if (currentPrintState == State.Description) 
							{
								CompleteMessage += Messages + " | ";
							}
							else if (currentPrintState == State.Message) 
							{
								if (MessageAmount >= Message.length) 
								{
									CompleteMessage += Side + " " + Messages + " |)";
								}
								else 
								{
									CompleteMessage += " " + Messages + ", ";
								}
							}
						}
						else 
						{
							CompleteMessage += Messages + ", ";
						}
					}
				}
			}
			
			MessageAmount++;
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

}
