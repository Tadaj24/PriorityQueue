import exceptions.EmptyQueueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

class PriorityQueueTest {
    private final String SAMPLE_STRING = "Sample string";

    PriorityQueue<String> priorityQueue;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    @DisplayName("Constructor test")
    void shouldConstructorInitializeQueueWithCorrectNumberOfElements(int numberOfElements) {
        String[] sampleStrings = getSimpleStringWords(numberOfElements);
        switch (numberOfElements){
            case 0:
                priorityQueue = new PriorityQueue<>();
                break;
            case 1:
                priorityQueue = new PriorityQueue<>(sampleStrings[0]);
                break;
            case 2:
                priorityQueue = new PriorityQueue<>(sampleStrings[0], sampleStrings[1]);
                break;
            case 3:
                priorityQueue = new PriorityQueue<>(sampleStrings[0], sampleStrings[1], sampleStrings[2]);
                break;
            default:
                priorityQueue = new PriorityQueue<>(sampleStrings[0], sampleStrings[1], sampleStrings[2], Arrays.copyOfRange(sampleStrings, 3, sampleStrings.length));
        }

        Assertions.assertEquals(numberOfElements, priorityQueue.size());
    }

    @Test
    @DisplayName("IsEmpty() method positive test")
    void shouldIsEmptyMethodReturnTrueForEmptyQueue(){
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        Assertions.assertEquals(true, priorityQueue.isEmpty());
    }

    @Test
    @DisplayName("IsEmpty() method negative test")
    void shouldIsEmptyMethodReturnFalseForQueueWithElements(){
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(SAMPLE_STRING);
        Assertions.assertEquals(false, priorityQueue.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("Size() method positive test")
    void shouldSizeMethodReturnCorrectNumberOfElements(int numberOfElements){
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        for (String s : getSimpleStringWords(numberOfElements)) {
            priorityQueue.push(s);
        }

        Assertions.assertEquals(numberOfElements, priorityQueue.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    @DisplayName("Push() method test validating adding do elements do queue")
    void shouldPushCorrectNumberOfElementsToQueue(int numberOfElements) {
        String[] sampleStrings = getSimpleStringWords(numberOfElements);
        priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < numberOfElements; i++) {
            priorityQueue.push(sampleStrings[i]);
        }

        Assertions.assertEquals(numberOfElements, priorityQueue.size());
    }

    @Test
    @DisplayName("Pop() method test validating if elements are correctly pop from queue")
    void shouldPopMethodReturnValueFromQueue(){
        priorityQueue = new PriorityQueue<>(SAMPLE_STRING);
        Assertions.assertEquals(SAMPLE_STRING, priorityQueue.pop());
    }

    @Test
    @DisplayName("Pop() method test validating if elements are correctly pop from queue with two elements")
    void shouldPopMethodReturnValueFromQueueWithTwoElements(){
        String[] sampleStrings = getSimpleStringWords(2);
        priorityQueue = new PriorityQueue<>(sampleStrings[0], sampleStrings[1]);
        Assertions.assertEquals(sampleStrings[0], priorityQueue.pop());
    }

    @Test
    @DisplayName("Top() method test validating if elements are correctly pop from queue with two elements")
    void shouldTopMethodReturnCorrectValueFromQueueWithThreeElements(){
        String[] sampleStrings = getSimpleStringWords(3);
        priorityQueue = new PriorityQueue<>(sampleStrings[2], sampleStrings[0], sampleStrings[1]);
        Assertions.assertEquals(sampleStrings[2], priorityQueue.top());
    }

    @Test()
    @DisplayName("Top() method test validating if method throw exception while queue is empty")
    void shouldTopMethodReturnEmptyQueueExceptionWhenQueueIsEmpty(){
        priorityQueue = new PriorityQueue<>(SAMPLE_STRING);
        priorityQueue.top();
        Assertions.assertThrows(EmptyQueueException.class, () -> priorityQueue.top());
    }

    @Test
    @DisplayName("Push() method test validating if elements are put to proper place")
    void shouldPushMethodMethodPutElementsInCorrectPlace(){
        String[] sampleStrings = getSimpleStringWords(3);
        priorityQueue = new PriorityQueue<>();
        priorityQueue.push(sampleStrings[1]);
        priorityQueue.push(sampleStrings[0]);
        priorityQueue.push(sampleStrings[2]);

        Assertions.assertEquals(sampleStrings[0], priorityQueue.pop());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4})
    @DisplayName("Clear() method test")
    void shouldClearRemoveAllElements(int numberOfElements) {
        String[] sampleStrings = getSimpleStringWords(numberOfElements);
        priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < numberOfElements; i++) {
            priorityQueue.push(sampleStrings[i]);
        }

        priorityQueue.clear();
        Assertions.assertEquals(0, priorityQueue.size());
    }

    private String[] getSimpleStringWords(int number){
        String[] table = new String[number];
        for (int i = 0; i < table.length; i++) {
            table[i] = String.format("%s %s", SAMPLE_STRING, i + 1);
        }
        return table;
    }
}