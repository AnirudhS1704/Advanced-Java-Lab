import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDetailsForm extends JFrame implements ActionListener {

    private JTextField loginIdField, nameField;
    private JPasswordField passwordField;

    public LoginDetailsForm() {
        setTitle("Login Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        JLabel loginIdLabel = new JLabel("Login ID:");
        loginIdField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        add(loginIdLabel);
        add(loginIdField);
        add(nameLabel);
        add(nameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // Empty cell
        add(submitButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            String loginId = loginIdField.getText();
            String name = nameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);

            // Establish database connection and insert data
            try (Connection connection = DriverManager.getConnection("jdbc:sqlite:login_details.db")) {
                String query = "INSERT INTO users (login_id, name, password) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, loginId);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, password);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data added to the database!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        // Create the SQLite database and table if they don't exist
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:login_details.db")) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, login_id TEXT, name TEXT, password TEXT)";
            connection.createStatement().executeUpdate(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(LoginDetailsForm::new);
    }
}
