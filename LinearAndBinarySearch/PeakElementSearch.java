package linearAndBinarySearch;

public class PeakElementSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeakElement(arr);

        System.out.println("Peak element found at index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }

    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean isLeftSmaller = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean isRightSmaller = (mid == arr.length - 1 || arr[mid] > arr[mid + 1]);

            // If both neighbors are smaller or out of bounds => peak
            if (isLeftSmaller && isRightSmaller) {
                return mid;
            }

            // Move to the side with the larger neighbor
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1; // Search left
            } else {
                left = mid + 1; // Search right
            }
        }

        return -1; // Should not reach here for a valid array
    }
}
