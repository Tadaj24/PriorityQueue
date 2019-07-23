import interfaces.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> priorityQueue = new PriorityQueue<String>("dupa", 2);
        priorityQueue.push("aaa");
        priorityQueue.push("bbb", 10);
        priorityQueue.push("ccc", 5);
        priorityQueue.push("ddd", 1);
    }
}
