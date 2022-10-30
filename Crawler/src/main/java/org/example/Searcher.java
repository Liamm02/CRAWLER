package org.example;

import java.io.IOException;

public class Searcher {
    public static int search(String ruta, int book) throws IOException {
        int logrado=0;
        while(logrado == 0){
            book+=1;
            logrado=Downloader.download(ruta,book);
        }
        book+=1;
        return book;
    }
}
