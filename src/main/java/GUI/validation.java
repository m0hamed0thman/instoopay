package GUI;

import javax.swing.*;
import java.io.IOException;
import java.net.*;

public class validation
{
    public static boolean validateEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        if(!email.matches(emailRegex))
            JOptionPane.showMessageDialog(null, "Invalid Email Address", "Error", JOptionPane.ERROR_MESSAGE);
        return email.matches(emailRegex);
    }

    public static boolean netIsAvailable(){
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream();
            return true;
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            return false;
        }
    }
    
    public static boolean netIsAvailable_byInet(){
        try {
            InetAddress inetAddress = InetAddress.getByName("www.google.com");
            return !inetAddress.equals("");
        }catch (Exception e){
            return false;
        }
    }

    public static boolean netIsAvailable_byhttp(){
        try {
            final URL url = new URL("http://www.google.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(300);
            conn.connect();
            return conn.getResponseCode() == 200;
        }catch (Exception e){
            return false;
        }
    }
}
