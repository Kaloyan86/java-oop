package design_patterns.factory;

public class WhiteCake extends Cake{

    public WhiteCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing White Cake...");

    }

    @Override
    public void bake() {
        System.out.println("Baking White Cake...");

    }

    @Override
    public void box() {
        System.out.println("Boxing White Cake...");
        System.out.println("Your White Cake is ready");
        System.out.printf("Your bill is %.2f", price * pieces);
    }
}
