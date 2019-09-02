package data_structures.stacks_and_queues;

import java.util.EmptyStackException;

public class Question3_2 {

   private static class MinStack {
       // Implemented for integers only
       private MyStack<Integer> stack;
       private MyStack<Integer> minimums;
       private Integer min;

       public MinStack() {
           stack = new MyStack<>();
           minimums = new MyStack<>();
       }

       public void push(int item) {
           stack.push(item);

           if (min == null) {
               min = item;
               minimums.push(item);
           } else if (item <= min) {
               min = item;
               minimums.push(item);
           }
       }

       public int pop() {
           int item = stack.pop();

           if (item == min) {
               minimums.pop();
               min = minimums.peek();
           }

           return item;
       }

       public int peek() {
           return stack.peek();
       }

       public int min() {
           if (min == null) throw new EmptyStackException();

           return min;
       }
   }


   public static void main(String[] args) {
       MinStack stack = new MinStack();
       stack.push(12);
       stack.push(18);
       stack.push(4);
       stack.push(3);
       stack.push(20);
       stack.push(3);

       System.out.println(stack.min()); // 3
       stack.pop();
       System.out.println(stack.min()); // 3
       stack.pop();
       stack.pop();
       System.out.println(stack.min()); // 4
       stack.pop();
       System.out.println(stack.min()); // 12

   }
}
