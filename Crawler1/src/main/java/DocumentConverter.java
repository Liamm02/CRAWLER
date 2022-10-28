import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DocumentConverter {

    public static void convertToJson(){
        ObjectMapper mapper = new ObjectMapper();
        try{
            //importing utf-8 text file
            File jsonFile = new File("\\Documents\\pg69250.txt");
            JsonBuilder builder = mapper.readValue(jsonFile,JsonBuilder.class);
            System.out.println(builder);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
