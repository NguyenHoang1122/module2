import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("***** Quan Ly San Pham *****");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi danh sach san pham");
            System.out.println("3. Tim san pham theo ten");
            System.out.println("4. Luu san pham vao file");
            System.out.println("5. Load san pham tu file");
            System.out.println("6. Xoa san pham theo ten");
            System.out.println("7. Sua san pham theo ten");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("Nhap lua chon cua ban: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    manager.addProduct(sc);
                    break;
                case 2:
                    manager.showProducts();
                    break;
                case 3:
                    manager.searchByName(sc);
                    break;
                case 4:
                    manager.saveToFile();
                    break;
                case 5:
                    manager.loadFromFile();
                    break;
                case 6:
                    System.out.print("Nhap ten san pham can xoa: ");
                    String nameToDelete = sc.nextLine();
                    manager.deleteProduct(nameToDelete);
                    break;
                case 7:
                    System.out.println("Nhap ten san pham can sua: ");
                    String nameToEdit = sc.nextLine();
                    manager.editProduct(nameToEdit);
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Ban da nhap sai hay nhap lai!");
            }
        } while (choice != 0);
    }
}
