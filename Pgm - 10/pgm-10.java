import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Pgm extends JFrame implements ActionListener{
	JLabel PatientNameL, medicineTypeL, treatmentTypeL, searchByMedicineL, searchByTreatmentL;
	JTextField PatientNameTF, medicineTypeTF, treatmentTypeTF, searchByMedicineTF, searchBytreatmentTF;
	JButton submit, searchByMedicine, searchByTreatment;
	Connection c;
	
	Pgm(){
		PatientNameL = new JLabel("Patient name:");
		PatientNameTF = new JTextField();
		
		medicineTypeL = new JLabel("Medicine type:");
		medicineTypeTF = new JTextField();
		
		treatmentTypeL = new JLabel("Treatment type:");
		treatmentTypeTF = new JTextField();
		
		searchByMedicineL = new JLabel("Search by medicine:");
		searchByMedicineTF = new JTextField();
		
		searchByTreatmentL = new JLabel("Treatment type:");
		searchBytreatmentTF = new JTextField();
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		searchByMedicine = new JButton("Search by medicine");
		searchByMedicine.addActionListener(this);
		searchByTreatment = new JButton("Search by treatment");
		searchByTreatment.addActionListener(this);
		
		setTitle("patient database");
		setLayout(new GridLayout(8, 2, 10, 10));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(PatientNameL);
		add(PatientNameTF);
		add(medicineTypeL);
		add(medicineTypeTF);
		add(treatmentTypeL);
		add(treatmentTypeTF);
		add(submit);
		add(new JLabel());
		add(searchByMedicineL);
		add(searchByMedicineTF);
		add(searchByMedicine);
		add(new JLabel());
		add(searchByTreatmentL);
		add(searchBytreatmentTF);
		add(searchByTreatment);
		
		setSize(400, 300);
		setVisible(true);
		
		connectToDB();
	}
	
	void connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db = "jdbc:mysql://localhost:3306/PatientDB";
			String dir = "root";
			String pass = "anirudh2003";
			
			c = DriverManager.getConnection(db, dir, pass);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void insertPatient() {
		String patientName = PatientNameTF.getText();
		String medicineType = medicineTypeTF.getText();
		String treatmentType = treatmentTypeTF.getText();
		
		try {
			String query1 = "insert into patient values (?, ?);";
			String query2 = "insert into medicine values (?, ?);";
			
			PreparedStatement ps1 = c.prepareStatement(query1);
			ps1.setString(1, patientName);
			ps1.setString(2, treatmentType);
			ps1.executeUpdate();
			
			PreparedStatement ps2 = c.prepareStatement(query2);
			ps2.setString(1, medicineType);
			ps2.setString(2, patientName);
			ps2.executeUpdate();
		}
		catch(SQLException e) {
			e.getStackTrace();
		}
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Submit") {
			insertPatient();
		}
		if(e.getActionCommand() == "Search by medicine") {
			String reqM = searchByMedicineTF.getText();
			System.out.println(reqM);
			try {
				Statement s = c.createStatement();
				ResultSet r1 = s.executeQuery("select * from medicine where mtype = '" + reqM + "';");
				
				while(r1.next()) {
					System.out.println(r1.getString("name"));
					
				}
			}
			catch(SQLException e1){
				e1.getStackTrace();
			}
		}
		if(e.getActionCommand() == "Search by treatment") {
			String reqT = searchBytreatmentTF.getText();
			System.out.println(reqT);
			try {
				Statement s = c.createStatement();
				ResultSet r1 = s.executeQuery("select * from patient where treatmentType = '" + reqT + "';");
				
				JTextArea ta = new JTextArea();
				while(r1.next()) {
					ta.append("Name: " + r1.getString("name") + "\n");
					
				}
				JScrollPane sp = new JScrollPane(ta);
				JOptionPane.showMessageDialog(this, sp, "Patient Name", JOptionPane.PLAIN_MESSAGE);
					
			}
			catch(SQLException e1){
				e1.getStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pgm();
	}

}
