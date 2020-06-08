package football;
/**
 * The Payment class implements an application that withdraws ,deposits in eWallet, and shows payer and payee.
 */
public class Payment {
    private final double amount;
    private User payer;
    private User payee;
    /**
     * This is parameterize constructor for this class to set payer, payee, and amount.
     * Creates a payment with its payer, payee, and amount.
     * @param payer This is the first parameter of parameterize constructor.
     * @param payee This is the second parameter of parameterize constructor.
     * @param amount This is the third parameter of parameterize constructor.
     */
    Payment(User payer, User payee, double amount){
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
    }
    /**
     * This method gets the amount.
     * @return int This returns amount which will be payed to playground owner.
     */
    public double getAmount() {
        return amount;
    }
    /**
     * This method sets the payer of payment.
     * @param payer to set it in payer.
     */
    public void setPayer(User payer) {
        this.payer = payer;
    }
    /**
     * This method sets the payee of payment.
     * @param payee to set it in payee.
     */
    public void setPayee(User payee) {
        this.payee = payee;
    }
    /**
     * This method deposits the amount of payment in payee eWallet.
     */
    public void deposit(){
        this.payee.setEWallet(this.payee.getEWallet() + this.amount);
    }
    /**
     * This method withdraws the amount of payment from payer eWallet.
     */
    public void withdraw(){
        this.payer.setEWallet(this.payer.getEWallet() - this.amount);
    }
}