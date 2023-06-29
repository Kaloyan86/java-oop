package inheritance.restaurant.beverage;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {

    private static final double COFFEE_MILLILITERS = 50;
    private static final BigDecimal COFFEE_PRICE = new BigDecimal(3.50);
    private static final double CAFFEINE = 150;

    private double caffeine;

    public Coffee(String name) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.caffeine = CAFFEINE;
    }

    public double getCaffeine() {
        return caffeine;
    }
}
