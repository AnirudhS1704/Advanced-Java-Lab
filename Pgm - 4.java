import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Student{
	String name, usn;
	int age;
	double cgpa;
	
	Student(String name, String usn, int age, double cgpa){
		this.name = name;
		this.age = age;
		this.usn = usn;
		this.cgpa = cgpa;
	}
}

public class STIS extends JFrame implements ActionListener{
	
	JLabel  nameL, usn, ageL, usnL, sgpa1L, sgpa2L, sgpa3L, sgpa4L;
	JTextField  nameTF, usnTF, ageTF, addressTF, sgpa1TF, sgpa2TF, sgpa3TF, sgpa4TF;
	ArrayList<Double> sgpas;
	HashMap<String, Student> studentList = new HashMap<>();
	
	STIS(){
		sgpas = new ArrayList<>();
		
		
		setTitle("SIS");
		setLayout(new GridLayout(8, 2, 10, 10));
		
		nameL = new JLabel("Name:");
		nameTF = new JTextField();
		
		usnL = new JLabel("USN:");
		usnTF = new JTextField();
		
		ageL = new JLabel("Age:");
		ageTF = new JTextField();
		
		sgpa1L = new JLabel("1st sem SGPA:");
		sgpa1TF = new JTextField();
		
		sgpa2L = new JLabel("2st sem SGPA:");
		sgpa2TF = new JTextField();
		
		sgpa3L = new JLabel("3st sem SGPA:");
		sgpa3TF = new JTextField();
		
		sgpa4L = new JLabel("4st sem SGPA:");
		sgpa4TF = new JTextField();
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(this);
		
		JButton display = new JButton("Display");
		display.addActionListener(this);
		
		add(nameL);
		add(nameTF);
		add(usnL);
		add(usnTF);
		add(ageL);
		add(ageTF);
		add(sgpa1L);
		add(sgpa1TF);
		add(sgpa2L);
		add(sgpa2TF);
		add(sgpa3L);
		add(sgpa3TF);
		add(sgpa4L);
		add(sgpa4TF);
		add(submit);
		add(display);
		
		setSize(400, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	 public void actionPerformed(ActionEvent e) {
		 String name = nameTF.getText();
		 String usn = usnTF.getText();
		 String age = ageTF.getText();
		 
		 String sgpa1 = sgpa1TF.getText();
		 String sgpa2 = sgpa2TF.getText();
		 String sgpa3 = sgpa3TF.getText();
		 String sgpa4 = sgpa4TF.getText();
		 
		 double cgpa=Double.valueOf(sgpa1);
		 if(e.getActionCommand().equals("Submit")) {
			 
			 sgpas.add(Double.parseDouble(sgpa1));
			 sgpas.add(Double.parseDouble(sgpa2));
			 sgpas.add(Double.parseDouble(sgpa3));
			 sgpas.add(Double.parseDouble(sgpa4));
			 
			 if(Integer.parseInt(age) < 18 || Integer.parseInt(age) > 60)
				 JOptionPane.showMessageDialog(this, "Age should be between 18 & 60");
			 
			 if(Double.valueOf(sgpa1) < 10.0 && Double.valueOf(sgpa2) < 10.0 && Double.valueOf(sgpa3) < 10.0 && Double.valueOf(sgpa4) < 10) 
				 cgpa = (Double.valueOf(sgpa1) + Double.valueOf(sgpa2) + Double.valueOf(sgpa3) + Double.valueOf(sgpa4)) / 4.0;
			 else
				 JOptionPane.showMessageDialog(this, "SGPA value should be between 0 and 10");
			 
			 
			 Student s = new Student(name, usn, Integer.parseInt(age), cgpa);
			 studentList.put(usn, s);
		 }
		 
		 
		 if (e.getActionCommand().equals("Display")) {
			 JTextArea textArea = new JTextArea();
	         for (Map.Entry<String, Student> en: studentList.entrySet()) {
	        	 Student s1 = en.getValue();
	        	 String details = "Name: " + s1.name + "\nUSN: " + usn + "\nAge: " + age + "\nCGPA: " + s1.cgpa;
	             textArea.append(details + "\n\n");
	         }
	         JScrollPane scrollPane = new JScrollPane(textArea);
	         scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));
	         JOptionPane.showMessageDialog(this, scrollPane, "Student Information", JOptionPane.PLAIN_MESSAGE);
		 }
		 
		 
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		STIS stis = new STIS();
	}

}
