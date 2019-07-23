import exceptions.NullPointerQueueElementException;
import interfaces.Queue;

public class PriorityQueue<T extends Comparable> implements Queue<T> {
    PriorityQueueElement head;

    public PriorityQueue() {
        PriorityQueueElement head = null;
    }

    public PriorityQueue(T headValue) {
        this.head = new PriorityQueueElement(headValue);
    }

    public PriorityQueue(T headValue, T... elements) {
        this.head = new PriorityQueueElement(headValue);
    }

    public T pop() {
        return null;
    }

    public void push(T elem) {
        if (elem == null){
            throw new NullPointerQueueElementException("Element which you want to add is null");
        }

        PriorityQueueElement newElement = new PriorityQueueElement(elem);

        if (isEmpty()){
            head = newElement;
            return;
        }

        PriorityQueueElement pivotElement = getLastElementWithGreaterOrSamePriority(newElement);
        insertElement(pivotElement, newElement);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean size() {
        return false;
    }

    public T top() {
        return null;
    }

    public void clean() {

    }

    //<editor-fold desc="Private methods">
    private void checkIfQueueIsEmpty() {
        if (isEmpty()) {
            throw new NullPointerQueueElementException("The queue is empty");
        }
    }

    private PriorityQueueElement getLastElementWithGreaterOrSamePriority(PriorityQueueElement newElement){
        if (isEmpty()) {
            throw new NullPointerQueueElementException("The queue is empty");
        }

        if (!head.hasNext()) {
            return head;
        }

        PriorityQueueElement lastElement = head;

        while (lastElement.hasNext()) {
            if (lastElement.compareTo(newElement) >= 0) {
                lastElement = lastElement.getNext();
            }
        }

        return lastElement;
    }

    private void insertElement(PriorityQueueElement pivot, PriorityQueueElement elementToInput) {
        if (!pivot.hasNext()){
            pivot.setNext(elementToInput);
            return;
        }

        elementToInput.setNext(pivot.getNext());
        pivot.setNext(elementToInput);
    }
    //</editor-fold>
}
