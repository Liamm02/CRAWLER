package org.example;

import org.json.JSONObject;

import java.io.File;

public class Document {

    String ID;
    String path;
    String MetaData_path;
    String Title = "Unknown";
    String Author = "Unknown";
    String Language = "English";
    JSONObject Variable_Metada = new JSONObject();


    public Document(String ID, String path){
        this.ID = ID;
        this.path = path+"/Documents";
    }
    public void ReadMetada(){
        this.MetaData_path = path+"Metadata/"+ID.substring(0,ID.length()-3)+"json";
        File file = new File(this.MetaData_path);
        if (file.exists()){
            File_Reader fr = new File_Reader();
            String content = fr.Read_File(file);
            System.out.println(content);

            JSONObject metadata = new JSONObject(content);

            this.Title = metadata.getString("Title");
            metadata.remove("Title");
            this.Author = metadata.getString("Author");
            metadata.remove("Author");
            this.Language = metadata.getString("Language");
            metadata.remove("Language");
            this.Variable_Metada = metadata;
            System.out.println(this.Language);

        }
    }
}
