package data_structures.stacks_and_queues;

import java.util.Stack;

public class Question3_5 {
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        int size = 0;

        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
            size += 1;
        }
        shiftStacks(tempStack, stack);

        for (int i = 0; i < size - 1; i++) {
            int max = stack.pop();

            for (int j = i + 1; j < size; j++) {
                int temp = stack.pop();
                if (temp > max) {
                    tempStack.push(max);
                    max = temp;
                } else {
                    tempStack.push(temp);
                }
            }

            stack.push(max);
            shiftStacks(tempStack, stack);
        }
    }

    public static void shiftStacks(Stack<Integer> from, Stack<Integer> to) {
        while(!from.isEmpty()) {
            to.push(from.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(0);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);
    }
}
