package exceptinon;

public class NotFoundStudentException extends Exception{
    public NotFoundStudentException(String message) {
        super(message);
    }
}
