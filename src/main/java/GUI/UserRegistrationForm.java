package GUI;

import DAO.User_DAO;
import Database.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Date;

/**
 * User Registration Form for InstaPay application
 * Collects user information such as name, birth date, gender, and email
 */
public class UserRegistrationForm extends Father {
    // UI Components
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField fullNameField;
    private JSpinner birthDateSpinner;
    private JComboBox<String> genderComboBox;
    private JTextField addresslField;
    private JButton nextButton;

    // Constants
    private static final Color BACKGROUND_COLOR = new Color(0x12, 0x34, 0x56);
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 18);
    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 18);

    /**
     * Constructor - initializes and displays the registration form
     */
    public UserRegistrationForm() {
        super();
        setTitle("InstaPay - User Registration");
        createComponents();
        setupListeners();
        layoutComponents();
        setVisible(true);
    }

    // UI Component Labels
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel fullNameLabel;
    private JLabel birthDateLabel;
    private JLabel genderLabel;
    private JLabel addressLabel;

    /**
     * Creates all UI components
     */
    private void createComponents() {
        // First Name
        firstNameLabel = createLabel("FIRST NAME");
        firstNameField = new JTextField(60);

        // Last Name
        lastNameLabel = createLabel("LAST NAME");
        lastNameField = new JTextField(4);

        // Full Name
        fullNameLabel = createLabel("FULL NAME");
        fullNameField = new JTextField(10);
        fullNameField.setEditable(false);

        // Birth Date
        birthDateLabel = createLabel("BIRTH DATE");
        SpinnerDateModel dateModel = new SpinnerDateModel();
        birthDateSpinner = new JSpinner(dateModel);
        birthDateSpinner.setEditor(new JSpinner.DateEditor(birthDateSpinner, "yyyy-MM-dd"));

        // Gender
        genderLabel = createLabel("GENDER");
        String[] genders = {"Male", "Female"};
        genderComboBox = new JComboBox<>(genders);

        // Email
        addressLabel = createLabel("Address");
        addresslField = new JTextField(20);

        // Next Button
        nextButton = new JButton("NEXT");
        nextButton.setFont(BUTTON_FONT);
        nextButton.setBackground(Color.lightGray);
        nextButton.setForeground(BACKGROUND_COLOR);
    }

    /**
     * Creates a standardized label with the given text
     */
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(LABEL_FONT);
        label.setForeground(TEXT_COLOR);
        return label;
    }

    /**
     * Sets up event listeners for components
     */
    private void setupListeners() {
        // Document listener for auto-updating full name
        DocumentListener nameListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { updateFullName(); }
            public void removeUpdate(DocumentEvent e) { updateFullName(); }
            public void insertUpdate(DocumentEvent e) { updateFullName(); }

            public void updateFullName() {
                fullNameField.setText(firstNameField.getText() + " " + lastNameField.getText());
            }
        };

        firstNameField.getDocument().addDocumentListener(nameListener);
        lastNameField.getDocument().addDocumentListener(nameListener);

        // Next button action listener
        nextButton.addActionListener(e -> validateAndSubmitForm());
    }

    /**
     * Validates form inputs and submits if valid
     */
    private void validateAndSubmitForm() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String fullName = fullNameField.getText().trim();
        Date birthDate = (Date) birthDateSpinner.getValue();
        String gender = (String) genderComboBox.getSelectedItem();
        String email = addresslField.getText().trim();

        if (!firstName.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "First name must contain only letters.");
            return;
        }

        if (!lastName.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Last name must contain only letters.");
            return;
        }

        if (!email.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Last name must contain only letters.");
            return;
        }

//        User user = new User();
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setFullName(fullName);
//        user.setBirthday(birthDate);
//        user.setAddress(email);
//        user.setUserId(1);
//        user.setEmail("othman9128@gmail.com");
//        user.setPassword("123456");
//        user.setStatus(true);
//        User_DAO user_dao = new User_DAO();
//        user_dao.addUser(user);
//        Email_verification email_verification = new Email_verification();
//        email_verification.setVisible(true);
//        dispose();
    }

    /**
     * Positions all components on the frame
     */
    private void layoutComponents() {
        int panelWidth = this.getWidth();

        // Common horizontal positions
        int labelWidth = 180;
        int fieldWidth = 300;
        int gap = 20;
        int totalWidth = labelWidth + gap + fieldWidth;
        int startX = (panelWidth - totalWidth) / 2;

        // First Name
        firstNameLabel.setBounds(startX, 50, labelWidth, 40);
        firstNameField.setBounds(startX + labelWidth + gap, 50, fieldWidth, 30);

        // Last Name
        lastNameLabel.setBounds(startX, 110, labelWidth, 40);
        lastNameField.setBounds(startX + labelWidth + gap, 110, fieldWidth, 30);

        // Full Name
        fullNameLabel.setBounds(startX, 170, labelWidth, 40);
        fullNameField.setBounds(startX + labelWidth + gap, 170, fieldWidth, 30);

        // Birth Date
        birthDateLabel.setBounds(startX, 230, labelWidth, 40);
        birthDateSpinner.setBounds(startX + labelWidth + gap, 230, fieldWidth, 30);

        // Gender
        genderLabel.setBounds(startX, 290, labelWidth, 40);
        genderComboBox.setBounds(startX + labelWidth + gap, 290, 200, 30);

        // Email
        addressLabel.setBounds(startX, 350, labelWidth, 40);
        addresslField.setBounds(startX + labelWidth + gap, 350, 200, 30);

        // Next Button - centered alone
        nextButton.setBounds((panelWidth - 150) / 2, 420, 150, 40);

        // Add components to frame
        add(firstNameLabel); add(firstNameField);
        add(lastNameLabel); add(lastNameField);
        add(fullNameLabel); add(fullNameField);
        add(birthDateLabel); add(birthDateSpinner);
        add(genderLabel); add(genderComboBox);
        add(addressLabel); add(addresslField);
        add(nextButton);
    }
    public static void main(String[] args) {
        Date date = new Date();

        User user = new User();
        user.setEmail("othman9128");
        user.setAddress("Egypt");
        user.setBirthday(date);
        user.setPassword("123454567");
        user.setFullName("Mohamed");
        user.setFirstName("Mohamed");
        user.setLastName("Hassan");
        User_DAO user_dao = new User_DAO();
        System.out.println(user_dao.checkUser(user.getEmail(),user.getPassword()));
    }
}
