package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public String Read_File(File file){
        try {
            String content = Files.readString(Path.of(file.toURI()));
            return content;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
