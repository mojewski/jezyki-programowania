package laboratorium3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Exercise6 extends JFrame {

    private DefaultTableModel tableModel;
    private JTable contactTable;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneField;
    private JTextField emailField;

    public Exercise6() {
        configureJFrame();
        configureUI();
    }

    private void configureJFrame() {
        setTitle("Zadanie 6");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void configureUI() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel(new GridLayout(2, 4, 8, 5));
        formPanel.add(new JLabel("Imię:"));
        formPanel.add(new JLabel("Nazwisko:"));
        formPanel.add(new JLabel("Telefon:"));
        formPanel.add(new JLabel("E-mail:"));

        firstNameField = new JTextField();
        lastNameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();

        formPanel.add(firstNameField);
        formPanel.add(lastNameField);
        formPanel.add(phoneField);
        formPanel.add(emailField);

        String[] columns = {"Imię", "Nazwisko", "Telefon", "E-mail"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        contactTable = new JTable(tableModel);
        contactTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contactTable.setRowHeight(24);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JButton addButton = new JButton("Dodaj kontakt");
        JButton deleteButton = new JButton("Usuń zaznaczony");
        JButton clearButton = new JButton("Wyczyść pola");

        addButton.addActionListener(e -> addContact());
        deleteButton.addActionListener(e -> deleteContact());
        clearButton.addActionListener(e -> clearFields());

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(contactTable), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    private void addContact() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();

        if (firstName.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Podaj przynajmniej imię oraz numer telefonu.", "Brak danych", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] row = {firstName, lastName, phone, email};
        tableModel.addRow(row);
        clearFields();
    }

    private void deleteContact() {
        int selectedRow = contactTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Zaznacz w tabeli kontakt, który chcesz usunąć.", "Nie wybrano wiersza", JOptionPane.WARNING_MESSAGE);
            return;
        }
        tableModel.removeRow(selectedRow);
    }

    private void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
        emailField.setText("");
        firstNameField.requestFocus();
    }
}