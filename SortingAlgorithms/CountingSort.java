public class CountingSort {
    public static void sort(int[] ages) {
        int max = 18, min = 10;
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages) count[age - min]++;

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            output[--count[ages[i] - min]] = ages[i];
        }

        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }
}