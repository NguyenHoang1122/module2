import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private List<Product> products = new ArrayList<>();
    private final String FILE_NAME = "resource/products.txt";
    public static Scanner sc = new Scanner(System.in);

    public void addProduct(Scanner sc) {
        System.out.print("Nhap ID: ");
        String id = sc.nextLine();
        System.out.print("Nhap ten: ");
        String name = sc.nextLine();
        System.out.print("Nhap gia: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap so luong: ");
        int quantity = Integer.parseInt(sc.nextLine());

        products.add(new Product(id, name, price, quantity));
    }

    public void showProducts() {
        if (products.isEmpty()) {
            System.out.println("Khong co san pham nao trong danh sach.");
        } else {
            for (Product p : products) {
                System.out.println(p.display());
            }
        }
    }

    public void searchByName(Scanner sc) {
        System.out.print("Nhap ten san pham can tim: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(keyword)) {
                System.out.println(p.display());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham nao voi ten: " + keyword);
        }
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product p : products) {
                bw.write(p.toString());
                bw.newLine();
            }
            System.out.println("Da luu");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        products.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);
                    products.add(new Product(id, name, price, quantity));
                }
            }
            System.out.println("Da load san pham tu file.");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void deleteProduct(String name) {
        boolean found = false;
        for (Product p : products) {
            if (p.getName().equals(name)) {
                products.remove(p);
                System.out.println("Da xoa san pham: " + p.display());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham voi Name: " + name);
        }
    }

    public void editProduct(String name) {
        boolean found = false;
        for (Product p : products) {
            if (p.getName().equals(name)) {
                System.out.print("Nhap ID moi: ");
                String newId = sc.nextLine();
                System.out.print("Nhap ten moi: ");
                String newName = sc.nextLine();
                System.out.print("Nhap gia moi: ");
                double newPrice = Double.parseDouble(sc.nextLine());
                System.out.print("Nhap so luong moi: ");
                int newQuantity = Integer.parseInt(sc.nextLine());

                p.setId(newId);
                p.setName(newName);
                p.setPrice(newPrice);
                p.setQuantity(newQuantity);

                System.out.println("Da cap nhat san pham: " + p.display());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham voi Name: " + name);
        }
    }
}
