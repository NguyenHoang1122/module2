public class Solution {
    Queue queue = new Queue();
    public void enQueue(int value){
        Node newNode = new Node(value);
        if (queue.rear == null) {
            queue.front = queue.rear = newNode;
            return;
        }
        queue.rear.link = newNode;
        queue.rear = newNode;
    }
    public void deQueue(){
        if (queue.front == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = queue.front;
        queue.front = queue.front.link;

        if (queue.front == null) {
            queue.rear = null;
        }
        System.out.println("Dequeued: " + temp.data);
    }

    public void displayQueue(){
        if (queue.front == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node current = queue.front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.link;
        }
        System.out.println();
    }
}
