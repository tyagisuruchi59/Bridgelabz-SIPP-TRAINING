package linearAndBinarySearch;
import java.util.HashSet;

public class RemoveDuplicatesUsingStringBuilder {
    public static void main(String[] args) {
        String input = "programming";

        String result = removeDuplicates(input);

        System.out.println("Original String: " + input);
        System.out.println("String without duplicates: " + result);
    }

    public static String removeDuplicates(String str) {
        // To store characters that have already appeared
        HashSet<Character> seen = new HashSet<>();

        // To build the result string
        StringBuilder sb = new StringBuilder();

        // Traverse each character
        for (char ch : str.toCharArray()) {
            // If a character is not seen before, add to result and set
            if (!seen.contains(ch)) {
                seen.add(ch);
                sb.append(ch);
            }
        }

        // Return the final string
        return sb.toString();
    }
}
