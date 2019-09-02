package data_structures.stacks_and_queues;

import java.util.NoSuchElementException;
import java.util.LinkedList;

public class Question3_6 {
    private static class Pet {
        public int arrival;
        public String type;

        public Pet(int arrival, String type) {
            this.arrival = arrival;
            this.type = type;
        }
    }

    private static class Dog extends Pet {
        public Dog(int arrival) {
            super(arrival, "Dog");
        }
    }

    private static class  Cat extends Pet {
        public Cat(int arrival) {
            super(arrival, "Cat");
        }
    }

    private static class AnimalQueue<Pet> {
        private LinkedList<Pet> queueList;

        public AnimalQueue() {
            queueList = new LinkedList<>();
        }
        public void add(Pet p) {
            queueList.add(p);
        }

        public Pet remove() {
            return queueList.removeFirst();
        }

        public Pet peek() {
            return queueList.getFirst();
        }

    }

    private static class AnimalShelter {
        private AnimalQueue<Cat> catQueue;
        private AnimalQueue<Dog> dogQueue;

        public AnimalShelter() {
            catQueue = new AnimalQueue<>();
            dogQueue = new AnimalQueue<>();
        }

        public void enqueue(Pet p) {
            if (p instanceof Cat) {
                catQueue.add((Cat) p);
            } else if (p instanceof Dog) {
                dogQueue.add((Dog) p);
            }
        }

        public Pet dequeueAny() {
            if (catQueue.peek().arrival <= dogQueue.peek().arrival) return catQueue.remove();
            return dogQueue.remove();
        }

        public Cat dequeueCat() { return catQueue.remove(); }

        public Dog dequeueDog() { return dogQueue.remove(); }


    }

}
