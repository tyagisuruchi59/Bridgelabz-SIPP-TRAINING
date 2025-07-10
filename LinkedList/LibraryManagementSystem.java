package LinkedList;

import java.util.Scanner;

// Node representing each book in the library
class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode prev, next;

    public BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}

// Doubly Linked List-based Library Management
class LibraryManager {
    BookNode head = null, tail = null;
    int totalBooks = 0;

    // Add book at beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        totalBooks++;
        System.out.println("Book added at beginning.");
    }

    // Add book at end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        totalBooks++;
        System.out.println("Book added at end.");
    }

    // Add book at specific position (1-based)
    public void addAtPosition(int pos, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (pos < 1 || pos > totalBooks + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
        } else if (pos == totalBooks + 1) {
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
            BookNode temp = head;
            for (int i = 1; i < pos - 1; i++) temp = temp.next;
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            totalBooks++;
            System.out.println("Book added at position " + pos);
        }
    }

    // Remove book by Book ID
    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book not found.");
            return;
        }

        if (current == head && current == tail) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        totalBooks--;
        System.out.println("Book with ID " + bookId + " removed.");
    }

    // Search by Book Title
    public void searchByTitle(String title) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found with title: " + title);
    }

    // Search by Author
    public void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found by author: " + author);
    }

    // Update availability status by Book ID
    public void updateAvailability(int bookId, boolean newStatus) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = newStatus;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    // Display books forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No books to display.");
            return;
        }

        System.out.println("\nBooks (Forward):");
        BookNode temp = head;
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    // Display books in reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books to display.");
            return;
        }

        System.out.println("\nBooks (Reverse):");
        BookNode temp = tail;
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    // Count total books
    public void countBooks() {
        System.out.println("Total number of books: " + totalBooks);
    }

    // Helper method to print book details
    private void printBook(BookNode book) {
        System.out.println("------------------------------");
        System.out.println("Book Title  : " + book.title);
        System.out.println("Author      : " + book.author);
        System.out.println("Genre       : " + book.genre);
        System.out.println("Book ID     : " + book.bookId);
        System.out.println("Availability: " + (book.isAvailable ? "Available" : "Unavailable"));
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager library = new LibraryManager();
        boolean run = true;

        while (run) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Books (Forward)");
            System.out.println("9. Display Books (Reverse)");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    boolean available = sc.nextBoolean();
                    sc.nextLine();
                    library.addAtBeginning(title, author, genre, bookId, available);
                    break;
                case 2:
                    System.out.print("Enter Book Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    available = sc.nextBoolean();
                    sc.nextLine();
                    library.addAtEnd(title, author, genre, bookId, available);
                    break;
                case 3:
                    System.out.print("Enter Book Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    available = sc.nextBoolean();
                    sc.nextLine();
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    library.addAtPosition(pos, title, author, genre, bookId, available);
                    break;
                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();
                    library.removeByBookId(removeId);
                    break;
                case 5:
                    System.out.print("Enter Book Title to search: ");
                    String searchTitle = sc.nextLine();
                    library.searchByTitle(searchTitle);
                    break;
                case 6:
                    System.out.print("Enter Author Name to search: ");
                    String searchAuthor = sc.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;
                case 7:
                    System.out.print("Enter Book ID to update status: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter new availability (true/false): ");
                    boolean newStatus = sc.nextBoolean();
                    library.updateAvailability(updateId, newStatus);
                    break;
                case 8:
                    library.displayForward();
                    break;
                case 9:
                    library.displayReverse();
                    break;
                case 10:
                    library.countBooks();
                    break;
                case 11:
                    run = false;
                    System.out.println("Exiting Library System...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
