import java.util.Scanner;

/**
 * Linked List Management System - menu-driven console application.
 */
public class Main {

    public static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            System.out.flush();
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static void compareLists() {
        String row = "%-24s | %-30s | %s%n";
        System.out.println("COMPARISON: Singly vs Doubly Linked List");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf(row, "Feature", "Singly Linked List", "Doubly Linked List");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf(row, "Node fields", "data, next", "data, prev, next");
        System.out.printf(row, "Traversal", "Forward only", "Forward and backward");
        System.out.printf(row, "Memory per node", "Less (1 reference)", "More (2 references)");
        System.out.printf(row, "Insert at beginning", "O(1)", "O(1)");
        System.out.printf(row, "Insert at end", "O(n) without tail", "O(1) with tail");
        System.out.printf(row, "Delete from beginning", "O(1)", "O(1)");
        System.out.printf(row, "Delete from end", "O(n)", "O(1) with tail");
        System.out.printf(row, "Delete a known node", "O(n), need previous node", "O(1), node has prev");
        System.out.printf(row, "Search / Display / Count", "O(n)", "O(n)");
        System.out.printf(row, "Reverse", "Reverse next links", "Swap prev/next, swap head/tail");
        System.out.printf(row, "Pointer handling", "Simple, fewer links to fix", "More links to fix, easier bugs");
        System.out.printf(row, "Best used when", "Memory is tight, forward use", "Need backward moves / end ops");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList singly = new SinglyLinkedList();
        DoublyLinkedList doubly = new DoublyLinkedList();
        int choice;

        do {
            System.out.println();
            System.out.println("==================================================");
            System.out.println(" LINKED LIST MANAGEMENT SYSTEM");
            System.out.println("==================================================");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Singly vs Doubly Linked List");
            System.out.println("4. Exit");
            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    singly.runMenu(sc);
                    break;
                case 2:
                    doubly.runMenu(sc);
                    break;
                case 3:
                    System.out.println();
                    compareLists();
                    break;
                case 4:
                    System.out.println("Thank you for using the Linked List Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } while (choice != 4);

        sc.close();
    }
}