package design_patterns.factory;

public class PastryShop {

    private PastryShop() {
    }

    public static Cake orderCake(String cakeType, double diameter, double price, int pieces) {
        Cake cake = CakeFactory.createCake(cakeType, diameter, price, pieces);
        cake.prepare();
        cake.bake();
        cake.box();

        return cake;
    }
}
