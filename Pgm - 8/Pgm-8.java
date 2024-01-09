import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bank extends JFrame implements ActionListener{
	JLabel repNoL, repNameL, stateL, comissionL, rateL, custNoL, custNameL, credit_LimitL;
	JTextField repNoTF, repNameTF, stateTF, comissionTF, rateTF, custNoTF, custNameTF, credit_LimitTF;
	JButton submit;
	
	Bank(){
		setTitle("Bank");
		setLayout(new GridLayout(9, 2, 10, 10));
		
		repNoL = new JLabel("Rep No:");
		repNameL = new JLabel("Rep Name:");
		stateL = new JLabel("State:");
		comissionL = new JLabel("comission:");
		rateL = new JLabel("Rate::");
		custNoL = new JLabel("Customer No:");
		custNameL = new JLabel("Customer Name:");
		credit_LimitL = new JLabel("Rep Name:");
		
		repNoTF = new JTextField();
		repNameTF = new JTextField();
		stateTF = new JTextField();
		comissionTF = new JTextField();
		rateTF = new JTextField();
		custNoTF = new JTextField();
		custNameTF = new JTextField();
		credit_LimitTF = new JTextField();
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		
		add(repNoL);
		add(repNoTF);
		
		add(repNameL);
		add(repNameTF);
		
		add(stateL);
		add(stateTF);
		
		add(comissionL);
		add(comissionTF);
		
		add(rateL);
		add(rateTF);
		
		add(custNoL);
		add(custNoTF);
		
		add(custNameL);
		add(custNameTF);
		
		add(credit_LimitL);
		add(credit_LimitTF);
		
		add(submit);
		
		setSize(400, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String repNo = repNoTF.getText();
		String repName = repNameTF.getText();
		String state = stateTF.getText();
		String comssion = comissionTF.getText();
		String rate = rateTF.getText();
		String custNo = custNoTF.getText();
		String custName = custNameTF.getText();
		String credit_limit = credit_LimitTF.getText();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String db = "jdbc:mysql://localhost:3306/Bank1Db";
			String dir =  "root";
			String pass = "anirudh2003";
			
			Connection c = (Connection) DriverManager.getConnection(db, dir, pass);
			Statement smt = c.createStatement();
			
			String query1 = "insert into cust values (?, ?, ?, ?, ?);";
			String query2 = "insert into rep values (?, ?, ?, ?, ?);";
			
			PreparedStatement ps1 = c.prepareStatement(query1);
			ps1.setString(1, custNo);
            ps1.setString(2, custName);
            ps1.setString(3, state);
            ps1.setString(4, credit_limit);
            ps1.setString(5, repNo);
            ps1.executeUpdate();
            
            PreparedStatement ps2 = c.prepareStatement(query2);
            ps2.setString(1, repNo);
            ps2.setString(2, repName);
            ps2.setString(3, state);
            ps2.setString(4, comssion);
            ps2.setString(5, rate);
            ps2.executeUpdate();
            
            String reqState = "KA";
            
            ResultSet res1 = smt.executeQuery("select * from cust;");
            System.out.println("Customers	->");
            while(res1.next()) {
            	if(reqState.equals(res1.getString("state"))) {
            		System.out.println("Name: " + res1.getString("custName"));
            		System.out.println("No: " + res1.getString("custNo"));
            		System.out.println("Name: " + res1.getString("state"));
            		System.out.println("Name: " + res1.getString("credit_limit"));
            		System.out.println("Name: " + res1.getString("repNo"));
            		System.out.println();
            	}
            }
            
            ResultSet res2 = smt.executeQuery("select * from rep;");
            System.out.println("Reps	->");
            while(res2.next()) {
            	if(reqState.equals(res2.getString("state"))) {
            		System.out.println("Name: " + res2.getString("repName"));
            		System.out.println("No: " + res2.getString("repNo"));
            		System.out.println("Name: " + res2.getString("state"));
            		System.out.println("Name: " + res2.getString("comission"));
            		System.out.println("Name: " + res2.getString("rate"));
            		System.out.println();
            	}
            }
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bank();
	}

}
