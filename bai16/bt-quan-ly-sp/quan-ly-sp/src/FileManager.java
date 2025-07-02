import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Student> readDataFromFile(File myFile) throws IOException {
        List<Student> students = new ArrayList<>();
        if (myFile.exists()) {
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Student s = new Student(Integer.parseInt(data[0]), data[1],Integer.parseInt(data[2]), data[3]);
                students.add(s);
            }
        } else {
            throw new FileNotFoundException("File not found: " + myFile.getAbsolutePath());
        }
        return students;
    }

    public static void writeDataToFile(File myFile, List<Student> students) throws IOException {
        if (myFile.exists()) {
            FileWriter fileWriter = new FileWriter(myFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : students) {
                String line = student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getAddress();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } else {
            throw new FileNotFoundException("File not found: " + myFile.getAbsolutePath());
        }
    }
}