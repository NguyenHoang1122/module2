import java.util.List;
import java.util.Scanner;

public class UserService {
    private List<User> users;
    private List<Book> books;
    private FileService fileService;
    private String userFilePath;

    public UserService(List<User> users, List<Book> books, String userFilePath, FileService fileService) {
        this.users = users;
        this.books = books;
        this.fileService = new FileService();
        this.userFilePath = userFilePath;
    }

    public void registerUser(Scanner scanner) {
        System.out.print("Nhập tên : ");
        String name = scanner.nextLine();
        System.out.print("Nhập địa chỉ email : ");
        String email = scanner.nextLine();

        User newUser = new User(name, email);
        users.add(newUser);
        fileService.saveUsersToFile(users, userFilePath);
        System.out.println("Đã đăng ký thành công !");
    }

    public void updateUser(Scanner scanner) {
        System.out.print("Nhập ID người dùng cần cập nhật: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        for (User user : users) {
            if (user.getId().equals(id)) {
                System.out.print("Nhập tên mới: ");
                user.setName(scanner.nextLine());
                System.out.print("Nhập địa chỉ email mới: ");
                user.setEmail(scanner.nextLine());
                fileService.saveUsersToFile(users, userFilePath);
                System.out.println("Đã cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy người dùng với ID " + id + " này.");
    }

    public void deleteUser(Scanner scanner) {
        System.out.print("Nhập ID người dùng cần xóa: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                fileService.saveUsersToFile(users, userFilePath);
                System.out.println("Đã xóa người dùng thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy người dùng với ID " + id + " này.");
    }

    public void borrowBook(Scanner scanner) {
        System.out.print("Nhập ID người dùng: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        User user = null;
        for (User u : users) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }
        if (user == null) {
            System.out.println("Không tìm thấy người dùng với ID " + id + ".");
            return;
        }

        System.out.print("Nhập tên sách để mượn: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                user.borrowBook(book);
                System.out.println("Đã mượn sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sách với tên : " + title);
    }

    public void returnBook(Scanner scanner) {
        System.out.print("Nhập ID người dùng: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        User user = null;
        for (User u : users) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }
        if (user == null) {
            System.out.println("Không tìm thấy người dùng với ID " + id + ".");
            return;
        }

        System.out.print("Nhập tên sách để trả: ");
        String title = scanner.nextLine();
        for (Book book : user.getBorrowedBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                user.returnBook(book);
                System.out.println("Đã trả sách thành công!");
                return;
            }
        }
        System.out.println("Không mượn cuốn sách " + title + " này.");
    }

    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("Chưa có tài khoản nào.");
        } else {
            for (User user : users) {
                System.out.println("ID : " + user.getId() + ", Name : " + user.getName() + ", Email : " + user.getEmail());
                System.out.println("Sách đã mượn : ");
                if (user.getBorrowedBooks().isEmpty()) {
                    System.out.println(" Chưa mượn quyển sách nào.");
                } else {
                    for (Book book : user.getBorrowedBooks()) {
                        System.out.println("  - " + book.getTitle() + " bởi " + book.getAuthor());
                    }
                }
            }
        }
    }
}
