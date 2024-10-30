package ChattingSystem;

import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.util.Random;

public class ChatRooms 
{
    public static UI Ui = new UI();
    public static ChattingSystem ChatSys = new ChattingSystem();

    private static int userInt; // Used for returning the users Integer.
	private static double userNum; // Used for returning the users Number.
	private static String userStr; // Used for returning the users String.

    private static enum MessageType 
    {
        Normal,
        Blocked,
        Ad,
        Link,
        UnNormal,
        System
    }

    public static class NewMessage
    {
        String Message;
        String time = Ui.GetTime();
        MessageType MessageStat;
        NewRoom LinkedRoom;
        Accounts.NewAccount LinkedAccount;
        
        NewMessage(String Message, NewRoom LinkedRoom, Accounts.NewAccount LinkedAccount, MessageType MessageStat)
        { 
            this.Message = Message;
            this.LinkedRoom = LinkedRoom;
            this.LinkedAccount = LinkedAccount;
            this.MessageStat = MessageStat; 
        }

        void ChangeMessageStat(MessageType MessageStat) 
        {
            this.MessageStat = MessageStat;
        }
    }

    public static class NewRoom 
    {
        String RoomName;
        String Description;

        Accounts.NewAccount Owner;
        
        boolean PrivateRoom;
        String PrivatePassword;

        List<Accounts.NewAccount> Users_Room = new ArrayList<>(); // Array of users within the room.
        List<Accounts.NewAccount> Users_Banned = new ArrayList<>(); // Array of users that are banned within the room.
        List<NewMessage> RoomMessages = new ArrayList<>(); // Every Message in Room.

        NewRoom(String RoomName, String PrivatePassword, boolean PrivateRoom, String Description, Accounts.NewAccount Owner) 
        {
            this.RoomName = RoomName;

            if (!this.PrivateRoom) 
            {
                this.PrivatePassword = PrivatePassword;
            }

            this.Description = Description;
            this.Owner = Owner;
        }

        void SetMode(boolean PrivateRoom, String PrivatePassword) 
        {
            this.PrivateRoom = PrivateRoom;
            
            if (this.PrivateRoom) 
            {
                this.PrivatePassword = PrivatePassword;
            }
        }

        void AddUser(Accounts.NewAccount AddedAccount) 
        {
            Users_Room.add(AddedAccount);
        }

        void RemoveUser(Accounts.NewAccount RemoveAccount) 
        {
            Users_Room.remove(RemoveAccount);
        }
    }

    public static class Warning 
    {
        enum WarnStatusEnum 
        {
            Active,
            UnActive
        }

        String WarnMessage;
        WarnStatusEnum CurrentWarnStatus = WarnStatusEnum.Active;
    }

    public static class User_class 
    {
        enum AccountStatusEnum
        {
            Text,
            Read_Only,
            Kicked,
            Banned,
            Invisible
        }

        AccountStatusEnum AccountStatus = AccountStatusEnum.Text;

        List<NewMessage> RoomMessages = new ArrayList<>(); // Every Message in Room.
        
        int Kicked_Amount = 0;
        int Banned_Amount = 0;
    }

    public static class Role 
    {
        // Visibility Enums.
        public static enum VisibleEnums
        {
            Visible,
            Hidden
        }

        String RoleName = "UnDefined"; // Role name.
        String RoleDescription = "UnDefined"; // Role description.

        int RoleUniqueID = 0;
        int RolePlacement = 0;

        Role(String Role_Name, Role Description) 
        {
            this.RoleUniqueID = (int) Ui.RandomNumber(106798437,99679993);
        }

        List<Accounts.NewAccount> Role_Memebers = new ArrayList<>(); // Array of Admins
        VisibleEnums RoleVisibility = VisibleEnums.Visible; // Wether others can view roles.

        // Command Control
        boolean Ban_Users = false; // Allowed to ban users.
        boolean Kick_Users = false; // Allowed to kick users.
        boolean Mute_Users = false; // Allowed to mute users.
        boolean Role_Users = false; // Give the user roles/take away roles.

        // Trolling Control
        boolean User_Disguise = false; // Can message with the name of the user chosen.

        // Message Control
        boolean Pin_Messages = false; // Can pin messages.
        boolean Delete_Messages = false; // Can delete Messages.
        boolean Clear_Messages = false; // Can clear messages.
        boolean Change_Messages = false; // Can Change user/self messages.
        boolean Show_Banned_Messages = false; // Can see banned messages.
        boolean Allow_Messaging = true;

        // Server Control
        boolean View_Settings = false; // Can view server settings.
        boolean Create_Roles = false; // Can Create new roles.
        boolean Change_Roles = false; // Can change roles.
        boolean Change_Server_Settings = false; // Can change server settings.
    }

    public static List<NewRoom> Rooms = new ArrayList<>();
    public static List<Role> Roles = new ArrayList<>();

    public static NewRoom CurrentRoom;
    private static int lunchamount = 0;

    public static void CreateMessage(String Message, NewRoom LinkedRoom) 
    {
        NewMessage NewMess = new NewMessage(Message, LinkedRoom, Accounts.GetCurrentAccount(), MessageType.Normal);
        lunchamount++;

        char[] BlockedChar = {'@', '#', '$', '%', '_'};
        String[] Links = {"www."};

        for (int i = 0; i < Message.length(); i++) 
        {
            for (int x = 0; x < BlockedChar.length; x++) 
            {
                if (Message.charAt(i) == BlockedChar[x]) 
                {
                    NewMess.ChangeMessageStat(MessageType.UnNormal);
                }
            }
        }

        int SameChars = 0;

        for (int y = 0; y < Links.length; y++) 
        {
            for (int w = 0; w < Message.length(); w++) 
            {
                if (!(SameChars <= 3)) 
                {
                    if (Message.charAt(w) == Links[y].charAt(SameChars)) 
                    {
                        SameChars++;
                    }
                    else 
                    {
                        SameChars = 0;
                    }
                }
                else 
                {
                    NewMess.ChangeMessageStat(MessageType.Link);
                }
            }
        }

        Accounts.GetCurrentAccount().Messages.add(NewMess);
        CurrentRoom.RoomMessages.add(NewMess);
    }

    public static void ViewRooms() 
    {
        boolean endLoop = false;
        for (boolean i = false; i == endLoop;) 
        {
            Ui.print("| View Chat Rooms |");
            Ui.addSpace(1);

            int RoomAmount = 0;
            for (int e = 0; e < Rooms.size(); e++) 
            {
                boolean IsBanned = false;
                
                for (int BUser = 0; BUser < Rooms.get(e).Users_Banned.size(); BUser++) 
                {
                    if (Accounts.CurrentAccount == Rooms.get(e).Users_Banned.get(BUser)) 
                    {
                        IsBanned = true;
                        break;
                    }
                }

                if (!IsBanned) 
                {
                    Ui.print(Rooms.get(e).RoomName);
                    Ui.print("  " + Rooms.get(e).Description);
                    Ui.print("----------------------");
                    RoomAmount++;
                }
                else 
                {
                    if (Accounts.CurrentAccount.showBannedRooms) 
                    {
                        RoomAmount++;
                        String BlurMessage = "";

                        for (int RoomName = 0; RoomName < Rooms.get(e).RoomName.length();) 
                        {
                            int LastRandomChar = 0;
                            int RandomCharReplace = (int) Ui.RandomNumber(1,5);

                            if (RandomCharReplace != LastRandomChar) 
                            {
                                if (RandomCharReplace == 1) 
                                {
                                    BlurMessage += "@";
                                }
                                else if (RandomCharReplace == 2) 
                                {
                                    BlurMessage += "#";
                                }
                                else if (RandomCharReplace == 3) 
                                {
                                    BlurMessage += "$";
                                }
                                else if (RandomCharReplace == 4) 
                                {
                                    BlurMessage += "%";
                                }
                                else if (RandomCharReplace == 5) 
                                {
                                    BlurMessage += "&";
                                }
                                else if (RandomCharReplace == 6) 
                                {
                                    BlurMessage += "*";
                                }
                                else if (RandomCharReplace == 7) 
                                {
                                    BlurMessage += "!";
                                }

                                RoomName++;
                            }
                        }
                    
                        Ui.print(BlurMessage + " (" + Rooms.get(e).RoomName + ")");
                        Ui.print(" [You are Banned] " + Rooms.get(e).Description);
                        Ui.print("----------------------");
                    }
                }
            }

            if (RoomAmount == 0) 
            {
                Ui.print("No Rooms.");
                Ui.addSpace(1);

                Ui.addButton(1, "Create Room");
                Ui.addButton(2, "Back");
                Ui.addSpace(1);

                userStr = Ui.userString(false, null);

                if (userStr.equals("1")) 
                {
                    Ui.clear();
                    CreateRoom();
                }
                else if (userStr.equals("2"))
                {
                    Ui.clear();
                    endLoop = true;
                    ChattingSystem.MainMenu();
                }
                else 
                {
                    Ui.clear();
                }
            }
            else // More then 0 rooms.
            {
                Ui.addButton(1, "Create Room");
                Ui.addButton(2, "Back");
                Ui.addSpace(1);

                userStr = Ui.userString(false, null);

                if (userStr.equals("1")) 
                {
                    Ui.clear();
                    CreateRoom();
                }
                else if (userStr.equals("2")) 
                {
                    Ui.clear();
                    endLoop = true;
                    ChattingSystem.MainMenu();
                }
                else 
                {
                    boolean GotRoom = false;
                    for (int r = 0; r < Rooms.size(); r++) 
                    {
                        if (userStr.equals(Rooms.get(r).RoomName)) 
                        {
                            boolean IsBanned = false;
                
                            for (int BUser = 0; BUser < Rooms.get(r).Users_Banned.size(); BUser++) 
                            {
                                if (Accounts.CurrentAccount == Rooms.get(r).Users_Banned.get(BUser)) 
                                {
                                    IsBanned = true;
                                }
                            }

                            if (!IsBanned) 
                            {
                                Ui.clear();

                                boolean AllowInRoom = false;

                                if (Rooms.get(r).PrivateRoom) 
                                {
                                    boolean GotRoomPassword = false;
                                    for (GotRoomPassword = false; GotRoomPassword == false;) 
                                    {
                                        Ui.print("Please Enter the room password for -[ "+ Rooms.get(r).RoomName +" ]- to continue.");
                                        Ui.addButton(1, "Back");
                                        Ui.addSpace(1);

                                        userStr = Ui.userString(true, "Password");

                                        if (userStr.equals(Rooms.get(r).PrivatePassword)) 
                                        {
                                            AllowInRoom = true;
                                            GotRoomPassword = true;
                                        }
                                        else if (userStr.equals("1"))
                                        {
                                            AllowInRoom = false;
                                        }
                                        else 
                                        {
                                            Ui.clear();
                                            Ui.print("That isn't the password. Please try again.");
                                        }
                                    }
                                }
                                else 
                                {
                                    CurrentRoom = Rooms.get(r);
                                    GotRoom = true;
                                    break; 
                                }

                                if (AllowInRoom) 
                                {
                                    CurrentRoom = Rooms.get(r);
                                    GotRoom = true;
                                    break;
                                }
                            }
                            else 
                            {
                                Ui.clear();
                                Ui.print("You have been banned from: " + Rooms.get(r).RoomName);
                                Ui.addSpace(1);
                                GotRoom = false;
                            }
                        }
                    }

                    if (GotRoom) 
                    {
                        Ui.clear();
                        endLoop = true;
                        ViewRoom();
                    }
                    else // Couldn't find a room with the name the player entered.
                    {
                        Ui.clear();
                        Ui.print("|- " + userStr + " -| is not a valid Room");
                        Ui.addSpace(1);
                    }
                }
            }
        }
    }

    public static void CreateRoom() 
    {
        boolean endLoop = false;
        for (boolean i = false; i == endLoop;) 
        {
            Ui.print("| Creating Chat Room |");
            Ui.addSpace(1);
            Ui.print("What is the room Name?");
            Ui.addSpace(1);

            Ui.addButton(1, "Back");
            Ui.addSpace(1);

            String Name = Ui.userString(true, "Room Name");

            if (Name.equals("1")) 
            {
                Ui.clear();
                endLoop = true;
                ViewRooms();
                break;
            }

            Ui.addSpace(1);

            Ui.clear();
            Ui.addButton(1, "Back");
            Ui.addSpace(1);
            Ui.print("What is the Description for the room?");

            String Description = Ui.userString(true, "Description");

            Ui.clear();

            boolean SkipPassword = false;
            String CreatingPassword = "";

            boolean endLoop2 = false;
            for (boolean d = false; i == endLoop2;) 
            {
                Ui.print("Do you want to add a Password?");
                Ui.print("Side note, the password can be togged in the room settings.");
                Ui.addSpace(1);
                Ui.addButton(1, "Back");
                Ui.addSpace(1);

                Ui.addButton(2, "Add Password");
                Ui.addButton(3, "Make Public");
                Ui.addSpace(1);

                SkipPassword = false;

                int DoCreatePassword = Ui.userIntager(false, null);

                if (DoCreatePassword == 1) 
                {
                    Ui.clear();
                    endLoop2 = true;
                    ViewRooms();
                    break;
                }
                else if (DoCreatePassword == 2) 
                {
                    Ui.clear();
                    boolean endLoop3 = false;
                    
                    for (boolean f = false; f == endLoop3;) 
                    {
                        Ui.print("What is the rooms password?");
                        CreatingPassword = Ui.userString(true, "Room Password");

                        boolean GotPassword = false;
                        for (boolean g = false; g == GotPassword;) 
                        {
                            Ui.clear();
                            Ui.print("Are you sure you want to make the password: -[ " + CreatingPassword + " ]-");

                            Ui.addButton(0, "Make Room Public");
                            Ui.addSpace(1);

                            Ui.addButton(1, "Keep Password");
                            Ui.addButton(2, "Discard Password");
                            
                            int KeepPassword = Ui.userIntager(false, null);

                            if (KeepPassword == 0) 
                            {
                                Ui.clear();
                                SkipPassword = true;
                                endLoop3 = true;
                                endLoop2 = true;
                                GotPassword = true;
                            }
                            else if (KeepPassword == 1) 
                            {
                                Ui.clear();
                                endLoop3 = true;
                                endLoop2 = true;
                                GotPassword = true;
                                SkipPassword = false;
                            }
                            else if (KeepPassword == 2) 
                            {
                               GotPassword = true; 
                            }
                        }  
                    }

                    Ui.clear();
                    endLoop3 = true;
                    endLoop2 = true;
                }
                else if (DoCreatePassword == 3) 
                {
                    Ui.clear();
                    SkipPassword = true;
                    endLoop2 = true;
                }
                else 
                {
                    Ui.clear();
                }
            }

            boolean RoomExists = false;

            for (int w = 0; w < Rooms.size(); w++) 
            {
                if (Rooms.get(w).RoomName.equals(Name)) 
                {
                    RoomExists = true;
                    break;
                }
            }

            Ui.clear();

            if (!RoomExists) 
            {
                NewRoom Room = new NewRoom(Name, CreatingPassword, SkipPassword, Description, Accounts.GetCurrentAccount());
                Rooms.add(Room);
                CurrentRoom = Room;
                // CurrentRoom.Users_Room.add(Accounts.CurrentAccount); Removed add later

                boolean endLoop4 = false;
                for (boolean x = false; x == endLoop4;) 
                {

                    Ui.print("| Create Room |");
                    Ui.addSpace(1);

                    Ui.addButton(1, "Open Room");
                    Ui.addButton(2, "Room Settings");
                    Ui.addButton(3, "Back");
                    Ui.addSpace(1);

                    userInt = Ui.userIntager(false, null);

                    if (userInt == 1) 
                    {
                        Ui.clear();
                        endLoop4 = true;
                        ViewRoom();
                    }
                    else if (userInt == 2) 
                    {
                        // Add Room Settings



                        Ui.clear();
                        Ui.print("Room settings coming soon.");
                        Ui.addSpace(1);
                    }
                    else if (userInt == 3) 
                    {
                        Ui.clear();
                        endLoop4 = true;
                        ViewRooms();
                    }
                    else 
                    {
                        Ui.clear();
                    }
                }
            }
            else 
            {
                Ui.clear();
                Ui.print("Room -[ " + Name + " ]- Already Exists.");
                Ui.addSpace(1);
            }
        }
    }

    private static int lunchamount2 = 0;

    public static void ViewRoom() 
    {
        boolean InRoom = false;
        for (int AllUsersInRoom = 0; AllUsersInRoom < CurrentRoom.Users_Room.size(); AllUsersInRoom++) 
        {
            if (Accounts.CurrentAccount == CurrentRoom.Users_Room.get(AllUsersInRoom)) 
            {
                InRoom = true;
                break;
            }
        }

        if (!InRoom) 
        {
            CurrentRoom.Users_Room.add(Accounts.CurrentAccount);
        }

        boolean endLoop = false;
        for (boolean e = false; e == endLoop;) 
        {
            int MessageLimit = 30;
            Ui.print("_-_-_-_-_PINS-_-_-_-_-_"); // Pin Top bar
            Ui.addSpace(1);

            Ui.print("Pin message Place Holder");

            Ui.addSpace(1);
            Ui.print("-_-_-_-_-_-_-_-_-_-_-_-"); // Top bar
            Ui.addSpace(1);

            List<NewMessage> LastMessages = new ArrayList<>();

            for (int i = CurrentRoom.RoomMessages.size(); i > 0; i--) 
            {
                if (LastMessages.size() >= MessageLimit) 
                {
                    LastMessages.add(CurrentRoom.RoomMessages.get(i - 1));
                    LastMessages.remove(LastMessages.size() - 1);
                }
                else 
                {
                    LastMessages.add(CurrentRoom.RoomMessages.get(i - 1));
                }
            }

            for (int x = LastMessages.size(); x > 0; x--) 
            {
                int BannedUser = 0;
                for (BannedUser = 0; BannedUser < CurrentRoom.Users_Banned.size(); BannedUser++) 
                {
                    if (LastMessages.get(x - 1).LinkedAccount == CurrentRoom.Users_Banned.get(BannedUser)) 
                    {
                        String BlurMessage = "";
                        for (int BannedMessageChar = 0; BannedMessageChar < LastMessages.get(x - 1).Message.length();) 
                        {
                            int LastRandomChar = 0;
                            int RandomCharReplace = (int) Ui.RandomNumber(1,5);

                            if (RandomCharReplace != LastRandomChar) 
                            {
                                if (RandomCharReplace == 1) 
                                {
                                    BlurMessage += "@";
                                }
                                else if (RandomCharReplace == 2) 
                                {
                                    BlurMessage += "#";
                                }
                                else if (RandomCharReplace == 3) 
                                {
                                    BlurMessage += "$";
                                }
                                else if (RandomCharReplace == 4) 
                                {
                                    BlurMessage += "%";
                                }
                                else if (RandomCharReplace == 5) 
                                {
                                    BlurMessage += "&";
                                }
                                else if (RandomCharReplace == 6) 
                                {
                                    BlurMessage += "*";
                                }
                                else if (RandomCharReplace == 7) 
                                {
                                    BlurMessage += "!";
                                }

                                BannedMessageChar++;
                            }
                        }

                        Ui.print("[Banned] " + LastMessages.get(x - 1).LinkedAccount.getUsername() + " | " + LastMessages.get(x - 1).time + " | " + BlurMessage);
                    }
                    else 
                    {
                        Ui.print(LastMessages.get(x - 1).LinkedAccount.getUsername() + " | " + LastMessages.get(x - 1).time + " | " + LastMessages.get(x - 1).Message);
                    }
                }
                
                if (BannedUser == 0) 
                {
                    Ui.print(LastMessages.get(x - 1).LinkedAccount.getUsername() + " | " + LastMessages.get(x - 1).time + " | " + LastMessages.get(x - 1).Message);
                }
            }

            Ui.addSpace(1);
            Ui.print("-_-_-_-_-_-_-_-_-_-_-_-"); // Bottom bar
            Ui.print("| " + CurrentRoom.RoomName + " |");
            Ui.print("Chat logs set to maxium: " + MessageLimit);
            Ui.addSpace(1);
            Ui.print("leave by entering -> /leave, or Type /help for commands.");
            Ui.addSpace(1);

            userStr = Ui.userString(false, null);
            char firstCharacter = userStr.charAt(0);

            boolean endLoop2 = false;
            for (boolean r = false; r == endLoop2;) 
            {
                if (firstCharacter == '/') 
                {
                    Ui.clear();
                    String lowerCaseMess = userStr;

                    if (lowerCaseMess.equals("/help")) 
                    {
                        Ui.print("Commands:");
                        Ui.print("---------");
                    }
                    if (lowerCaseMess.equals("/leave")) 
                    {
                        Ui.clear();
                        endLoop = true;
                        endLoop2 = true;
                        ViewRooms();
                    }
                    else if (lowerCaseMess.equals("/ban")) 
                    {
                        Ui.clear();

                        boolean AllowedBanning = true;

                        if (Accounts.CurrentAccount != CurrentRoom.Owner) 
                        {
                            AllowedBanning = false;
                            Ui.print("Sorry only -[ " + CurrentRoom.Owner.getUsername() + " ]- can use this command.");
                            Ui.addSpace(1);
                        }

                        int User = 0;
                        for (User = 0; User < CurrentRoom.Users_Room.size();) 
                        {
                            User++;
                        }

                        if (AllowedBanning) 
                        {
                            if (User > 1) 
                            {
                                boolean endLoop3 = false;
                                for (boolean t = false; t == endLoop3;) 
                                {
                                    Ui.print("Please select the user you wish to ban.");
                                    Ui.print("--[ Users in room: " + CurrentRoom.RoomName + " ]--");
                                    Ui.addSpace(1);
                                    Ui.addButton(-1, "Type Username");
                                    Ui.addButton(0, "Back");
                                    Ui.addSpace(1);

                                    User = 0;
                                    for (User = 0; User < CurrentRoom.Users_Room.size();) 
                                    {
                                        if (!(CurrentRoom.Users_Room.get(User) == Accounts.CurrentAccount)) 
                                        {
                                            Ui.addButton(User + 1, "" + CurrentRoom.Users_Room.get(User).getUsername());
                                        }
                                        User++;
                                    }

                                    userInt = Ui.userIntager(false, null);

                                    if (userInt == -1) 
                                    {
                                        Ui.clear();
                                        boolean endLoop4 = false;
                                        for (boolean y = false; y == endLoop4;) 
                                        {
                                            Ui.print("Please type the username of the user you wish to ban.");
                                            Ui.print("--[ Users in room: " + CurrentRoom.RoomName + " ]--");
                                            Ui.addSpace(1);
                                            Ui.addButton(-1, "Pick Number");
                                            Ui.addButton(0, "Back");
                                            Ui.addSpace(1);

                                            userStr = Ui.userString(false, null);

                                            if (userStr.equals("-1")) 
                                            {
                                                Ui.clear();
                                                endLoop4 = true;
                                            }
                                            else if (userStr.equals("0")) 
                                            {
                                                Ui.clear();
                                                endLoop3 = true;
                                                endLoop4 = true;
                                            }
                                            else 
                                            {
                                                int AllUsers = 0;
                                                boolean GotUser = false;
                                                for (AllUsers = 0; AllUsers < Accounts.accounts.size(); AllUsers++) 
                                                {
                                                    if (userStr.equals(Accounts.accounts.get(AllUsers).username) && !(userStr.equals(Accounts.CurrentAccount.username))) 
                                                    {
                                                        CurrentRoom.Users_Banned.add(Accounts.accounts.get(AllUsers));
                                                        CurrentRoom.Users_Room.remove(Accounts.accounts.get(AllUsers));
                                                        GotUser = true;
                                                        break;
                                                    }
                                                }

                                                Ui.clear();

                                                if (!GotUser) 
                                                {
                                                    Ui.print("No user of the name -[ " + userStr + " ]-");
                                                    Ui.print("Please enter the name again.");
                                                    Ui.addSpace(1);
                                                }
                                                else 
                                                {
                                                    endLoop3 = true;
                                                    endLoop4 = true;

                                                    Ui.print(" -[ " + Accounts.accounts.get(AllUsers).username + " ]- Has been banned from -[ " + CurrentRoom.RoomName + " ]-");
                                                    Ui.addSpace(1);
                                                }
                                            }
                                        }
                                    }
                                    else if (userInt == 0) 
                                    {
                                        Ui.clear();
                                        endLoop3 = true;
                                    }
                                    else if (userInt > 0 && userInt <= CurrentRoom.Users_Room.size())
                                    {
                                        CurrentRoom.Users_Banned.add(Accounts.accounts.get(userInt - 1));
                                        CurrentRoom.Users_Room.remove(Accounts.accounts.get(userInt - 1));

                                        Ui.clear();
                                        endLoop3 = true;

                                        Ui.print(" -[ " + Accounts.accounts.get(userInt - 1).username + " ]- Has been banned from -[ " + CurrentRoom.RoomName + " ]-");
                                        Ui.addSpace(1);
                                    }
                                    else 
                                    {
                                        Ui.clear();
                                        Ui.print("Please enter a number above 0 for selecting a person.");
                                        Ui.addSpace(1);
                                    } 
                                }
                            }
                            else 
                            {
                                Ui.clear();
                                Ui.print("There needs to be at least 2 people in the chat room.");
                                Ui.addSpace(1);
                            }
                        }     
                    }
                    else 
                    {
                        Ui.print("Sorry {- " + userStr + " -} isn't a valid command. Type /help for a list of commands.");
                    }

                    break;
                }
      
                Ui.clear();
                CreateMessage(userStr, CurrentRoom);
                endLoop2 = true;
            }
        }
    }
}