import javax.swing.*;
import java.awt.*;

public class Father extends JFrame {
    public Father() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenWidth / 3 + screenWidth / 6, screenHeight - 50);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(0x123456));
        setLayout(null); // ضروري لتفعيل setBounds
    }
}