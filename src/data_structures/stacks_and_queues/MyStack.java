package data_structures.stacks_and_queues;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        private StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public void push(T item) {
        // Push a new element to the top of the stack
        StackNode<T> temp = new StackNode<>(item);
        temp.next = top;
        top = temp;
    }

    public T pop() {
        // Pop off the top of the stack and return top element
        if (top == null) throw new EmptyStackException();

        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        // Return top element without removing from stack
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        // Check if stack is empty
        return (top == null);
    }


}
