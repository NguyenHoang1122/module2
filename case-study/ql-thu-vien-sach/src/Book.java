public class Book {
    private static int idCounter = 1;
    Integer id;
    String title;
    String author;
    String category;
    boolean available;

    public Book(String title, String author, String category, boolean available) {
        this.id = idCounter ++;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = available;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" + "id =" + id + ", Tên ='" + title + '\'' + ", Tác giả ='" + author + '\'' + ", Thể loại ='" + category + '\'' + ", Có sẵn?=" + available + '}';
    }
}
