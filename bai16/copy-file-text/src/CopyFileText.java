import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập file nguồn: ");
        String source = scanner.nextLine();
        File srcFile = new File(source);
        if (checkSrcFile(srcFile)) return;
        System.out.println("Nhập file đích: ");
        String target = scanner.nextLine();
        File tgtFile = new File(target);
        if (checkTgtFile(tgtFile, scanner)) return;

        int count = 0;

        try (FileReader reader = new FileReader(srcFile); FileWriter writer = new FileWriter(tgtFile)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
                count++;
            }
            System.out.println("Sao chép thành công. Đã sao chép " + count + " ký tự.");
        } catch (IOException e) {
            System.out.println("Lỗi sao chép file." + e.getMessage());
        }
    }

    private static boolean checkTgtFile(File tgtFile, Scanner scanner) {
        if (tgtFile.exists()) {
            System.out.println("File đích đã tồn tại. Ghi đè? (y/n): ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("y")) {
                System.out.println("Hủy sao chép.....");
                return true;
            }
        }
        return false;
    }

    private static boolean checkSrcFile(File srcFile) {
        if (!srcFile.exists()) {
            System.out.println("File nguồn không tồn tại.");
            return true;
        }
        if (!srcFile.isFile()) {
            System.out.println("File nguồn không hợp lệ.");
            return true;
        }
        return false;
    }
}
