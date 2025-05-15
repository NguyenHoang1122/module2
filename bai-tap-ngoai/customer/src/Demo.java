public class Demo {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "Toan", "nguyenvantoan@gmail.com", "0966858642", "2025-05-15", 807);
        customer.displayInfo();
        customer.makePurchases(215);
        customer.displayInfo();
    }
}
