import java.util.List;
import java.util.Scanner;

public class Demo {
    private static final String BOOK_FILE = "file/books.txt";
    private static final String USER_FILE = "file/users.txt";

    private final Scanner scanner = new Scanner(System.in);
    private final FileService fileService = new FileService();
    private final BookService bookService;
    private final UserService userService;
    private final List<Book> books;
    private final List<User> users;

    public Demo() {
        this.books = fileService.loadBooksFromFile(BOOK_FILE);
        this.users = fileService.loadUsersFromFile(USER_FILE);
        this.bookService = new BookService(books, fileService, BOOK_FILE);
        this.userService = new UserService(users, books, USER_FILE, fileService);
    }

    public void run() {
        int choice = -1;
        do {
            printMenu();
            System.out.print("Nhập lựa chọn : ");
            try{
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        bookService.addBook(scanner);
                        break;
                    case 2:
                        bookService.updateBook(scanner);
                        break;
                    case 3:
                        bookService.deleteBook(scanner);
                        break;
                    case 4:
                        bookService.searchBook(scanner);
                        break;
                    case 5:
                        userService.registerUser(scanner);
                        break;
                    case 6:
                        userService.updateUser(scanner);
                        break;
                    case 7:
                        userService.deleteUser(scanner);
                        break;
                    case 8:
                        userService.borrowBook(scanner);
                        break;
                    case 9:
                        userService.returnBook(scanner);
                        break;
                    case 10:
                        bookService.displayAllBooks();
                        break;
                    case 11:
                        userService.displayAllUsers();
                        break;
                    case 0:
                        saveDataToFile();
                        System.out.println("Đang thoát.........");
                        break;
                    default:
                        System.out.println("Bạn đã nhập sai. Vui lọng nhập lại !");
                }
            }catch (NumberFormatException e) {
                System.out.println("Không hợp lệ. Vui lòng nhập một số.");
            }

        } while (choice != 0);
    }

    private void printMenu() {
        System.out.println(" ======================================= LIBRARY MENU =======================================");
        System.out.print("|| 1. Thêm sách                || ");
        System.out.print("2. Sửa sách                    || ");
        System.out.println("3. Xóa sách             ||");
        System.out.print("|| 4. Tìm sách                 || ");
        System.out.print("5. Tạo tài khoản               || ");
        System.out.println("6. Câp nhập tài khoản   ||");
        System.out.print("|| 7. Xóa tài khoản            || ");
        System.out.print("8. Mượn sách                   || ");
        System.out.println("9. Trả sách             ||");
        System.out.print("|| 10. Hiển thị tất cả sách    || ");
        System.out.print("11. Hiển thị tất cả tài khoản  || ");
        System.out.println("0. Thoát                ||");
        System.out.println(" ____________________________________________________________________________________________");

    }

    private void saveDataToFile() {
        fileService.saveBooksToFile(books, BOOK_FILE);
        fileService.saveUsersToFile(users, USER_FILE);
        System.out.println(" Đã được lưu !");
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.run();
    }
}

