//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("Radius is " + circle.getRadius());
        System.out.println("Area is " + circle.getArea());

        Circle circle2 = new Circle(4.2);
        System.out.println("Radius is " + circle2.getRadius());
        System.out.println("Area is " + circle2.getArea());
    }
}