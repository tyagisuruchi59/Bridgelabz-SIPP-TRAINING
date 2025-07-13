package Stack;
import java.util.HashMap;

public class TwoSumIndices {
    public static int[] findIndices(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) return new int[]{map.get(comp), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // not found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = findIndices(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}

