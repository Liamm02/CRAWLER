package org.example;

import java.util.*;

public class DocLinesRelationCreator {

    public static HashMap<String, List<Integer>> DOCLINESRelationCreator(HashMap<String, Set<Integer>> Document_map, String key, String doc){
        HashMap<String, List<Integer>> DOC_LINES = new HashMap<>();
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(Document_map.get(key));
        Collections.sort(list2);
        DOC_LINES.put(doc, list2);
        return DOC_LINES;
    }
}
