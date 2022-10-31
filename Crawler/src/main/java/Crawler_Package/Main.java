package Crawler_Package;

import Downloader.Checker;
import Downloader.Searcher;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        String path = ".\\src\\main\\resources";
        Properties_Editor pe = new Properties_Editor(path);
        int n = Integer.valueOf(pe.Get_Propertie("LastDownloaded")) + 1;
        System.out.println("Starting search by: " + n +"\n");
        System.out.println("-------------------------------------------------------------------------------------");
        TimeTask_Gutenberg gt = new TimeTask_Gutenberg(path);
        gt.start();



    }
}