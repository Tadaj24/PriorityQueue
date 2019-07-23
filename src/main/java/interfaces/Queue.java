package interfaces;


import exceptions.NullPointerQueueElementException;

public interface Queue <T extends Comparable> {
    T pop();

    void push(T elem);

    T top();

    void clean();

    boolean isEmpty();

    boolean size();
}
