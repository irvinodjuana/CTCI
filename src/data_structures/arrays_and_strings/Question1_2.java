package data_structures.arrays_and_strings;
import java.util.HashMap;

public class Question1_2 {
    // Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.

    public static boolean checkPermutation(String strA, String strB) {
        // strings must be the same length
        if (strA.length() != strB.length()) return false;

        HashMap<Character, Integer> charMap = new HashMap<>();
        // Loop through first string and add counts of characters to a HashMap
        for (int i = 0; i < strA.length(); i++) {
            char letter = strA.charAt(i);
            if (charMap.containsKey(letter)) {
                int oldScore = charMap.get(letter);
                charMap.put(letter, oldScore + 1);
            } else {
                charMap.put(letter, 1);
            }
        }

        // Loop through second string and subtract counts of characters from same HashMap
        for (int i = 0; i < strB.length(); i++) {
            char letter = strB.charAt(i);
            if (charMap.containsKey(letter)) {
                int oldScore = charMap.get(letter);
                if (oldScore - 1 < 0) {
                    // second string has an one more count of a char than the first
                    return false;
                } else {
                    charMap.put(letter, oldScore - 1);
                }
            } else {
                // second string contains some character not in first string; not a permutation
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        // Test examples
        System.out.println(checkPermutation("abbaccd", "accdbab")); //true
        System.out.println(checkPermutation(" ", " ")); // true
        System.out.println(checkPermutation("abcdef", "abcdefg")); //false
        System.out.println(checkPermutation("helloworld", "hello")); //false
    }
}
