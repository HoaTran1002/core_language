package knowledge.collections_generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsGenericsDemo {
    public static void main(String[] args) {
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Node.js");
        languages.add("Python");

        Map<String, Integer> ranking = new HashMap<>();
        for (int i = 0; i < languages.size(); i++) {
            ranking.put(languages.get(i), i + 1);
        }

        printItems("Languages", languages);
        System.out.println("Ranking = " + ranking);
    }

    private static <T> void printItems(String label, List<T> items) {
        System.out.println(label + " -> " + items);
    }
}
