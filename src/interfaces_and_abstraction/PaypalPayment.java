package interfaces_and_abstraction;

public class PaypalPayment implements Payment {

    private String email;
    private String password;

    public PaypalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid by Paypal.");
    }

    public void pay() {
        System.out.println(" paid by Paypal.");
    }

    @Override
    public String toString() {
        return "PaypalPayment{" +
               "email='" + email + '\'' +
               ", password='" + password + '\'' +
               '}';
    }
}
