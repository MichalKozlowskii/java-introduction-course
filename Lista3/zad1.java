import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, Integer> numberOfOccurences(String input) {
        Map<String, Integer> result = new HashMap<>();
        String[] words = input.split(" ");

        for (String word : words) {
            word = word.toLowerCase();
            word = word.replace(".", "");

            if (result.containsKey(word)) {
                result.replace(word, result.get(word) + 1);
            }
            else {
                result.put(word, 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "To jest przykładowe zdanie. To zdanie jest tylko przykładowe.";

        Map<String, Integer> occurences = numberOfOccurences(input);

        for (Map.Entry<String, Integer> occurence : occurences.entrySet()) {
            System.out.println("Word: " + occurence.getKey() + " occurs " + occurence.getValue() + " times.");
        }
    }
}