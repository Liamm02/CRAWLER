import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFiles {


    @Test
    public void testFiles() throws Exception {
        //folder to evaluate all text documents, extract their metadata and store it in a json file
        //specify folder
        File folder = new File("C:\\Documents");

        FileGenerator.generate(folder);
    }

}
