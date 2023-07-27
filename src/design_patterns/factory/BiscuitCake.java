package design_patterns.factory;

public class BiscuitCake extends Cake {

    public BiscuitCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Biscuit Cake...");
    }

    @Override
    public void bake() {
        System.out.println("Baking Biscuit Cake...");
    }

    @Override
    public void box() {
        System.out.println("Boxing Biscuit Cake...");
        System.out.println("Your Biscuit Cake is ready");
        System.out.printf("Your bill is %.2f", price * pieces);
    }
}
