package football;
/**
 * The Reservation class implements an application that creates a reservation for specific playground in specific time.
 */
public class Reservation {
    private final User bookedPlayer;
    private final Playground reservedPlayground;
    private final User playgroundOwner;
    private final Payment payment;
    private final String time;
    private boolean done;
    /**
     * This is parameterize constructor for this class to set booked player, reserved playground, playground owner, price for reservation, and time.
     * Creates reservation booked player, reserved playground, playground owner, price for reservation, and time of reservation.
     * @param bookedPlayer This is player who booked playground.
     * @param reservedPlayground This is reserved playground.
     * @param playgroundOwner This is owner of reserved playground.
     * @param price This is the value of money which player will pay it for reservation.
     * @param time This is time of reservation.
     */
    Reservation(User bookedPlayer, Playground reservedPlayground, User playgroundOwner, double price, String time){
        this.bookedPlayer = bookedPlayer;
        this.reservedPlayground = reservedPlayground;
        this.playgroundOwner = playgroundOwner;
        this.payment = new Payment(bookedPlayer, playgroundOwner, price);
        this.time = time;
        this.done = false;
    }
    /**
     * This method gets reserved playground.
     * @return Playground This returns reserved playground.
     */
    public Playground getReservedPlayground() {
        return reservedPlayground;
    }
    /**
     * This method gets time of reservation.
     * @return String This returns time of reservation.
     */
    public String getTime() {
        return time;
    }
    /**
     * This method tells if reservation finished or not.
     * @return boolean This returns if reservation finished or not.
     */
    public boolean isDone() {
        return done;
    }
    /**
     * This method sets if reservation finished or not.
     * @param done to set if reservation finished or not.
     */
    public void setDone(boolean done) {
        this.done = done;
    }
    /**
     * This method gets payment of reservation.
     * @return Payment This contains the payer, payee, and amount which payed.
     */
    public Payment getPayment() {
        return payment;
    }
    /**
     * This method show reservation information.
     * @return String This returns the string representation of the reservation information.
     */
    @Override
    public String toString(){
        return "Booked player name: " + this.bookedPlayer.getName() + '\n' +
                "Booked player id: " + this.bookedPlayer.getUsername() + '\n' +
                "Booking playground name: " + this.reservedPlayground.getName() + '\n' +
                "Booking playground id: " + this.reservedPlayground.getId() + '\n' +
                "Playground Owner name: " + this.playgroundOwner.getName() + '\n' +
                "Playground Owner id: " + this.playgroundOwner.getUsername() + '\n' +
                "Price: " + this.payment.getAmount() + '\n' +
                "Hour: " + this.time;

    }
}