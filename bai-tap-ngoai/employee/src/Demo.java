public class Demo {
    public static void main(String[] args) {
        Employee emp = new Employee(13526, "Nguyen Thi Trang", "Manager", 20000, "2025-05-15", "Marketing");
        emp.displayInfo();
        emp.calculateBonus(0.05);
        emp.raiseSalary(0.05);
        emp.displayInfo();
    }
}
