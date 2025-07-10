package LinkedList;

import java.util.Scanner;

// Node class representing a Movie in the doubly linked list
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next, prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

// Class to manage the doubly linked list of movies
class MovieManagement {
    MovieNode head = null, tail = null;
    int length = 0; // To track number of nodes

    // Add movie at beginning of the list
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
        System.out.println("Movie added at beginning.");
    }

    // Add movie at end of the list
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
        System.out.println("Movie added at end.");
    }

    // Add movie at a specific position (1-based indexing)
    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos <= 0 || pos > length + 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            addAtBeginning(title, director, year, rating);
        } else if (pos == length + 1) {
            addAtEnd(title, director, year, rating);
        } else {
            MovieNode newNode = new MovieNode(title, director, year, rating);
            MovieNode temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            length++;
            System.out.println("Movie added at position " + pos + ".");
        }
    }

    // Remove movie by title (case-insensitive)
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        MovieNode current = head;
        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (current == head) {
            head = current.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = current.prev;
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        length--; // Decrease length
        System.out.println("Movie removed: " + title);
    }

    // Search for movies by director (case-insensitive)
    public void searchByDirector(String director) {
        boolean found = false;
        MovieNode current = head;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found by director: " + director);
    }

    // Search for movies by rating
    public void searchByRating(double rating) {
        boolean found = false;
        MovieNode current = head;
        while (current != null) {
            if (current.rating == rating) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    // Display all movies in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("\nMovies (Forward):");
        MovieNode current = head;
        while (current != null) {
            printMovie(current);
            current = current.next;
        }
        System.out.println("Total Movies: " + length);
    }

    // Display all movies in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("\nMovies (Reverse):");
        MovieNode current = tail;
        while (current != null) {
            printMovie(current);
            current = current.prev;
        }
        System.out.println("Total Movies: " + length);
    }

    // Update rating of a movie by title
    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("Old Rating: " + current.rating);
                current.rating = newRating;
                System.out.println("Updated rating to " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    // Helper function to print a movie's details
    private void printMovie(MovieNode node) {
        System.out.println("Title: " + node.title);
        System.out.println("Director: " + node.director);
        System.out.println("Year: " + node.year);
        System.out.println("Rating: " + node.rating);
        System.out.println("-----------------------------");
    }
}

// Main class to run the movie management system
public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManagement movies = new MovieManagement();
        boolean run = true;

        while (run) {
            System.out.println("\n===== Movie Management System =====");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Display Movies (Forward)");
            System.out.println("8. Display Movies (Reverse)");
            System.out.println("9. Update Movie Rating");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = sc.nextDouble();
                    if (choice == 1)
                        movies.addAtBeginning(title, director, year, rating);
                    else if (choice == 2)
                        movies.addAtEnd(title, director, year, rating);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        movies.addAtPosition(pos, title, director, year, rating);
                    }
                    break;

                case 4:
                    System.out.print("Enter Title to remove: ");
                    String rTitle = sc.nextLine();
                    movies.removeByTitle(rTitle);
                    break;

                case 5:
                    System.out.print("Enter Director to search: ");
                    String dName = sc.nextLine();
                    movies.searchByDirector(dName);
                    break;

                case 6:
                    System.out.print("Enter Rating to search: ");
                    double r = sc.nextDouble();
                    movies.searchByRating(r);
                    break;

                case 7:
                    movies.displayForward();
                    break;

                case 8:
                    movies.displayReverse();
                    break;

                case 9:
                    System.out.print("Enter Movie Title to update rating: ");
                    String uTitle = sc.nextLine();
                    System.out.print("Enter new Rating: ");
                    double newRating = sc.nextDouble();
                    movies.updateRating(uTitle, newRating);
                    break;

                case 10:
                    run = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
