package football;

import java.util.Random;
/**
 * The Invitation class implements an application that creates invitations which will be send from players to each other.
 */
public class Invitation {
    private final User invitationSender;
    private final User invitationReceiver;
    private final String message;
    private final String type;
    private String id;
    /**
     * This is parameterize constructor for this class to set invitation sender, invitation receiver, type of invitation, invitation id.
     * Creates reservation booked player, reserved playground, playground owner, price for reservation, and time of reservation.
     * @param invitationSender This is player who send the invitation to another player.
     * @param invitationReceiver This is player who was sent the invitation.
     * @param type This is type of invitation if it play invitation or join team invitation.
     * @param message This is the message which wrote in the invitation.
     */
    public Invitation(User invitationSender, User invitationReceiver, String type, String message){
        this.invitationSender = invitationSender;
        this.invitationReceiver = invitationReceiver;
        this.message = message;
        this.type = type;
        this.generateRandomNumbers();
    }
    /**
     * This method gets invitation message.
     * @return Playground This returns invitation message which will be sent.
     */
    public String getMessage() {
        return message;
    }
    /**
     * This method gets invitation sender.
     * @return Playground This returns invitation sender who sent invitation.
     */
    public User getInvitationSender() {
        return invitationSender;
    }
    /**
     * This method gets invitation receiver.
     * @return Playground This returns invitation receiver.
     */
    public User getInvitationReceiver() {
        return invitationReceiver;
    }
    /**
     * This method gets type of invitation if it play invitation or join team invitation.
     * @return Playground This returns type of invitation.
     */
    public String getType() {
        return type;
    }
    /**
     * This method gets unique id for the invitation.
     * @return User This returns a unique id for the invitation.
     */
    public String getId() {
        return id;
    }
    /**
     * This method sets a unique id for the invitation.
     */
    public void generateRandomNumbers() {
        Random rand = new Random();
        int num = rand.nextInt(10000);
        for(Invitation invitation : Main.invitations){
            if(invitation.id.equals(Integer.toString(num))) {
                generateRandomNumbers();
            }
        }
        this.id = Integer.toString(num);
    }
    /**
     * This method shows invitation information.
     * @return String This returns the string representation of the invitation information.
     */
    @Override
    public String toString(){
        return "Invitation ID: " + this.id + '\n' +
                "From: " + this.invitationSender.getName() + '\n' +
                "To: " + this.invitationReceiver.getName() + '\n' + this.message;
    }
}