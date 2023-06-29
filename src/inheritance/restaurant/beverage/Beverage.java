package inheritance.restaurant.beverage;

import java.math.BigDecimal;

import inheritance.restaurant.Product;

public class Beverage extends Product {

    private double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }
}
