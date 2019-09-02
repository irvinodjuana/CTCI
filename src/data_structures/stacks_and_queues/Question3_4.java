package data_structures.stacks_and_queues;

import java.util.NoSuchElementException;

public class Question3_4 {
    private static class MyQueue<T> {
        // Two stacks: one for adding and one for removing
        private MyStack<T> addStack;
        private MyStack<T> removeStack;
        int numRemoved;

        public MyQueue() {
            addStack = new MyStack<>();
            removeStack = new MyStack<>();
            numRemoved = 0;
        }

        public void add(T item) {
            addStack.push(item);
        }

        public T remove() {
            T item;
            if (removeStack.isEmpty()) {
                refreshStacks();
            } else {
                numRemoved++;
            }
            return removeStack.pop();
        }

        public T peek() {
            if (removeStack.isEmpty()) {
                refreshStacks();
            }
            return removeStack.peek();
        }


        private void refreshStacks() {
            // flip over addStack and copy to removeStack, pop, then copy/flip back to addStack
            // performed anytime removeStack is empty
            // throws: NoSuchElementException when removing or peeking when Queue is empty
            MyStack<T> tempStack = new MyStack<T>();

            while (!addStack.isEmpty()) {
                T temp = addStack.pop();
                removeStack.push(temp);
                tempStack.push(temp);
            }
            for (int i = 0; i < numRemoved; i++) {
                removeStack.pop();
                tempStack.pop();
            }

            if (removeStack.isEmpty()) throw new NoSuchElementException(); // removing from empty queue
            tempStack.pop();
            numRemoved = 0;

            while(!tempStack.isEmpty()) {
                addStack.push(tempStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        for (int i = 1; i < 4; i++) {
            queue.add(i);
        }
        for (int i = 1; i < 4; i++) {
            System.out.println("removed: " + queue.remove());
        }
        for (int i = 4; i < 9; i++) {
            queue.add(i);
        }
        for (int i = 4; i < 5; i++) {
            System.out.println("removed: " + queue.remove());
        }
        for (int i = 5; i < 10; i++) {
            System.out.println("removed: " + queue.remove()); // expect up to 8, then exception
        }


    }
}
