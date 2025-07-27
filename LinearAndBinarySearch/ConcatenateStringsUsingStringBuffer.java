package linearAndBinarySearch;

public class ConcatenateStringsUsingStringBuffer {
    public static void main(String[] args) {
        // Sample input array of strings
        String[] words = {"Hello", " ", "world", "!", " Welcome", " to", " Java."};

        // Call the method to concatenate using StringBuffer
        String result = concatenateStrings(words);

        // Print the result
        System.out.println("Concatenated String: " + result);
    }

    public static String concatenateStrings(String[] arr) {
        // Create a new StringBuffer object
        StringBuffer sb = new StringBuffer();

        // Append each string in the array
        for (String str : arr) {
            sb.append(str);
        }

        // Convert to string and return
        return sb.toString();
    }
}
