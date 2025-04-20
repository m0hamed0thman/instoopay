import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;

public class InternetMonitor extends Thread{
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
    public void run() {
        Internet_Stats internetStats = new Internet_Stats();
        boolean frist = true;
        while(true){
            if(!netIsAvailable()){
                if(frist){
                    internetStats.setVisible(true);
                    frist = false;
                }
            }else {
                internetStats.setVisible(false);
                frist = true;
                break;
            }
            try {
                Thread.sleep(400);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

}
