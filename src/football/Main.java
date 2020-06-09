package football;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
/**
 * The Main class implements an application that show the user his menu with the allowed operations for this user which based on his role.
 */
public class Main {
    private static final Scanner input = new Scanner(System.in);
    public static List<User> users = new ArrayList<>();
    public static List<Team> teams = new ArrayList<>();
    public static List<Invitation> invitations = new ArrayList<>();
    public static List<Notification> notifications = new ArrayList<>();
    private static User user;
    /**
     * This method shows the options that can user choose from them and use the application.
     * User can sign up with roll player or playground owner.
     * Administrator can login he was signed up on system before.
     * @param args command-line arguments.
     */
    public static void main(String [] args) {
        User admin = new User("Rawda Ahmed", "RawdaAhmed", "rawdaahmed165@gmail.com", "Rawda11$", "administrator");
        users.add(admin);
        /*User player1 = new User("Salma Ahmed", "SalmaAhmed", "salma.smsm.samasemo@gmail.com", "Salma@114", 70,"player");
        users.add(player1);
        User player2 = new User("Omnia Mohamed", "OmniaMohamed", "omniamuhamed114@gmail.com", "Omnia@114", 100,"player");
        users.add(player2);
        User owner = new User("Malak Rizk", "MalakRizk", "malkrizk@gmail.com", "Malak@114",40, "playground owner");
        users.add(owner);
        List<String> availableHours = new ArrayList<>();
        availableHours.add("4:00");
        availableHours.add("5:00");
        availableHours.add("8:00");
        owner.addPlayground("Malak's playground", "Malak Rizk", "MalakRizk", "12 Ahmed Barakat st Fesal Giza Egypt", "This is a big playground, it is in a good location", availableHours, 20, 40, 30);
        owner.getPlaygrounds().get(0).setId("31112");
        admin.approvePlayground("MalakRizk", "31112");*/
        mainScreen();
    }
    /**
     * This method shows the first menu will appear to the user whether he is a player, a playground owner or an administrator.
     * User can sign up with roll player or playground owner or login.
     * Administrator can only login. he was signed up on system before.
     * After login or signUp the operations will appear to user by his roll.
     */
    private static void mainScreen(){
        System.out.println("Welcome to GoFo application.");
        System.out.println("------------------------------------");
        System.out.println("choose from menu:");
        System.out.println("[1] SignUp");
        System.out.println("[2] Login");
        int choice = Validation.getIntFromUser(1, 2);
        switch(choice){
            case 1:
                userSignUp();
                break;
            case 2:
                userLogin();
                break;
            default:
                break;
        }
        determineScreen();
    }
    /**
     * This method shows the menu of the operations which the user can choose from them by his roll after login or signUp.
     */
    private static void determineScreen(){
        if(user.getRoll().equalsIgnoreCase("player")){
            playerScreen();
        } else if(user.getRoll().equalsIgnoreCase("playground owner")){
            playgroundOwnerScreen();
        } else if (user.getRoll().equalsIgnoreCase("administrator")){
            administratorScreen();
        }
    }
    /**
     * This method shows the menu of the operations which the player can choose from them after login or signUp.
     */
    private static void playerScreen(){
        System.out.println("Welcome " + user.getName());
        System.out.println("----------------------------------");
        boolean anotherChoice;
        do{
            System.out.println("Choose from menu:");
            System.out.println("[1] view all available playgrounds.");
            System.out.println("[2] view playgrounds with specific price.");
            System.out.println("[3] view playgrounds with specific time.");
            System.out.println("[4] view playgrounds in specific area.");
            System.out.println("[5] view playgrounds with specific price & time & area.");
            System.out.println("[6] Edit my information.");
            System.out.println("[7] view my new invitations.");
            System.out.println("[8] Send play invitation to specific player.");
            System.out.println("[9] Send play invitation to your team.");
            System.out.println("[10] Send join team invitation to specific player.");
            System.out.println("[11] Remove player from your team.");
            System.out.println("[12] View my team.");
            System.out.println("[13] view your reservations.");
            System.out.println("[14] view last reservation.");
            System.out.println("[15] Add money to eWallet.");
            System.out.println("[16] view eWallet.");
            System.out.println("[17] log out.");
            System.out.println("[18] Exit program.");
            int choice = Validation.getIntFromUser(1, 18);
            switch(choice){
                case 1:
                    viewAvailablePlaygrounds();
                    break;
                case 2:
                    filterPlaygroundPrice();
                    break;
                case 3:
                    filterHours();
                    break;
                case 4:
                    filterLocation();
                    break;
                case 5:
                    filterAll();
                    break;
                case 6:
                    editPlayerInfo();
                    break;
                case 7:
                    viewInvitations();
                    break;
                case 8:
                    sendPlayInvitationToPlayer();
                    break;
                case 9:
                    sendPlayInvitationToTeam();
                    break;
                case 10:
                    sendJoinTeamInvitation();
                    break;
                case 11:
                    removePlayerFromTeam();
                    break;
                case 12:
                    viewTeam();
                    break;
                case 13:
                    viewAllReservations();
                    break;
                case 14:
                    viewLastReservation();
                    break;
                case 15:
                    addToeWallet();
                    break;
                case 16:
                    System.out.println("Money in your eWallet is: " + user.getEWallet());
                    break;
                case 17:
                    userLogOut();
                    return;
                default:
                    System.out.println("Thank you for using GoFootball application.");
                    System.exit(0);
                    break;
            }
            System.out.println("Do you want another service?");
            anotherChoice = checkOperation();
        }while(anotherChoice);
        System.out.println("Thank you for using GoFootball application.");
    }
    /**
     * This method shows the menu of the operations which the playground owner can choose from them after login or signUp.
     */
    private static void playgroundOwnerScreen(){
        System.out.println("Welcome " + user.getName());
        System.out.println("----------------------------------");
        boolean anotherChoice;
        do{
            System.out.println("Choose from menu: ");
            System.out.println("[1] Add playground.");
            System.out.println("[2] Create profile.");
            System.out.println("[3] View all your playgrounds.");
            System.out.println("[4] Edit playground information.");
            System.out.println("[5] View booking for specific playground.");
            System.out.println("[6] View Notifications.");
            System.out.println("[7] Check eWallet.");
            System.out.println("[8] Log out.");
            System.out.println("[9] Exit program.");
            int choice = Validation.getIntFromUser(1, 9);
            switch(choice){
                case 1:
                    addPlayground();
                    break;
                case 2:
                    createProfile();
                    break;
                case 3:
                    user.viewPlaygrounds();
                    break;
                case 4:
                    editPlaygroundInfo();
                    break;
                case 5:
                    viewReservationsOfPlayground();
                    break;
                case 6:
                    viewNotifications();
                    break;
                case 7:
                    System.out.println("Money in eWallet is: " + user.getEWallet());
                    break;
                case 8:
                    userLogOut();
                    return;
                default:
                    System.out.println("Thank you for using GoFootball application.");
                    System.exit(0);
                    break;
            }
            System.out.println("Do you want another service?");
            anotherChoice = checkOperation();
        }while(anotherChoice);
        System.out.println("Thank you for using GoFootball application.");
    }
    /**
     * This method shows the menu of the operations which the administrator can choose from them after login.
     */
    private static void administratorScreen(){
        System.out.println("Welcome " + user.getName());
        System.out.println("----------------------------------");
        boolean anotherChoice;
        do {
            System.out.println("Choose from menu:");
            System.out.println("[1] Show pending playgrounds.");
            System.out.println("[2] Suspend playground");
            System.out.println("[3] Activate playground.");
            System.out.println("[4] Delete playground.");
            System.out.println("[5] Log out.");
            System.out.println("[6] Exit program.");
            int choice = Validation.getIntFromUser(1, 6);
            switch(choice){
                case 1:
                    viewPendingPlayground();
                    break;
                case 2:
                    suspendPlayground();
                    break;
                case 3:
                    activatePlayground();
                    break;
                case 4:
                    removePlayground();
                    break;
                case 5:
                    userLogOut();
                    return;
                default:
                    System.out.println("Thank you for using GoFootball application.");
                    System.exit(0);
                    break;
            }
            System.out.println("Do you want another service?");
            anotherChoice = checkOperation();
        }while(anotherChoice);
        System.out.println("Thank you for using GoFootball application.");
    }
    /**
     * This method checks if the username which the user will input it is unique or not.
     * @return boolean This is a flag says if the username is taken or not.
     */
    private static boolean uniqueUsername(String username){
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                System.out.println("Username is used, please re-enter new one: ");
                return false;
            }
        }
        return true;
    }
    /**
     * This method makes the user can signUp.
     * This method takes the name, unique username, email, strong password, roll, and the value of eWallet form the user.
     * It send a Verification code in mail to confirm the sign up operation.
     */
    private static void userSignUp(){
        System.out.println("Enter your name: ");
        String name = Validation.getStringAlphaFromUser();
        System.out.println("Enter username: ");
        String username = "";
        boolean isUnique;
        do{
            username = Validation.getStringFromUser();
            isUnique = uniqueUsername(username);
        } while(!isUnique);
        System.out.println("Enter your Email address: ");
        String email = "";
        do{
            email = Validation.getStringFromUser();
            if(!Validation.invalidEmail(email))
                System.out.println("wrong email, please re-enter your email address");
        } while(!Validation.invalidEmail(email));
        System.out.println("Enter a strong password: ");
        String password = "";
        do{
            password = Validation.getStringFromUser();
            if(!Validation.invalidPassword(password))
                System.out.println("weak password, please re-enter a strong one");
        } while(!Validation.invalidPassword(password));
        System.out.println("Enter a value to eWallet: ");
        double eWallet = Validation.getDoubleFromUser();
        System.out.println("Enter your roll (player / playground owner): ");
        String roll = "";
        boolean validRoll;
        do{
            validRoll = true;
            roll = Validation.getStringAlphaFromUser();
            if(!roll.equalsIgnoreCase("player") && !roll.equalsIgnoreCase("playground owner")){
                validRoll = false;
                System.out.println("invalid roll, please enter (player / playground owner): ");
            }
        } while(!validRoll);
        System.out.println("Verification code sent, please check your email.");
        String verificationCode;
        String signUpVerificationCode = sendSignUpVerificationCode(email);
        do{
            System.out.println("Enter code we sent:");
            verificationCode = Validation.getStringNumFromUser();
            if(!signUpVerificationCode.equals(verificationCode))
                System.out.println("Wrong code, please try again.");
        }while(!signUpVerificationCode.equals(verificationCode));
        user = new User(name, username, email, password, eWallet, roll);
        users.add(user);
        System.out.println("SignUp Successfully.");
    }
    /**
     * This method makes the user can login.
     * This method takes the username, and password form the user.
     * It checks if the username, and password is found and right or not.
     */
    private static void userLogin(){
        System.out.println("Enter your username: ");
        String username = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        for(User currentUser : users) {
            if(username.equals(currentUser.getUsername()) && password.equals(currentUser.getPassword())) {
                user = currentUser;
                return;
            }
        }
        System.out.println("this username is not found, please try again.");
        userLogin();
    }
    /**
     * This method makes the user can logout.
     */
    private static void userLogOut(){
        user = null;
        mainScreen();
    }
    /**
     * This method checks if user input word yes or no.
     * @return boolean This is a flag says if user input word yes or no
     */
    private static boolean checkOperation() {
        boolean Operation = false;
        String answer = Validation.getStringAlphaFromUser();
        if(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")){
            System.out.println("invalid input, please enter (yes / no).");
            checkOperation();
        }
        else if(answer.equalsIgnoreCase("yes"))
            Operation = true;
        return Operation;
    }
    /**
     * This method allows administrator to see the pending playground to decide approve it or no.
     */
    private static void viewPendingPlayground(){
        boolean found = user.viewPendingPlayground();
        if(!found){
            System.out.println("No pending playground found.");
            return;
        }
        System.out.println("do you want to approve any playground?");
        boolean approve = checkOperation();
        if(approve)
            approvePlayground();
    }
    /**
     * This method allows administrator to approve a playground.
     * This method takes username of the playground owner from administrator.
     * also takes the id of playground from administrator.
     * If this playground was not found he will be asked to input this information again.
     */
    private static void approvePlayground(){
        System.out.println("Enter username of the owner: ");
        String username = Validation.getStringFromUser();
        System.out.println("Enter ID of the playground: ");
        String id = Validation.getStringNumFromUser();
        boolean valid = user.approvePlayground(username, id);
        if(!valid){
            System.out.println("Playground not found, please try again.");
            approvePlayground();
        }
        System.out.println("Playground approved.");
    }
    /**
     * This method allows administrator to suspend a playground after receiving any complaint.
     * This method takes username of the playground owner from administrator.
     * also takes the id of playground from administrator.
     * If this playground was not found he will be asked to input this information again.
     */
    private static void suspendPlayground(){
        System.out.println("Enter username of the owner: ");
        String username = Validation.getStringFromUser();
        System.out.println("Enter ID of the playground: ");
        String id = Validation.getStringNumFromUser();
        boolean valid = user.suspendPlayground(username, id);
        if(!valid){
            System.out.println("Playground not found, please try again.");
            suspendPlayground();
        }
        System.out.println("Playground suspended.");
    }
    /**
     * This method allows administrator to activate a playground if he knows that the complaint will not be repeated.
     * This method takes username of the playground owner from administrator.
     * Also takes the id of playground from administrator.
     * If this playground was not found he will be asked to input this information again.
     */
    private static void activatePlayground(){
        System.out.println("Enter username of the owner: ");
        String username = Validation.getStringFromUser();
        System.out.println("Enter ID of the playground: ");
        String id = Validation.getStringNumFromUser();
        boolean valid = user.activatePlayground(username, id);
        if(!valid){
            System.out.println("Playground not found, please try again.");
            activatePlayground();
        }
        System.out.println("Playground activated.");
    }
    /**
     * This method allows administrator to delete a playground from system.
     * This method takes username of the playground owner from administrator.
     * Also takes the id of playground from administrator.
     * If this playground was not found he will be asked to input this information again.
     */
    private static void removePlayground(){
        System.out.println("Enter username of the owner: ");
        String username = Validation.getStringFromUser();
        System.out.println("Enter ID of the playground: ");
        String id = Validation.getStringNumFromUser();
        boolean valid = user.deletePlayground(username, id);
        if(!valid){
            System.out.println("Playground not found, please try again.");
            removePlayground();
        }
        System.out.println("Playground removed.");
    }
    /**
     * This method shows the menu of the information which the playground owner can edit it.
     * This method takes the information which the playground owner can edit it from the playground owner.
     * @param updatedPlayground This is an object from Playground class to store new information in it.
     */
    private static void playgroundUpdatedInfoScreen(Playground updatedPlayground){
        System.out.println("choose information that you want to update: ");
        System.out.println("[1] name");
        System.out.println("[2] location");
        System.out.println("[3] description");
        System.out.println("[4] price per hour");
        System.out.println("[5] available hours");
        System.out.println("[6] height");
        System.out.println("[7] width");
        int choice = Validation.getIntFromUser(1, 7);
        switch (choice){
            case 1:
                System.out.println("Enter the new name");
                String newName = Validation.getStringAlphaFromUser();
                updatedPlayground.setName(newName);
                break;
            case 2:
                System.out.println("Enter the new location");
                String newLocation = Validation.getStringFromUser();
                updatedPlayground.setLocation(newLocation);
                break;
            case 3:
                System.out.println("Enter the new description");
                String newDescription = Validation.getStringFromUser();
                updatedPlayground.setDescription(newDescription);
                break;
            case 4:
                System.out.println("Enter the new price per hour");
                int newPricePerHour = Validation.getIntFromUser();
                updatedPlayground.setPricePerHour(newPricePerHour);
                break;
            case 5:
                System.out.println("Enter the new available hours");
                List<String> newAvailableHours = new ArrayList<String>();
                String newHours = Validation.getStringFromUser();
                String[] hour = newHours.split(" ");
                newAvailableHours = Arrays.asList(hour);
                updatedPlayground.setAvailableHours(newAvailableHours);
                break;
            case 6:
                System.out.println("Enter the new height");
                int height = Validation.getIntFromUser();
                updatedPlayground.setPricePerHour(height);
                break;
            case 7:
                System.out.println("Enter the new width");
                int width = Validation.getIntFromUser();
                updatedPlayground.setPricePerHour(width);
                break;
            default:
                break;
        }
    }
    /**
     * This method updates the information which the playground owner input it.
     * This method asks the playground owner if he want to update another information.
     * If the playground was not found it will ask th playground owner to try again.
     */
    private static void editPlaygroundInfo() {
        System.out.println("Enter the id of your playground");
        String searchID = Validation.getStringNumFromUser();
        Playground updatedPlayground = new Playground();
        boolean anotherUpdate;
        do{
            playgroundUpdatedInfoScreen(updatedPlayground);
            System.out.println("do you want update another information?");
            anotherUpdate = checkOperation();
        }while(anotherUpdate);
        boolean isUpdated = user.updatePlaygroundInfo(searchID, updatedPlayground);
        if(!isUpdated){
            System.out.println("playground isn't found, please try again.");
            editPlaygroundInfo();
        }else{
            System.out.println("Information updated.");
        }
    }
    /**
     * This method generate a random number to be the verification code of creating profile for playground owner and show it to him.
     * @return String This is the random verification code of creating profile.
     */
    private static String sendProfileVerificationCode(){
        String verificationCode;
        Random rand = new Random();
        verificationCode = Integer.toString(rand.nextInt(1000000000));
        System.out.println("message was sent.");
        System.out.println('\n' + "Create profile code: " + verificationCode + '\n' + "don't give this code to anyone. " +
                "This code used to create GoFo profile. We never ask it for anything again.");
        return verificationCode;
    }
    /**
     * This method takes the phone and address of playground owner from him to create his profile.
     * It asks him to enter the verification code which was shown to him and if he entered wrong one it will ask him to re-enter it.
     */
    private static void createProfile(){
        System.out.println("Enter your phone:");
        String phone = Validation.getStringNumFromUser();
        System.out.println("Enter your Address:");
        String address = Validation.getStringFromUser();
        String sendingVerificationCode = sendProfileVerificationCode();
        String verificationCode;
        do{
            System.out.println("Enter code we sent:");
            verificationCode = Validation.getStringNumFromUser();
            if(!sendingVerificationCode.equals(verificationCode))
                System.out.println("Wrong code, please try again.");
        }while(!sendingVerificationCode.equals(verificationCode));
        user.createProfile(phone, address);
        System.out.println("Profile created.");
    }
    /**
     * This method takes the name, whole location, description, price per hour, width, height, and available hours of playground from playground owner to create a playground and add it to system.
     */
    private static void addPlayground(){
        System.out.println("Enter name of playground: ");
        String name = Validation.getStringAlphaFromUser();
        System.out.println("Enter whole location for playground: ");
        String location = Validation.getStringFromUser();
        System.out.println("Enter description of playground: ");
        String description = Validation.getStringFromUser();
        System.out.println("Enter price per hour of playground: ");
        double pricePerHour = Validation.getDoubleFromUser();
        System.out.println("Enter width of playground: ");
        double width = Validation.getDoubleFromUser();
        System.out.println("Enter height of playground: ");
        double height = Validation.getDoubleFromUser();
        System.out.println("Enter available hours of playground: ");
        List<String> availableHours = new ArrayList<String>();
        String hours = Validation.getStringFromUser();
        String[] hour = hours.split(" ");
        availableHours = Arrays.asList(hour);
        user.addPlayground(name, user.getName(), user.getUsername(), location, description, availableHours, pricePerHour, width, height);
        System.out.println("Playground added.");
    }
    /**
     * This method view all reservations of a specific playground.
     * It takes the id og the playground.
     * If this id was not found it asks the playground to enter it again.
     */
    private static void viewReservationsOfPlayground(){
        if(!user.getPlaygrounds().isEmpty()){
            System.out.println("Enter ID of the playground: ");
            String id = Validation.getStringNumFromUser();
            boolean found = user.viewReservationsOfPlayground(id);
            if(!found){
                System.out.println("Playground not found, please try again.");
                viewReservationsOfPlayground();
            }
            return;
        }
        System.out.println("No playgrounds yet.");
    }
    /**
     * This method shows the menu of the information which the player can edit it.
     * This method takes the information which can be edited it from the player.
     * @param updatedPlayer This is an object from User class to store new information in it.
     */
    private static void PlayerUpdatedInfoScreen(User updatedPlayer) {
        System.out.println("choose information that you want to update:");
        System.out.println("[1] Name");
        System.out.println("[2] Id");
        System.out.println("[3] Password");
        System.out.println("[4] Email");
        int choice = Validation.getIntFromUser(1, 4);
        switch (choice) {
            case 1:
                System.out.println("Enter the new name");
                String newName = Validation.getStringAlphaFromUser();
                updatedPlayer.setName(newName);
                break;
            case 2:
                System.out.println("Enter the new username");
                String newUsername = Validation.getStringFromUser();
                updatedPlayer.setUsername(newUsername);
                break;
            case 3:
                System.out.println("Enter the new Password");
                boolean isStrong;
                do {
                    String newPassword = Validation.getStringFromUser();
                    isStrong = Validation.invalidPassword(newPassword);
                    if (!isStrong)
                        System.out.println("password is weak, please reenter strong one: ");
                    else {
                        updatedPlayer.setPassword(newPassword);
                    }
                } while (!isStrong);
                break;
            case 4:
                System.out.println("Enter the new Email");
                boolean isValid;
                do {
                    String newEmail = Validation.getStringFromUser();
                    isValid = Validation.invalidEmail(newEmail);
                    if (!isValid)
                        System.out.println("inValid email, please reenter valid one: ");
                    else {
                        updatedPlayer.setEmail(newEmail);
                    }
                } while (!isValid);
                break;
            default:
                break;
        }
    }
    /**
     * This method updates the information which the player input it.
     * This method asks the player if he want to update another information.
     */
    private static void editPlayerInfo() {
        User updatedPlayer = new User();
        boolean anotherUpdate;
        do{
            PlayerUpdatedInfoScreen(updatedPlayer);
            System.out.println("do you want update information again?");
            anotherUpdate = checkOperation();
        }while(anotherUpdate);
        user.updatePlayerInfo(updatedPlayer);
        System.out.println("Information updated.");
    }
    /**
     * This method allows the player to see all available playgrounds without filter them.
     * It asks him if he want to book any playground of them.
     */
    private static void viewAvailablePlaygrounds(){
        List<Playground> availablePlaygrounds = user.getAvailablePlaygrounds();
        if(!availablePlaygrounds.isEmpty()){
            for(Playground playground : availablePlaygrounds){
                System.out.println(playground);
                System.out.println("----------------------------------------");
            }
            System.out.println("Do you wanna book a playground?");
            boolean checkAnswer = checkOperation();
            if(checkAnswer)
                bookingPlayground();
        }else
            System.out.println("No playground found.");
    }
    /**
     * This method allows the player to see available playgrounds in specific area.
     * It takes from player the area he want playground in it.
     * It asks him if he want to book any playground of them.
     */
    private static void filterLocation(){
        System.out.println("Enter a specific area: ");
        String area = Validation.getStringAlphaFromUser();
        List<Playground> availablePlaygrounds = user.filterLocation(area);
        if(!availablePlaygrounds.isEmpty()){
            for(Playground playground : availablePlaygrounds){
                System.out.println(playground);
                System.out.println("----------------------------------------");
            }
            System.out.println("Do you wanna book a playground?");
            boolean checkAnswer = checkOperation();
            if(checkAnswer)
                bookingPlayground();
        }else
            System.out.println("No playground found in this area.");
    }
    /**
     * This method allows the player to see available playgrounds in specific hour.
     * It takes from player a specific hour to book.
     * It asks him if he want to book any playground of them.
     */
    private static void filterHours(){
        System.out.println("Enter a specific hour: ");
        String hour = Validation.getStringFromUser();
        List<Playground> availablePlaygrounds = user.filterHours(hour);
        if(!availablePlaygrounds.isEmpty()){
            for(Playground playground : availablePlaygrounds){
                System.out.println(playground);
                System.out.println("----------------------------------------");
            }
            System.out.println("Do you wanna book a playground?");
            boolean checkAnswer = checkOperation();
            if(checkAnswer)
                bookingPlayground();
        }else
            System.out.println("No playground found in this hour.");
    }
    /**
     * This method allows the player to see available playgrounds with specific range of price.
     * It takes from player the maximum price would he pay for playground.
     * It asks him if he want to book any playground of them.
     */
    private static void filterPlaygroundPrice(){
        System.out.println("Enter a max range for price: ");
        double price = Validation.getDoubleFromUser();
        List<Playground> availablePlaygrounds = user.filterPlaygroundPrice(price);
        if(!availablePlaygrounds.isEmpty()){
            for(Playground playground : availablePlaygrounds){
                System.out.println(playground);
                System.out.println("----------------------------------------");
            }
            System.out.println("Do you wanna book a playground?");
            boolean checkAnswer = checkOperation();
            if(checkAnswer)
                bookingPlayground();
        }else{
            System.out.println("No playground found with this price.");
        }
    }
    /**
     * This method allows the player to see available playgrounds in specific area, in specific hour, and with specific range of price.
     * It takes from player the area he want playground in it, a specific hour to book, and a maximum price would he pay for playground.
     * It asks him if he want to book any playground of them.
     */
    private static void filterAll(){
        System.out.println("Enter a specific area: ");
        String area = Validation.getStringAlphaFromUser();
        System.out.println("Enter a specific hour: ");
        String hour = Validation.getStringFromUser();
        System.out.println("Enter a max range for price: ");
        double price = Validation.getDoubleFromUser();
        List<Playground> availablePlaygrounds = user.filterAll(area, hour, price);
        if(!availablePlaygrounds.isEmpty()){
            for(Playground playground : availablePlaygrounds){
                System.out.println(playground);
                System.out.println("----------------------------------------");
            }
            System.out.println("Do you wanna book a playground?");
            boolean checkAnswer = checkOperation();
            if(checkAnswer)
                bookingPlayground();
        }else
            System.out.println("No playground found with this requirements.");
    }
    /**
     * This method allows the player to book a specific playground in specific hour with playground id.
     * It takes playground id, an hour, and the password of player to withdraw the price of reservation from player.
     * If the playground was not found it will ask the player to try again.
     */
    private static void bookingPlayground(){
        System.out.println("Enter playground ID: ");
        String id = Validation.getStringNumFromUser();
        System.out.println("Enter hour you want to book: ");
        String hour = Validation.getStringFromUser();
        System.out.println("Enter your password to withdraw from EWallet: ");
        String password = Validation.getStringFromUser();
        boolean finish = user.bookingPlayground(id, hour, password);
        if(!finish)
            bookingPlayground();
    }
    /**
     * This method allows the player to cancel reservation of playground which was booked.
     * It takes playground id, the hour which the player booked the playground in it from player.
     * If the reservation was not found it will ask the player to try again.
     */
    private static void cancelReservation(){
        System.out.println("Enter playground ID: ");
        String id = Validation.getStringNumFromUser();
        System.out.println("Enter hour you booked: ");
        String hour = Validation.getStringFromUser();
        boolean accept = user.cancelReservation(id, hour);
        if(accept)
            System.out.println("Reservation cancelled successfully.");
        else{
            System.out.println("Reservation not found, please try again.");
            cancelReservation();
        }
    }
    /**
     * This method allows the player to sign reservation of playground which was booked as done to put the price of reservation on playground owner's eWallet.
     * It takes playground id, the hour which the player booked the playground in it from player.
     * If the reservation was not found it will ask the player to try again.
     */
    private static void doneReservation(){
        System.out.println("Enter playground ID: ");
        String id = Validation.getStringNumFromUser();
        System.out.println("Enter hour you booked: ");
        String hour = Validation.getStringFromUser();
        boolean accept = user.doneReservation(id, hour);
        if(accept)
            System.out.println("Reservation done.");
        else{
            System.out.println("Reservation not found, please try again.");
            doneReservation();
        }
    }
    /**
     * This method allows the player to sign reservation of playground which was booked as done or cancel it.
     */
    private static void manageReservation(){
        System.out.println("Do you want to cancel/sign as done?");
        boolean answer = checkOperation();
        if(answer){
            System.out.println("choose from menu: ");
            System.out.println("[1] cancel reservation.");
            System.out.println("[2] Sign reservation as done.");
            int choice = Validation.getIntFromUser(1,2);
            switch (choice){
                case 1:
                    cancelReservation();
                    break;
                case 2:
                    doneReservation();
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * This method allows the player to see his reservations which wouldn't be done or cancel yet.
     */
    private static void viewAllReservations(){
        List<Reservation> reservations = user.getAllReservations();
        if(reservations != null){
            for(Reservation reservation : reservations){
                System.out.println(reservation);
                System.out.println("--------------------------------------------");
            }
            manageReservation();
        }else
            System.out.println("No reservations found.");
    }
    /**
     * This method allows the player to see the last reservation which wouldn't be done or cancel yet.
     */
    private static void viewLastReservation(){
        Reservation reservation = user.getLastReservation();
        if(reservation != null){
            System.out.println(reservation);
            System.out.println("--------------------------------------------");
            manageReservation();
        }else
            System.out.println("No reservations found.");
    }
    /**
     * This method allows the player to create team if he has not one yet.
     * It checks if this player has a team or not.
     */
    private static void createTeam(){
        for(Team team : teams){
            if(team.teamLeader == user) {
                return;
            }
        }
        Team newTeam = new Team(user);
        teams.add(newTeam);
    }
    /**
     * This method allows the player to send invitation to another player to join his team.
     * It takes the other player name, and his email from the team leader which will send invitation.
     * This method will send an email to the other player.
     * If the player wan not found it will ask the player to try again.
     */
    private static void sendJoinTeamInvitation() {
        createTeam();
        System.out.println("Enter player name: ");
        String name = Validation.getStringAlphaFromUser();
        System.out.println("Enter player email: ");
        String email = Validation.getStringFromUser();
        Team userTeam = null;
        for(Team team : teams){
            if(team.teamLeader.getUsername().equals(user.getUsername())){
                userTeam = team;
            }
        }
        assert userTeam != null;
        if (userTeam.getPlayers().size() < 11) {
            Invitation invitation = user.sendJoinTeamInvitation(name, email);
            if (invitation == null) {
                System.out.println("Player can't be found, please try again.");
                sendJoinTeamInvitation();
            }else{
                sendMail(invitation.getInvitationReceiver().getEmail(), invitation.getMessage());
                invitations.add(invitation);
                System.out.println("Invitation sent successfully.");
            }
        }else{
            System.out.println("Your team is complete it must be at least 11 players.");
        }
    }
    /**
     * This method allows the player to remove a player from his team.
     * it takes the other player username from the team leader.
     */
    private static void removePlayerFromTeam(){
        Team userTeam = null;
        for(Team team : teams){
            if(team.teamLeader.getUsername().equals(user.getUsername())){
                userTeam = team;
            }
        }
        if(userTeam == null){
            System.out.println("You don't have a team yet.");
            return;
        }else if (userTeam.getPlayers().isEmpty()){
            System.out.println("No players in your team yet.");
            return;
        }else{
            System.out.println("Enter the username of player you want to remove: ");
            String username = Validation.getStringAlphaFromUser();
            for(User player : userTeam.getPlayers()){
                if(player.getUsername().equals(username)){
                    userTeam.removePlayer(player);
                    System.out.println("Player removed.");
                    return;
                }
            }
        }
        System.out.println("Player can't be found, please try again.");
        removePlayerFromTeam();
    }
    /**
     * This method allows the player to send invitation to another player to play with him.
     * It takes the other player name, and his email from the player which will send invitation.
     * This method will send an email to the other player.
     * If the player wan not found it will ask the player to try again.
     */
    private static void sendPlayInvitationToPlayer(){
        System.out.println("Enter player name: ");
        String name = Validation.getStringAlphaFromUser();
        System.out.println("Enter player email: ");
        String email = Validation.getStringFromUser();
        Invitation invitation = user.sendPlayInvitationToPlayer(name, email);
        if(invitation == null){
            System.out.println("Player can't be found, please try again.");
            sendJoinTeamInvitation();
        }else{
            sendMail(invitation.getInvitationReceiver().getEmail(), invitation.getMessage());
            invitations.add(invitation);
            System.out.println("Invitation sent successfully.");
        }
    }
    /**
     * This method allows the player to send invitation to his team to play.
     * This method will send an email to team players.
     */
    private static void sendPlayInvitationToTeam(){
        Team userTeam = null;
        List<Invitation> teamInvitations = new ArrayList<>();
        for(Team team : teams){
            if(team.teamLeader.getUsername().equals(user.getUsername())){
                userTeam = team;
                teamInvitations = user.sendPlayInvitationToTeam();
                invitations.addAll(teamInvitations);
            }
        }
        if(userTeam == null){
            System.out.println("You don't have a team yet.");
        }else if (userTeam.getPlayers().isEmpty()){
            System.out.println("No players in your team.");
        }else {
            for(Invitation invitation : teamInvitations){
                sendMail(invitation.getInvitationReceiver().getEmail(), invitation.getMessage());
            }
            System.out.println("Invitations sent successfully.");
        }
    }
    /**
     * This method allows the player to see all invitations which was sent to him.
     * It asks him if he want to accept or reject any of them.
     * If he accepted or rejected any of them, it will send email to the invitation sender that his invitation was accepted or rejected.
     */
    private static void viewInvitations() {
        List<Invitation> userInvitations = new ArrayList<>();
        for(Invitation invitation : invitations){
            if(invitation.getInvitationReceiver().getName().equals(user.getName())
                    && invitation.getInvitationReceiver().getEmail().equals(user.getEmail())){
                userInvitations.add(invitation);
                System.out.println(invitation);
                System.out.println("---------------------------------------------");
            }
        }
        if(userInvitations.isEmpty()){
            System.out.println("No invitations found.");
            return;
        }
        System.out.println("Do you want to accept/reject any invitation?");
        boolean answer = checkOperation();
        if(answer){
            System.out.println("choose from menu: ");
            System.out.println("[1] Accept invitation.");
            System.out.println("[2] Reject invitation.");
            int choice = Validation.getIntFromUser(1,2);
            switch (choice){
                case 1:
                    acceptInvitations();
                    break;
                case 2:
                    rejectInvitation();
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * This method allows the player to accept any invitation was sent to him.
     * It takes the invitation id to accept it.
     * If the invitation was not found, it will asks him to try again.
     */
    private static void acceptInvitations() {
        System.out.println("Enter invitation id: ");
        String id = Validation.getStringNumFromUser();
        for(Invitation invitation : invitations){
            if(invitation.getId().equals(id) && invitation.getType().equals("play")){
                String message = "Hi " + invitation.getInvitationSender().getName() + "," + '\n' + invitation.getInvitationReceiver().getName() + " accepts your invitation.";
                sendMail(invitation.getInvitationSender().getEmail(), message);
                invitations.remove(invitation);
                System.out.println("Invitation accepted.");
                return;
            }else if(invitation.getId().equals(id) && invitation.getType().equals("join team")){
                for(Team team : teams){
                    if(invitation.getInvitationSender() == team.teamLeader){
                        System.out.println("Invitation accepted, you were added to the team.");
                        team.addPlayer(user);
                        invitations.remove(invitation);
                        return;
                    }
                }
            }
        }
        System.out.println("Invitation not found, please enter right id.");
        acceptInvitations();
    }
    /**
     * This method allows the player to reject any invitation was sent to him.
     * It takes the invitation id to reject it.
     * If the invitation was not found, it will asks him to try again.
     */
    private static void rejectInvitation(){
        System.out.println("Enter invitation id: ");
        String id = Validation.getStringNumFromUser();
        for(Invitation invitation : invitations){
            if(invitation.getId().equals(id)){
                String message = "Hi " + invitation.getInvitationSender().getName() + "," + '\n' + invitation.getInvitationReceiver().getName() + " rejects your invitation.";
                sendMail(invitation.getInvitationSender().getEmail(), message);
                invitations.remove(invitation);
                System.out.println("Invitation rejected.");
                return;
            }
        }
        System.out.println("Invitation not found, please enter right id.");
        rejectInvitation();
    }
    /**
     * This method allows the playground owner to see all notifications which were sent to him.
     * It asks him if he want to remove any of them after seeing them.
     */
    private static void viewNotifications() {
        List<Notification> userNotifications = new ArrayList<>();
        for(Notification notification : notifications){
            if(notification.getPayeeUsername().equals(user.getUsername())){
                userNotifications.add(notification);
                System.out.println(notification.getMessageToPayee());
                System.out.println("---------------------------------------------");
            }
        }
        if(userNotifications.isEmpty()){
            System.out.println("No notifications found.");
            return;
        }
        System.out.println("Do you want to remove any notification?");
        boolean answer = checkOperation();
        if(answer){
            deleteNotifications();
        }
    }
    /**
     * This method allows the playground owner to remove any of the notifications which were sent to him.
     * It takes the notification id to remove it.
     */
    private static void deleteNotifications(){
        System.out.println("Enter id of notification: ");
        String id = Validation.getStringNumFromUser();
        for(Notification notification : notifications){
            if(notification.getId().equals(id)){
                notifications.remove(notification);
                System.out.println("Notification removed.");
                return;
            }
        }
        System.out.println("Notification not found, please enter right id.");
        deleteNotifications();
    }
    /**
     * This method allows the player to see his team information and his players.
     */
    public static void viewTeam(){
        Team userTeam = null;
        for(Team team : teams){
            if(team.teamLeader.getUsername().equals(user.getUsername())){
                userTeam = team;
            }
        }
        if(userTeam == null){
            System.out.println("You don't have a team yet.");
        }else if (userTeam.getPlayers().isEmpty()){
            System.out.println("No players in your team.");
        }else{
            System.out.println(userTeam);
        }
    }
    /**
     * This method allows the player to add money in his eWallet.
     * It takes the value he wants to add.
     */
    public static void addToeWallet(){
        System.out.println("Enter value you want to add: ");
        double value = Validation.getDoubleFromUser();
        value = user.getEWallet() + value;
        user.setEWallet(value);
        System.out.println("Money add.");
        System.out.println("Money in your eWallet is: " + user.getEWallet());
    }

    /**
     * This method generates a random verification code and send it to the user which is signing up to complete the sign up operation.
     * @param to This is the email of the user which is signing up.
     * @return String This is the verification code which will be sent.
     */
    public static String sendSignUpVerificationCode(String to){
        Random rand = new Random();
        String verificationCode = Integer.toString(rand.nextInt(1000000));
        sendMail(to, '\n' + "Sign up code: " + verificationCode + '\n' + "don't give this code to anyone. " +
                "This code used to create GoFo account. We never ask it for anything again.");
        return verificationCode;
    }
    /**
     * This method allow the system to send mails to application users.
     * @param to This is email of the user which will be sent the mail to him.
     * @param invitationMessage This is the message which will be sent to the user in mail.
     */
    public static void sendMail(String to, String invitationMessage){
        String from = "gofootballsystem@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("gofootballsystem@gmail.com", "GoFootballSystem11");
            }
        });
        session.setDebug(false);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("GoFootball application");
            message.setText(invitationMessage);
            System.out.println("sending...");
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}