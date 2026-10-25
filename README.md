# Linked List Management System

A menu-driven console application in Java for practicing Singly and Doubly Linked Lists.

## Objective

Implement a Singly Linked List and a Doubly Linked List from scratch (no arrays, no `java.util.LinkedList`) with all the required operations, and compare how the two work.

## Language Used: Java

## Features
- Two complete linked list implementations with their own menus
- Every operation is a separate method
- Input validation (non-numeric input is rejected and asked again)
- Handles edge cases: empty list, one-node list, invalid positions, missing values, duplicates, zero and negative values
- Option to compare Singly vs Doubly Linked List

## Project Structure
```
Linked-List-Management-System/
|-- README.md
|-- src/
|   |-- SinglyLinkedList.java
|   |-- DoublyLinkedList.java
|   |-- Main.java
|-- sample-output/
|   |-- output.txt
|-- .gitignore
```

## Singly Linked List

Each node stores `data` and `next`. The list keeps only a `head` reference, so operations at the end need a traversal.

## Doubly Linked List

Each node stores `data`, `prev` and `next`. The list keeps both `head` and `tail`, which makes insert/delete at the end O(1) and allows backward traversal.

## Operations

| Operation | Singly | Doubly |
|---|:---:|:---:|
| Insert at Beginning / End / Position | Yes | Yes |
| Insert After / Before a Node | Yes | Yes |
| Delete from Beginning / End / Position | Yes | Yes |
| Delete by Value | Yes | Yes |
| Search, Update | Yes | Yes |
| Display | Yes | Forward and Backward |
| Count Nodes | Yes | Yes |
| Find Maximum / Minimum | Yes | Yes |
| Find Middle Element | Yes | Yes |
| Reverse | Yes | Yes |
| Sort (Bubble Sort) | Yes | Yes |
| Remove Duplicates | Yes | Yes |

Notes:
- Positions are 1-based (position 1 is the head).
- Middle element uses slow/fast references. For an **even** number of nodes, the **second** middle node is returned (e.g. 10, 20, 30, 40 gives 30).
- Insert/Delete "After", "Before" and "by Value" act on the **first** matching node.
- Remove Duplicates keeps the first occurrence of each value.

## How to Run

Make sure the JDK is installed (`javac -version`), then from the project root:

```bash
# compile
javac -d out src/*.java

# run
java -cp out Main
```

## Sample Output

Full run: [`sample-output/output.txt`](sample-output/output.txt)

```
Singly Linked List
40 -> 10 -> 30 -> 20 -> 50 -> NULL      (before)
-7 -> 0 -> 5 -> 5 -> 20 -> 20 -> ...    (after Sort)
50 -> 40 -> 30 -> 20 -> 5 -> 0 -> -7 -> NULL   (after Reverse)

Doubly Linked List
Forward : NULL <- -3 <-> 0 <-> 10 <-> 20 <-> 30 <-> 40 <-> 50 -> NULL
Backward: NULL <- 50 <-> 40 <-> 30 <-> 20 <-> 10 <-> 0 <-> -3 -> NULL
```

## Time Complexity

| Operation | Singly | Doubly |
|---|---|---|
| Insert at Beginning | O(1) | O(1) |
| Insert at End | O(n) (no tail) | O(1) (tail kept) |
| Insert at Position | O(n) | O(n) |
| Delete from Beginning | O(1) | O(1) |
| Delete from End | O(n) | O(1) |
| Search / Display / Count | O(n) | O(n) |
| Find Min / Max / Middle | O(n) | O(n) |
| Reverse | O(n), extra space O(1) | O(n), extra space O(1) |
| Bubble Sort | O(n^2) | O(n^2) |
| Remove Duplicates | O(n^2) | O(n^2) |

## Made By

- Name: Abhishek Dwivedi
- Sys ID 2025466800 / Section: CS - D
- Course: Btech CSE
