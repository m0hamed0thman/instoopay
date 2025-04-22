package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import DAO.User_DAO;

public class Login extends Father {
    private JLabel img;
    private JLabel email;
    private JTextField emailF;
    private JLabel password;
    private JPasswordField passwordF;
    private JButton signInButton;
    private JButton signUpButton;
    private ImageIcon originalIcon;

    public Login() {
        super();
        setTitle("GUI.Login Page");
        setcomponent();
        setupListeners();
    }
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
    private void setupListeners() {
        signInButton.addActionListener(e -> {
            String enteredEmail = emailF.getText();
            String enteredPassword = new String(passwordF.getPassword());
            if(!netIsAvailable()) {
                InternetMonitor internetMonitor = new InternetMonitor();
                internetMonitor.start();
            }else {
                if(validation.validateEmail(enteredEmail) && !enteredPassword.isEmpty()) {
                    // Login logic using User_DAO to check credentials
                    User_DAO userDao = new User_DAO();
                    boolean isValidUser = userDao.checkUser(enteredEmail, enteredPassword);

                    if(isValidUser) {
                        JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        // TODO: Navigate to the main application screen after successful login
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid email or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    }
                } else if(enteredPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Enter Your Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        signUpButton.addActionListener(e -> {
            if(!netIsAvailable()){
                InternetMonitor internetMonitor = new InternetMonitor();
                internetMonitor.start();
            }else {
                UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
                userRegistrationForm.setVisible(true);
                dispose();
            }
        });
    }


    public void setcomponent() {
        int frameWidth = getWidth();

        // Image
        originalIcon = new ImageIcon("src/GUI.main/resources/icon2.jpeg");
        Image resizedImage = originalIcon.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
        originalIcon = new ImageIcon(resizedImage);
        img = new JLabel();
        img.setIcon(originalIcon);
        img.setBounds((frameWidth - 350) / 3, 40, 600, 300);
        add(img);

        // Email Label
        email = new JLabel("Email:");
        email.setForeground(Color.WHITE);
        email.setBounds((frameWidth - 400) / 2, 460, 200, 40);
        email.setFont(new Font("Arial", Font.BOLD, 20));
        add(email);

        // Email Field
        emailF = new JTextField(20);
        emailF.setBounds((frameWidth - 300) / 2 + 100, 460, 300, 40);
        emailF.setFont(new Font("Arial", Font.BOLD, 20));
        add(emailF);

        password = new JLabel("Password:");
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Arial", Font.BOLD, 20));
        password.setBounds((frameWidth - 400) / 2, 530, 200, 40);
        add(password);

        // Password Field
        passwordF = new JPasswordField(20);
        passwordF.setFont(new Font("Arial", Font.BOLD, 20));
        passwordF.setBounds((frameWidth - 300) / 2 + 100, 530, 300, 40);
        add(passwordF);

        // Sign In Button
        signInButton = new JButton("Sign In");
        signInButton.setFont(new Font("Arial", Font.BOLD, 20));
        signInButton.setBounds((frameWidth - 250) / 2, 700, 120, 45);
        add(signInButton);

        // Sign Up Button
        signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Arial", Font.BOLD, 20));
        signUpButton.setBounds((frameWidth - 250) / 2 + 140, 700, 120, 45);
        add(signUpButton);
    }
}
