import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class prueba {
    public static Map<String, Integer> sortByValue(final Map<String, Integer> wordCounts) {
        return wordCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
    public static void main(String[] args) {
        final Map<String, Integer> wordCounts = new HashMap<>();
        wordCounts.put("USA", 100);
        wordCounts.put("jobs", 200);
        wordCounts.put("software", 50);
        wordCounts.put("technology", 70);
        wordCounts.put("opportunity", 200);
        final Map<String, Integer> sortedByCount = sortByValue(wordCounts);
        System.out.println(sortedByCount);
        Set<String> s= sortedByCount.keySet();
        Object[]ss=s.toArray();
        System.out.println( ss[0]);
        System.out.println(sortedByCount.keySet());
    }
}