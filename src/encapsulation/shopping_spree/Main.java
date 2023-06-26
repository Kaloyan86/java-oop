package encapsulation.shopping_spree;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import jdk.jshell.PersistentSnippet;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();
        try {
            Arrays.stream(scanner.nextLine().split(";"))
                  .forEach(p -> {
                      String[] tokens = p.split("=");
                      Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                      people.put(person.getName(), person);
                  });

            Arrays.stream(scanner.nextLine().split(";"))
                  .forEach(p -> {
                      String[] tokens = p.split("=");
                      Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                      products.put(product.getName(), product);
                  });
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String line = scanner.nextLine();

        while (!line.equals("END")) {

            String[] tokens = line.split("\\s+");

            String personName = tokens[0];
            String productName = tokens[1];
            Person person = people.get(personName);
            Product product = products.get(productName);
            try {
                person.buyProduct(product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            line = scanner.nextLine();
        }

        people.values().forEach(p -> {
            System.out.printf("%s - ", p.getName());
            if (p.getProducts().size() == 0) {
                System.out.println("Nothing bought.");
            } else {
                String productsName = p.getProducts()
                                       .stream()
                                       .map(Product::getName)
                                       .collect(Collectors.joining(", "));

                System.out.println(productsName);
            }
        });
    }
}
