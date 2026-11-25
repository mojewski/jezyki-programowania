package laboratorium3;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Exercise135 extends JFrame {

    public Exercise135() {
        configureJFrame();
        configureJPanelExercise1();
    }

    private void configureJFrame() {
        setTitle("Laboratorium 3");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void configureJPanelExercise1() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        JLabel loginLabel = new JLabel("Login:");
        JTextField loginField = new JTextField();

        JLabel passwordLabel = new JLabel("Hasło:");
        JPasswordField passwordField = new JPasswordField();

        JLabel strengthLabel = new JLabel("Siła hasła:");
        JProgressBar strengthBar = new JProgressBar(0, 4);
        strengthBar.setStringPainted(true);
        strengthBar.setString("Brak");

        JButton submitButton = new JButton("->");

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        JLabel welcomeLabel = new JLabel("Witaj!", SwingConstants.CENTER);
        JButton nameButton = new JButton("Podaj imię");

        formPanel.add(loginLabel);
        formPanel.add(loginField);

        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        formPanel.add(strengthLabel);
        formPanel.add(strengthBar);

        formPanel.add(new JLabel());
        formPanel.add(submitButton);

        formPanel.add(welcomeLabel);
        formPanel.add(nameButton);

        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePasswordStrength(passwordField, strengthBar);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePasswordStrength(passwordField, strengthBar);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePasswordStrength(passwordField, strengthBar);
            }
        });

        submitButton.addActionListener(e -> {
            String login = loginField.getText();
            String password = new String(passwordField.getPassword());

            resultArea.append("Login: " + login + " Hasło: " + password + "\n");
        });

        nameButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Jak masz na imię?", "Powitanie", JOptionPane.QUESTION_MESSAGE);
            if (name != null && !name.isBlank()) {
                welcomeLabel.setText("Witaj, " + name.trim() + "!");
                JOptionPane.showMessageDialog(this, "Miło Cię widzieć " + name + "!\n");
            }
        });

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

        mainPanel.add(menuPanel, BorderLayout.SOUTH);
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(mainPanel);
    }

    private void updatePasswordStrength(JPasswordField passwordField, JProgressBar strengthBar) {
        String pass = new String(passwordField.getPassword());
        int score = 0;
        if (pass.length() >= 8) score++;
        if (pass.matches(".*[A-Z].*")) score++;
        if (pass.matches(".*[0-9].*")) score++;
        if (pass.matches(".*[^a-zA-Z0-9].*")) score++;

        strengthBar.setValue(score);

        if (pass.isEmpty()) {
            strengthBar.setForeground(Color.RED);
            strengthBar.setString("Brak");
        } else if (score <= 1) {
            strengthBar.setForeground(Color.ORANGE);
            strengthBar.setString("Słabe");
        } else if (score <= 3) {
            strengthBar.setForeground(Color.YELLOW);
            strengthBar.setString("Średnie");
        } else {
            strengthBar.setForeground(Color.GREEN);
            strengthBar.setString("Silne");
        }
    }
}