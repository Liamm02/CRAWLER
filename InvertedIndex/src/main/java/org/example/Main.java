package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = "./src/main/resources/";
        Checker checker = new Checker(path);
        ArrayList<String> documents = checker.documents_checker();
        checker.MetaData_checker();
        checker.Inv_Index_checker();

        for (String name: documents){
            System.out.println("Indexing document: "+name);
            Document doc = new Document(name,path);
            doc.ReadMetada();

            List<String> text = PunctuationDeleter.PunctuationDelete(name,path);
            HashMap<String, Set<Integer>> Doc_InvertedIndex = StopwordsDeleter.StopwordsDelete(text,doc.Language,path);

            DocumentIndexer.DocumentIndex(Doc_InvertedIndex,name,path);

        }
    }
}