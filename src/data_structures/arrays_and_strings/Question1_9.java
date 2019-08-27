package data_structures.arrays_and_strings;

public class Question1_9 {
    public static String rotate(String str, int index) {
        return str.substring(index) + str.substring(0, index);
    }

    public static boolean isRotation(String strA, String strB) {
        char pivot = strB.charAt(0);

        for (int i = 0; i < strA.length(); i++) {
            if (strA.charAt(i) == pivot) {
                if (rotate(strA, i).equals(strB)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }

}
