import java.io.*;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    public static Scanner scanner = new Scanner(System.in);
    public static  File myFile = new File("resource/data.txt");
    public static void showListStudents() {
        try {
            List<Student> students = FileManager.readDataFromFile(myFile);
            for (Student student : students) {
                System.out.println(student);
            }
        }catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }

    public static void  addStudent() {
        System.out.println("Enter Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter address: ");
        String address = scanner.nextLine();
        try {
            if (myFile.exists()) {
                FileWriter fileWriter = new FileWriter(myFile, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                String line = id + "," + name + "," + age + "," + address;
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        }catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }

    }

    public static void deleteStudent(int id){
        try {
            List<Student> students = FileManager.readDataFromFile(myFile);
            Student studentDelete = null;
            for (Student student : students) {
                if (student.getId() == id) {
                    studentDelete = student;
                    break;
                }
            }
            if (studentDelete == null){
                throw new ItemNotFoundException("Student with id " + id + " not found.");
            }
            students.remove(studentDelete);
            FileManager.writeDataToFile(myFile, students);
        }catch (ItemNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }
}