import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService {
    public void saveBooksToFile(List<Book> books, String filePath) {
        try (PrintWriter printWriter = new PrintWriter(filePath)) {
            for (Book book : books) {
                printWriter.println(book.getId() + "," + book.getTitle() + "," + book.getAuthor() + "," +
                        book.getCategory() + "," + book.isAvailable());
            }
        } catch (IOException e) {
            System.err.println("Không thể lưu vào file : " + e.getMessage());
        }
    }

    public List<Book> loadBooksFromFile(String filePath) {
        List<Book> books = new ArrayList<>();
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                System.out.println("Không tìm thấy file, tạo file mơi : " + filePath);
                file.createNewFile();
                return books;
            }

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length == 5) {
                        Integer id = Integer.parseInt(parts[0]);
                        String title = parts[1];
                        String author = parts[2];
                        String category = parts[3];
                        boolean available = Boolean.parseBoolean(parts[4]);
                        books.add(new Book(title, author, category, available));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Không thể tải sách từ file : " + e.getMessage());
        }
        return books;
    }

    public void saveUsersToFile(List<User> users, String filePath) {
        try (PrintWriter printWriter = new PrintWriter(filePath)) {
            for (User user : users) {
                printWriter.println(user.getId() + "," + user.getName() + "," + user.getEmail());
            }
        } catch (IOException e) {
            System.err.println("Không thể lưu tài khoản vào file : " + e.getMessage());
        }
    }

    public List<User> loadUsersFromFile(String filePath) {
        List<User> users = new ArrayList<>();
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                System.out.println("Không tìm thấy file, tạo file mới : " + filePath);
                file.createNewFile();
                return users;
            }
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        Integer id = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        String email = parts[2];
                        users.add(new User(name, email));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Không thể lưu tài khoản vào file : " + e.getMessage());
        }
        return users;
    }
}
