import interfaces.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> priorityQueue = new PriorityQueue<String>("eee");
        priorityQueue.push("c");
        priorityQueue.push("bbb");
        priorityQueue.push("p");
        priorityQueue.push("e");
        priorityQueue.push("g");
        priorityQueue.push("a");
        priorityQueue.push("ddd");
        System.out.println(priorityQueue);

        System.out.println("Size: " + priorityQueue.size());

        System.out.println(priorityQueue.pop());
        System.out.println(priorityQueue.pop());
        System.out.println(priorityQueue.pop());
        System.out.println(priorityQueue.pop());
        System.out.println(priorityQueue.pop());
        System.out.println(priorityQueue.pop());
        System.out.println("last " + priorityQueue.pop());
    }
}
