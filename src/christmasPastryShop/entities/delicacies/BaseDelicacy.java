package christmasPastryShop.entities.delicacies;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import static christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseDelicacy implements Delicacy {

    private String name;
    private double portion;
    private double price;

    public BaseDelicacy(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    public void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }

        this.portion = portion;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }

        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2flv", this.name, this.portion, this.price);
    }
}
