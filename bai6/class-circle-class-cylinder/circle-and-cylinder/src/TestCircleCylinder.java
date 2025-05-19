public class TestCircleCylinder {
    public static void main(String[] args) {
        Circle circle = new Circle(4.5, "blue");
        System.out.println(circle.toString());

        Cylinder cylinder = new Cylinder(5);
        System.out.println(cylinder.toString());

        Cylinder cylinder2 = new Cylinder(5,4,"green");
        System.out.println(cylinder2.toString());
    }
}
