package Downloader;

import java.io.IOException;

public class DownloadableDocumentSearcher {
    public static int search(String path, int DocID) throws IOException {
        int success=0;
        while(success == 0){
            DocID+=1;
            success=Downloader.download(path,DocID);
        }
        return DocID;
    }
}
