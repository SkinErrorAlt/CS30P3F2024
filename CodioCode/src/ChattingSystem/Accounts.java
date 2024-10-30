package ChattingSystem;

import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.util.Random;

public class Accounts {
    public static UI Ui = new UI(); // Gets the Ui file for easier UI.
    public static ChatRooms ChatRoom = new ChatRooms();
    public static ChattingSystem ChatSys = new ChattingSystem(); // Gets the MySaving file for activating a function.

    private static NumberFormat numberFormatter = NumberFormat.getNumberInstance();

	private static boolean endLoop = false; // Used for the for statement loops to keep looking until its able to go to the next one.
	private static int userInt; // Used for returning the users Integer.
	private static double userNum; // Used for returning the users Number.
	private static String userStr; // Used for returning the users String.
    
    private static boolean gotAccount; // Used for seeing if it got an account.

    public static class NewAccount // Used for creating new accounts.
    {
        String username; // Used for getting the username of the account.
        String password; // Used for getting the password of the account.

        
        int safetyCode = (int) Ui.RandomNumber(185827,998539); // Gens a random number as a safe code.

        String creationDate;

        // Account Storage
        List<ChatRooms.NewMessage> Messages = new ArrayList<>();
        List<ChatRooms.NewRoom> InRooms = new ArrayList<>();
        List<Friend> Friends = new ArrayList<>();
        List<ChatRooms.NewRoom> FriendsRequests = new ArrayList<>();

        // Account Settings
        boolean allowFriendRequests = true;
        boolean showBannedRooms = true;
        boolean showBlockedUsersMessages = false;
        boolean safetyCodeActive = false; // Sees if the user toggled a safe code.

        NewAccount(String createUsername, String createPassword) // Quickly sets up a username and password when creating a new account.
        { 
            // Sets both username and password for the account.
            username = createUsername;
            password = createPassword;
        }

        String getUsername() // Returns the username of the account.
        {
            return username;
        }

        String getPassword() // Returns the password of the account.
        {
            return password;
        }

        int getSafetyCode() // Returns the safetyCode of the account.
        {
            return safetyCode;
        }

        boolean hasSafetyCode()
        {
            return safetyCodeActive;
        }

        void created() 
        {
            creationDate = Ui.GetTime();
        }
    }

    public static class Friend 
    {
        NewAccount FriendsAccount;
        
        enum FriendStatusEnum 
        {
            Friend,
            Stared
        }

        FriendStatusEnum FriendStatus = FriendStatusEnum.Friend;
    }

    public static List<NewAccount> accounts = new ArrayList<>(); // Creates a new array to store the accounts.
    public static NewAccount CurrentAccount; // Creates a variable to store the current account.

    public static void DeleteAccount()
    {
        int GetAccount = 0; // Used to count.
        boolean gotAccount = false; // Sees if it got the transaction list.

        for (GetAccount = 0; GetAccount < accounts.size(); GetAccount++) // loops through the Transaction list.
        {
            if (CurrentAccount == accounts.get(GetAccount)) // Sees if the Currrent Account matches the Linked Account inside the transaction list.
            {
                gotAccount = true; // Changes that it got the transaction and breaks ending the loop.
                break;
            }
        }

        if (gotAccount) // If it got the account then it will delete it from the account array.
        {
            accounts.remove(GetAccount); // Removes the current account from the accounts array.
        }
    }
    
    public static boolean Login() // Returns if the user logged in.
    {
        endLoop = false; // Used for the (for) loop.
        gotAccount = false; // Used to return if it got the account or not.

        for (boolean i = false; i == endLoop;) // Starts the loop.
        {
            Ui.print("[Login in]"); // Title for showing what page the user is currently viewing.
            Ui.addSpace(1);

            Ui.addButton(1, "Back"); // A way for the user to head back.
            Ui.addSpace(1);

            String EnteredUsername = Ui.userString(true, "Username"); // Creates an area for the user to input the username of the account.

            if (EnteredUsername.equals("1")) // If the user chooses to back out it will end the loop and bring them back to the Main Menu.
            {
                endLoop = true;
                Ui.clear(); // Clears the screen for better readablitly.
                ChatSys.quitOut = true;
                break;
            }

            String EnteredPassword = Ui.userString(true, "Password"); // Creates an area for the user to input the password of the account.

            if (EnteredPassword.equals("1")) // If the user chooses to back out it iwll end the loop and bring them back to the Main Menu.
            {
                endLoop = true;
                Ui.clear(); // Once again clears the screen.
                ChatSys.quitOut = true;
                break;
            }

            for (int CA = 0; CA < accounts.size(); CA++)
            {
                if (EnteredUsername.equals(accounts.get(CA).username) && EnteredPassword.equals(accounts.get(CA).password)) // Checks in the array storing the accounts if the user and password match what the user has entered.
                {
                    if (accounts.get(CA).hasSafetyCode()) 
                    {
                        Ui.print("Please enter the accounts safety code. [" + accounts.get(CA).safetyCode + "]"); // Dev mode remove the safety code when done.
                         String userSafetyCode = Ui.userString(true, "Code"); // Asks the user to enter the safety code.

                        if (userSafetyCode.equals("1")) 
                        {
                            endLoop = true;
                            Ui.clear(); // Once again clears the screen.
                            ChatSys.quitOut = true;
                            break;
                        }
                        else if (userSafetyCode.equals("" + accounts.get(CA).safetyCode)) // Answered the safety code.
                        {
                            gotAccount = true; // If the user has gotten it correct then it will set gotAccount to true and end the loop.
                            CurrentAccount = accounts.get(CA); // Logs in on that account.
                            break;
                        }
                        else // Failed to answer the safetyCode
                        {
                            Ui.clear();
                            Ui.print("Safety code failed.");
                            Ui.addSpace(1);
                            break;
                        }
                    }
                    else 
                    {
                        gotAccount = true; // If the user has gotten it correct then it will set gotAccount to true and end the loop.
                        CurrentAccount = accounts.get(CA); // Logs in on that account.
                        break;
                    }
                }
            }

            endLoop = true; // Ends the full loop.
        }

        return gotAccount; // Returns the variable.
    }

    public static void SignUp() // Creates a new account for the user.
    {
        endLoop = false; // Used for the loop.

        for (boolean i = false; i == endLoop;) 
        {
            Ui.print("[Sign Up]"); // Shows the user they are currenly signing up.
            Ui.addSpace(1);

            Ui.addButton(1, "Back"); // Shows the user they can go back.
            Ui.addSpace(1);

            String EnteredUsername = Ui.userString(true, "Username"); // Gets the user made username for the account.

            if (EnteredUsername.equals("1")) // Allows the user to go back if they entered 1
            {
                Ui.clear(); // Clears the screen.
                endLoop = true; // Ends the loop.
                ChatSys.MainMenu();
                ChatSys.quitOut = true;
                break;
            }
            
            String EnteredPassword = Ui.userString(true, "Password"); // Gets the user made password.

            if (EnteredPassword.equals("1")) // Allows the user to go back even after entering the username for the account.
            {
                Ui.clear(); // Clears the screen.
                endLoop = true; // Ends the loop.
                ChatSys.MainMenu();
                ChatSys.quitOut = true;
                break;
            }

            boolean AccountExists = false; // Used to see if the account already exists.
            for (int CA = 0; CA < accounts.size(); CA++) // Loops through every account within the account storage array.
            {
                if (EnteredUsername.equals(accounts.get(CA).username)) // Checks if the entered username is the same as a account.
                {
                    AccountExists = true; // Changes the Account Exists varaible and ends the loop.
                    break;
                }
            }

            if (!AccountExists) // If the account doesn't exist.
            {
                NewAccount account = new NewAccount(EnteredUsername, EnteredPassword); // Creates a new NewAccount class and assigns the Entered username and password to the account.
                
                accounts.add(account); // Adds the account to the accounts list.

                Ui.clear(); // Clears the screen.
                CurrentAccount = account; // Switches the current account to the new one.
                account.created(); // Lunches a function that will start the accounts starting date.
                endLoop = true; // Ends the loop.
                ChatRooms.ViewRooms();
            }
            else // If the account already exists.
            {
                Ui.clear(); // Clears the screen.
                Ui.print("Sorry but the account is already taken, please try again."); // Gives the user a warning on why it didn't work.
            }
        }
    }

    public static NewAccount GetCurrentAccount() // Returns the Current Account.
    {
        return CurrentAccount;
    }

    public static void UserAccount() 
    {

    }
}