package football;

import java.util.ArrayList;
import java.util.List;
/**
 * The User class implements an application that creates a user account for this application which can be a player, playground owner ,or administrator.
 * This class make user can manage his account on this application.
 * The player can book a specific playground, cancel reservation or accept it, send invitation to any player to play with him or to his team, and can send invitation to ant player to join his team.
 * Every player can create only one team.
 * The player can accept the invitations which was sent to him or reject them.
 * The playground owner can add a new playground, edit information of his playgrounds, show notification with payment which was payed to him.
 * Every playground owner can own a playground or more.
 * The administrator can manage playgrounds on this system.
 * He can approve the playgrounds, suspend them if he has been notified of any complaint, activate playgrounds if he knows that the complaint will not be repeated, and delete playgrounds from this system.
 */
public class User {
    private String name;
    private String username;
    private String email;
    private String password;
    private double eWallet;
    private final String roll;
    private String address;
    private String phone;
    private final List<Playground> playgrounds = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();
    /**
     * This is default constructor for this class to set name of user, username of him, password of this account, his email, the value in his eWallet, his role, his address, and his phone for the playground owner.
     * Creates user with give name, username, password, email, the value in his eWallet, role, address, and phone initial values.
     */
    User() {
        this.name = "";
        this.username = "";
        this.password = "";
        this.email = "";
        this.eWallet = -1;
        this.roll = "";
        this.address = "";
        this.phone = "";
    }
    /**
     * This is parameterize constructor for this class to set name of playground, owner name, owner username, location, description for it, price per hour, width, and height.
     * * Creates user with give name, username, password, email, the value in his eWallet, role, address, and phone.
     * @param name This is name of user.
     * @param username This is username of user.
     * @param email This is email of user.
     * @param password This is the password of user account.
     * @param roll This is the roll of user. It can be player, playground owner, or administrator.
     */
    User(String name, String username, String email, String password, String roll) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.eWallet = -1;
        this.roll = roll;
        this.address = "";
        this.phone = "";
    }
    /**
     * This is parameterize constructor for this class to set name of playground, owner name, owner username, location, description for it, price per hour, width, and height.
     * * Creates user with give name, username, password, email, the value in his eWallet, role, address, and phone.
     * @param name This is name of user.
     * @param username This is username of user.
     * @param email This is email of user.
     * @param password This is the password of user account.
     * @param eWallet This is the value in user's eWallet.
     * @param roll This is the roll of user. It can be player, playground owner, or administrator.
     */
    User(String name, String username, String email, String password, double eWallet, String roll) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.eWallet = eWallet;
        this.roll = roll;
        this.address = "";
        this.phone = "";
    }
    /**
     * This method gets the name of user.
     * @return String This is name of user.
     */
    public String getName() { return name; }
    /**
     * This method sets name of user.
     * @param name to set name of user.
     */
    public void setName(String name) { this.name = name; }
    /**
     * This method gets the username of user.
     * @return String This is username of user.
     */
    public String getUsername() { return username; }
    /**
     * This method sets username of user.
     * @param username to set username of user.
     */
    public void setUsername(String username) { this.username = username; }
    /**
     * This method gets the email of user.
     * @return String This is email of user.
     */
    public String getEmail() { return email; }
    /**
     * This method sets the email of user.
     * @param email to set email of user.
     */
    public void setEmail(String email) { this.email = email; }
    /**
     * This method sets the password of user.
     * @param password to set password of user.
     */
    public void setPassword(String password) { this.password = password; }
    /**
     * This method gets the password of user.
     * @return String This is password of user.
     */
    public String getPassword() { return password; }
    /**
     * This method sets money in user's eWallet.
     * @param eWallet to set money in eWallet of user.
     */
    public void setEWallet(double eWallet) {
        this.eWallet = eWallet;
    }
    /**
     * This method gets money in user's eWallet.
     * @return double This is money in user's eWallet.
     */
    public double getEWallet() {
        return eWallet;
    }
    /**
     * This method gets the roll of user.
     * @return String This is roll of user.
     */
    public String getRoll() { return roll; }
    /**
     * This method gets the playgrounds of a playground owner.
     * @return List of playgrounds This is the playgrounds of a playground owner.
     */
    public List<Playground> getPlaygrounds() {
        return playgrounds;
    }
    /**
     * This method allows administrator to see the pending playground to decide approve it or no.
     * @return boolean This is a flag tells if there is pending playground or not.
     */
    public boolean viewPendingPlayground(){
        boolean found = false;
        for(User user : Main.users){
            for(Playground playground : user.playgrounds){
                if(playground.isPending()){
                    System.out.println(playground);
                    found = true;
                }
                System.out.println("----------------------------------------");
            }
        }
        return found;
    }
    /**
     * This method allows administrator to approve a playground after seeing its information.
     * @param ownerUsername This is the username of the playground owner.
     * @param playgroundId This is the id of playground.
     * @return boolean This is a flag tells if playground is found or not.
     */
    public boolean approvePlayground(String ownerUsername, String playgroundId){
        for(User user : Main.users){
            if(user.username.equals(ownerUsername)){
                for(Playground playground : user.playgrounds){
                    if(playground.getId().equals(playgroundId)){
                        playground.setPending(false);
                        playground.setAvailable(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * This method allows administrator to suspend a playground after receiving any complaint.
     * @param ownerUsername This is the username of the playground owner.
     * @param playgroundId This is the id of playground.
     * @return boolean This is a flag tells if playground is found or not.
     */
    public boolean suspendPlayground(String ownerUsername, String playgroundId){
        for (User user : Main.users){
            if(user.username.equalsIgnoreCase(ownerUsername)){
                for(Playground playground : user.playgrounds){
                    if(playground.getId().equalsIgnoreCase(playgroundId)){
                        playground.setAvailable(false);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * This method allows administrator to activate a playground if he knows that the complaint will not be repeated.
     * @param ownerUsername This is the username of the playground owner.
     * @param playgroundId This is the id of playground.
     * @return boolean This is a flag tells if playground is found or not.
     */
    public boolean activatePlayground(String ownerUsername, String playgroundId){
        for (User user : Main.users){
            if(user.username.equalsIgnoreCase(ownerUsername)){
                for(Playground playground : user.playgrounds){
                    if(playground.getId().equalsIgnoreCase(playgroundId)){
                        playground.setAvailable(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * This method allows administrator to delete a playground from system.
     * @param ownerUsername This is the username of the playground owner.
     * @param playgroundId This is the id of playground.
     * @return boolean This is a flag tells if playground is found or not.
     */
    public boolean deletePlayground(String ownerUsername, String playgroundId){
        for (User user : Main.users){
            if(user.username.equalsIgnoreCase(ownerUsername)){
                for(Playground playground : user.playgrounds){
                    if(playground.getId().equalsIgnoreCase(playgroundId)){
                        user.playgrounds.remove(playground);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * This method creates profile for playground owner by setting his phone and his address.
     * @param address This is address of the playground owner.
     * @param phone This is phone of the playground owner.
     */
    public void createProfile(String address, String phone){
        this.address = address;
        this.phone = phone;
    }
    /**
     * This method allows playground owner to add playground by setting its name, its owner name, its owner username, its location, description for it, its available hours, its price per hour, its height, and its width.
     * @param name This is the name of the playground.
     * @param ownerName This is the name of the playground owner.
     * @param ownerUsername This is the username of the playground owner.
     * @param location This is the location of the playground.
     * @param description This is the description for the playground.
     * @param availableHours These are available hours of the playground.
     * @param pricePerHour This is the price per hour of the playground.
     * @param height This is the height of the playground.
     * @param width This is the width of the playground.
     */
    public void addPlayground(String name, String ownerName, String ownerUsername, String location, String description, List<String> availableHours, double pricePerHour, double width, double height) {
        Playground newPlayground = new Playground(name, ownerName, ownerUsername, location, description, availableHours, pricePerHour, width, height);
        this.playgrounds.add(newPlayground);
    }
    /**
     * This method allows playground owner to update information of his playground.
     * @param playgroundID This is the id of the playground which will be updated.
     * @param updatedPlayground This is updated information of playground.
     * @return boolean This is a flag says if playground is found or not.
     */
    public boolean updatePlaygroundInfo(String playgroundID, Playground updatedPlayground) {
        for(Playground playground : this.playgrounds){
            if(playgroundID.equals(playground.getId())) {
                if(!updatedPlayground.getName().equals(""))
                    playground.setName(updatedPlayground.getName());
                if(!updatedPlayground.getLocation().equals(""))
                    playground.setLocation(updatedPlayground.getLocation());
                if(!updatedPlayground.getDescription().equals(""))
                    playground.setDescription(updatedPlayground.getDescription());
                if(updatedPlayground.getPricePerHour() != -1)
                    playground.setPricePerHour(updatedPlayground.getPricePerHour());
                if(!updatedPlayground.getAvailableHours().isEmpty())
                    playground.setAvailableHours(updatedPlayground.getAvailableHours());
                if(updatedPlayground.getHeight() != -1){
                    playground.setHeight(updatedPlayground.getHeight());
                    playground.setSize(playground.getHeight(), playground.getWidth());
                }
                if(updatedPlayground.getWidth() != -1){
                    playground.setWidth(updatedPlayground.getWidth());
                    playground.setSize(playground.getHeight(), playground.getWidth());
                }
                return true;
            }
        }
        return false;
    }
    /**
     * This method allows playground owner to see reservations of his playground.
     * @param playgroundId This is the id of the playground.
     * @return boolean This is a flag says if playground is found or not.
     */
    public boolean viewReservationsOfPlayground(String playgroundId){
        for(Playground playground : this.playgrounds){
            if(playground.getId().equals(playgroundId)){
                if(playground.getReservations().isEmpty()){
                    System.out.println("No reservations found.");
                    return true;
                }
                for(Reservation reservation : playground.getReservations()){
                    System.out.println(reservation);
                    System.out.println("----------------------------------------");
                }
                return true;
            }
        }
        return false;
    }
    /**
     * This method allows playground owner to see his playgrounds information.
     */
    public void viewPlaygrounds(){
        if(this.playgrounds.isEmpty()){
            System.out.println("No playgrounds yet.");
            return;
        }
        for(Playground playground : this.playgrounds){
            System.out.println(playground);
            System.out.println("----------------------------------------");
        }
    }
    /**
     * This method allows the player to see available playgrounds without filter them.
     * @return List of playgrounds These are all available playgrounds.
     */
    public List<Playground> getAvailablePlaygrounds(){
        List<Playground> availablePlaygrounds = new ArrayList<>();
        for(User user : Main.users){
            for(Playground playground : user.playgrounds){
                if(Boolean.TRUE.equals(playground.isAvailable()))
                    availablePlaygrounds.add(playground);
            }
        }
        return availablePlaygrounds;
    }
    /**
     * This method allows the player to see available playgrounds in specific area.
     * @param area This is the area which the player searches about playground in it.
     * @return List of playgrounds These are all available playgrounds in specific area.
     */
    public List<Playground> filterLocation(String area){
        List<Playground> availablePlaygrounds = new ArrayList<>();
        for(User user : Main.users){
            for(Playground playground : user.playgrounds){
                if(Boolean.TRUE.equals(playground.isAvailable())
                        && playground.getLocation().toLowerCase().contains(area.toLowerCase()))
                    availablePlaygrounds.add(playground);
            }
        }
        return availablePlaygrounds;
    }
    /**
     * This method allows the player to see available playgrounds in specific hour.
     * @param hour This is the hour which the player searches about.
     * @return List of playgrounds These are all available playgrounds in specific hour.
     */
    public List<Playground> filterHours(String hour){
        List<Playground> availablePlaygrounds = new ArrayList<>();
        for(User user : Main.users){
            for(Playground playground : user.playgrounds){
                if(Boolean.TRUE.equals(playground.isAvailable())
                        && playground.getAvailableHours().contains(hour))
                    availablePlaygrounds.add(playground);
            }
        }
        return availablePlaygrounds;
    }
    /**
     * This method allows the player to see available playgrounds with specific range of price.
     * @param price This is the max price which player want to pay for playground.
     * @return List of playgrounds These are all available playgrounds in specific range of price.
     */
    public List<Playground> filterPlaygroundPrice(double price){
        List<Playground> availablePlaygrounds = new ArrayList<>();
        for(User user : Main.users){
            for(Playground playground : user.playgrounds){
                if (Boolean.TRUE.equals(playground.isAvailable())
                        && playground.getPricePerHour() <= price && price > 0)
                    availablePlaygrounds.add(playground);
            }
        }
        return availablePlaygrounds;
    }
    /**
     * This method allows the player to see available playgrounds in specific area, in specific hour, and with specific range of price.
     * @param area This is the area which the player searches about playground in it.
     * @param hour This is the hour which the player searches about.
     * @param price This is the max price which player want to pay for playground.
     * @return List of playgrounds These are all available playgrounds in specific area, in specific hour, and in specific range of price.
     */
    public List<Playground> filterAll(String area, String hour, double price){
        List<Playground> availablePlaygrounds = new ArrayList<>();
        for(User user : Main.users){
            for(Playground playground : user.playgrounds){
                if(Boolean.TRUE.equals(playground.isAvailable()) && playground.getLocation().toLowerCase().contains(area.toLowerCase())
                        && playground.getAvailableHours().contains(hour)
                        && playground.getPricePerHour() <= price && price > 0)
                    availablePlaygrounds.add(playground);
            }
        }
        return availablePlaygrounds;
    }
    /**
     * This method allows the player to book a specific playground in specific hour with playground id.
     * @param playgroundID This is the playground id to determine which playground will be booked.
     * @param bookingHour This is the hour which the player will book the playground in it.
     * @param password This is the password of the player which booked the playground to withdraw the price of reservation from his eWallet.
     * @return boolean This is a flag says says if the reservation was booked or not.
     */
    public boolean bookingPlayground(String playgroundID, String bookingHour, String password){
        Reservation reservation = null;
        for(User user : Main.users){
            for(Playground playground : user.playgrounds){
                for(String hour : playground.getAvailableHours()){
                    if(playgroundID.equals(playground.getId())
                            && hour.equals(bookingHour)
                            && Boolean.TRUE.equals(playground.isAvailable())
                            && this.getEWallet() >= playground.getPricePerHour()
                            && this.password.equals(password)){
                        reservation = new Reservation(this, playground, user, playground.getPricePerHour(), bookingHour);
                        reservation.getPayment().withdraw();
                        this.reservations.add(reservation);
                        playground.addReservation(reservation);
                        playground.getAvailableHours().remove(hour);
                        if(playground.getAvailableHours().isEmpty())
                            playground.setAvailable(false);
                        System.out.println("booked successfully.");
                        return true;
                    } else if(this.getEWallet() < playground.getPricePerHour()){
                        System.out.println("Money in eWallet isn't enough.");
                        return true;
                    } else if(!this.password.equals(password)){
                        System.out.println("Wrong password, please try again.");
                        return false;
                    }
                }
            }
        }
        System.out.println("Playground not found.");
        return false;
    }
    /**
     * This method allows the player to cancel reservation of playground which was booked.
     * @param playgroundID This is the playground id to determine which playground was booked.
     * @param bookingHour This is the hour which the player booked the playground in it.
     * @return boolean This is a flag says says if the reservation was found or not.
     */
    public boolean cancelReservation(String playgroundID, String bookingHour) {
        for(User user : Main.users){
            for(Playground playground : user.playgrounds){
                if(playgroundID.equals(playground.getId())) {
                    for(Reservation reservation : this.reservations){
                        if(reservation.getReservedPlayground().getId().equals(playgroundID) && reservation.getTime().equals(bookingHour)){
                            playground.setAvailable(true);
                            playground.getAvailableHours().add(bookingHour);
                            this.reservations.remove(reservation);
                            playground.getReservations().remove(reservation);
                            reservation.getPayment().setPayee(this);
                            reservation.getPayment().setPayer(user);
                            reservation.getPayment().deposit();
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    /**
     * This method allows the player to sign reservation of playground which was booked as done to put the price of reservation on playground owner's eWallet.
     * @param playgroundID This is the playground id to determine which playground was booked.
     * @param bookingHour This is the hour which the player booked the playground in it.
     * @return boolean This is a flag says says if the reservation was found or not.
     */
    public boolean doneReservation(String playgroundID, String bookingHour){
        for(User user : Main.users){
            for(Playground playground : user.playgrounds){
                if(playgroundID.equals(playground.getId())) {
                    for(Reservation reservation : this.reservations){
                        if(reservation.getReservedPlayground().getId().equals(playgroundID) && reservation.getTime().equals(bookingHour) && !reservation.isDone()){
                            reservation.setDone(true);
                            reservation.getPayment().deposit();
                            playground.getAvailableHours().add(bookingHour);
                            this.reservations.remove(reservation);
                            Notification notification = new Notification(this.name, user.username, playground.getPricePerHour());
                            Main.notifications.add(notification);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    /**
     * This method allows the player to update his information.
     * @param updatedPlayer This is updated information of the player.
     */
    public void updatePlayerInfo(User updatedPlayer) {
        if(!updatedPlayer.name.equals(""))
            this.setName(updatedPlayer.name);
        if(!updatedPlayer.username.equals(""))
            this.setUsername(updatedPlayer.username);
        if(!updatedPlayer.password.equals(""))
            this.setPassword(updatedPlayer.password);
        if(!updatedPlayer.email.equals(""))
            this.setEmail(updatedPlayer.email);
    }
    /**
     * This method allows the player to see his reservations which wouldn't be done or cancel yet.
     * @return List of reservations These are all new reservations of the player which wouldn't be done or cancel yet.
     */
    public List<Reservation> getAllReservations(){
        if(this.reservations.isEmpty()){
            return null;
        }
        return this.reservations;
    }
    /**
     * This method allows the player to see the last reservation which wouldn't be done or cancel yet.
     * @return Reservation This is the last reservation which wouldn't be done or cancel yet.
     */
    public Reservation getLastReservation(){
        if(this.reservations.isEmpty()){
            return null;
        }
        return this.reservations.get((this.reservations.size())-1);
    }
    /**
     * This method allows the player to send invitation to another player to play with him.
     * @param name This is the name of the another player which has been sent the invitation.
     * @param email This is the email of the another player which has been sent the invitation.
     * @return Invitation This is the invitation which was sent.
     */
    public Invitation sendPlayInvitationToPlayer(String name, String email) {
        Invitation invitation = null;
        String message = "Hi " + name + "," + '\n' + this.getName() +" invites you to play." + '\n' + this.getName() + " hopes you accept.";
        for(User player : Main.users){
            if(player.name.equals(name) && player.email.equals(email)){
                invitation = new Invitation(this, player, "play" , message);
            }
        }
        return invitation;
    }
    /**
     * This method allows the player to send invitation to his team to play with him.
     * @return List of invitations these are the invitations which were sent.
     */
    public List<Invitation> sendPlayInvitationToTeam() {
        List<Invitation> invitations = new ArrayList<>();
        for(Team team : Main.teams){
            if(team.getTeamLeader() == this){
                for(User player : team.getPlayers()){
                    String message = "Hi " + player.getName() + "," + '\n' + this.getName() + " invites you to play." + '\n' + this.getName() + " hopes you accept.";
                    Invitation invitation = new Invitation(this, player, "play" , message);
                    invitations.add(invitation);
                }
            }
        }
        return invitations;
    }
    /**
     * This method allows the player to send invitation to another player to join his team.
     * @param name This is the name of the another player which has been sent the invitation.
     * @param email This is the email of the another player which has been sent the invitation.
     * @return Invitation This is the invitation which was sent.
     */
    public Invitation sendJoinTeamInvitation(String name, String email) {
        Invitation invitation = null;
        String message = "Hi " + name + "," + '\n' + this.getName() + " invites you to join our team." + '\n' + this.getName() + " hopes you accept.";
        for(User player : Main.users){
            if(player.name.equals(name) && player.email.equals(email)){
                invitation = new Invitation(this, player, "join team", message);
            }
        }
        return invitation;
    }
}