package fifoDatastructure;

public class FifoDataStructureExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.push(10);
        System.out.println(queue.pull());

        Queue <String> queue1 = new Queue<>();
        queue1.push("Hello-01");
        queue1.push("Hello-02");

        System.out.println(queue1.pull());
        System.out.println(queue1.pull());
        System.out.println(queue1.pull());
    }
}
