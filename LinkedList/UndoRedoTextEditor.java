package LinkedList;

import java.util.Scanner;

// Node representing each text state
class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
    }
}

class TextEditor {
    private TextState head = null;    // Head of the doubly linked list
    private TextState current = null; // Current state
    private int size = 0;             // Current size of history
    private final int MAX_HISTORY = 10;

    // Add a new state (new action or typed text)
    public void addState(String content) {
        TextState newState = new TextState(content);

        // If not at the latest state, clear the redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }

        // Link the new state
        if (current == null) {
            head = newState;
        } else {
            current.next = newState;
            newState.prev = current;
        }

        current = newState;
        size++;

        // Maintain only last 10 states
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("New state added.");
    }

    // Undo (go to previous state)
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo (go to next state)
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Show current text content
    public void displayCurrent() {
        if (current == null) {
            System.out.println("Editor is empty.");
        } else {
            System.out.println("Current State: \"" + current.content + "\"");
        }
    }

    // Display all states (for debugging)
    public void displayAllStates() {
        TextState temp = head;
        System.out.println("\n--- History ---");
        while (temp != null) {
            if (temp == current) System.out.print("-> ");
            System.out.println(temp.content);
            temp = temp.next;
        }
        System.out.println("----------------");
    }
}

public class UndoRedoTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Text Editor ---");
            System.out.println("1. Type/Add New State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("5. Show All States (debug)");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new content: ");
                    String content = sc.nextLine();
                    editor.addState(content);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrent();
                    break;
                case 5:
                    editor.displayAllStates();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting editor...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
