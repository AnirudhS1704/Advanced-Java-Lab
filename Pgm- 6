import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pgm6 extends JFrame implements ActionListener {

    JTextField nameField, ageField, familyMembersField, addressField;
    JComboBox<String> payScaleComboBox;
    JRadioButton maleRadioButton, femaleRadioButton;

    public Pgm6() {
        setTitle("Employee Data Entry");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2, 5, 5));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        
        JLabel payScaleLabel = new JLabel("Pay Scale:");
        String[] payScales = {"Select", "Payscale 1", "Payscale 2", "Payscale 3"};
        
        payScaleComboBox = new JComboBox<>(payScales);
        JLabel familyMembersLabel = new JLabel("Family Members:");
        familyMembersField = new JTextField();
        
        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();
        
        JLabel genderLabel = new JLabel("Gender:");
        ButtonGroup genderGroup = new ButtonGroup();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(payScaleLabel);
        add(payScaleComboBox);
        add(familyMembersLabel);
        add(familyMembersField);
        add(addressLabel);
        add(addressField);
        add(genderLabel);
        add(maleRadioButton);
        add(new JLabel()); // Empty cell
        add(new JLabel()); // Empty cell
        add(femaleRadioButton);
        add(submitButton);

        setSize(400,  250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String payScale = (String) payScaleComboBox.getSelectedItem();
            int familyMembers = Integer.parseInt(familyMembersField.getText());
            String address = addressField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";

            if (age >= 22 && age <= 60) {
                String message = "Name: " + name + "\nAge: " + age + "\nPay Scale: " + payScale +
                        "\nFamily Members: " + familyMembers + "\nAddress: " + address +
                        "\nGender: " + gender;
                JOptionPane.showMessageDialog(this, message, "Employee Data", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String input = JOptionPane.showInputDialog(this, "Enter valid age (between 22 and 60):");
                int newAge = Integer.parseInt(input);
                if (newAge >= 22 && newAge <= 60) {
                    ageField.setText(String.valueOf(newAge));
                    actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Submit"));
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid age entered.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Pgm6();
    }
}
