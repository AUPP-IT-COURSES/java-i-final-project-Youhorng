package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(100);

    // Text field for personal details

    JTextField tfName, tfNationality;
    JComboBox genderBox, maritalStatusBox;

    // Text field for contact information

    JTextField tfAddress, tfPhoneNumber, tfEmail, tfEmerContact;

    // Employee Information

    JTextField  tfSalary;
    JLabel tfId;
    JComboBox jobBox, departmentBox, statusBox;

    JButton add_employee;
    JButton home_btn;

    AddEmployee() {

        // Create two panels for the main frame
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        rightPanel.setBounds(0,0,250,900);
        rightPanel.setBackground(new Color(135,196,255));
        rightPanel.setLayout(null);
        add(rightPanel);

        leftPanel.setBounds(250,0,750,900);
        leftPanel.setLayout(null);
        add(leftPanel);

        // Create employee logo in heading

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Images/emp-logo.png"));
        Image image1 = image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel logo = new JLabel(image2);
        logo.setBounds(70,20,100,100);
        rightPanel.add(logo);

        // Create employee title

        JLabel title = new JLabel("OfficePilot");
        title.setFont(new Font("serif", Font.BOLD, 40));
        title.setBounds(35,80,400,100);
        rightPanel.add(title);

        home_btn = new JButton("HOME");
        home_btn.setFont(new Font("serif", Font.BOLD, 23));
        home_btn.setBounds(30,780,180,40);
        home_btn.setBackground(new Color(57, 167, 255));
        home_btn.addActionListener(this);
        rightPanel.add(home_btn);

        // Left panel
        JLabel headingAdd = new JLabel("Add Employee");
        headingAdd.setFont(new Font("serif", Font.BOLD, 40));
        headingAdd.setBounds(240,5,300,60);
        leftPanel.add(headingAdd);

        JLabel personal_detail = new JLabel("Personal Details");
        personal_detail.setFont(new Font("serif", Font.BOLD, 23));
        personal_detail.setBounds(30,100,200,40);
        leftPanel.add(personal_detail);

        JLabel full_name = new JLabel("Full Name");
        full_name.setFont(new Font("serif", Font.PLAIN, 20));
        full_name.setBounds(30,160,200,30);
        leftPanel.add(full_name);

        tfName = new JTextField();
        tfName.setBounds(130,160,200,30);
        tfName.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(tfName);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("serif", Font.PLAIN, 20));
        gender.setBounds(30,220,200,30);
        leftPanel.add(gender);

        String genders[] = {"Male", "Female", "Others"};
        genderBox = new JComboBox(genders);
        genderBox.setBounds(130,220,200,30);
        genderBox.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(genderBox);

        JLabel nationality = new JLabel("Nationality");
        nationality.setFont(new Font("serif", Font.PLAIN, 20));
        nationality.setBounds(30,280,200,30);
        leftPanel.add(nationality);

        tfNationality = new JTextField();
        tfNationality.setBounds(130,280,200,30);
        tfNationality.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(tfNationality);

        JLabel marital_status = new JLabel("Marital");
        marital_status.setFont(new Font("serif", Font.PLAIN, 20));
        marital_status.setBounds(30,340,200,30);
        leftPanel.add(marital_status);

        String status[] = {"Married", "Single", "Divorced"};
        maritalStatusBox = new JComboBox(status);
        maritalStatusBox.setBounds(130,340,200,30);
        maritalStatusBox.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(maritalStatusBox);

        JLabel contact_information = new JLabel("Contact Information");
        contact_information.setBounds(410,100,200,40);
        contact_information.setFont(new Font("serif", Font.BOLD, 23));
        leftPanel.add(contact_information);

        JLabel address = new JLabel("Address");
        address.setBounds(410,160,200,30);
        address.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(address);

        tfAddress = new JTextField();
        tfAddress.setBounds(510,160,200,30);
        tfAddress.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(tfAddress);

        JLabel phone_number = new JLabel("Phone No");
        phone_number.setBounds(410,220,200,30);
        phone_number.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(phone_number);

        tfPhoneNumber = new JTextField();
        tfPhoneNumber.setBounds(510,220,200,30);
        tfPhoneNumber.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(tfPhoneNumber);

        JLabel email = new JLabel("Email");
        email.setBounds(410,280,200,30);
        email.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(email);

        tfEmail = new JTextField();
        tfEmail.setBounds(510,280,200,30);
        tfEmail.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(tfEmail);

        JLabel emergency_contact = new JLabel("Emergency");
        emergency_contact.setBounds(410,340,200,30);
        emergency_contact.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(emergency_contact);

        tfEmerContact = new JTextField();
        tfEmerContact.setBounds(510,340,200,30);
        tfEmerContact.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(tfEmerContact);

        JLabel employee_detail = new JLabel("Employment Detail");
        employee_detail.setFont(new Font("serif", Font.BOLD, 23));
        employee_detail.setBounds(260, 400,200,40);
        leftPanel.add(employee_detail);

        JLabel empId = new JLabel("Employee ID");
        empId.setBounds(160,460,200,30);
        empId.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(empId);

        tfId = new JLabel("000" + number);
        tfId.setBounds(340,460,200,30);
        tfId.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(tfId);

        JLabel salary = new JLabel("Employee Salary");
        salary.setBounds(160,520,200,30);
        salary.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(salary);

        tfSalary = new JTextField();
        tfSalary.setBounds(340,520,200,30);
        tfSalary.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(tfSalary);

        JLabel job_title = new JLabel("Employee title");
        job_title.setBounds(160,580,200,30);
        job_title.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(job_title);

        String[] jobs = {"Developer"," HR"," Service "," Auditor "," Security", " Manager "," Designer"};
        jobBox = new JComboBox(jobs);
        jobBox.setBounds(340,580,200,30);
        jobBox.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(jobBox);

        JLabel department = new JLabel("Department");
        department.setBounds(160,640,200,30);
        department.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(department);

        String[] departments = {"IT"," HR"," Service "," Finance "," Security", " Management "," Stock"};
        departmentBox = new JComboBox(departments);
        departmentBox.setBounds(340,640,200,30);
        departmentBox.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(departmentBox);

        JLabel emp_status = new JLabel("Employee Status");
        emp_status.setBounds(160,700,200,30);
        emp_status.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(emp_status);

        String[] emp_status_list = {"Full Time", "Part Time", "Contract", "Permanent"};
        statusBox = new JComboBox(emp_status_list);
        statusBox.setBounds(340,700,200,30);
        statusBox.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(statusBox);

        add_employee = new JButton("Add Employee");
        add_employee.setBounds(260,780,200,40);
        add_employee.setForeground(Color.BLACK);
        add_employee.setBackground(new Color(57, 167, 255));
        add_employee.setFont(new Font("serif", Font.BOLD, 23));
        add_employee.addActionListener(this);
        leftPanel.add(add_employee);


        // Set frame
        setTitle("Employee Management System");
        setLocation(350,30);
        setSize(1000, 900);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add_employee) {
            String full_name = tfName.getText();
            String gender = (String) genderBox.getSelectedItem();
            String nationality = tfNationality.getText();
            String marital = (String) maritalStatusBox.getSelectedItem();
            String address = tfAddress.getText();
            String phone = tfPhoneNumber.getText();
            String email = tfEmail.getText();
            String emer_contact = tfEmerContact.getText();
            String emp_id = tfId.getText();
            String salary = tfSalary.getText();
            String title = (String) jobBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();
            String status = (String) statusBox.getSelectedItem();

            if (!full_name.isEmpty() || !nationality.isEmpty() || !address.isEmpty() || !phone.isEmpty() || !email.isEmpty() || !emer_contact.isEmpty() || !salary.isEmpty()) {
                try {

                    Conn conn = new Conn();
                    String query = "insert into employeedetail values('"+full_name+"', '"+gender+"', '"+nationality+"', '"+marital+"', '"+address+"', '"+phone+"', '"+email+"', '"+emer_contact+"', '"+emp_id+"', '"+salary+"', '"+title+"', '"+department+"', '"+status+"')";
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Information added successfully");
                }
                catch (Exception E) {
                    E.printStackTrace();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Please fill all of the information");
            }
        }

        if (e.getSource() == home_btn) {
            new Main();
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new AddEmployee();

    }
}
