package GUI;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;

public class EmailService {
    private final String fromEmail = "instoopay@gmail.com ";
    private final String appPassword= "reuvgftdfmmkjshw";


    public void sendVerificationCode(String toEmail, String code) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, appPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Your Verification Code");
            message.setText("Your verification code is: " + code);

            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Verification code sent to your email", "Successful", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("NEXT");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
