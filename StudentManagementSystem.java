import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    static HashMap<Integer, String> studentMap = new HashMap<>();
    static final String FILE_NAME = "students.txt";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--student management menu--");
            System.out.println("1. Add student");
            System.out.println("2. save to File");
            System.out.println("3. Load from File");
            System.out.println("4. Search by ID");
            System.out.println("5. Remove Student");
            System.out.println("6. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> saveToFile();
                case 3 -> loadFromFile();
                case 4 -> searchStudent(sc);
                case 5 -> removeStudent(sc);
                case 6 -> displayAll();
                case 0 -> System.out.println("Exiting program.");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
        sc.close();  // Close the scanner here
    }

    static void addStudent(Scanner sc) {
        System.out.println("Enter Student ID: ");
        int id = sc.nextInt();// consume newline
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        if (studentMap.containsKey(id)) {
            System.out.println("ID already exists!");
        } else {
            studentMap.put(id, name);
            System.out.println("Student added.");
        }
    }

    static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    static void loadFromFile() {
        studentMap.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                studentMap.put(id, name);
            }
            System.out.println("Data loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }

    static void searchStudent(Scanner sc) {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        if (studentMap.containsKey(id)) {
            System.out.println("Name: " + studentMap.get(id));
        } else {
            System.out.println("Student ID not found.");
        }
    }

    static void removeStudent(Scanner sc) {
        System.out.print("Enter ID to remove: ");
        int id = sc.nextInt();
        if (studentMap.remove(id) != null) {
            System.out.println("Student removed.");
        } else {
            System.out.println("ID not found.");
        }
    }

    static void displayAll() {
        if (studentMap.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("\nStudent List:");
            for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
            }
        }
    }
}
