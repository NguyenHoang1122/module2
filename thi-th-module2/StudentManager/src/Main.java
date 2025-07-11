import service.StudentService;
import service.BatchService;
import service.TeacherService;
import exceptinon.NotFoundStudentException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BatchService batchService = new BatchService();
        StudentService studentService = new StudentService(batchService);
        TeacherService teacherService = new TeacherService();

        while (true) {
            System.out.println("\n--- Hệ thống quản lý sinh viên ---");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Hiển thị toàn bộ sinh viên");
            System.out.println("4. Tìm kiếm sinh viên theo tên");
            System.out.println("5. Hiển thị toàn bộ giáo viên");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    studentService.addStudent();
                    break;
                case "2":
                    try {
                        studentService.deleteStudent();
                    } catch (NotFoundStudentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    studentService.showAllStudents();
                    break;
                case "4":
                    studentService.searchByName();
                    break;
                case "5":
                    teacherService.showAllTeachers();
                    break;
                case "0":
                    System.out.println("Thoát........");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        }
    }
}