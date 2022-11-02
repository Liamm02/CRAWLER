package Crawler_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEditor {

    Properties properties;
    String path;
    public PropertiesEditor(String path){
        this.properties = new Properties();
        this.path = path;
    }
    public Properties EditProperties(String key, String value){

        try {
            FileInputStream in = new FileInputStream(path + "\\Prop.properties");
            this.properties.load(in);
            in.close();

            FileOutputStream out = new FileOutputStream(path + "\\Prop.properties");
            this.properties.setProperty(key, value);
            this.properties.store(out, null);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;

    }

    public String GetProperties(String key){

        try {
            FileInputStream in = new FileInputStream(path + "\\Prop.properties");
            this.properties.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.properties.getProperty(key);

    }

}
