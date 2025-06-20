public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.enQueue(14);
        solution.enQueue(22);
        solution.enQueue(-6);

        solution.displayQueue();

        solution.deQueue();
        solution.deQueue();
        solution.displayQueue();
        solution.enQueue(9);
        solution.enQueue(20);
        solution.displayQueue();
    }
}
