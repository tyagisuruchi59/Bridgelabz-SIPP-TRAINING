package LinkedList;

import java.util.*;

// Node representing each user in the social media system
class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // Stores list of friend User IDs
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
    }
}

// Manages the user network using a singly linked list
class SocialNetwork {
    private UserNode head = null;

    // Add a new user to the network
    public void addUser(int userId, String name, int age) {
        if (getUserById(userId) != null) {
            System.out.println("User ID already exists.");
            return;
        }
        UserNode newNode = new UserNode(userId, name, age);
        newNode.next = head;
        head = newNode;
        System.out.println("User added successfully.");
    }

    // Add a mutual friend connection between two users
    public void addFriend(int userId1, int userId2) {
        if (userId1 == userId2) {
            System.out.println("Cannot add yourself as a friend.");
            return;
        }

        UserNode user1 = getUserById(userId1);
        UserNode user2 = getUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        // Avoid duplicate friendships
        if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
        if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
        System.out.println("Friend connection added.");
    }

    // Remove a friend connection between two users
    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = getUserById(userId1);
        UserNode user2 = getUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));
        System.out.println("Friend connection removed.");
    }

    // Display mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = getUserById(userId1);
        UserNode user2 = getUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        // Find intersection of both friend lists
        List<Integer> mutual = new ArrayList<>(user1.friendIds);
        mutual.retainAll(user2.friendIds);

        System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ":");
        if (mutual.isEmpty()) {
            System.out.println("No mutual friends.");
        } else {
            for (int id : mutual) {
                UserNode mutualFriend = getUserById(id);
                System.out.println("- " + mutualFriend.name + " (ID: " + id + ")");
            }
        }
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        UserNode user = getUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        if (user.friendIds.isEmpty()) {
            System.out.println("No friends.");
        } else {
            for (int id : user.friendIds) {
                UserNode friend = getUserById(id);
                System.out.println("- " + friend.name + " (ID: " + id + ")");
            }
        }
    }

    // Search and display user by ID
    public void searchById(int userId) {
        UserNode user = getUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
        } else {
            printUser(user);
        }
    }

    // Search and display user by name
    public void searchByName(String name) {
        UserNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                printUser(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No user found with name: " + name);
        }
    }

    // Display friend count for all users
    public void countFriendsOfAllUsers() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " (ID: " + temp.userId + ") has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Get user node by ID
    private UserNode getUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Display user information
    private void printUser(UserNode user) {
        System.out.println("User ID  : " + user.userId);
        System.out.println("Name     : " + user.name);
        System.out.println("Age      : " + user.age);
        System.out.println("Friends  : " + user.friendIds);
    }
}

// Main driver class to interact with the system
public class SocialMediaFreindConnections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetwork network = new SocialNetwork();
        boolean running = true;

        while (running) {
            System.out.println("\n==== Social Media Friend System ====");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display Friends of User");
            System.out.println("6. Search User by ID");
            System.out.println("7. Search User by Name");
            System.out.println("8. Count Friends of All Users");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    network.addUser(id, name, age);
                    break;
                case 2:
                    System.out.print("Enter First User ID: ");
                    int uid1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int uid2 = sc.nextInt();
                    network.addFriend(uid1, uid2);
                    break;
                case 3:
                    System.out.print("Enter First User ID: ");
                    uid1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    uid2 = sc.nextInt();
                    network.removeFriend(uid1, uid2);
                    break;
                case 4:
                    System.out.print("Enter First User ID: ");
                    uid1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    uid2 = sc.nextInt();
                    network.findMutualFriends(uid1, uid2);
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    int viewId = sc.nextInt();
                    network.displayFriends(viewId);
                    break;
                case 6:
                    System.out.print("Enter User ID to search: ");
                    id = sc.nextInt();
                    network.searchById(id);
                    break;
                case 7:
                    System.out.print("Enter Name to search: ");
                    name = sc.nextLine();
                    network.searchByName(name);
                    break;
                case 8:
                    network.countFriendsOfAllUsers();
                    break;
                case 9:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
