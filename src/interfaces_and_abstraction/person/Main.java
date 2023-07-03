package interfaces_and_abstraction.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> birthables = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String object = tokens[0];


            switch (object) {
                case "Citizen":
                    // Citizen {name} {age} {id} {birthdate}
                    String citizenName = tokens[1];
                    int citizenAge = Integer.parseInt(tokens[2]);
                    String citizenId = tokens[3];
                    String citizenBirthdate = tokens[4];

                    Citizen citizen = new Citizen(citizenName,
                                                  citizenAge,
                                                  citizenId,
                                                  citizenBirthdate);

                    birthables.add(citizen);
                    break;
                case "Pet":
                    // Pet {name} {birthdate}
                    String petName = tokens[1];
                    String petBirthDate = tokens[2];

                    Pet pet = new Pet(petName, petBirthDate);
                    birthables.add(pet);

                    break;
            }

            input = scanner.nextLine();
        }
        String year = scanner.nextLine();
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }

    }

}
