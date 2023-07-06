package interfaces_and_abstraction;

public class RevolutPayment implements Payment {

    private String phoneNumber;

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid by Revolut.");
    }
}
