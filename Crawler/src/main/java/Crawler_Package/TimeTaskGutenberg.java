package Crawler_Package;

import Downloader.FoldersChecker;
import Downloader.DownloadableDocumentSearcher;
import MetaData_Extractor.FileGenerator;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTaskGutenberg {

    long delay = 60 * 1000;
    LoopTask task = new LoopTask();
    Timer timer = new Timer("Printing");
    String path;
    DownloadableDocumentSearcher sc = new DownloadableDocumentSearcher();

    public TimeTaskGutenberg(String path){
        this.path = path;
    }

    public void start() {
        timer.cancel();
        timer = new Timer("Printing");
        Date executionDate = new Date();
        timer.scheduleAtFixedRate(task, executionDate, delay);
    }


    private class LoopTask extends TimerTask {
        public void run() {
            try {
                PropertiesEditor pe = new PropertiesEditor(path);

                String ruta= FoldersChecker.FoldersChecker(path);
                int next = sc.search(ruta,Integer.valueOf(pe.GetProperties("LastDownloaded")) + 1);

                pe.EditProperties("LastDownloaded",String.valueOf(next));
                System.out.println("downloaded document with ID " + pe.GetProperties("LastDownloaded"));
                System.out.println("-----------------------------------------");

                System.out.println("Extracting metadata for the following documents:");
                File folder = new File(path);
                FileGenerator.generateJsonFile(folder);
                System.out.println("-------------------------------------------------------------------------------------");
                PredocumentDeleter.deletePredocument(path);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
    }



}
