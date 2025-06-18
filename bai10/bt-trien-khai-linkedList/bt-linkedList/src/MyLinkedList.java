import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private Node<E> head;
    private int numNodes = 0;

    public MyLinkedList() {
        head = null;
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNodes) throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(element);
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node<E> newNode = new Node<>(element);
            newNode.next = temp.next;
            temp.next = newNode;
            numNodes++;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(E e) {
        if (head == null) {
            addFirst(e);
        } else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<>(e);
            numNodes++;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) throw new IndexOutOfBoundsException();

        Node<E> removed;
        if (index == 0) {
            removed = head;
            head = head.next;
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            removed = temp.next;
            temp.next = removed.next;
        }
        numNodes--;
        return removed.data;
    }

    public boolean remove(Object e) {
        if (head == null) return false;
        if (head.data.equals(e)) {
            head = head.next;
            numNodes--;
            return true;
        }
        Node<E> temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(e)) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> newList = new MyLinkedList<>();
        Node<E> temp = head;
        while (temp != null) {
            newList.addLast(temp.data);
            temp = temp.next;
        }
        return newList;
    }

    public boolean contains(E o) {
        return indexOf(o) != -1;
    }

    public int indexOf(E o) {
        Node<E> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(o)) return index;
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes) throw new IndexOutOfBoundsException();

        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public E getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.data;
    }

    public E getLast() {
        if (head == null) throw new NoSuchElementException();
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }
}