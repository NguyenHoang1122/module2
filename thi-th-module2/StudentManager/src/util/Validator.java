package util;

public class Validator {
    public static boolean isValidName(String name){
        return name != null && name.length() >= 4 && name.length() <= 50;
    }

    public static boolean isValidDate(String date){
        return date.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("^(090|091)\\d{7}$");
    }
}
