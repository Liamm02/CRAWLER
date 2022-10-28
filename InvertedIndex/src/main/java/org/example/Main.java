package org.example;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "./";
        Checker checker = new Checker(path);
        ArrayList<String> documents = checker.documents_checker();
        checker.Indices_Folder_Checker();

        Document_Normalizer dn = new Document_Normalizer();
        List<String> text = dn.Translator(documents.get(5));
        System.out.println(text.get(4551));

        dn.Stopwords_Deleter(text);


        HashMap<String, Set<Integer>> map = new HashMap<String, Set<Integer>>();
        Set<Integer> t = new HashSet<Integer>();
        Set<Integer> t2 = new HashSet<Integer>();
        t.add(2);
        t.add(3);
//        map.put("hola",t);
//        System.out.println(map);
//        t2.addAll(t);
//        t.clear();
//        System.out.println(map);
//        map.put("hola",t2);
//        System.out.println(map);


    }
}