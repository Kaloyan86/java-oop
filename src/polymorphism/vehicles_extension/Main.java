package polymorphism.vehicles_extension;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

        tokens = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

        tokens = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split("\\s+");
            try {
                switch (tokens[0]) {
                    case "Drive":
                        double distance = Double.parseDouble(tokens[2]);
                        switch (tokens[1]) {
                            case "Car":
                                System.out.println(car.drive(distance));
                                break;
                            case "Truck":
                                System.out.println(truck.drive(distance));
                                break;
                            case "Bus":
                               //  bus.setEmpty(false);
                                if (bus.isEmpty()){
                                    bus.setEmpty(false);
                                    bus.setFuelConsumption(bus.getFuelConsumption() + 1.4);
                                }
                                System.out.println(bus.drive(distance));
                                break;
                        }
                        break;
                    case "Refuel":
                        double liters = Double.parseDouble(tokens[2]);
                        switch (tokens[1]) {
                            case "Car":
                                car.refuel(liters);
                                break;
                            case "Truck":
                                truck.refuel(liters);
                                break;
                            case "Bus":
                                bus.refuel(liters);
                                break;
                        }
                        break;
                    case "DriveEmpty":
                      //  bus.setEmpty(true);
                        if (!bus.isEmpty()){
                            bus.setEmpty(true);
                            bus.setFuelConsumption(bus.getFuelConsumption() - 1.4);
                        }

                        distance = Double.parseDouble(tokens[2]);
                        System.out.println(bus.drive(distance));
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
