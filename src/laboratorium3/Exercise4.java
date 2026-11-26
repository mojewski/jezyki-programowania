package laboratorium3;

import javax.swing.*;
import java.awt.*;

public class Exercise4 extends JFrame {

    private JTextField display;
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public Exercise4() {
        configureJFrame();
        configureUI();
    }

    private void configureJFrame() {
        setTitle("Kalkulator");
        setSize(320, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void configureUI() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        display = new JTextField("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 8, 8));
        String[] labels = {
                "C", " ", " ", "<-",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : labels) {
            if (label.equals(" ")) {
                buttonPanel.add(new JLabel());
            } else {
                JButton btn = new JButton(label);
                btn.addActionListener(e -> handleButtonClick(label));
                buttonPanel.add(btn);
            }
        }

        mainPanel.add(display, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    private void handleButtonClick(String text) {
        if (text.equals("C")) {
            display.setText("0");
            firstNumber = 0;
            operator = "";
            startNewNumber = true;
            return;
        }

        if (text.equals("<-")) {
            if (startNewNumber) {
                return;
            }
            String current = display.getText();
            if (current.length() > 1) {
                display.setText(current.substring(0, current.length() - 1));
            } else {
                display.setText("0");
                startNewNumber = true;
            }
            return;
        }      if (text.equals(".")) {
            if (startNewNumber) {
                display.setText("0.");
                startNewNumber = false;
            } else if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
            return;
        }

        if (text.matches("[0-9]")) {
            if (startNewNumber || display.getText().equals("0")) {
                display.setText(text);
                startNewNumber = false;
            } else {
                display.setText(display.getText() + text);
            }
            return;
        }

        if (text.matches("[+\\-*/]")) {
            firstNumber = Double.parseDouble(display.getText());
            operator = text;
            startNewNumber = true;
            return;
        }

        if (text.equals("=") && !operator.isEmpty()) {
            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case "+" -> result = firstNumber + secondNumber;
                case "-" -> result = firstNumber - secondNumber;
                case "*" -> result = firstNumber * secondNumber;
                case "/" -> {
                    if (secondNumber == 0) {
                        display.setText("Błąd");
                        operator = "";
                        startNewNumber = true;
                        return;
                    }
                    result = firstNumber / secondNumber;
                }
            }

            if (result == (long) result) {
                display.setText(String.valueOf((long) result));
            } else {
                display.setText(String.valueOf(result));
            }

            operator = "";
            startNewNumber = true;
        }
    }
}