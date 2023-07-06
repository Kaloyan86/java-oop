package interfaces_and_abstraction;

public class Demo {

    public static void main(String[] args) {
        int amount = 100;
        Payment paypalPayment = new PaypalPayment("kaloyan@mail.com", "asd");
        Payment cardPayment = new CreditCardPayment("VISA", "123456");

        pay(paypalPayment, amount);
        pay(cardPayment, amount);
        pay(new RevolutPayment(), amount);

        pay(amount);
    }

    static void pay(Payment payment, int amount) {
        payment.pay(amount);
    }

    static void pay(int amount) {
        System.out.println(amount);
    }
}
