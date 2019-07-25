import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriorityQueueElementTest {
    PriorityQueueElement priorityQueueElement;

    @Test
    @DisplayName("hasNext() method test - case: should return false")
    void shouldHasNextMethodReturnFalse() {
        priorityQueueElement = new PriorityQueueElement("Sample");
        Assertions.assertEquals(false, priorityQueueElement.hasNext());
    }

    @Test
    @DisplayName("hasNext() method test - case: should return true")
    void shouldHasNextMethodReturnTrue() {
        priorityQueueElement = new PriorityQueueElement("Sample 1");
        priorityQueueElement.setNext(new PriorityQueueElement("Sample 2"));
        Assertions.assertEquals(true, priorityQueueElement.hasNext());
    }
}