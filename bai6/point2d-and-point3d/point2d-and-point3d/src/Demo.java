public class Demo {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(3f,5.3f);
        System.out.println("point2D = " + point2D.toString());

        Point3D point3D = new Point3D(3f,5.3f,5.3f);
        System.out.println("point3D = " + point3D.toString());

        point3D.setXYZ(3f,5.3f,5.3f);
        System.out.println("point3D after setXYZ = " + point3D.toString());
    }
}
