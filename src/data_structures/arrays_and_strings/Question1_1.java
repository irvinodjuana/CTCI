package data_structures.arrays_and_strings;
import java.util.HashSet;
import java.util.Set;

public class Question1_1 {

    public static boolean isUnique(String str) {
        // Question 1.1, check if a string has all unique characters
        Set<Character> charSet = new HashSet<Character>();
        char letter;

        for (int i = 0; i < str.length(); i++) {
            letter = str.charAt(i);
            if (charSet.contains(letter)) {
                return false;
            } else {
                charSet.add(letter);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Question 1.1 Check
        System.out.println(isUnique("hello"));
        System.out.println(isUnique("abcdef !?."));
    }
}

