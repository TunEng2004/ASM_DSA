package newpackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mylist studentList = new Mylist();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Sort Students by Marks (Bubble Sort)");
            System.out.println("6. Sort Students by Marks (Selection Sort)");
            System.out.println("7. Search Student by ID");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        // Add new student
                        String id;
                        while (true) {
                            System.out.print("Enter ID: ");
                            id = scanner.nextLine();
                            if (id.matches("[0-9]+")) {
                                break;
                            } else {
                                System.out.println("Invalid ID. Please enter numbers only.");
                            }
                        }
                        String fullName;
                        while (true) {
                            System.out.print("Enter full name: ");
                            fullName = scanner.nextLine();
                            if (fullName.matches("[a-zA-Z ]+") && fullName.length() <= 30) {
                                break;
                            } else {
                                System.out.println("Invalid name. Please use letters and spaces only, up to 30 characters.");
                            }
                        }
                        double marks;
                        while (true) {
                            System.out.print("Enter marks: ");
                            try {
                                marks = scanner.nextDouble();
                                scanner.nextLine(); // Consume newline
                                if (marks >= 0 && marks <= 10) {
                                    break;
                                } else {
                                    System.out.println("Invalid marks. Please enter a value between 0 and 10.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input for marks. Please enter a numeric value.");
                                scanner.nextLine(); // Consume invalid input
                            }
                        }

                        studentList.addStudent(new Student(id, fullName, marks));
                        System.out.println("Student added successfully.");
                    }
                    case 2 -> {
                        // Edit student details
                        String id;
                        while (true) {
                            System.out.print("Enter ID to edit: ");
                            id = scanner.nextLine();
                            if (id.matches("[0-9]+")) {
                                break;
                            } else {
                                System.out.println("Invalid ID. Please enter numbers only.");
                            }
                        }
                        String fullName;
                        while (true) {
                            System.out.print("Enter new full name: ");
                            fullName = scanner.nextLine();
                            if (fullName.matches("[a-zA-Z ]+") && fullName.length() <= 30) {
                                break;
                            } else {
                                System.out.println("Invalid name. Please use letters and spaces only, up to 30 characters.");
                            }
                        }
                        double marks;
                        while (true) {
                            System.out.print("Enter new marks: ");
                            try {
                                marks = scanner.nextDouble();
                                scanner.nextLine(); // Consume newline
                                if (marks >= 0 && marks <= 10) {
                                    break;
                                } else {
                                    System.out.println("Invalid marks. Please enter a value between 0 and 10.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input for marks. Please enter a numeric value.");
                                scanner.nextLine(); // Consume invalid input
                            }
                        }

                        studentList.editStudent(id, fullName, marks);
                    }
                    case 3 -> {
                        // Delete student
                        String id;
                        while (true) {
                            System.out.print("Enter ID to delete: ");
                            id = scanner.nextLine();
                            if (id.matches("[0-9]+")) {
                                break;
                            } else {
                                System.out.println("Invalid ID. Please enter numbers only.");
                            }
                        }
                        studentList.deleteStudent(id);
                    }
                    case 4 -> studentList.displayStudents();
               case 5 -> {
    studentList.sortStudents(); // Bubble Sort
    System.out.println("Students sorted by marks using Bubble Sort.");
    studentList.displayStudents(); // Hiển thị sau khi sắp xếp
}
case 6 -> {
    studentList.selectionSortStudents(); // Selection Sort
    System.out.println("Students sorted by marks using Selection Sort.");
    studentList.displayStudents(); // Hiển thị sau khi sắp xếp
}

                    case 7 -> {
                        String id;
                        while (true) {
                            System.out.print("Enter ID to search: ");
                            id = scanner.nextLine();
                            if (id.matches("[0-9]+")) {
                                break;
                            } else {
                                System.out.println("Invalid ID. Please enter numbers only.");
                            }
                        }

                        Student foundStudent = studentList.searchStudent(id);
                        if (foundStudent != null) {
                            System.out.println("Found: " + foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                    }
                    case 8 -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 8.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }
}



