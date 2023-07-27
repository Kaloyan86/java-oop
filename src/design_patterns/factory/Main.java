package design_patterns.factory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cakeType = scanner.nextLine();
        double diameter = Double.parseDouble(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        int pieces = Integer.parseInt(scanner.nextLine());

        Cake cake = PastryShop.orderCake(cakeType, diameter, price, pieces);
    }
}
