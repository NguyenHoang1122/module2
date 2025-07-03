import java.util.Scanner;

public class PhoneClass {
    private static final String PHONE_REGEX = "(\\([0-9]{2}\\)-\\(0[0-9]{9}\\))";
    Scanner sc = new Scanner(System.in);

    public void validatePhone(){
        System.out.println("Enter the phone number:");
        String phone = sc.nextLine();
        if (phone.matches(PHONE_REGEX)) {
            System.out.println("Valid Phone Number");
        } else {
            System.out.println("Invalid Phone Number");
        }
    }
    public static void main(String[] args) {
        PhoneClass phoneClass = new PhoneClass();
        phoneClass.validatePhone();
    }
}
