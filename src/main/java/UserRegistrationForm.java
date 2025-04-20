import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Date;
import java.util.regex.Pattern;

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
    private JTextField emailField;
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
    private JLabel emailLabel;

    /**
     * Creates all UI components
     */
    private void createComponents() {
        // First Name
        firstNameLabel = createLabel("FIRST NAME");
        firstNameField = new JTextField(10);

        // Last Name
        lastNameLabel = createLabel("LAST NAME");
        lastNameField = new JTextField(10);

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
        emailLabel = createLabel("EMAIL");
        emailField = new JTextField(20);

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
        String email = emailField.getText().trim();

        if (!firstName.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "First name must contain only letters.");
            return;
        }

        if (!lastName.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Last name must contain only letters.");
            return;
        }

        if (!validation.validateEmail(email)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.");
            return;
        }

        // Form is valid, print the information
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Full Name: " + fullName);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Gender: " + gender);
        System.out.println("Email: " + email);

        // Proceed to email verification
        Email_verification emailVerification = new Email_verification();
        emailVerification.setVisible(true);
        dispose();
    }

    /**
     * Positions all components on the frame
     */
    private void layoutComponents() {
        // First Name
        firstNameLabel.setBounds(50, 50, 180, 40);
        firstNameField.setBounds(250, 50, 200, 30);

        // Last Name
        lastNameLabel.setBounds(50, 110, 180, 40);
        lastNameField.setBounds(250, 110, 200, 30);

        // Full Name
        fullNameLabel.setBounds(50, 170, 180, 40);
        fullNameField.setBounds(250, 170, 200, 30);

        // Birth Date
        birthDateLabel.setBounds(50, 230, 180, 40);
        birthDateSpinner.setBounds(250, 230, 200, 30);

        // Gender
        genderLabel.setBounds(50, 290, 180, 40);
        genderComboBox.setBounds(250, 290, 200, 30);

        // Email
        emailLabel.setBounds(50, 350, 180, 40);
        emailField.setBounds(250, 350, 200, 30);

        // Next Button
        nextButton.setBounds(220, 420, 150, 40);

        // Add components to frame
        add(firstNameLabel); add(firstNameField);
        add(lastNameLabel); add(lastNameField);
        add(fullNameLabel); add(fullNameField);
        add(birthDateLabel); add(birthDateSpinner);
        add(genderLabel); add(genderComboBox);
        add(emailLabel); add(emailField);
        add(nextButton);
    }


    /**
     * Main method to start the application
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserRegistrationForm());
    }
}
