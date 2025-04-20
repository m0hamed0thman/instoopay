import javax.swing.*;

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

}
