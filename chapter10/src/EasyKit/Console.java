package EasyKit;

import java.util.ArrayList;
import java.util.List;

import EasyKit.Ui.TextFieldSettings;

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
	
	private static State PrintState = State.Message;
	
	public static void error(Object... Message) 
	{	
		PrintState = State.Name;
		
		String CompleteMessage = "";
		String SectionMarker = "|=|";
		String TrueMark = "✔️";
		String FalseMark = "✖️";
		
		int currentMessage = 0;
		double logicAmount = 0, trueLogicAmount = 0;
		
		for (Object Text : Message) 
		{
			boolean IsNextMessage = false;
			Object NextMessage = Message;
			
			if ((currentMessage + 1) < Message.length) 
			{
				IsNextMessage = true;
				NextMessage = Message[currentMessage + 1];
			}
			
			if (Text instanceof String) 
			{
				if (currentMessage == 0 && Message.length > 1) 
				{
					if (PrintState == State.Name) 
					{
						CompleteMessage += "[" + Text + "]: ";
						PrintState = State.Message;
					}
				}
				else if (currentMessage > 0 && Message.length > 1) 
				{
					if (PrintState == State.Message) 
					{
						CompleteMessage += Text;
						
						if (IsNextMessage) 
						{
							if (NextMessage instanceof String) 
							{
								if (currentMessage + 2 < Message.length) 
								{
									if (Message[currentMessage + 2] instanceof String) 
									{
										CompleteMessage += " | ";
									}
									else 
									{
										CompleteMessage += ", ";
									}
								}
								
								PrintState = State.Description;
							}
							else if (NextMessage instanceof Boolean) 
							{
								CompleteMessage += " | ";
								PrintState = State.Logic;
							}
						}
					}
					else if (PrintState == State.Description) 
					{
						CompleteMessage += Text;
						
						if (IsNextMessage) 
						{
							if (NextMessage instanceof String) 
							{
								CompleteMessage += ", ";
							}
							else if (NextMessage instanceof Boolean) 
							{
								CompleteMessage += " | ";
								PrintState = State.Logic;
							}
						}
					}
				}
				else if (Message.length == 1) 
				{
					CompleteMessage += "[Unknown]: " + Text;
				}
				else 
				{
					CompleteMessage += "[ErrorSys]: No strings or booleans were given.";
				}
			}
			else if (Text instanceof Boolean) 
			{
				if (currentMessage == 0) 
				{
					CompleteMessage += "[ErrorSys]: No name was given. [";
					CompleteMessage += (boolean) Text ? TrueMark : FalseMark + "]";
					
					break;
				}
				else 
				{
					CompleteMessage += (Boolean) Text ? TrueMark : FalseMark;
					
					logicAmount++;
					
					if ((Boolean) Text) 
					{
						trueLogicAmount += 1;
					}
					
					if (IsNextMessage) 
					{
						if (Message[currentMessage + 1] instanceof Boolean) 
						{
							CompleteMessage += ", ";
						}
						else if (Message[currentMessage + 1] instanceof String) 
						{
							if (trueLogicAmount == 0)
							{
								if (logicAmount > 2) 
								{
									CompleteMessage += " | (" + (int) trueLogicAmount + "/" + (int) logicAmount + "): " + 0 + "%";
								}
								else 
								{
									CompleteMessage += " |";
								}
							}
							else 
							{
								CompleteMessage += " | (" + (int) trueLogicAmount + "/" + (int) logicAmount + "): " + (int) Math.round((trueLogicAmount) / (logicAmount) * 100) + "% " + SectionMarker + " ";
								
								if (IsNextMessage) 
								{
									if (NextMessage instanceof String) //.//
									{
										PrintState = State.Message;
									}
								}
							}
						}
					}
					else 
					{
						if (trueLogicAmount == 0) 
						{
							CompleteMessage += " | (" + (int) trueLogicAmount + "/" + (int) logicAmount + "): " + 0 + "%";
						}
						else 
						{
							CompleteMessage += " | (" + (int) trueLogicAmount + "/" + (int) logicAmount + "): " + (int) Math.round((trueLogicAmount) / (logicAmount) * 100) + "%";
						}
					}
				}
			}
			
			currentMessage++;
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
//