import exceptions.EmptyQueueException;
import exceptions.NullPointerQueueElementException;

import java.util.stream.Stream;

public class PriorityQueue<T extends Comparable> implements Queue<T> {
    PriorityQueueElement head;

    //region Constructors
    public PriorityQueue() {
        PriorityQueueElement head = null;
    }

    public PriorityQueue(T headValue) {
        this.head = new PriorityQueueElement(headValue);
    }

    public PriorityQueue(T firstValue, T secondValue) {
        push(firstValue);
        push(secondValue);
    }

    public PriorityQueue(T firstValue, T secondValue, T thirdValue) {
        push(firstValue);
        push(secondValue);
        push(thirdValue);
    }

    public PriorityQueue(T firstValue, T secondValue, T thirdValue, T... elements) {
        push(firstValue);
        push(secondValue);
        push(thirdValue);
        Stream.of(elements).forEach(x -> push(x));
    }
    //endregion

    //region Queue interface methods
    public T pop() {
        if (isEmpty()) {
            throw new EmptyQueueException("The queue is empty");
        }

        PriorityQueueElement elementToReturn = head;
        head = head.getNext();
        return (T) elementToReturn.getContent();
    }

    public void push(T elem) {
        if (elem == null) {
            throw new NullPointerQueueElementException("Element which you want to add is null.");
        }

        PriorityQueueElement newElement = new PriorityQueueElement(elem);

        if (isEmpty()) {
            head = newElement;
            return;
        }

        PriorityQueueElement pivotElement = getLastElementWithGreaterOrSamePriority(newElement);
        insertElement(pivotElement, newElement);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }

        int count = 1;
        PriorityQueueElement currentElement = head;
        while (currentElement.hasNext()) {
            count++;
            currentElement = currentElement.getNext();
        }

        return count;
    }

    public T top() {
        if (isEmpty()) {
            throw new EmptyQueueException("The queue is empty");
        }

        PriorityQueueElement currentElement = head;

        if (size() == 1){
            head = null;
            return (T) currentElement.getContent();
        }

        PriorityQueueElement previousElement = head;
        currentElement = head.getNext();
        while (currentElement.hasNext()) {
            previousElement = currentElement;
            currentElement = currentElement.getNext();
        }

        previousElement.setNext(null);

        return (T) currentElement.getContent();
    }

    public void clear() {
        head = null;
    }
    //endregion

    //region Private methods
    private PriorityQueueElement getLastElementWithGreaterOrSamePriority(PriorityQueueElement newElement) {
        if (isEmpty()) {
            throw new NullPointerQueueElementException("The queue is empty");
        }

        if (head.compareTo(newElement) > 0) {
            return null;
        }

        if (!head.hasNext()) {
            return head;
        }

        PriorityQueueElement lastElement = head;

        while (lastElement.hasNext()) {
            if (lastElement.getNext().compareTo(newElement) <= 0) {
                lastElement = lastElement.getNext();
                continue;
            }

            break;
        }

        return lastElement;
    }

    private void insertElement(PriorityQueueElement pivot, PriorityQueueElement elementToInput) {
        if (pivot == null) {
            elementToInput.setNext(head);
            head = elementToInput;
            return;
        }

        if (!pivot.hasNext()) {
            pivot.setNext(elementToInput);
            return;
        }

        elementToInput.setNext(pivot.getNext());
        pivot.setNext(elementToInput);
    }

    //endregion
    //region Override methods
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Queue:\n");
        if (isEmpty()) {
            return "Queue is empty\n";
        }

        PriorityQueueElement currentElement = head;
        sb.append(currentElement.getContent().toString() + "\n");

        while (currentElement.hasNext()) {
            currentElement = currentElement.getNext();
            sb.append(currentElement.getContent().toString() + "\n");
        }

        return sb.toString();
    }
    //endregion
}
