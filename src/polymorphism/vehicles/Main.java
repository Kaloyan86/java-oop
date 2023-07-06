package polymorphism.vehicles;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

        tokens = scanner.nextLine().split("\\s+");

        Truck truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split("\\s+");

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
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
