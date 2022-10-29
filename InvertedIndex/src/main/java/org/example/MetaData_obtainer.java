package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class MetaData_obtainer {

    String path;
    List<String> Metadata_Fields;
    public MetaData_obtainer(String path){
        this.path = path;
        this.Metadata_Fields = Arrays.asList("Title","Author","Translator","ReleaseDate","Language","Producers","character encoding");
    }

    public void Obtain_Metadata(String docID) throws IOException {
        BufferedReader br = null;
        String strLine = "";
        System.out.println(this.Metadata_Fields);
        LineNumberReader reader = new LineNumberReader(new InputStreamReader(
                new FileInputStream(this.path+"Documents/"+docID), "UTF-8"));
        while (((strLine = reader.readLine()) != null) && reader.getLineNumber() <= 30) {

            for (int e =0;e<this.Metadata_Fields.size();e++){

            }

            }
        reader.close();


    }
}
