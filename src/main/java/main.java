import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class main {
    private static boolean netIsAvailable() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
//        Loading loading = new Loading();
//        try {
//            loading.setVisible(true);
//            int time = 2000 ;
//            Thread.sleep(time);
//        }catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        loading.setVisible(false);
        DBConnection db = new DBConnection();
        db.getConnection();
//        InternetMonitor.startMonitoring(1);
    }
}
