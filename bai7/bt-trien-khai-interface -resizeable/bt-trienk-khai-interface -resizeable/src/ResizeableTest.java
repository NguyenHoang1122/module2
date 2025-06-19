import java.util.Random;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Square(4.0);

        Random rand = new Random();

        for (Shape shape : shapes) {
            double percent = 1 + rand.nextInt(100); // 1–100%
            System.out.println("\nBefore resize:");
            System.out.println(shape);
            System.out.println("Area: " + getArea(shape));

            if (shape instanceof Resizeable) {
                ((Resizeable) shape).resize(percent);
                System.out.println("Resized by " + percent + "%");
            }

            System.out.println("After resize:");
            System.out.println(shape);
            System.out.println("Area: " + getArea(shape));
        }
    }

    public static double getArea(Shape shape) {
        if (shape instanceof Circle) {
            return ((Circle) shape).getArea();
        } else if (shape instanceof Rectangle) {
            return ((Rectangle) shape).getArea();
        }
        return 0.0;
    }
}