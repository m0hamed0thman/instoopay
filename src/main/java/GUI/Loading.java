package GUI;

import javax.swing.*;

public class Loading extends JFrame {
    public Loading() {
        ImageIcon icon = new ImageIcon("src/GUI.main/resources/Transfergif.gif");
        JLabel label = new JLabel(icon);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        this.getContentPane().add(label);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1200, 630);
        this.setLocationRelativeTo(null);
    }
}
