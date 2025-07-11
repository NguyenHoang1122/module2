import java.util.List;
import java.util.Scanner;

public class BookService {
    private List<Book> books;
    private FileService fileService;
    private String bookFilePath;

    public BookService(List<Book> books, FileService fileService, String bookFilePath) {
        this.books = books;
        this.fileService = fileService;
        this.bookFilePath = bookFilePath;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Scanner scanner) {
        System.out.print("Nhập tên sách : ");
        String title = scanner.nextLine();
        System.out.print("Nhập tác giả sách: ");
        String author = scanner.nextLine();
        System.out.print("Nhập thể loại sách: ");
        String category = scanner.nextLine();
        System.out.print("Sách có sẵn không (true/false): ");
        boolean available = scanner.nextBoolean();
        scanner.nextLine();
        Book newBook = new Book(title, author, category, available);
        books.add(newBook);
        fileService.saveBooksToFile(books, bookFilePath);
        System.out.println("Thêm sách thành công.");
    }

    public void updateBook(Scanner scanner) {
        System.out.println("Nhập tên sách cần cập nhật: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.print("Nhập tên sách mới: ");
                book.setTitle(scanner.nextLine());
                System.out.print("Nhập tác giả mới: ");
                book.setAuthor(scanner.nextLine());
                System.out.print("Nhập thể loại mới: ");
                book.setCategory(scanner.nextLine());
                System.out.print("Sách có sẵn không (true/false): ");
                book.setAvailable(scanner.nextBoolean());
                scanner.nextLine();
                fileService.saveBooksToFile(books, bookFilePath);
                System.out.println("Đã cập nhật thành công!");
                return;
            }
        }
    }

    public void deleteBook(Scanner scanner) {
        System.out.println("Nhập tên sách cần xóa : ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                fileService.saveBooksToFile(books, bookFilePath);
                System.out.println("Đã xóa thành công sách: " + title);
                return;
            }
        }
    }

    public void searchBook(Scanner scanner) {
        System.out.print("Nhập tên sách cần tìm: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Đã tìm thấy sách : " + book);
                return;
            }
        }
        System.out.println("Không tìm thấy sách với tên: " + title);
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Không có sách nào có trong thư viện.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
