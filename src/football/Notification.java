package football;

import java.util.Random;
/**
 * The Notification class implements an application that creates notification that tells the playground owner that player payed for him.
 */
public class Notification {
    private final String payeeUsername;
    private String id;
    private final String messageToPayee;
    /**
     * This is parameterize constructor for this class to set payer, payee and the amount which was payed.
     * Creates notification with unique id, and message telling the payee that he has been payed the amount.
     * @param payerName This is name of who payed money.
     * @param payeeUsername This is username of who is payed money.
     * @param amount This is value of money which was payed.
     */
    public Notification(String payerName, String payeeUsername, double amount){
        this.payeeUsername = payeeUsername;
        this.generateRandomNumbers();
        this.messageToPayee = "You was payed " + amount + " from " + payerName + '\n' + "Notification ID: " + id;
    }
    /**
     * This method gets the payee username.
     * @return String This returns the payee username.
     */
    public String getPayeeUsername() {
        return payeeUsername;
    }
    /**
     * This method gets the message which will appear to payee which telling him that he has been payed money.
     * @return String This returns the message which will appear to payee.
     */
    public String getMessageToPayee() {
        return messageToPayee;
    }
    /**
     * This method gets unique id for the notification.
     * @return User This returns a unique id for the notification.
     */
    public String getId() {
        return id;
    }
    /**
     * This method sets a unique id for the notification.
     */
    public void generateRandomNumbers() {
        Random rand = new Random();
        int num = rand.nextInt(10000);
        for(Notification notification : Main.notifications){
            if(notification.id.equals(Integer.toString(num))) {
                generateRandomNumbers();
            }
        }
        this.id = Integer.toString(num);
    }
}