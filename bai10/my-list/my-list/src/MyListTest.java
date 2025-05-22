public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();

        myList.add(20);
        myList.add(33);
        myList.add(40);
        myList.add(1, 50);
        System.out.println("Index 1: " + myList.get(1));
        System.out.println("Phan tu 33 co? khong? :" + myList.contains(33));
        System.out.println("Vi tri 40 : " + myList.indexOf(40));

        myList.remove(1);
        System.out.println("Index 1: " + myList.get(1));
        System.out.println("Kich thuoc ds : " + myList.size());
        myList.clear();
        System.out.println("sau khi clear : " + myList.size());
    }
}
