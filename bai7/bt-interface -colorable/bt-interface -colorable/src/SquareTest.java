public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(5.5);
        System.out.println(square);

        square = new Square(7.0, "blue", true);
        System.out.println(square);
        square.howToColor();
    }
}
