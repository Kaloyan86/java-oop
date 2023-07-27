package design_patterns.strategy;

/*
  Strategy pattern is useful when we have multiple algorithms
  for specific task, and we want our application to be flexible
  to choose any of the algorithm at runtime for specific task.

  Strategy pattern is example for a runtime polymorphism.

 */
public class ShoppingCart {

    public int calculateTotal() {
        int sum = 0;
//        for(Item item : items){
//            sum += item.getPrice();
//        }
        return sum;
    }

    public void pay(Payment paymentMethod) {
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}
