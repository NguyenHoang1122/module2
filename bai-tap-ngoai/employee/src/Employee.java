public class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;
    private String hireDate;
    private String department;

    public Employee() {
        this.id = 0;
        this.name = "";
        this.position = "";
        this.salary = 0;
        this.hireDate = "";
        this.department = "";
    }

    public Employee(String name, String position) {
        this();
        this.name = name;
        this.position = position;
    }

    public Employee(int id, String name, String position, double salary, String hireDate, String department) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String date) {
        this.hireDate = date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String dept) {
        this.department = dept;
    }

    public double calculateBonus(double percentage) {
        return  salary * percentage;
    }

    public void raiseSalary(double percentage) {
        salary += salary*percentage;
    }
    public void displayInfo(){
        System.out.println("Employee ID: " + this.id);
        System.out.println("Employee Name: " + this.name);
        System.out.println("Employee Position: " + this.position);
        System.out.println("Employee Salary: " + this.salary);
        System.out.println("Employee Hire Date: " + this.hireDate);
        System.out.println("Employee Department: " + this.department);
    }

    public boolean isManager(){
        return this.position.equals("Manager");
    }

}
