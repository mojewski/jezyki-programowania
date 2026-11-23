package laboratorium3;

import javax.swing.*;
import java.awt.*;

public class Exercise13 extends JFrame {

    public Exercise13() {
        configureJFrame();
        configureJPanelExercise1();
    }

    private void configureJFrame() {
        setTitle("Laboratorium 3");
        setSize(600,450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void configureJPanelExercise1() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JPanel formPanel  = new JPanel(new GridLayout(4, 2, 5, 5));

        JLabel loginLabel = new JLabel("Login:");
        JTextField loginField = new JTextField();

        JLabel passwordLabel = new JLabel("Hasło:");
        JPasswordField passwordField = new JPasswordField();

        JButton submitButton = new JButton("->");

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        JLabel welcomeLabel = new JLabel("Witaj!", SwingConstants.CENTER);

        JButton nameButton = new JButton("Podaj imię");

        formPanel.add(loginLabel);
        formPanel.add(loginField);

        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        formPanel.add(new JLabel());
        formPanel.add(submitButton);

        formPanel.add(welcomeLabel);
        formPanel.add(nameButton);

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
        JButton task5Button = new JButton("Zadanie 5");

        task2Button.addActionListener(e -> new Exercise2().setVisible(true));
        task5Button.addActionListener(e -> new Exercise5().setVisible(true));

        menuPanel.add(task2Button);
        menuPanel.add(task5Button);

        mainPanel.add(menuPanel, BorderLayout.SOUTH);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(mainPanel);
    }
}
