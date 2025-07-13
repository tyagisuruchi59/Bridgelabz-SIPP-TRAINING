public class BubbleSort {
    public static void sort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (marks[i - 1] > marks[i]) {
                    int temp = marks[i];
                    marks[i] = marks[i - 1];
                    marks[i - 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
