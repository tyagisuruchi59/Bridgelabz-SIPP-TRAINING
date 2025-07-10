package LinkedList;

import java.util.Scanner;

// Node representing each Task in the circular linked list
class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Circular Linked List based Task Scheduler
class TaskScheduler {
    TaskNode head = null;
    TaskNode tail = null;
    TaskNode current = null;
    int size = 0;

    // Add task at beginning
    public void addAtBeginning(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        tail.next = head;
        size++;
        System.out.println("Task added at beginning.");
    }

    // Add task at end
    public void addAtEnd(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        tail.next = head;
        size++;
        System.out.println("Task added at end.");
    }

    // Add task at specific position (1-based index)
    public void addAtPosition(int pos, int id, String name, int priority, String date) {
        if (pos <= 0 || pos > size + 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            addAtBeginning(id, name, priority, date);
        } else if (pos == size + 1) {
            addAtEnd(id, name, priority, date);
        } else {
            TaskNode newNode = new TaskNode(id, name, priority, date);
            TaskNode temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
            System.out.println("Task added at position " + pos);
        }
    }

    // Remove a task by Task ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        TaskNode current = head;
        TaskNode prev = null;
        boolean found = false;

        do {
            if (current.taskId == id) {
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Task ID not found.");
            return;
        }

        if (current == head && current.next == head) {
            // Only one node
            head = null;
            this.current = null;
        } else if (current == head) {
            // Deleting head
            TaskNode tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            head = head.next;
            tail.next = head;
        } else {
            prev.next = current.next;
        }

        if (this.current == current) {
            this.current = current.next;
        }

        size--;
        System.out.println("Task with ID " + id + " removed.");
    }

    // View the current task
    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }
        printTask(current);
    }

    // Move to the next task
    public void moveToNextTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }
        current = current.next;
        System.out.println("Moved to next task.");
        viewCurrentTask();
    }

    // Display all tasks starting from head
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        System.out.println("\nAll Tasks:");
        TaskNode temp = head;
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total Tasks: " + size);
    }

    // Search tasks by priority
    public void searchByPriority(int targetPriority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == targetPriority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with priority: " + targetPriority);
        }
    }

    // Helper method to print a task
    private void printTask(TaskNode task) {
        System.out.println("----------------------------");
        System.out.println("Task ID   : " + task.taskId);
        System.out.println("Task Name : " + task.taskName);
        System.out.println("Priority  : " + task.priority);
        System.out.println("Due Date  : " + task.dueDate);
    }
}

public class TaskSchedulerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        boolean run = true;

        while (run) {
            System.out.println("\n==== Task Scheduler ====");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search Task by Priority");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date (dd-mm-yyyy): ");
                    String date = sc.nextLine();

                    if (choice == 1)
                        scheduler.addAtBeginning(id, name, priority, date);
                    else if (choice == 2)
                        scheduler.addAtEnd(id, name, priority, date);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        scheduler.addAtPosition(pos, id, name, priority, date);
                    }
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    int removeId = sc.nextInt();
                    scheduler.removeById(removeId);
                    break;

                case 5:
                    scheduler.viewCurrentTask();
                    break;

                case 6:
                    scheduler.moveToNextTask();
                    break;

                case 7:
                    scheduler.displayTasks();
                    break;

                case 8:
                    System.out.print("Enter Priority to search: ");
                    int searchPriority = sc.nextInt();
                    scheduler.searchByPriority(searchPriority);
                    break;

                case 9:
                    run = false;
                    System.out.println("Exiting Task Scheduler...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
