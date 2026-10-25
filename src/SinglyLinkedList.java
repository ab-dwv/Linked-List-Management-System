import java.util.Scanner;

/**
 * Singly Linked List - each node stores data and a reference to the next node.
 */
public class SinglyLinkedList {

    // Node
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Insertion

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        System.out.println(value + " inserted at the beginning.");
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println(value + " inserted at the end.");
    }

    public void insertAtPosition(int value, int position) {
        int size = count();
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position. Valid positions are 1 to " + (size + 1) + ".");
            return;
        }
        Node newNode = new Node(value);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = head;
            for (int i = 1; i < position - 1; i++) {
                previous = previous.next;
            }
            newNode.next = previous.next;
            previous.next = newNode;
        }
        System.out.println(value + " inserted at position " + position + ".");
    }

    public void insertAfter(int target, int value) {
        Node current = head;
        while (current != null && current.data != target) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Value " + target + " not found. Nothing inserted.");
            return;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println(value + " inserted after " + target + ".");
    }

    public void insertBefore(int target, int value) {
        if (head == null) {
            System.out.println("List is empty. Nothing inserted.");
            return;
        }
        Node newNode = new Node(value);
        if (head.data == target) {     
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = head;
            while (previous.next != null && previous.next.data != target) {
                previous = previous.next;
            }
            if (previous.next == null) {
                System.out.println("Value " + target + " not found. Nothing inserted.");
                return;
            }
            newNode.next = previous.next;
            previous.next = newNode;
        }
        System.out.println(value + " inserted before " + target + ".");
    }

    // Deletion

    /** Delete from Beginning - O(1). */
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        System.out.println(head.data + " deleted from the beginning.");
        head = head.next;
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head.next == null) {            // only one node
            System.out.println(head.data + " deleted from the end.");
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        System.out.println(current.next.data + " deleted from the end.");
        current.next = null;
    }

    public void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        int size = count();
        if (position < 1 || position > size) {
            System.out.println("Invalid position. Valid positions are 1 to " + size + ".");
            return;
        }
        if (position == 1) {
            System.out.println(head.data + " deleted from position 1.");
            head = head.next;
            return;
        }
        Node previous = head;
        for (int i = 1; i < position - 1; i++) {
            previous = previous.next;
        }
        System.out.println(previous.next.data + " deleted from position " + position + ".");
        previous.next = previous.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head.data == value) {
            head = head.next;
            System.out.println(value + " deleted.");
            return;
        }
        Node previous = head;
        while (previous.next != null && previous.next.data != value) {
            previous = previous.next;
        }
        if (previous.next == null) {
            System.out.println("Value " + value + " not found.");
            return;
        }
        previous.next = previous.next.next;
        System.out.println(value + " deleted.");
    }

    // Search / Update / Display / Count

    public void search(int value) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Value " + value + " found at position " + position + ".");
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("Value " + value + " not found.");
    }

    public void update(int oldValue, int newValue) {
        Node current = head;
        while (current != null) {
            if (current.data == oldValue) {
                current.data = newValue;
                System.out.println(oldValue + " updated to " + newValue + ".");
                return;
            }
            current = current.next;
        }
        System.out.println("Value " + oldValue + " not found. Nothing updated.");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("NULL");
        System.out.println(sb);
    }

    public int count() {
        int total = 0;
        Node current = head;
        while (current != null) {
            total++;
            current = current.next;
        }
        return total;
    }

    // Max / Min / Middle

    public void findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int max = head.data;
        for (Node current = head.next; current != null; current = current.next) {
            if (current.data > max) {
                max = current.data;
            }
        }
        System.out.println("Maximum value: " + max);
    }

    public void findMinimum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int min = head.data;
        for (Node current = head.next; current != null; current = current.next) {
            if (current.data < min) {
                min = current.data;
            }
        }
        System.out.println("Minimum value: " + min);
    }

    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node slow = head;
        Node fast = head;
        int position = 1;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            position++;
        }
        System.out.print("Middle element: " + slow.data + " (position " + position + ")");
        if (count() % 2 == 0) {
            System.out.print(" - even number of nodes, second middle shown");
        }
        System.out.println();
    }

    // Reverse / Sort / Remove Duplicates

    public void reverse() {
        if (head == null || head.next == null) {
            System.out.println("Nothing to reverse (list has fewer than 2 nodes).");
            return;
        }
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        System.out.println("List reversed.");
    }

    /** Sort ascending using Bubble Sort (swaps data) - O(n^2). */
    public void sort() {
        if (head == null || head.next == null) {
            System.out.println("Nothing to sort (list has fewer than 2 nodes).");
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("List sorted in ascending order.");
    }

    /** Remove repeated values, keeping the first occurrence - O(n^2). */
    public void removeDuplicates() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int removed = 0;
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;   // unlink the duplicate
                    removed++;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        if (removed == 0) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println(removed + " duplicate node(s) removed.");
        }
    }

    // Menu

    public void runMenu(Scanner sc) {
        int choice;
        do {
            System.out.println();
            System.out.println("********** Operation on Singly Linked List **********");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display");
            System.out.println("13. Count Nodes");
            System.out.println("14. Find Maximum");
            System.out.println("15. Find Minimum");
            System.out.println("16. Find Middle Element");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove Duplicates");
            System.out.println("20. Exit");
            choice = Main.readInt(sc, "Enter the choice:- ");
            System.out.println();

            switch (choice) {
                case 1:
                    insertAtBeginning(Main.readInt(sc, "Enter value: "));
                    break;
                case 2:
                    insertAtEnd(Main.readInt(sc, "Enter value: "));
                    break;
                case 3: {
                    int value = Main.readInt(sc, "Enter value: ");
                    int position = Main.readInt(sc, "Enter position: ");
                    insertAtPosition(value, position);
                    break;
                }
                case 4: {
                    int target = Main.readInt(sc, "Enter the existing value to insert after: ");
                    int value = Main.readInt(sc, "Enter new value: ");
                    insertAfter(target, value);
                    break;
                }
                case 5: {
                    int target = Main.readInt(sc, "Enter the existing value to insert before: ");
                    int value = Main.readInt(sc, "Enter new value: ");
                    insertBefore(target, value);
                    break;
                }
                case 6:
                    deleteFromBeginning();
                    break;
                case 7:
                    deleteFromEnd();
                    break;
                case 8:
                    deleteFromPosition(Main.readInt(sc, "Enter position: "));
                    break;
                case 9:
                    deleteByValue(Main.readInt(sc, "Enter value to delete: "));
                    break;
                case 10:
                    search(Main.readInt(sc, "Enter value to search: "));
                    break;
                case 11: {
                    int oldValue = Main.readInt(sc, "Enter the value to update: ");
                    int newValue = Main.readInt(sc, "Enter the new value: ");
                    update(oldValue, newValue);
                    break;
                }
                case 12:
                    display();
                    break;
                case 13:
                    System.out.println("Number of nodes: " + count());
                    break;
                case 14:
                    findMaximum();
                    break;
                case 15:
                    findMinimum();
                    break;
                case 16:
                    findMiddle();
                    break;
                case 17:
                    reverse();
                    break;
                case 18:
                    sort();
                    break;
                case 19:
                    removeDuplicates();
                    break;
                case 20:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 20.");
            }
        } while (choice != 20);
    }
}