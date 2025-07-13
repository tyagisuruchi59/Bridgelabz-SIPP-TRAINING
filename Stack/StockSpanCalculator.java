package Stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanCalculator {
    public static void calculateSpan(int[] prices, int[] span) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;

        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = new int[prices.length];
        calculateSpan(prices, span);
        System.out.println(Arrays.toString(span));
    }
}
