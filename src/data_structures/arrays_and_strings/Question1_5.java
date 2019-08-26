package data_structures.arrays_and_strings;

public class Question1_5 {
    public static boolean oneEditAway(String strA, String strB) {
        String str1, str2;
        if (strA.length() >= strB.length() ) {
            str1 = strA;
            str2 = strB;
        } else {
            str1 = strB;
            str2 = strA;
        }

        int lengthDiff = str1.length() - str2.length(); // length diff should always be >= 0

        if (lengthDiff > 1) {
            return false;
        } else if (lengthDiff == 0) {
            return checkReplace(str1, str2);
        } else {   // lengthDiff == 1
            return checkRemove(str1, str2);
        }
    }

    public static boolean checkReplace(String str1, String str2) {
        // requires: str1.length() == str2.length()
        boolean editFound = false;

        for (int i = 0; i < str1.length(); i++) {
            if ((str1.charAt(i) != str2.charAt(i)) && editFound) {
                return false;
            } else if (str1.charAt(i) != str2.charAt(i)) {
                editFound = true;
            }
        }

        return true;
    }

    public static boolean checkRemove(String str1, String str2) {
        // requires: str1.length() == str2.length() + 1
        boolean editFound = false;
        int j = 0;

        for (int i = 0; i < str1.length() && j < str2.length(); i++) {
            if (str1.charAt(i) != str2.charAt(j) && editFound) {
                return false;
            } else if (str1.charAt(i) != str2.charAt(j)) {
                editFound = true;
            } else {
                j++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pales", "pale"));
        System.out.println(oneEditAway("pale", "bale"));
        System.out.println(oneEditAway("pale", "bake"));
    }

}
