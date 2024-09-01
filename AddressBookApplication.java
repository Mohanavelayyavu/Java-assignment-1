import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ContactEntry {
    private String fullName;
    private String phoneNumber;
    private String email;

    public ContactEntry(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + fullName + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

class ContactBook {
    private List<ContactEntry> entries;

    public ContactBook() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(ContactEntry entry) {
        entries.add(entry);
        System.out.println("Entry added successfully.");
    }

    public void showAllEntries() {
        if (entries.isEmpty()) {
            System.out.println("No entries found.");
        } else {
            for (ContactEntry entry : entries) {
                System.out.println(entry);
            }
        }
    }

    public void searchEntryByName(String name) {
        boolean found = false;
        for (ContactEntry entry : entries) {
            if (entry.getFullName().equalsIgnoreCase(name)) {
                System.out.println(entry);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No entry found with the name: " + name);
        }
    }
}

public class ContactBookApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactBook contactBook = new ContactBook();
        int userChoice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new entry");
            System.out.println("2. View all entries");
            System.out.println("3. Search for an entry by name");
            System.out.println("4. Exit the application");
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (userChoice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();

                    ContactEntry newEntry = new ContactEntry(name, phoneNumber, email);
                    contactBook.addEntry(newEntry);
                    break;
                case 2:
                    System.out.println("All Entries:");
                    contactBook.showAllEntries();
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    contactBook.searchEntryByName(searchName);
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (userChoice != 4);

        scanner.close();
    }
}
