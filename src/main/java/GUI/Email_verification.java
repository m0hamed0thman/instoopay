package GUI;

import javax.swing.*;
import java.awt.*;

public class Email_verification extends Father{
    private final JLabel email;
    private JTextField emailF;

    public Email_verification() {
        super();
        int frameWidth = getWidth();
        JLabel label = new JLabel("Email Verification");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setBounds(350, 20, 350, 70);
        label.setForeground(Color.WHITE);
        add(label);
        setVisible(true);
        email = new JLabel("Email:");
        email.setForeground(Color.WHITE);
        email.setBounds((frameWidth - 400) / 2, 160, 200, 40);
        email.setFont(new Font("Arial", Font.BOLD, 20));
        add(email);

        // Email Field
        emailF = new JTextField(20);
        emailF.setBounds((frameWidth - 300) / 2 + 100, 160, 300, 40);
        emailF.setFont(new Font("Arial", Font.BOLD, 20));
        add(emailF);

        JButton send = new JButton("Send Verification Code");
        send.setFont(new Font("Arial", Font.BOLD, 15));
        send.setBounds((frameWidth - 250) / 2, 250, 250, 45);
        add(send);
        send.addActionListener(e -> {
            String enteredEmail = emailF.getText();
            if(!validation.validateEmail(enteredEmail)) {

            } else {
                EmailService emailService = new EmailService();
                VerificationCodeGenerator generator = new VerificationCodeGenerator();
                String userEmail = emailF.getText();
                String code = generator.generateCode(6);
                emailService.sendVerificationCode(userEmail, code);
                boolean log = true;
                String userInput;
                while (log){
                    userInput = JOptionPane.showInputDialog(null, "Enter the verification code sent to your email:");
                    if (userInput.equals(code)) {
                        System.out.println("Verification successful!");
                        log = false;
                    } else {
                        System.out.println("Invalid code.");
                    }
                }


            }
        });
        setResizable(false);

    }
    public static void main(String[] args) {
        new Email_verification();
    }
}
