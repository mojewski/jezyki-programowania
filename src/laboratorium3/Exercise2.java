package laboratorium3;

import javax.swing.*;
import java.awt.*;

public class Exercise2 extends JFrame {

    private JLabel targetBox;

    public Exercise2() {
        configureJFrame();
        configureUI();
    }

    private void configureJFrame() {
        setTitle("Zadanie 2");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void configureUI() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JPanel controlPanel = new JPanel(new GridLayout(2, 4, 8, 8));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 0, 8));

        JButton colorBtn = new JButton("Zmień kolor");
        JButton moveLeftBtn = new JButton("<- Przesuń");
        JButton moveRightBtn = new JButton("Przesuń ->");
        JButton moveUpBtn = new JButton("Przesuń ^");
        JButton moveDownBtn = new JButton("Przesuń v");
        JButton biggerBtn = new JButton("Powiększ (+20px)");
        JButton smallerBtn = new JButton("Pomniejsz (-20px)");
        JButton resetBtn = new JButton("Reset");

        controlPanel.add(colorBtn);
        controlPanel.add(moveLeftBtn);
        controlPanel.add(moveRightBtn);
        controlPanel.add(moveUpBtn);
        controlPanel.add(moveDownBtn);
        controlPanel.add(biggerBtn);
        controlPanel.add(smallerBtn);
        controlPanel.add(resetBtn);

        JPanel canvasPanel = new JPanel();
        canvasPanel.setLayout(null);
        canvasPanel.setBackground(Color.WHITE);
        canvasPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        targetBox = new JLabel("[Komponent do edycji]", SwingConstants.CENTER);
        targetBox.setOpaque(true);
        targetBox.setBackground(Color.GRAY);
        targetBox.setForeground(Color.WHITE);
        targetBox.setBounds(50, 50, 140, 80);

        canvasPanel.add(targetBox);

        colorBtn.addActionListener(e -> {
            Color chosenColor = JColorChooser.showDialog(this, "Wybierz nowy kolor", targetBox.getBackground());
            if (chosenColor != null) {
                targetBox.setBackground(chosenColor);
            }
        });

        moveLeftBtn.addActionListener(e -> {
            targetBox.setBounds(targetBox.getX() - 25, targetBox.getY(), targetBox.getWidth(), targetBox.getHeight());
        });

        moveRightBtn.addActionListener(e -> {
            targetBox.setBounds(targetBox.getX() + 25, targetBox.getY(), targetBox.getWidth(), targetBox.getHeight());
        });

        moveUpBtn.addActionListener(e -> {
            targetBox.setBounds(targetBox.getX(), targetBox.getY() - 25, targetBox.getWidth(), targetBox.getHeight());
        });

        moveDownBtn.addActionListener(e -> {
            targetBox.setBounds(targetBox.getX(), targetBox.getY() + 25, targetBox.getWidth(), targetBox.getHeight());
        });

        biggerBtn.addActionListener(e -> {
            targetBox.setBounds(targetBox.getX(), targetBox.getY(), targetBox.getWidth() + 20, targetBox.getHeight() + 20);
        });

        smallerBtn.addActionListener(e -> {
            int newW = Math.max(40, targetBox.getWidth() - 20);
            int newH = Math.max(40, targetBox.getHeight() - 20);
            targetBox.setBounds(targetBox.getX(), targetBox.getY(), newW, newH);
        });

        resetBtn.addActionListener(e -> {
            targetBox.setBounds(50, 50, 140, 80);
            targetBox.setBackground(Color.GRAY);
        });

        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(canvasPanel, BorderLayout.CENTER);
        add(mainPanel);
    }
}
