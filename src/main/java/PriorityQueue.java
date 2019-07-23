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

    /**
     * Constructor with initializing first element of the queue
     * @param headValue     - first element of the queue
     * @param priority - priority of the added element
     */
    public PriorityQueue(T headValue, int priority) {
        this.head = new PriorityQueueElement(headValue, priority);
    }

    public T pop() {
        return null;
    }

    public void push(T elem) throws NullPointerQueueElementException {
        push(elem, 0);
    }

    public void push(T elem, int priority) throws NullPointerQueueElementException {
        if (elem == null){
            throw new NullPointerQueueElementException("Element which you want to add is null");
        }

        PriorityQueueElement newElement = new PriorityQueueElement(elem, priority);

        if (isEmpty()){
            head = newElement;
            return;
        }

        PriorityQueueElement pivotElement = getLastElementWithGreaterOrSamePriority(priority);
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
    private void checkIfQueueIsEmpty() throws NullPointerQueueElementException {
        if (isEmpty()) {
            throw new NullPointerQueueElementException("The queue is empty");
        }
    }

    private PriorityQueueElement getLastElementWithGreaterOrSamePriority(int priority) throws NullPointerQueueElementException {
        if (isEmpty()) {
            throw new NullPointerQueueElementException("The queue is empty");
        }

        if (!head.hasNext()) {
            return head;
        }

        PriorityQueueElement lastElement = head;


        while (lastElement.hasNext()) {
            if (lastElement.getNext().getPriority() > priority) {
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
