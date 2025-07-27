package linearAndBinarySearch;

public class FirstNegativeSearch {
    public static void main(String[] args) {
        int[] numbers = {10, 5, 3, 0, -4, 7, -2};

        int index = findFirstNegative(numbers);

        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found.");
        }
    }

    // Linear search to find first negative number
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // Return index when first negative is found
            }
        }
        return -1; // No negative number found
    }
}
