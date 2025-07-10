package LinkedList;

import java.util.Scanner;

//Class Node that is defines a blueprint for the object of LinkedList
class Node{
    int rollNumber;
    String name;
    int age;
    double grade;
    Node next;
    public Node(int rollNumber, String name, int age,double grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecord list = new StudentRecord();
        boolean flag = true;
        while(flag){
            System.out.println("1. Add Student ");
            System.out.println("2. Delete Student ");
            System.out.println("3. Display details of Students ");
            System.out.println("4. Search Student Using Roll Number ");
            System.out.println("5. Update Grades using Roll Number ");
            System.out.println("6. Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter Index At which you want to add the Student");
                    int index = sc.nextInt();
                    System.out.println("Enter roll number : ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter age : ");
                    int age = sc.nextInt();
                    System.out.println("Enter grade : ");
                    double grade = sc.nextDouble();
                    list.addAtIndex(index, rollNumber, name, age, grade);
                    break;
                case 2:
                    System.out.println("Enter Index At which you want to delete the Student");
                    index = sc.nextInt();
                    list.deleteAtIndex(index);
                    break;
                case 3:
                    list.displayDetails();
                    break;
                case 4:
                    System.out.println("Enter roll number for searching: ");
                    int RollNumber = sc.nextInt();
                    list.searchByRollNumber(RollNumber);
                    break;
                case 5:
                    System.out.println("Enter Roll Number for upgrading the grades of student : ");
                    int rollnum = sc.nextInt();
                    System.out.println("Enter the new Grades");
                    double newGrade = sc.nextDouble();
                    list.updateGradesByRollNumber(rollnum, newGrade);
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    flag = false;
                    break;
            }
        }
    }
}

class StudentRecord {
    Node head = null;
    Node tail = null;
    int length = 0;

    //method for adding node at the head of the linked list
    private void addAtHead(int rollNumber, String name, int age , double grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (head == null) {
            head = tail = newNode;
            length++;
            return;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    //Method for adding node at tail of the linked list
    private void addAtTail(int rollNumber, String name, int age, double grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (head == null) {
            head = tail = newNode;
            length++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    //To add at any index
    public void addAtIndex(int index,int rollNumber, String name, int age, double grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if(index<0 || index>length) {
            System.out.println("Not valid index");
            return;
        }
        if (head == null || index == 0) {
            addAtHead(rollNumber, name, age, grade);
        } else if (index == length) {
            addAtTail(rollNumber, name, age, grade);
        }
        else{
            Node temp = new Node(rollNumber, name, age, grade);
            Node current = head;
            for(int i = 0; i < index-1; i++) {
                current = current.next;
            }
            temp.next = current.next;
            current.next = temp;
            length++;
        }
        System.out.println("Student Added Successfully");
    }


    //Delete from index
    public void deleteAtIndex(int index) {
        if(index<0 || index>=length || head==null){
            System.out.println("index is out of range");
            return;
        }
        if(index==0){
            if(length == 1) {
                head = tail = null;
                length--;
                return;
            }
            head = head.next;
            length--;
            return;
        }
        else {
            Node current = head;
            for (int i = 0; i < index-1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            length--;
        }
        System.out.println("Student Deleted Successfully");
    }

    //methods for searching student details by using roll number
    public void searchByRollNumber(int rollNumber) {
        Node current = head;
        while(current != null) {
            if(current.rollNumber == rollNumber) {
                System.out.println("Student details having roll no : "+current.rollNumber);
                System.out.println("Student name : "+current.name);
                System.out.println("Student age : "+current.age);
                System.out.println("Student grade : "+current.grade);
                System.out.println("-------------------------------------------");
                return;
            }
            current = current.next;
        }
        System.out.println("No student record found with roll no : "+rollNumber);
    }

    //method for display all student with all details
    public void displayDetails(){
        if(head == null) {
            System.out.println("There is no student No records found");
            return;
        }
        Node current = head;
        while(current != null) {
            System.out.println("All Students Details are : ");
            System.out.println("Roll No : "+current.rollNumber);
            System.out.println("Student name : "+current.name);
            System.out.println("Student age : "+current.age);
            System.out.println("Student grade : "+current.grade);
            System.out.println("-------------------------------------------");
            current = current.next;
        }
    }

    //method for updating grades by using roll numbers
    public void updateGradesByRollNumber(int rollNumber,double grade) {
        Node current = head;
        while(current != null) {
            if(current.rollNumber == rollNumber) {
                System.out.println("Update Student grades Successfully from "+current.grade+" to "+grade);
                current.grade = grade;
                return;
            }
            current = current.next;
        }
        System.out.println("No student record found with roll no : "+rollNumber);
    }
}
