import java.util.*;

public class Main {
    public static List<List<String>> srt(List<String> lst) {
        Collections.sort(lst);

        Map<Character, List<String>> wordsMap = new HashMap<>();
        List<String> currList = new ArrayList<>();

        for (String word : lst) {
            char firstLetter = word.charAt(0);

            if (!wordsMap.containsKey(firstLetter)) {
                currList = new ArrayList<>();
                wordsMap.put(firstLetter, currList);
            }

            if (word.length() % 2 == 0) {
                currList.add(word);
                wordsMap.put(firstLetter, currList);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Character, List<String>> entry : wordsMap.entrySet()) {
            List<String> innerResultList = List.of(String.valueOf(entry.getKey()), entry.getValue().toString());
            result.add(innerResultList);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> wordsList = Arrays.asList(
                "cherry",
                "blueberry",
                "citrus",
                "apple",
                "apricot",
                "banana",
                "coconut"
        );

        System.out.println(srt(wordsList));
    }
}
