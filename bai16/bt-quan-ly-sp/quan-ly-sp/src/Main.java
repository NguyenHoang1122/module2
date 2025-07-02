import java.io.File;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        File file = new File("resource/data.txt");
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        int choice;
        do {
            System.out.println("------Menu------");
            System.out.println("1. Show List Students");
            System.out.println("2. Add Student");
            System.out.println("3. Delete Student by ID");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    studentManager.showListStudents();
                    break;
                case 2:
                    studentManager.addStudent();
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    studentManager.deleteStudent(id);
                    System.out.println("Student with ID " + id + " has been deleted.");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);

    }
}