package ChattingSystem;

public class ChattingSystem 
{
    private static UI Ui = new UI();
    public static Accounts account = new Accounts();
    private static ChatRooms chatRooms = new ChatRooms();

    private static int userInt; // Used for returning the users Integer.
	private static double userNum; // Used for returning the users Number.
	private static String userStr; // Used for returning the users String.

    public static boolean quitOut = false; // Used for login and sign up to see if the user backed out.

    public static void main(String[] args) 
    {
        Ui.clear();
        MainMenu();
    }

    public static void MainMenu() 
    {
        boolean endLoop = false;
        for (boolean i = false; i == endLoop;) 
        {
            // Ui.print(Ui.GetTime()); (This is testing the time function that i got from the internet, this is used in the messaging system to show the time that the message was sent).
            Ui.print("| Chatting Rooms |");
            Ui.addSpace(1);

            Ui.addButton(1, "Login");
            Ui.addButton(2, "Sign Up");
            Ui.addSpace(1);

            userInt = Ui.userIntager(false, null);

            if (userInt == 1) 
            {
                Ui.clear();
                endLoop = true;
                Login();
            }
            else if (userInt == 2) 
            {
                Ui.clear();
                if (quitOut) 
                {
                    quitOut = false;
                }

                account.SignUp();
            }
            else 
            {
                Ui.clear();
                Ui.print("Please enter a number between 1-2.");
                Ui.addSpace(1);
            }
        }
    }

    public static void Login() 
    {
        boolean loggedIn = account.Login();

        if (loggedIn) 
        {
            Ui.clear();
            Ui.print("Logged In as " + account.CurrentAccount.getUsername());
            chatRooms.ViewRooms();
        }
        else 
        {
            if (quitOut) 
            {
                Ui.clear();
                quitOut = false;
                MainMenu();
            }
            else 
            {
                Ui.clear();
                Ui.print("Name or Password is incorrect.");
                Ui.addSpace(1);
                Login();
            }
        }        
    }
}