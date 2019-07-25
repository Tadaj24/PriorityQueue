package interfaces;

public interface Queue<T extends Comparable> {
    T pop();

    void push(T elem);

    T top();

    void clear();

    boolean isEmpty();

    int size();
}
