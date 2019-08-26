package data_structures.arrays_and_strings;

public class Question1_6 {
    public static String compression(String str) {
        // requires: alphabetic string only
        char current = str.charAt(0);
        int count = 0;
        StringBuilder compressed = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == current) {
                count++;
            } else {
                compressed.append(current);
                compressed.append(count);
                current = str.charAt(i);
                count = 1;
            }
        }

        compressed.append(current);
        compressed.append(count);

        if (compressed.length() < str.length()) {
            return compressed.toString();
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println(compression("aabcccccaaa"));
        System.out.println(compression("aaa"));
        System.out.println(compression("abcdefg"));
    }
}
