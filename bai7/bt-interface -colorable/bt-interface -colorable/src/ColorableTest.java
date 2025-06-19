public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(3.5);
        shapes[1] = new Rectangle(2.0, 4.0);
        shapes[2] = new Square(6.0);
        shapes[3] = new Square(8.0, "red", false);

        for (Shape shape : shapes) {
            System.out.println("Area = " + getArea(shape));

            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }

            System.out.println();
        }
    }

    private static double getArea(Shape shape) {
        if (shape instanceof Circle) {
            return ((Circle) shape).getArea();
        } else if (shape instanceof Rectangle) {
            return ((Rectangle) shape).getArea();
        }
        return 0;
    }
}