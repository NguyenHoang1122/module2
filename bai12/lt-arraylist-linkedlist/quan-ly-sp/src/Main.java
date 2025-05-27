import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---Quan Ly San Pham---");
            System.out.println("1. Thêm sản phẩm.");
            System.out.println("2. Sửa thông tin sản phẩm(nhập ID).");
            System.out.println("3. Xóa sản phẩm(nhập ID).");
            System.out.println("4. Hiển thị thông tin sản phẩm.");
            System.out.println("5. Tìm kiếm sản phẩm.");
            System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá.");
            System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá.");
            System.out.println("0. Thoát.");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    pm.addProduct((new Product(id,name,price)));
                    break;
                case 2:
                    System.out.print("Nhập ID: ");
                    int editID = scanner.nextInt();
                    scanner.nextLine();
                    if(!pm.checkProduct(editID)){
                        System.out.println("Khong tim thay sp co id : " + editID);
                        break;
                    }
                    System.out.print("Nhập tên mới : ");
                    String newName = scanner.nextLine();
                    System.out.print("Nhập giá mới : ");
                    double newPrice = scanner.nextDouble();
                    pm.editProduct(editID,newName,newPrice);
                    break;
                case 3:
                    System.out.print("Nhập ID: ");
                    int deleteID = scanner.nextInt();
                    scanner.nextLine();
                    if(!pm.checkProduct(deleteID)){
                        System.out.println("Khong tim thay sp co id : " + deleteID);
                        break;
                    }
                case 4:
                    pm.displayProducts();
                    break;
            }
        }while(choice != 0);
    }
}