package Crawler_Package;

public class Main {

    public static void main(String[] args) throws Exception {
        String path = ".\\src\\main\\resources";
        PropertiesEditor pe = new PropertiesEditor(path);
        int SearchIDStarter = Integer.valueOf(pe.GetProperties("LastDownloaded")) + 1;
        System.out.println("Starting search by: " + SearchIDStarter +"\n");
        System.out.println("-------------------------------------------------------------------------------------");
        TimeTaskGutenberg gt = new TimeTaskGutenberg(path);
        gt.start();





    }
}