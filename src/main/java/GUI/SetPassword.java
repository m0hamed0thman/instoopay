package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetPassword extends Father {
    private JPasswordField pf;
    private JPasswordField pf1;
    private JButton b2;
    private JButton b3;

    public SetPassword() {
        super();
        setTitle("Instoopay");
        setResizable(false);
        setLayout(null);

        // Set up icon
        ImageIcon icon = new ImageIcon("src/GUI.main/resources/icon2.jpeg");
        setIconImage(icon.getImage());

        // Set up image
        JLabel img = new JLabel();
        try {
            ImageIcon i2 = new ImageIcon("src/GUI.main/resources/WhatsApp Image 2025-04-17 at 8.51.06 PM.jpeg");
            Image image = i2.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            i2 = new ImageIcon(image);
            img = new JLabel(i2);
        } catch (Exception e) {
            img = new JLabel("Image not found");
            img.setForeground(Color.WHITE);
        }
        img.setBounds(60, 20, 250, 250);
        img.setHorizontalAlignment(SwingConstants.CENTER);
        add(img);

        // Set Password label and field
        JLabel l2 = new JLabel("Set Password");
        l2.setBounds(50, 300, 150, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        add(l2);

        pf = new JPasswordField();
        pf.setBounds(180, 300, 170, 30);
        add(pf);

        // Reset Password label and field
        JLabel l3 = new JLabel("Reset Password");
        l3.setBounds(50, 350, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        add(l3);

        pf1 = new JPasswordField();
        pf1.setBounds(180, 350, 170, 30);
        add(pf1);

        // OK button
        b2 = new JButton("OK");
        b2.setBounds(240, 500, 100, 30);
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b2.setForeground(new Color(0x123456));
        b2.setBackground(Color.LIGHT_GRAY);
        add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b2) {
                    String password = new String(pf.getPassword());
                    String resetPassword = new String(pf1.getPassword());

                    if (password.isEmpty() || resetPassword.isEmpty()) {
                        JOptionPane.showMessageDialog(SetPassword.this, "Please enter both passwords",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!password.equals(resetPassword)) {
                        JOptionPane.showMessageDialog(SetPassword.this, "Passwords do not match",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(SetPassword.this, "Password successfully set",
                                "Successful", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("NEXT");
                    }
                }
            }
        });

        // BACK button
        b3 = new JButton("BACK");
        b3.setBounds(60, 500, 100, 30);
        b3.setFont(new Font("Arial", Font.BOLD, 20));
        b3.setForeground(new Color(0x123456));
        b3.setBackground(Color.LIGHT_GRAY);
        add(b3);

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b3) {
                    System.out.println("BACK");
                }
            }
        });

        getContentPane().setBackground(new Color(0x123456));
        setVisible(true);
    }

    public static void main(String[] args) {
        new SetPassword();
    }
}
