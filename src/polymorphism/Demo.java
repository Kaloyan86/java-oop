package polymorphism;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import interfaces_and_abstraction.CreditCardPayment;
import interfaces_and_abstraction.Payment;
import interfaces_and_abstraction.PaypalPayment;
import interfaces_and_abstraction.RevolutPayment;

public class Demo {

    /*

    Polymorphism is the ability of an object to take on different forms.

    In Java, polymorphism refers to the ability of a class to provide different implementations of a method,
    depending on the type of object that is passed to the method.

    There are two types of polymorphism dynamic and static A.K.A runtime and compile time.

    The static polymorphism can be achieved by method overloading.
    Overloading allows different methods to have the same name,
    but different signatures where the signature can differ by the number of input parameters
    or type of input parameters or both.
    Overloading is related to compile-time (or static) polymorphism.

    Dynamic polymorphism: Overriding is a feature that allows a subclass
    or child class to provide a specific implementation of a method
    that is already provided by one of its super-classes or parent classes.

    When a method in a subclass has the same name, same parameters or signature,
    and same return type (or sub-type) as a method in its super-class,
    then the method in the subclass is said to override the method in the super-class.

     */

    public static void main(String[] args) {
        List<Payment> paymentList = new LinkedList<>();
        Payment paypalPayment = new PaypalPayment("kaloyan@mail.com", "asd");
        Payment cardPayment = new CreditCardPayment("VISA", "123456");

        paymentList.add(paypalPayment);
        paymentList.add(cardPayment);
        paymentList.add(new RevolutPayment());

        printPaymentList(paymentList);
    }

    static void printPaymentList(List<Payment> paymentList) {
        paymentList.forEach(System.out::println);
        //        paymentList.forEach(payment -> payment.pay(10));
    }
}






