public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String joinDate;
    private double totalPurchases;

    public Customer(){
        this.id = 0;
        this.name = "";
        this.email = "";
        this.phone = "";
        this.joinDate = "";
        this.totalPurchases = 0;
    }
    public Customer(String name){
        this();
        this.name = name;
    }
    public Customer(String name, String email, String phone){
        this();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public Customer(int id, String name, String email, String phone, String joinDate, double totalPurchases){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.joinDate = joinDate;
        this.totalPurchases = totalPurchases;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public double getTotalPurchases() {
        return totalPurchases;
    }

    public void setTotalPurchases(double totalPurchases) {
        this.totalPurchases = totalPurchases;
    }
    public void makePurchases(double amount){
        if(amount > 0){
            this.totalPurchases += amount;
        }
    }
    public void displayInfo(){
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Email: " + this.email);
        System.out.println("Phone: " + this.phone);
        System.out.println("Join Date: " + this.joinDate);
        System.out.println("Total Purchases: " + this.totalPurchases + " USD.");
        System.out.println("Vip : " + (isVip() ? "Yes" : "No"));
    }
    public boolean isVip(){
        return totalPurchases > 1000;
    }
}
