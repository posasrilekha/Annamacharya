import java.util.HashMap;
import java.util.Scanner;
public class PhoneBook {
    private static HashMap<String, String> contacts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
				    displayContacts();
                    break;
				case 6:
				    System.out.println("Exiting phonebook.Goodbye!");
					break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }
    private static void showMenu() {
        System.out.println("\nPhonebook Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. Search Contact");
        System.out.println("3. Delete Contact");
		System.out.println("4.Update Contact");
        System.out.println("5. Display All Contacts");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }
    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();

        contacts.put(name, phone);
        System.out.println("Contact added successfully.");
    }

    private static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine().trim();

        if (contacts.containsKey(name)) {
            System.out.println(name + ": " + contacts.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine().trim();

        if (contacts.remove(name) != null) {
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }
	private static void updateContact() {
        System.out.print("Enter name to update: ");
        String name = scanner.nextLine().trim();

        if (contacts.containsKey(name)) {
            System.out.println("Current phone number: " + contacts.get(name));
            System.out.print("Enter new phone number: ");
            String newPhone = scanner.nextLine().trim();
            contacts.put(name, newPhone);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void displayContacts() {
    if (contacts.isEmpty()) {
        System.out.println("Phonebook is empty.");
        return;
    }
    System.out.println("\n--- All Contacts (Alphabetical Order) ---");
    contacts.keySet().stream()
        .sorted(String::compareToIgnoreCase)
        .forEach(name -> System.out.println(name + ": " + contacts.get(name)));
}

        }
