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
	
	private static enum MessageType 
	{
		Name,
		Message,
		Description,
		Logic,
		End
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
	
	// Todo: Complete making a function to handle all other error message prompts
	private static class Message 
	{
		String Message = "";
		MessageType MessageState;
		
		MessageType NextMessageType;
		
		<other> Message(other... Settings) 
		{
			for (other OtherSettings : Settings) 
			{
				if (OtherSettings instanceof String) 
				{
					this.Message = Message;
				}
				else if (OtherSettings instanceof MessageType) 
				{
					this.NextMessageType = (MessageType) OtherSettings;
				}
			}
		}
	}
	
	private static class WholeMessage 
	{
		int SectionAmount = 0;
		
		List<Message> Messages = new ArrayList<>();
	}
	
	public static void error1(Object... Message) 
	{
		WholeMessage Messages = new WholeMessage();
		
		String CompleteMessage = "";
		String SectionMarker = "|=|";
		String TrueMark = "✔️";
		String FalseMark = "✖️";
		
		for (Object Text : Message) 
		{
			if (Text instanceof String) 
			{
				Message NewText = new Message(Text, null, null);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void errorInTesting(Object... Message) 
	{
		String CompleteMessage = "";
		String Side = "|=|";
		String TrueMark = "✔️";
		String FalseMark = "✖️";
		
		if (Message.length <= 1) 
		{
			currentPrintState = State.Message;
		}
		else 
		{
			currentPrintState = State.Name;
		}
		
		int MessageAmount = 0;
		
		if (Message.length == 0) 
		{
			System.err.println("[Error] Failed to create a error message. No error message was given.");
			return;
		}
		
		for (Object Messages : Message) 
		{
			if (Message.length <= 1) 
			{
				CompleteMessage = "[Unknown]: " + Messages;
			}
			else 
			{
				if (currentPrintState == State.Name) 
				{
					CompleteMessage = "[" + Message[MessageAmount] + "]: ";
					currentPrintState = State.Message;
				}
				else if (currentPrintState != State.Name)
				{
					// [Test Function Name]: |=| Message, Description | CheckStatus |=| Message | CheckStatus |
					
					if (Message[MessageAmount] instanceof Boolean) 
					{
						if ((boolean) Message[MessageAmount]) 
						{
							CompleteMessage += TrueMark;
						}
						else 
						{
							CompleteMessage += FalseMark;
						}
						
						if (!((MessageAmount + 1) <= Message.length)) 
						{
							if (Message[(MessageAmount + 1)] instanceof Boolean) 
							{
								CompleteMessage += " " + Side;
								currentPrintState = State.Next;
							}
							else 
							{
								CompleteMessage += ", ";
								currentPrintState = State.Next;
							}
						}
						else 
						{
							CompleteMessage += " | ";
							currentPrintState = State.Next;
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
							else if (currentPrintState == State.Next) 
							{
								CompleteMessage += " [=]";
								currentPrintState = State.Message;
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
