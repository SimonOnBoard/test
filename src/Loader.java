import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Loader implements Runnable {
    private String url;
    private String destinationFolder;

    public Loader(String url, String destinationFolder) {
        this.url = url;
        this.destinationFolder = destinationFolder;
    }

    @Override
    public void run() {
        try {
            URL website = new URL(this.url);
            ReadableByteChannel rbc;
            rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(this.getFileName());
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private String getFileName() {
        String[] splited = this.url.split("/");
        return this.destinationFolder + '/' +splited[splited.length - 1];
    }
}
