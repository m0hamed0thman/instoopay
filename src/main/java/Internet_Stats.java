import javax.swing.*;

public class Internet_Stats extends JFrame {
    public Internet_Stats() {
        ImageIcon icon = new ImageIcon("src/main/resources/no_internet.gif");
        JLabel label = new JLabel(icon);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        this.getContentPane().add(label);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500, 630);
        this.setLocationRelativeTo(null);
    }
}
