package data_structures.stacks_and_queues;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Question3_3 {

    private static class SetOfStacks<T> {
        private ArrayList<MyStack<T>> stackSet;
        private int capacity;  // must be greater than 0
        private int lastDepth;

        public SetOfStacks(int capacity) {
            stackSet = new ArrayList<>();
            this.capacity = capacity;
        }

        public void push(T item) {
            if (stackSet.isEmpty() || lastDepth >= capacity) {
                stackSet.add(new MyStack<T>());
                lastDepth = 0;
            }

            this.lastStack().push(item);
            lastDepth++;
        }

        public T pop() {
            if (stackSet.isEmpty()) throw new EmptyStackException();
            T item = this.lastStack().pop();
            lastDepth--;
            if (this.lastStack().isEmpty()) {
                stackSet.remove(stackSet.size() - 1);
                lastDepth = capacity;
            }
            return item;
        }

        public T peek() {
            if (stackSet.isEmpty()) throw new EmptyStackException();
            return this.lastStack().peek();
        }


        private MyStack<T> lastStack() {
            if (stackSet.isEmpty()) return null;
            return stackSet.get(stackSet.size() - 1);
        }

    }


    public static void main(String[] args) {
        SetOfStacks<Integer> stack = new SetOfStacks<>(2);

        for (int i = 0; i < 34; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 35; i++) {
            System.out.println("Popped: " + stack.pop());
        }

    }
}
