package linearAndBinarySearch;

import java.util.Arrays;

public class LinearAndBinaryChallenge {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        int missing = findFirstMissingPositive(nums.clone());
        int index = binarySearchTarget(nums.clone(), target);

        System.out.println("First missing positive integer: " + missing);
        System.out.println("Index of target (" + target + "): " + index);
    }

    // Linear Search for first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Mark numbers in correct index positions
        for (int i = 0; i < n; i++) {
            while (
                    nums[i] > 0 && nums[i] <= n &&
                            nums[nums[i] - 1] != nums[i]
            ) {
                // Swap nums[i] to its correct position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Find the first index i were nums[i] != i+1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return n + 1;
    }

    // Binary Search for target index (after sorting)
    public static int binarySearchTarget(int[] nums, int target) {
        Arrays.sort(nums); // Must sort before binary search
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1; // Not found
    }
}
