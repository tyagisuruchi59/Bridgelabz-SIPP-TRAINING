package linearAndBinarySearch;

public class WordSearchInSentences {
    public static void main(String[] args) {
        String[] sentences = {
                "Java is a programming language.",
                "It is widely used in web development.",
                "Android apps are mostly built using Java.",
                "Python is also popular."
        };

        String wordToSearch = "Android";

        String result = findSentenceWithWord(sentences, wordToSearch);

        System.out.println("Result: " + result);
    }

    // Linear search to find the first sentence containing the word
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            // Check case-insensitively
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found"; // If no sentence contains the word
    }
}
