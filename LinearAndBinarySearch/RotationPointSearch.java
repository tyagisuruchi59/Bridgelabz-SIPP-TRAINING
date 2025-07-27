package linearAndBinarySearch;

public class RotationPointSearch {
    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};

        int rotationIndex = findRotationPoint(arr);

        System.out.println("Rotation point (smallest element) is at index: " + rotationIndex);
        System.out.println("Smallest element: " + arr[rotationIndex]);
    }

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Binary search loop
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost, minimum is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // Minimum is in the left half (including mid)
                right = mid;
            }
        }

        // Left is the index of the smallest element
        return left;
    }
}
