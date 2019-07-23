import interfaces.QueueElement;
import lombok.Data;

@Data
public class PriorityQueueElement<T> implements QueueElement<T> {
    private PriorityQueueElement next = null;

    private T content;

    int priority;

    public PriorityQueueElement(T content, int priority) {
        this.content = content;
        this.priority = priority;
    }

    public PriorityQueueElement(T content) {
        this.content = content;
        this.priority = 0;
    }

    public boolean hasNext() {
        return next != null;
    }
}
