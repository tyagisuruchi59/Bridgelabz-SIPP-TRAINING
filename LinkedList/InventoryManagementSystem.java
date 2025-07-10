package LinkedList;

import java.util.Scanner;

class ItemNode {
    String name;
    int id;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
}

class InventoryManager {
    ItemNode head = null;
    int size = 0;

    // Add at beginning
    public void addAtBeginning(String name, int id, int quantity, double price) {
        ItemNode newNode = new ItemNode(name, id, quantity, price);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Item added at beginning.");
    }

    // Add at end
    public void addAtEnd(String name, int id, int quantity, double price) {
        ItemNode newNode = new ItemNode(name, id, quantity, price);
        if (head == null) {
            head = newNode;
        } else {
            ItemNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        size++;
        System.out.println("Item added at end.");
    }

    // Add at position (1-based)
    public void addAtPosition(int pos, String name, int id, int quantity, double price) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            addAtBeginning(name, id, quantity, price);
        } else if (pos == size + 1) {
            addAtEnd(name, id, quantity, price);
        } else {
            ItemNode newNode = new ItemNode(name, id, quantity, price);
            ItemNode temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
            System.out.println("Item added at position " + pos);
        }
    }

    // Remove item by ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.id == id) {
            head = head.next;
            size--;
            System.out.println("Item removed.");
            return;
        }
        ItemNode current = head;
        while (current.next != null && current.next.id != id) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item ID not found.");
        } else {
            current.next = current.next.next;
            size--;
            System.out.println("Item removed.");
        }
    }

    // Update quantity by ID
    public void updateQuantity(int id, int newQuantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item ID not found.");
    }

    // Search by ID
    public void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.id == id) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by Name
    public void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                printItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        ItemNode temp = head;
        double total = 0;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.printf("Total Inventory Value: ₹%.2f%n", total);
    }

    // Sort by name or price (asc or desc)
    public void sort(String criteria, boolean ascending) {
        if (head == null || head.next == null) return;

        for (ItemNode i = head; i.next != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                boolean shouldSwap = false;
                if (criteria.equalsIgnoreCase("name")) {
                    int cmp = i.name.compareToIgnoreCase(j.name);
                    shouldSwap = ascending ? (cmp > 0) : (cmp < 0);
                } else if (criteria.equalsIgnoreCase("price")) {
                    shouldSwap = ascending ? (i.price > j.price) : (i.price < j.price);
                }
                if (shouldSwap) {
                    // Swap contents
                    String tempName = i.name;
                    int tempId = i.id;
                    int tempQty = i.quantity;
                    double tempPrice = i.price;

                    i.name = j.name;
                    i.id = j.id;
                    i.quantity = j.quantity;
                    i.price = j.price;

                    j.name = tempName;
                    j.id = tempId;
                    j.quantity = tempQty;
                    j.price = tempPrice;
                }
            }
        }

        System.out.println("Inventory sorted by " + criteria + " in " + (ascending ? "ascending" : "descending") + " order.");
    }

    // Display all items
    public void displayItems() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }

        System.out.println("\nInventory Items:");
        ItemNode temp = head;
        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    private void printItem(ItemNode item) {
        System.out.println("-----------------------------");
        System.out.println("Item Name : " + item.name);
        System.out.println("Item ID   : " + item.id);
        System.out.println("Quantity  : " + item.quantity);
        System.out.println("Price     : ₹" + item.price);
    }
}
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManager inventory = new InventoryManager();
        boolean run = true;

        while (run) {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Item (Beginning)");
            System.out.println("2. Add Item (End)");
            System.out.println("3. Add Item (Position)");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search Item by ID");
            System.out.println("7. Search Item by Name");
            System.out.println("8. Display Inventory");
            System.out.println("9. Calculate Total Inventory Value");
            System.out.println("10. Sort Inventory");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    if (choice == 1)
                        inventory.addAtBeginning(name, id, qty, price);
                    else if (choice == 2)
                        inventory.addAtEnd(name, id, qty, price);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        inventory.addAtPosition(pos, name, id, qty, price);
                    }
                    break;
                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    int removeId = sc.nextInt();
                    inventory.removeById(removeId);
                    break;
                case 5:
                    System.out.print("Enter Item ID to update: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();
                    inventory.updateQuantity(updateId, newQty);
                    break;
                case 6:
                    System.out.print("Enter Item ID to search: ");
                    int searchId = sc.nextInt();
                    inventory.searchById(searchId);
                    break;
                case 7:
                    System.out.print("Enter Item Name to search: ");
                    String searchName = sc.nextLine();
                    inventory.searchByName(searchName);
                    break;
                case 8:
                    inventory.displayItems();
                    break;
                case 9:
                    inventory.calculateTotalValue();
                    break;
                case 10:
                    System.out.print("Sort by (name/price): ");
                    String criteria = sc.nextLine();
                    System.out.print("Ascending? (true/false): ");
                    boolean asc = sc.nextBoolean();
                    inventory.sort(criteria, asc);
                    break;
                case 11:
                    run = false;
                    System.out.println("Exiting Inventory System...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
