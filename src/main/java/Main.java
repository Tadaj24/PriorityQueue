import interfaces.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> priorityQueue = new PriorityQueue<String>("dupa", 2);
        priorityQueue.push("aaa");
        priorityQueue.push("ccc");
        priorityQueue.push("bbb");
        priorityQueue.push("ddd");
    }
}
