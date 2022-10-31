package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PunctuationDeleter {

    public static List<String> PunctuationDelete(String doc, String path) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(path+"Documents/"+ doc)));


        String lines = text.replaceAll("\\p{Punct}|[,‘’×·”“—«»—ºªπ~:+\\[\\\\@^{%(-*|&<`}._=\\]!>;?¿¡#$)/]", " ").toLowerCase();
        String Fixedlines = lines.trim().replaceAll(" +", " ");
        String[] linesArray = Fixedlines.split("\\r?\\n");
        List<String> LinesList = new ArrayList<String>(Arrays.asList(linesArray));
        return LinesList;
    }

}
