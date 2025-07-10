package LinkedList;

import java.util.Scanner;

class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

class RoundRobinScheduler {
    private ProcessNode tail = null;
    private int totalProcesses = 0;
    private int timeQuantum;
    private int[] waitingTime, turnAroundTime;
    private int[] burstCopy;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add process at end
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        if (tail == null) {
            tail = newNode;
            newNode.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        totalProcesses++;
        System.out.println("Process added: PID = " + processId);
    }

    // Remove process by PID
    private void removeProcess(int processId) {
        if (tail == null) return;

        ProcessNode curr = tail.next;
        ProcessNode prev = tail;

        do {
            if (curr.processId == processId) {
                if (curr == tail && curr.next == tail) {
                    tail = null;
                } else {
                    if (curr == tail)
                        tail = prev;
                    prev.next = curr.next;
                }
                totalProcesses--;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);
    }

    // Display processes
    public void displayProcesses() {
        if (tail == null) {
            System.out.println("No processes in queue.");
            return;
        }

        System.out.println("\nProcesses in Queue:");
        ProcessNode temp = tail.next;
        do {
            System.out.println("PID: " + temp.processId + " | Remaining: " + temp.remainingTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != tail.next);
    }

    // Run round robin
    public void runScheduler() {
        if (tail == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        waitingTime = new int[totalProcesses];
        turnAroundTime = new int[totalProcesses];
        burstCopy = new int[totalProcesses];

        ProcessNode curr = tail.next;
        int time = 0, index = 0;

        // Store original burst times
        do {
            burstCopy[index++] = curr.burstTime;
            curr = curr.next;
        } while (curr != tail.next);

        while (tail != null) {
            ProcessNode temp = tail.next;
            do {
                if (temp.remainingTime > 0) {
                    int execTime = Math.min(timeQuantum, temp.remainingTime);
                    System.out.println("\nExecuting PID: " + temp.processId + " for " + execTime + " units");
                    temp.remainingTime -= execTime;
                    time += execTime;

                    if (temp.remainingTime == 0) {
                        int pid = temp.processId;
                        int idx = getIndex(pid);
                        turnAroundTime[idx] = time;
                        waitingTime[idx] = time - burstCopy[idx];
                        removeProcess(pid);
                    }
                    displayProcesses();
                }
                temp = temp.next;
            } while (temp != tail.next);
        }

        printAverageTimes();
    }

    private int getIndex(int pid) {
        ProcessNode temp = tail.next;
        int i = 0;
        do {
            if (temp.processId == pid) return i;
            temp = temp.next;
            i++;
        } while (temp != tail.next);
        return -1;
    }

    private void printAverageTimes() {
        int totalWT = 0, totalTAT = 0;
        System.out.println("\nProcess Completion Details:");
        for (int i = 0; i < waitingTime.length; i++) {
            System.out.println("PID: " + (i + 1) + " | Waiting Time: " + waitingTime[i] + " | Turnaround Time: " + turnAroundTime[i]);
            totalWT += waitingTime[i];
            totalTAT += turnAroundTime[i];
        }

        System.out.println("\nAverage Waiting Time: " + (float) totalWT / waitingTime.length);
        System.out.println("Average Turnaround Time: " + (float) totalTAT / turnAroundTime.length);
    }
}

public class RoundRobinSchedulingAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();
        RoundRobinScheduler scheduler = new RoundRobinScheduler(tq);

        boolean run = true;
        while (run) {
            System.out.println("\n1. Add Process\n2. Display Queue\n3. Run Round Robin\n4. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter Burst Time: ");
                    int bt = sc.nextInt();
                    System.out.print("Enter Priority: ");
                    int pr = sc.nextInt();
                    scheduler.addProcess(pid, bt, pr);
                    break;
                case 2:
                    scheduler.displayProcesses();
                    break;
                case 3:
                    scheduler.runScheduler();
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
