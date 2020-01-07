import com.beust.jcommander.JCommander;

import java.util.Scanner;

public class Main {
    public static ThreadPool threadPool;
    public static void main(String[] args) {
        Args args1 = new Args();
        JCommander jCommander = new JCommander(args1);
        Scanner sc = new Scanner(System.in);
        jCommander.parse(args);
        args1.checkIfCountersError();
        initThreadPool(args1.getCount());
        System.out.println(args1.getCount());
        System.out.println(args1.getMode());
        System.out.println(args1.getFolder());
        getDownloadByThreadPool(args1.getUrls(),args1.getFolder());
    }

    private static void initThreadPool(int count) {
        threadPool = new ThreadPool(count);
    }

    private static void getDownloadByThreadPool(String[] urls, String folder) {
        for( String url : urls){
            threadPool.submit(new Loader(url,folder));
        }
    }
}
