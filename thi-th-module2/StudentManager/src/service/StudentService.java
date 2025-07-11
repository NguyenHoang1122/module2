// File: service/StudentService.java
package service;

import exceptinon.NotFoundStudentException;
import model.Student;
import util.CSVUtil;
import util.Validator;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {
    private final List<Student> studentList = new ArrayList<>();
    private final String STUDENT_FILE = "data/students.csv";
    private final BatchService batchService;
    private final Scanner sc = new Scanner(System.in);

    public StudentService(BatchService batchService) {
        this.batchService = batchService;
        loadFromFile();
    }

    private void loadFromFile() {
        List<String[]> data = CSVUtil.readCSV(STUDENT_FILE);
        for (String[] row : data) {
            Student student = new Student(
                    Integer.parseInt(row[0]), row[1], row[2], row[3], row[4], row[5]
            );
            studentList.add(student);
        }
    }

    private void saveToFile() {
        List<String[]> data = studentList.stream()
                .map(s -> new String[]{
                        String.valueOf(s.getId()), s.getName(), s.getBirthDate(),
                        s.getGender(), s.getPhoneNumber(), s.getClassID()
                })
                .collect(Collectors.toList());
        CSVUtil.writeCSV(data, STUDENT_FILE);
    }

    private int getNextId() {
        return studentList.stream().mapToInt(Student::getId).max().orElse(0) + 1;
    }

    private boolean phoneExists(String phone) {
        return studentList.stream().anyMatch(s -> s.getPhoneNumber().equals(phone));
    }

    public void addStudent() {
        int id = getNextId();

        System.out.print("Nhập tên sinh viên: ");
        String name = sc.nextLine();
        if (!Validator.isValidName(name)) {
            System.out.println("Tên phải từ 4 đến 50 ký tự.");
            return;
        }

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        String birthDate = sc.nextLine();
        if (!Validator.isValidDate(birthDate)) {
            System.out.println("Ngày sinh không hợp lệ.");
            return;
        }

        System.out.print("Nhập giới tính: ");
        String gender = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String phone = sc.nextLine();
        if (!Validator.isValidPhone(phone)) {
            System.out.println("Số điện thoại không hợp lệ.");
            return;
        } else if (phoneExists(phone)) {
            System.out.println("Số điện thoại đã tồn tại.");
            return;
        }

        System.out.print("Nhập mã lớp học: ");
        String batchId = sc.nextLine();
        if (!batchService.exists(batchId)) {
            System.out.println("Mã lớp học không tồn tại.");
            return;
        }

        Student student = new Student(id, name, birthDate, gender, phone, batchId);
        studentList.add(student);
        saveToFile();
        System.out.println("Thêm sinh viên thành công.");
    }

    public void deleteStudent() throws NotFoundStudentException {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID không hợp lệ.");
            return;
        }

        Optional<Student> studentOpt = studentList.stream().filter(s -> s.getId() == id).findFirst();
        if (studentOpt.isEmpty()) {
            throw new NotFoundStudentException("Sinh viên không tồn tại");
        }

        System.out.print("Bạn có chắc muốn xóa không (Yes/No)? ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("Yes")) {
            studentList.remove(studentOpt.get());
            saveToFile();
            showAllStudents();
        }
    }

    public void showAllStudents() {
        printStudentHeader();
        for (Student s : studentList) {
            printStudentRow(s);
        }
    }

    public void searchByName() {
        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = sc.nextLine().toLowerCase();

        List<Student> result = studentList.stream()
                .filter(s -> s.getName().toLowerCase().contains(keyword))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên phù hợp.");
        } else {
            printStudentHeader();
            result.forEach(this::printStudentRow);
        }
    }

    private void printStudentHeader() {
        System.out.printf("%-5s %-20s %-12s %-8s %-12s\n", "ID", "Tên", "Ngày sinh", "GT", "Lớp");
    }

    private void printStudentRow(Student s) {
        String batchName = batchService.getBatchNameById(s.getClassID());
        System.out.printf("%-5d %-20s %-12s %-8s %-12s\n",
                s.getId(), s.getName(), s.getBirthDate(), s.getGender(), batchName);
    }
}