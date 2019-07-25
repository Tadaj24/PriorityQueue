import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
class PriorityQueueElement<T extends Comparable> implements QueueElement, Comparable<PriorityQueueElement> {
    private PriorityQueueElement next = null;

    private T content;

    public PriorityQueueElement(T content) {
        this.content = content;
    }

    public boolean hasNext() {
        return next != null;
    }

    public int compareTo(@NotNull PriorityQueueElement o) {
        return this.content.compareTo(o.content);
    }
}
