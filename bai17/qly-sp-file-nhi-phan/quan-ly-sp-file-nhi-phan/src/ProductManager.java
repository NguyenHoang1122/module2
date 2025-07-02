import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public static final String FILE_PATH = "products.bin";
    public Scanner scanner = new Scanner(System.in);
    public void writeProductsToFile(List<Product> products) {
        try {
            File file = new File(FILE_PATH);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
              ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(products);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> readProductsFromFile() {
        List<Product> products = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            products = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void displayProducts(List<Product> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.printf("%-10s %-20s %-10s %-20s %-30s%n", "ID", "Name", "Price", "Manufacturer", "Description");
        for (Product product : products) {
            System.out.printf("%-10s %-20s %-10.2f %-20s %-30s%n",
                    product.getId(), product.getName(), product.getPrice(),
                    product.getManufacturer(), product.getDescription());
        }
    }

    public void addProduct() {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter product manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter product description: ");
        String description = scanner.nextLine();

        Product newProduct = new Product(id, name, price, manufacturer, description);
        List<Product> products = readProductsFromFile();
        if (products != null) {
            products.add(newProduct);
            writeProductsToFile(products);
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Error reading products from file.");
        }
    }

    public void searchProducts(List<Product> products) throws IOException {
        if (products == null || products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.print("Enter product ID to search: ");
        String searchId = scanner.nextLine();
        boolean found = false;
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(searchId)) {
                System.out.println("Product found: " + product);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product with ID " + searchId + " not found.");
        }
    }

    public void deleteProduct(List<Product> products) throws IOException {
        if (products == null || products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.print("Enter product ID to delete: ");
        String deleteId = new BufferedReader(new InputStreamReader(System.in)).readLine();
        boolean removed = products.removeIf(product -> product.getId().equalsIgnoreCase(deleteId));
        if (removed) {
            writeProductsToFile(products);
            System.out.println("Product with ID " + deleteId + " has been deleted.");
        } else {
            System.out.println("Product with ID " + deleteId + " not found.");
        }
    }
}
