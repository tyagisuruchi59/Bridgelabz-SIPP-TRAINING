package linearAndBinarySearch;

public class ReverseString {
    public static String reverseUsingStringBuilder(String input) {
        // Create a StringBuilder object and append the input string
        StringBuilder sb = new StringBuilder(input);

        // Use the reverse() method to reverse the characters
        sb.reverse();

        // Convert the StringBuilder back to a string and return
        return sb.toString();
    }

    public static void main(String[] args) {
        String original = "hello";
        String reversed = reverseUsingStringBuilder(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
