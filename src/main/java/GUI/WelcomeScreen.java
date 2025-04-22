package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class WelcomeScreen extends Father {
    private JLabel welcomeLabel;
    private JButton nextButton;
    private ImageIcon originalIcon;

    public WelcomeScreen() {
        setupFrame();
        setupComponents();
        setupListeners();

        // Add components to frame
        this.add(welcomeLabel);
        this.add(nextButton);

        // Set background color
        this.getContentPane().setBackground(new Color(0x123456));

        // Add component listener to handle resizing
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustComponentSizes();
            }
        });
    }

    private void setupFrame() {
        this.setTitle("Instoopay");
        this.setResizable(true);
        this.setLayout(null);

        // No icon available in resources
        // Using default Java icon

        // Note: Size and default close operation are set by GUI.Father class
    }

    private void setupComponents() {
        // Store the original icon for later resizing
        originalIcon = new ImageIcon("src/GUI.main/resources/WhatsApp Image 2025-04-17 at 8.51.06 PM.jpeg");

        // Initialize components
        welcomeLabel = new JLabel();
        welcomeLabel.setText("<<Welcome to Instoopay>>");
        welcomeLabel.setIconTextGap(+30);
        welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
        welcomeLabel.setVerticalTextPosition(JLabel.TOP);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setOpaque(false);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        nextButton = new JButton("Next");
        nextButton.setBackground(Color.LIGHT_GRAY);
        nextButton.setBorder(BorderFactory.createLineBorder(new Color(0x123456)));
        nextButton.setFocusPainted(false);
        nextButton.setForeground(new Color(0x123456));
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Set initial sizes and positions
        adjustComponentSizes();
    }

    private void adjustComponentSizes() {
        // Get current frame dimensions
        int frameWidth = this.getWidth();
        int frameHeight = this.getHeight();

        // Skip if frame is not yet visible or has zero size
        if (frameWidth <= 0 || frameHeight <= 0) {
            return;
        }

        // Resize image to be proportional to frame size
        int imageSize = Math.min(frameWidth / 2, frameHeight / 2);
        Image resizedImage = originalIcon.getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(resizedImage);
        welcomeLabel.setIcon(scaledIcon);

        // Center the label in the frame with appropriate size
        int labelWidth = imageSize + 100; // Add padding
        int labelHeight = imageSize + 100; // Add padding for text
        int labelX = (frameWidth - labelWidth) / 2;
        int labelY = (frameHeight - labelHeight) / 3; // Position in the upper third
        welcomeLabel.setBounds(labelX, labelY, labelWidth, labelHeight);

        // Setup next button
        int buttonWidth = 150;
        int buttonHeight = 40;
        int buttonX = (frameWidth - buttonWidth) / 2;
        int buttonY = labelY + labelHeight + 20; // Position below the label
        nextButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
    }

    private void setupListeners() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login logginScreen = new Login();
                logginScreen.setVisible(true);
                dispose();
            }
        });
    }

}
