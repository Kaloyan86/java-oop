package design_patterns.builder;

import java.util.*;

public class Main {

    private static final String CREATE_COMMAND = "CREATE";
    private static final String CONTACT_INFO_COMMAND = "INFO";
    private static final String DELETE_CONTACT_COMMAND = "DELETE";
    private static final String PHONEBOOK_COMMAND = "PHONEBOOK";
    private static final String END_COMMAND = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Phonebook phonebook = new Phonebook();

        while (!END_COMMAND.equals(command)) {

            switch (command) {
                case CREATE_COMMAND:
                    List<String> contactInfo = readContactInfo(scanner);

                    Contact contact = new Contact.Builder(contactInfo.get(0), contactInfo.get(1)).company(contactInfo.get(2))
                                                                                                 .title(contactInfo.get(3))
                                                                                                 .email(contactInfo.get(4))
                                                                                                 .website(contactInfo.get(5))
                                                                                                 .birthday(contactInfo.get(6))
                                                                                                 .build();
                    phonebook.addContact(contact);
                    break;
                case CONTACT_INFO_COMMAND:
                    String contactName = scanner.nextLine();
                    System.out.println(phonebook.getContactByName(contactName).toString());
                    break;
                case DELETE_CONTACT_COMMAND:
                    contactName = scanner.nextLine();
                    phonebook.deleteContactByName(contactName);
                    break;
                case PHONEBOOK_COMMAND:
                    phonebook.getAllContacts()
                             .forEach(System.out::println);
                    break;
            }

            command = scanner.nextLine();
        }
    }

    private static List<String> readContactInfo(Scanner input) {
        List<String> contactInfo = new ArrayList<>();

        System.out.print("Name: ");
        contactInfo.add(input.nextLine());

        System.out.print("Number: ");
        contactInfo.add(input.nextLine());

        System.out.print("Company: ");
        contactInfo.add(input.nextLine());

        System.out.print("Title: ");
        contactInfo.add(input.nextLine());

        System.out.print("Email: ");
        contactInfo.add(input.nextLine());

        System.out.print("Website: ");
        contactInfo.add(input.nextLine());

        System.out.print("Birthday: ");
        contactInfo.add(input.nextLine());

        return contactInfo;
    }
}
