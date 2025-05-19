public class Demo {
    public static void main(String[] args) {
        Point p1 = new Point();
        System.out.println("Point 1: " + p1);

        Point p2 = new Point(7f,9f);
        System.out.println("Point 2: " + p2);

        p2.setXY(12f,9f);
        System.out.println("Point setXY: " + p2);

        MoveablePoint mp1 = new MoveablePoint();
        System.out.println("MoveablePoint 1: " + mp1);
        MoveablePoint mp2 = new MoveablePoint(22f,34f);
        System.out.println("MoveablePoint 2: " + mp2);
        MoveablePoint mp3 = new MoveablePoint(8f,11f,32f,41f);
        System.out.println("MoveablePoint 3: " + mp3);

        mp3.move();
        System.out.println("MoveablePoint 3 after move: " + mp3);
    }
}
