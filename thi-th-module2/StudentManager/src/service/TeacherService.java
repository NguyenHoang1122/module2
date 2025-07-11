package service;

import model.Teacher;
import util.CSVUtil;

import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    private final List<Teacher> teachers = new ArrayList<>();
    public TeacherService() {
        loadFromFile();
    }

    private  void loadFromFile() {
        List<String[]> data = CSVUtil.readCSV("data/teacher.csv");
        for (String[] row : data) {
            if (row.length == 5) {
                Teacher teacher = new Teacher(row[0], row[1], row[2], row[3], row[4]);
                teachers.add(teacher);
            }
        }
    }

    public void showAllTeachers() {
        System.out.printf("%-10s %-20s %-12s %-8s %-12s\n", "ID", "Tên", "Ngày sinh", "Giới tính", "Số điện thoại");
        for (Teacher teacher : teachers) {
            System.out.printf("%-10s %-20s %-12s %-8s %-12s\n",
                teacher.getId(),
                teacher.getName(),
                teacher.getBirthDate(),
                teacher.getGender(),
                teacher.getPhone());
        }
    }
}
