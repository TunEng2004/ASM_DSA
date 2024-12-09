package newpackage;

import java.util.ArrayList;
import java.util.Collections;

public class Mylist {
    private Node head;
    private final ArrayList<Student> studentList; // ArrayList để hỗ trợ các thuật toán sắp xếp và tìm kiếm nhanh

    public Mylist() {
        studentList = new ArrayList<>();
    }

    // Thêm học sinh vào danh sách liên kết và ArrayList
    public void addStudent(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        studentList.add(student); // Thêm học sinh vào ArrayList
    }

    // Chỉnh sửa thông tin học sinh theo ID
    public void editStudent(String id, String newFullName, double newMarks) {
        Node current = head;
        while (current != null) {
            if (current.student.getId().equals(id)) {
                current.student = new Student(id, newFullName, newMarks);
                System.out.println("Student with ID " + id + " has been updated.");
                
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getId().equals(id)) {
                        studentList.set(i, current.student);
                        break;
                    }
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Xóa học sinh khỏi danh sách
    public void deleteStudent(String id) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.student.getId().equals(id)) {
            head = head.next;
            System.out.println("Student with ID " + id + " has been deleted.");
            studentList.removeIf(student -> student.getId().equals(id)); // Xóa học sinh khỏi ArrayList
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.student.getId().equals(id)) {
                current.next = current.next.next;
                System.out.println("Student with ID " + id + " has been deleted.");
                studentList.removeIf(student -> student.getId().equals(id)); // Xóa học sinh khỏi ArrayList
                return;
            }
            current = current.next;
        }
        System.out.println("Student with ID " + id + " not found.");
    }

public void displayStudents() {
    if (studentList.isEmpty()) {
        System.out.println("No students to display.");
        return;
    }
    System.out.printf("%-10s %-20s %-10s %-10s%n", "ID", "Full Name", "Marks", "Ranking");
    System.out.println("-------------------------------------------------------------");
    
    // Hiển thị học sinh từ ArrayList sau khi sắp xếp
    for (Student student : studentList) {
        System.out.printf("%-10s %-20s %-10.2f %-10s%n",
                student.getId(), student.getFullName(), student.getMarks(), student.getRanking());
    }
}

// Sắp xếp học sinh theo điểm số từ thấp đến cao bằng Bubble Sort
public void sortStudents() {
    if (studentList.isEmpty()) return;

    for (int i = 0; i < studentList.size() - 1; i++) {
        for (int j = 0; j < studentList.size() - i - 1; j++) {
            // So sánh điểm của học sinh tại vị trí j và j+1
            if (studentList.get(j).getMarks() > studentList.get(j + 1).getMarks()) {
                // Hoán đổi nếu học sinh tại vị trí j có điểm lớn hơn học sinh tại j+1
                Student temp = studentList.get(j);
                studentList.set(j, studentList.get(j + 1));
                studentList.set(j + 1, temp);
            }
        }
    }
    System.out.println("Students have been sorted by marks from lowest to highest using Bubble Sort.");
}

    // Tìm kiếm học sinh theo ID (sử dụng Binary Search trong ArrayList)
    public Student binarySearch(String id) {
        Collections.sort(studentList, (s1, s2) -> s1.getId().compareTo(s2.getId())); 

        int left = 0, right = studentList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Student midStudent = studentList.get(mid);
            if (midStudent.getId().equals(id)) {
                return midStudent;
            } else if (midStudent.getId().compareTo(id) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Student not found
    }

public void selectionSortStudents() {
    if (studentList.isEmpty()) return;

    for (int i = 0; i < studentList.size() - 1; i++) {
        int maxIndex = i; // Tìm phần tử lớn nhất trong danh sách
        for (int j = i + 1; j < studentList.size(); j++) {
            // So sánh điểm học sinh tại vị trí j với điểm học sinh tại vị trí maxIndex
            if (studentList.get(j).getMarks() > studentList.get(maxIndex).getMarks()) {
                maxIndex = j; // Cập nhật maxIndex nếu tìm thấy học sinh có điểm lớn hơn
            }
        }
        
        // Hoán đổi học sinh tại vị trí maxIndex với học sinh tại vị trí i
        if (maxIndex != i) {
            Student temp = studentList.get(i);
            studentList.set(i, studentList.get(maxIndex));
            studentList.set(maxIndex, temp);
        }
    }
    System.out.println("Students have been sorted by marks from highest to lowest using Selection Sort.");
}



   public Student searchStudent(String id) {
    if (studentList.isEmpty()) {
        System.out.println("No students to search.");
        return null;
    }

    // Tìm kiếm học sinh theo ID trong ArrayList
    for (Student student : studentList) {
        if (student.getId().equals(id)) {
            return student; // Trả về học sinh nếu tìm thấy
        }
    }
    System.out.println("Student with ID " + id + " not found.");
    return null; // Trả về null nếu không tìm thấy học sinh
}

}
