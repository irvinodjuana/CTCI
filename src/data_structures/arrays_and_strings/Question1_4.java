package data_structures.arrays_and_strings;

public class Question1_4 {

    public static boolean permutationOfPalindrome(String str) {
        // Assumption: non-alphabetic characters like spaces, punctuation, can be ignored
        str = str.toUpperCase();
        int[] letterCount = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char nextChar = str.charAt(i);
            if (nextChar >= 'A' && nextChar <= 'Z') {
                // check if character is a letter
                letterCount[nextChar - 'A'] += 1;
            }
        }

        int countOdd = 0;
        for (int count: letterCount) {
            if (count % 2 != 0) countOdd++;
            if (countOdd > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(permutationOfPalindrome("Tact Coa"));            // true
        System.out.println(permutationOfPalindrome("racec ar !!!*&%"));     // true
        System.out.println(permutationOfPalindrome("hamburger"));           // false
    }
}
