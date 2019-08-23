package data_structures.arrays_and_strings;

public class Question1_3 {
    // convert string (or char array) into a URL-friendly version, replacing spaces with "%20"
    public static char[] URLify(char[] arr, int trueLength) {
        char[] arrCopy = new char[arr.length];
        int j = 0;

        for (int i = 0; i < trueLength; i++) {
            if (arr[i] == ' ') {
                arrCopy[j] = '%';
                arrCopy[j + 1] = '2';
                arrCopy[j + 2] = '0';
                j += 3;
            } else {
                arrCopy[j] = arr[i];
                j++;
            }
        }
        return arrCopy;
    }

    public static void main(String[] args) {
        char[] test1 = "Mr John Smith    ".toCharArray();
        System.out.println(URLify(test1, 13));
    }
}
