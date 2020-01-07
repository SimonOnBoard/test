import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class Args {
    @Parameter(names  = {"--mode","--m"}, description = "mode of downloading")
    private String mode;
    @Parameter(names  = {"--count","--c"}, description = "amount of threads")
    private int count = 1;
    @Parameter(names  = {"--files","--fi"}, description = "urls of files")
    private String urls;
    @Parameter(names  = {"--folder","--fo"}, description = "destination folder")
    private String folder;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public String[] getUrls() {
        return urls.split(";");
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public void checkIfCountersError() {
        if(this.getCount() > 1 && !this.getMode().equals("multi-thread")){
            throw new IllegalArgumentException("Parametrs mismatch");
        }
    }
}
