package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        checkMagazine("give me one grand today night".split(" "), "give one grand today".split(" "));
    }

    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        // put note into a hash map
        Arrays.stream(note).forEach(word -> wordsMap.compute(word, (k, v) -> v == null ? 1 : v + 1));

        Arrays.stream(magazine).forEach(word -> {
            Integer val = wordsMap.get(word);
            if (val != null) {
                wordsMap.put(word, --val);
            }
        });

        boolean allWordsFound = wordsMap.values().stream().anyMatch(val -> val > 0);
        String result = allWordsFound ? "No" : "Yes";
        System.out.println(result);
    }

}
