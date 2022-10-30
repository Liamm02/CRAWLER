package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String ruta=Folder.creater();
        int book=Searcher.search(ruta,13);
    }
}