package design_patterns.factory;

public class CakeFactory {

    private CakeFactory() {
    }

    public static Cake createCake(String cakeType, double diameter, double price, int pieces) {
        Cake cake = null;

        switch (cakeType) {
            case "Chocolate":
                cake = new ChocolateCake(diameter, price, pieces);
                break;
            case "White":
                cake = new WhiteCake(diameter, price, pieces);
                break;
            case "Spinach":
                cake = new SpinachCake(diameter, price, pieces);
                break;
            case "Biscuit":
                cake = new BiscuitCake(diameter, price, pieces);
                break;
        }

        return cake;
    }
}
