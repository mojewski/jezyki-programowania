package laboratorium3;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Exercise135 extends JFrame {

    private JTextField loginField;
    private JPasswordField passwordField;
    private JProgressBar strengthBar;
    private JTextArea resultArea;
    private JLabel welcomeLabel;

    public Exercise135() {
        configureJFrame();
        configureUI();
    }

    private void configureJFrame() {
        setTitle("Laboratorium 3");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void configureUI() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        mainPanel.add(createFormPanel(), BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        mainPanel.add(createMenuPanel(), BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        loginField = new JTextField();
        passwordField = new JPasswordField();

        strengthBar = new JProgressBar(0, 4);
        strengthBar.setStringPainted(true);
        strengthBar.setString("Brak");

        JButton submitButton = new JButton("->");
        welcomeLabel = new JLabel("Witaj!", SwingConstants.CENTER);
        JButton nameButton = new JButton("Podaj imię");

        formPanel.add(new JLabel("Login:"));
        formPanel.add(loginField);
        formPanel.add(new JLabel("Hasło:"));
        formPanel.add(passwordField);
        formPanel.add(new JLabel("Siła hasła:"));
        formPanel.add(strengthBar);
        formPanel.add(new JLabel());
        formPanel.add(submitButton);
        formPanel.add(welcomeLabel);
        formPanel.add(nameButton);

        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePasswordStrength();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePasswordStrength();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePasswordStrength();
            }
        });

        submitButton.addActionListener(e -> handleLogin());
        nameButton.addActionListener(e -> askForName());

        return formPanel;
    }

    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        JButton task2Button = new JButton("Zadanie 2");
        JButton task4Button = new JButton("Zadanie 4");
        JButton task6Button = new JButton("Zadanie 6");

        task2Button.addActionListener(e -> new Exercise2().setVisible(true));
        task4Button.addActionListener(e -> new Exercise4().setVisible(true));
        task6Button.addActionListener(e -> new Exercise6().setVisible(true));

        menuPanel.add(task2Button);
        menuPanel.add(task4Button);
        menuPanel.add(task6Button);

        return menuPanel;
    }

    private void handleLogin() {
        String login = loginField.getText();
        String password = new String(passwordField.getPassword());
        resultArea.append("Login: " + login + " Hasło: " + password + "\n");
    }

    private void askForName() {
        String name = JOptionPane.showInputDialog(this, "Jak masz na imię?", "Powitanie", JOptionPane.QUESTION_MESSAGE);
        if (name != null && !name.isBlank()) {
            welcomeLabel.setText("Witaj, " + name.trim() + "!");
            JOptionPane.showMessageDialog(this, "Miło Cię widzieć " + name.trim() + "!");
        }
    }

    private void updatePasswordStrength() {
        char[] password = passwordField.getPassword();
        int length = password.length;

        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for(char c : password) {
            if(Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if(Character.isDigit(c)) {
                hasDigit = true;
            } else if(!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        int score = 0;
        if (length >= 8) score++;
        if (hasUpperCase) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        if (length == 0) {
            strengthBar.setValue(0);
            strengthBar.setString("Brak");
        } else if (score <= 1) {
            strengthBar.setValue(1);
            strengthBar.setForeground(Color.RED);
            strengthBar.setString("Słabe");
        } else if (score <= 3) {
            strengthBar.setValue(score);
            strengthBar.setForeground(Color.ORANGE);
            strengthBar.setString("Średnie");
        } else {
            strengthBar.setValue(4);
            strengthBar.setForeground(Color.GREEN);
            strengthBar.setString("Silne");
        }
    }
}