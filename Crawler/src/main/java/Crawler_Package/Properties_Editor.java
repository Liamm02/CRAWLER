package Crawler_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties_Editor {

    Properties prop;
    String path;
    public Properties_Editor(String path){
        this.prop = new Properties();
        this.path = path;
    }
    public Properties Edit_Properties(String key, String value){

        try {
            FileInputStream in = new FileInputStream(path + "\\Prop.properties");
            this.prop.load(in);
            in.close();

            FileOutputStream out = new FileOutputStream(path + "\\Prop.properties");
            this.prop.setProperty(key, value);
            this.prop.store(out, null);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;

    }

    public String Get_Propertie(String key){

        try {
            FileInputStream in = new FileInputStream(path + "\\Prop.properties");
            this.prop.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.prop.getProperty(key);

    }

}
