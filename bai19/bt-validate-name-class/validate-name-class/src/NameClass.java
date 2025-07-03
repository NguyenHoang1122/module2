import java.util.Scanner;

public class NameClass {
    private static final String NAME_REGEX = "(C|A｜P)[^a-zA-Z0-9] + [0-9]{4} + (G|H|I|K)";
    Scanner sc = new Scanner(System.in);

    public void validateName() {
        System.out.println("Enter the name:");
        String name = sc.nextLine();
        if (name.matches(NAME_REGEX)) {
            System.out.println("Valid Name");
        } else {
            System.out.println("Invalid Name");
        }
    }

    public static void main(String[] args) {
        NameClass nameClass = new NameClass();
        nameClass.validateName();
    }
}
