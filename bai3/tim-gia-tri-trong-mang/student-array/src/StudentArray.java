import java.util.Scanner;

public class StudentArray {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name's student: ");
        String name = scanner.next();
        boolean isExist = false;
        for(int i = 0; i < students.length; i++) {
            if(students[i].equals(name)) {
                System.out.print("Position of the students in the list " + name + " is: " + (i+1));
                isExist = true;
                break;
            }
        }
        if(!isExist) {
            System.out.println("Not found" + name + " in the list.");
        }
    }
}
