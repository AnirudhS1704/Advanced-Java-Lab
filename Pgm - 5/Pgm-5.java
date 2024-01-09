import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

class Item {
    private String id;
    private String name;
    private double price;

    public Item(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class CustomerDetailsApp  extends JFrame {
	
    private HashMap<String, String> customers;
    private ArrayList<Item> items;

    private JTextField mobileField, itemIdField, quantityField, discountField;

    public CustomerDetailsApp () {
        customers = new HashMap<>();
        items = new ArrayList<>();
        // Dummy data for items
        items.add(new Item("101", "Item A", 10));
        items.add(new Item("102", "Item B", 15));
        items.add(new Item("103", "Item C", 20));

        JLabel mobileLabel = new JLabel("Enter Mobile Number:");
        mobileField = new JTextField(20);

        JButton checkButton = new JButton("Check Customer");
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkCustomer();
            }
        });

        JLabel itemIdLabel = new JLabel("Enter Item ID:");
        itemIdField = new JTextField(10);

        JLabel quantityLabel = new JLabel("Enter Quantity:");
        quantityField = new JTextField(5);

        JLabel discountLabel = new JLabel("Enter Discount:");
        discountField = new JTextField(5);

        JButton calculateButton = new JButton("Calculate Total Cost");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTotalCost();
            }
        });

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(mobileLabel);
        panel.add(mobileField);
        panel.add(checkButton);
        panel.add(itemIdLabel);
        panel.add(itemIdField);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(discountLabel);
        panel.add(discountField);
        panel.add(calculateButton);

        this.add(panel);
        this.setTitle("Customer Purchase");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void checkCustomer() {
        String mobile = mobileField.getText();
        if (customers.containsKey(mobile)) {
            String customerId = customers.get(mobile);
            JOptionPane.showMessageDialog(this, "Customer ID: " + customerId + " exists!");
        } else {
            String customerId = String.valueOf(customers.size() + 1); // Generate new customer ID
            customers.put(mobile, customerId);
            JOptionPane.showMessageDialog(this, "New customer added! Customer ID: " + customerId);
        }
    }

    private void calculateTotalCost() {
        String itemId = itemIdField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double discount = Double.parseDouble(discountField.getText());

        Item item = getItemById(itemId);
        if (item != null) {
            double totalCost = item.getPrice() * quantity;
            totalCost -= (totalCost * discount / 100);

            JOptionPane.showMessageDialog(this, "Item Name: " + item.getName() + "\nTotal Cost: $" + totalCost);
        } else {
            JOptionPane.showMessageDialog(this, "Item not found!");
        }
    }

    private Item getItemById(String itemId) {
        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
		new Runnable(){
			public void run(){
				new CustomerDetailsApp();
    	}
	});
}
}


