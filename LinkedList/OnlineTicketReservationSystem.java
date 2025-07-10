package LinkedList;

import java.util.Scanner;

// Node representing each ticket
class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

class TicketReservationSystem {
    private TicketNode tail = null;
    private int count = 0;

    // Add a new ticket at the end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newNode = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (tail == null) {
            newNode.next = newNode;
            tail = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        count++;
        System.out.println("Ticket booked successfully!");
    }

    // Remove ticket by ticket ID
    public void removeTicket(int ticketId) {
        if (tail == null) {
            System.out.println("No tickets found.");
            return;
        }

        TicketNode curr = tail.next, prev = tail;
        boolean found = false;

        do {
            if (curr.ticketId == ticketId) {
                found = true;
                break;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);

        if (!found) {
            System.out.println("Ticket ID not found.");
            return;
        }

        if (curr == tail && curr == tail.next) {
            tail = null;
        } else {
            prev.next = curr.next;
            if (curr == tail) tail = prev;
        }

        count--;
        System.out.println("Ticket with ID " + ticketId + " removed.");
    }

    // Display all tickets
    public void displayTickets() {
        if (tail == null) {
            System.out.println("No tickets to display.");
            return;
        }

        System.out.println("\n--- Booked Tickets ---");
        TicketNode curr = tail.next;
        do {
            printTicket(curr);
            curr = curr.next;
        } while (curr != tail.next);
    }

    // Search by customer name or movie name
    public void searchTicket(String keyword) {
        if (tail == null) {
            System.out.println("No tickets to search.");
            return;
        }

        TicketNode curr = tail.next;
        boolean found = false;
        do {
            if (curr.customerName.equalsIgnoreCase(keyword) || curr.movieName.equalsIgnoreCase(keyword)) {
                printTicket(curr);
                found = true;
            }
            curr = curr.next;
        } while (curr != tail.next);

        if (!found) {
            System.out.println("No ticket found for: " + keyword);
        }
    }

    // Total tickets booked
    public void totalTickets() {
        System.out.println("Total tickets booked: " + count);
    }

    // Helper: print ticket
    private void printTicket(TicketNode t) {
        System.out.println("----------------------------");
        System.out.println("Ticket ID     : " + t.ticketId);
        System.out.println("Customer Name : " + t.customerName);
        System.out.println("Movie Name    : " + t.movieName);
        System.out.println("Seat Number   : " + t.seatNumber);
        System.out.println("Booking Time  : " + t.bookingTime);
    }
}

public class OnlineTicketReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();
        boolean run = true;

        while (run) {
            System.out.println("\n=== Online Ticket Reservation System ===");
            System.out.println("1. Add Ticket");
            System.out.println("2. Remove Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer or Movie Name");
            System.out.println("5. Total Tickets Booked");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String mname = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, cname, mname, seat, time);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int removeId = sc.nextInt();
                    system.removeTicket(removeId);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name or Movie Name: ");
                    String keyword = sc.nextLine();
                    system.searchTicket(keyword);
                    break;
                case 5:
                    system.totalTickets();
                    break;
                case 6:
                    run = false;
                    System.out.println("Exiting Ticket System...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
