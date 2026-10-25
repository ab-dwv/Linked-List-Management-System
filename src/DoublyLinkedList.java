import java.util.Scanner;

/**
 * Doubly Linked List - each node stores data, a reference to the previous
 * node (prev) and a reference to the next node (next). The list keeps both
 * a head and a tail reference.
 */
public class DoublyLinkedList {

    // Node
    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // Private helpers - they fix head/tail and both links in one place

    private void linkBefore(Node target, int value) {
        Node newNode = new Node(value);
        newNode.next = target;
        newNode.prev = target.prev;
        if (target.prev != null) {
            target.prev.next = newNode;
        } else {
            head = newNode;             
        }
        target.prev = newNode;
    }

    /** Put a new node immediately after 'target'. */
    private void linkAfter(Node target, int value) {
        Node newNode = new Node(value);
        newNode.prev = target;
        newNode.next = target.next;
        if (target.next != null) {
            target.next.prev = newNode;
        } else {
            tail = newNode;             
        }
        target.next = newNode;
    }

    private void unlink(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;        
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;             
        }
    }
    private Node nodeAt(int position) {
        Node current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        return current;
    }
    private Node findNode(int value) {
        Node current = head;
        while (current != null && current.data != value) {
            current = current.next;
        }
        return current;
    }
    // Insertion

    public void insertAtBeginning(int value) {
        addFirst(value);
        System.out.println(value + " inserted at the beginning.");
    }

    private void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void insertAtEnd(int value) {
        addLast(value);
        System.out.println(value + " inserted at the end.");
    }

    private void addLast(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public void insertAtPosition(int value, int position) {
        int size = count();
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position. Valid positions are 1 to " + (size + 1) + ".");
            return;
        }
        if (position == 1) {
            addFirst(value);
        } else if (position == size + 1) {
            addLast(value);
        } else {
            linkBefore(nodeAt(position), value);
        }
        System.out.println(value + " inserted at position " + position + ".");
    }
    public void insertAfter(int target, int value) {
        Node node = findNode(target);
        if (node == null) {
            System.out.println("Value " + target + " not found. Nothing inserted.");
            return;
        }
        linkAfter(node, value);
        System.out.println(value + " inserted after " + target + ".");
    }

    /** Insert a new value right before the first node that holds 'target'. */
    public void insertBefore(int target, int value) {
        Node node = findNode(target);
        if (node == null) {
            System.out.println("Value " + target + " not found. Nothing inserted.");
            return;
        }
        linkBefore(node, value);
        System.out.println(value + " inserted before " + target + ".");
    }
    // Deletion

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        System.out.println(head.data + " deleted from the beginning.");
        unlink(head);
    }
    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        System.out.println(tail.data + " deleted from the end.");
        unlink(tail);
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
        Node node = nodeAt(position);
        System.out.println(node.data + " deleted from position " + position + ".");
        unlink(node);
    }
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        Node node = findNode(value);
        if (node == null) {
            System.out.println("Value " + value + " not found.");
            return;
        }
        unlink(node);
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
        Node node = findNode(oldValue);
        if (node == null) {
            System.out.println("Value " + oldValue + " not found. Nothing updated.");
            return;
        }
        node.data = newValue;
        System.out.println(oldValue + " updated to " + newValue + ".");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("NULL <- ");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        sb.append(" -> NULL");
        System.out.println(sb);
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("NULL <- ");
        Node current = tail;
        while (current != null) {
            sb.append(current.data);
            if (current.prev != null) {
                sb.append(" <-> ");
            }
            current = current.prev;
        }
        sb.append(" -> NULL");
        System.out.println(sb);
    }

    /** Count the nodes. */
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
        Node current = head;
        while (current != null) {
            Node temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        Node temp = head;
        head = tail;
        tail = temp;
        System.out.println("List reversed.");
    }

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
    public void removeDuplicates() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int removed = 0;
        Node current = head;
        while (current != null) {
            Node runner = current.next;
            while (runner != null) {
                Node nextRunner = runner.next;   // save before unlinking
                if (runner.data == current.data) {
                    unlink(runner);
                    removed++;
                }
                runner = nextRunner;
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
            System.out.println("********** Operation on Doubly Linked List **********");
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
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle Element");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Exit");
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
                    displayForward();
                    break;
                case 13:
                    displayBackward();
                    break;
                case 14:
                    System.out.println("Number of nodes: " + count());
                    break;
                case 15:
                    findMaximum();
                    break;
                case 16:
                    findMinimum();
                    break;
                case 17:
                    findMiddle();
                    break;
                case 18:
                    reverse();
                    break;
                case 19:
                    sort();
                    break;
                case 20:
                    removeDuplicates();
                    break;
                case 21:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 21.");
            }
        } while (choice != 21);
    }
}