package interfaces;


import exceptions.NullPointerQueueElementException;

public interface Queue <T extends Comparable> {
    T pop();

    void push(T elem) throws NullPointerQueueElementException;

    void push(T elem, int priority) throws NullPointerQueueElementException;

    T top();

    void clean();

    boolean isEmpty();

    boolean size();
}
