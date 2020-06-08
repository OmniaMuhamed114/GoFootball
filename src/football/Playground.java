package football;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * The Playground class implements an application that creates playgrounds for playground owner.
 */
public class Playground {
    private String name;
    private final String ownerName;
    private final String ownerUsername;
    private String location;
    private String description;
    private String id;
    private double pricePerHour;
    private boolean Available;
    private double width;
    private double height;
    private double size;
    private boolean pending;
    private List<String> availableHours = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();
    /**
     * This is default constructor for this class to set name of playground, owner name, owner username, location, description for it, price per hour, width, and height.
     * Creates playground with give name of it, owner name, owner username, location, description for it, price per hour, width, and height initial values.
     */
    public Playground() {
        this.name = "";
        this.ownerName = "";
        this.ownerUsername = "";
        this.location = "";
        this.description = "";
        this.pricePerHour = -1;
        this.Available = false;
        this.width = -1;
        this.height = -1;
        this.size = -1;
        this.pending = true;
    }
    /**
     * This is parameterize constructor for this class to set name of playground, owner name, owner username, location, description for it, price per hour, width, and height.
     * Creates playground with name of it, owner name, owner username, location, description for it, price per hour, width, and height.
     * @param name This is name of playground.
     * @param ownerName This is name of owner of playground.
     * @param ownerUsername This is username of owner of playground.
     * @param location This is the location of playground.
     * @param description This is a description for playground.
     * @param availableHours This is the available hours which player can book it in.
     * @param pricePerHour This is price of playground per hour.
     * @param width This is the width of playground.
     * @param height This is the height of playground.
     */
    public Playground(String name, String ownerName, String ownerUsername, String location, String description, List<String> availableHours, double pricePerHour, double width, double height) {
        this.name = name;
        this.ownerName = ownerName;
        this.ownerUsername = ownerUsername;
        this.location = location;
        this.description = description;
        this.availableHours = availableHours;
        this.generateRandomNumbers();
        this.pricePerHour = pricePerHour;
        this.Available = false;
        this.width = width;
        this.height = height;
        this.size = width * height;
        this.pending = true;
    }
    /**
     * This method sets a unique id for the playground.
     */
    public void generateRandomNumbers() {
        Random rand = new Random();
        int num = rand.nextInt(100000);
        for(User user : Main.users){
            for(Playground playground : user.getPlaygrounds()){
                if(playground.getId().equals(Integer.toString(num))) {
                    generateRandomNumbers();
                }
            }
        }
        this.id = Integer.toString(num);
    }
    /**
     * This method sets id of playground.
     * @param id to set playground id.
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     *This method gets the id of playground.
     * @return String This is id of playground.
     */
    public String getId() { return id; }
    /**
     * This method sets name of playground.
     * @param name to set name of playground.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *This method gets the name of playground.
     * @return String This is name of playground.
     */
    public String getName() {
        return name;
    }
    /**
     * This method sets location of playground.
     * @param location to set location of playground.
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     *This method gets the location of playground.
     * @return String This is location of playground.
     */
    public String getLocation() {
        return location;
    }
    /**
     * This method sets description of playground.
     * @param description to set description of playground.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     *This method gets the description of playground.
     * @return String This is description of playground.
     */
    public String getDescription() {
        return description;
    }
    /**
     * This method sets available Hours of playground.
     * @param availableHours to set available Hours of playground.
     */
    public void setAvailableHours(List<String> availableHours) {
        this.availableHours = availableHours;
    }
    /**
     *This method gets the available hours of playground.
     * @return List<String> These are available hours of playground.
     */
    public List<String> getAvailableHours() {
        return availableHours;
    }
    /**
     *This method gets the reservations of playground.
     * @return List<Reservation> These are reservations of playground.
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    /**
     * This method sets price Per Hour of playground.
     * @param pricePerHour to set price Per Hour of playground.
     */
    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
    /**
     *This method gets the price per hour of playground.
     * @return double This is price per hour of playground.
     */
    public double getPricePerHour() {
        return pricePerHour;
    }
    /**
     * This method sets the availability of playground.
     * @param available to set the availability of playground.
     */
    public void setAvailable(boolean available) {
        Available = available;
    }
    /**
     *This method gets if the playground is available or not.
     * @return boolean This is an availability of playground.
     */
    public boolean isAvailable() {
        return Available;
    }
    /**
     * This method sets width of playground.
     * @param width to set width of playground.
     */
    public void setWidth(double width) {
        this.width = width;
    }
    /**
     *This method gets the width of playground.
     * @return double This is width of playground.
     */
    public double getWidth() { return width; }
    /**
     * This method sets height of playground.
     * @param height to set height of playground.
     */
    public void setHeight(double height) {
        this.height = height;
    }
    /**
     *This method gets the height of playground.
     * @return double This is height of playground.
     */
    public double getHeight() {
        return height;
    }
    /**
     * This method sets size of playground.
     * @param height to set height of playground.
     * @param width to set
     */
    public void setSize(double height, double width) {this.size = width * height;}
    /**
     *This method gets if the playground is pending or not.
     * @return boolean This is a flag tells us if the playground is pending or not.
     */
    public boolean isPending() { return pending; }
    /**
     * This method sets if playground is pending or not.
     * @param pending to set if playground is pending or not.
     */
    public void setPending(boolean pending) { this.pending = pending; }
    /**
     * This method adds a reservation to reservations list of playground.
     * @param reservation to add it to the reservation list.
     */
    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
    }
    /**
     * This method shows playground information.
     * @return String This returns the string representation of the playground information.
     */
    @Override
    public String toString(){
        StringBuilder playgroundInfo = new StringBuilder(
                "Name: " + this.name + '\n' +
                "Name of owner: " + this.ownerName + '\n' +
                "Username of owner: " + this.ownerUsername + '\n' +
                "Location: " + this.location + '\n' +
                "Description: " + this.description + '\n' +
                "Id: " + this.id + '\n' +
                "pricePerHour: " + this.pricePerHour + '\n' +
                "isAvailable: " + this.Available + '\n' +
                "width: " + this.width + '\n' +
                "height: " + this.height + '\n' +
                "size: " + this.size + '\n' +
                "Pending: " + this.pending + '\n' +
                "availableHours:");
        for(String hour : this.availableHours)
            playgroundInfo.append(" ").append(hour).append(" ");
        return playgroundInfo.toString();
    }
}