package oy.tol.tra;

import java.util.Arrays;

public class QueueImplementation<E> implements QueueInterface<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;
    private int capacity;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public QueueImplementation(int capacity) {
        this.capacity = capacity > 0 ? capacity : DEFAULT_CAPACITY;
        this.array = (E[]) new Object[this.capacity];
        this.size = 0;
        this.head = 0;
        this.tail = -1; // Initially, there's no element in the queue
    }

    public QueueImplementation() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(E element) {
        if (element == null) {
            throw new NullPointerException("Cannot add null element to the queue.");
        }
        if (size == capacity) {
            reallocate();
        }
        tail = (tail + 1) % capacity; // Move tail circularly
        array[tail] = element;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty, cannot dequeue.");
        }
        E element = array[head];
        array[head] = null; // Clear the dequeued element
        head = (head + 1) % capacity; // Move head circularly
        size--;
        return element;
    }

    @Override
    public E element() {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty, cannot retrieve element.");
        }
        return array[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
        head = 0; // Reset head
        tail = -1; // Reset tail
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @SuppressWarnings("unchecked")
    private void reallocate() {
        capacity *= 2;
        E[] newArray = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(head + i) % size]; // Copy elements starting from head
        }
        array = newArray;
        head = 0; // Reset head after reallocation
        tail = size - 1; // Reset tail after reallocation
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[(head + i) % capacity]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
