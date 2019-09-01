package data_structures.stacks_and_queues;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {
        // Add an item to the back of the queue
        QueueNode<T> temp = new QueueNode<>(item);
        if (first == null) first = temp;
        if (last == null) {
            last = temp;
        } else {
            last.next = temp;
            last = last.next;
        }
    }

    public T remove() {
        // Remove the first item in the Queue and return that item
        if (first == null) throw new NoSuchElementException();
        T item = first.data;
        first = first.next;
        return item;
    }

    public T peek() {
        // Return first item in Queue without removing it
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

}
