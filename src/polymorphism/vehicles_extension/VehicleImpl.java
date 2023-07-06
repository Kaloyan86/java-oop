package polymorphism.vehicles_extension;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String drive(double distance) {
        double neededFuel = this.fuelConsumption * distance;

        DecimalFormat df = new DecimalFormat("#.##");

        String result = String.format("%s needs refueling", this.getClass().getSimpleName());

        if (this.fuelQuantity >= neededFuel) {
            result = String.format("%s travelled %s km",
                                   this.getClass().getSimpleName(),
                                   df.format(distance));

            this.fuelQuantity -= neededFuel;
        }

        return result;
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        double newFuelQuantity = this.fuelQuantity + liters;

        if (newFuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                             this.getClass().getSimpleName(),
                             this.fuelQuantity);
    }
}
