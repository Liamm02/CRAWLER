package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StopwordsDeleter {

    public static HashMap<String, Set<Integer>> StopwordsDelete(List<String> LinesList, String Language, String path) throws IOException {

        String StopwordsText = new String(Files.readAllBytes(Paths.get(
                path+"Stopwords/"+Language+"_stopwords.txt")));
        String[] stopwords = StopwordsText.split(",");
        Set<String> StopwordsSet = new HashSet<String>(Arrays.asList(stopwords));
        HashMap<String, Set<Integer>> map = new HashMap<String, Set<Integer>>();
        int line = 1;
        for (String cadena: LinesList) {
            if(!cadena.isBlank() | !cadena.isEmpty()) {

                Set<Integer> temp = new HashSet<Integer>();
                String[] words = cadena.split(" ");
                List<String> wordsList = new ArrayList<String>(Arrays.asList(words));

                for (String word : wordsList) {
                    if (word != "" && !word.isBlank()) {
                        if (StopwordsSet.contains(word)) {
                        } else {
                            if (!map.containsKey(word)) {
                                temp.add(line);
                                Set<Integer> temp2 = new HashSet<Integer>();
                                temp2.addAll(temp);
                                map.put(word, temp2);
                                temp.clear();
                            }
                            else if (map.containsKey(word)) {
                                Set<Integer> temp3 = map.get(word);
                                temp3.add(line);
                                map.replace(word, temp3);
                            }
                        }
                    }

                }
            }
            line += 1;
        }
        return map;
    }
}
