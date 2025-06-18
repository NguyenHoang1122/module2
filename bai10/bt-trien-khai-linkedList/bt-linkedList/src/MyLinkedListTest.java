public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList();

        list.addFirst(10);
        list.addLast(20);
        list.add(1, 15);
        list.printList();
        System.out.println("size:" + list.size());

        list.remove(Integer.valueOf(15));
        list.printList();

        System.out.println("Contains 20?" + list.contains(20));
        System.out.println("Contains 10?" + list.contains(10));

        MyLinkedList<Integer> cloned = list.clone();
        cloned.printList();
    }
}
