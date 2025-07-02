import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        List<Product> products = manager.readProductsFromFile();
        int choice;

        do {
            System.out.println("------Menu------");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. search Product by ID");
            System.out.println("4. Delete Product by ID");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manager.addProduct();
                    products = manager.readProductsFromFile();
                    break;
                case 2:
                    manager.displayProducts(products);
                    break;
                case 3:
                    manager.searchProducts(products);
                    products = manager.readProductsFromFile();
                    break;
                case 4:
                    manager.deleteProduct(products);
                    products = manager.readProductsFromFile();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
    }
}
