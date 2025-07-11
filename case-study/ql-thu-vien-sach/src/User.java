import java.util.ArrayList;
import java.util.List;

public class User {
    private static int idCounter = 1;
    Integer id;
    String name;
    String email;
    private List<Book> borrowedBooks;

    public User( String name, String email) {
        this.id = idCounter ++;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
        } else {
            System.out.println("Sách này không có sẵn để mượn.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
        } else {
            System.out.println("Chưa mượn sách này.");
        }
    }

    @Override
    public String toString() {
        return "Use{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", borrowedBooks=" + borrowedBooks + '}';
    }
}
