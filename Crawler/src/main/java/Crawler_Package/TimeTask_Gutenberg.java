package Crawler_Package;

import Downloader.Checker;
import Downloader.Searcher;
import MetaData_Extractor.FileGenerator;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTask_Gutenberg{

    long delay = 60 * 1000; // delay in milliseconds
    LoopTask task = new LoopTask();
    Timer timer = new Timer("Printing");
    String path;
    Searcher sc = new Searcher();

    public TimeTask_Gutenberg(String path){
        this.path = path;
    }

    public void start() {
        timer.cancel();
        timer = new Timer("Printing");
        Date executionDate = new Date(); // no params = now
        timer.scheduleAtFixedRate(task, executionDate, delay);
    }


    private class LoopTask extends TimerTask {
        public void run() {


//            System.out.println(book);
            try {
                Properties_Editor pe = new Properties_Editor(path);

                String ruta= Checker.FolderChecker(path);
                int next = sc.search(ruta,Integer.valueOf(pe.Get_Propertie("LastDownloaded")) + 1);

                pe.Edit_Properties("LastDownloaded",String.valueOf(next));
                System.out.println("downloaded document with ID " + pe.Get_Propertie("LastDownloaded"));
                System.out.println("-----------------------------------------");

                System.out.println("Extracting metadata for the following documents:");
                File folder = new File(path);
                FileGenerator.generate(folder);
                System.out.println("-------------------------------------------------------------------------------------");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
    }



}
