package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddPerformance extends JFrame implements ActionListener {

    JButton home_btn;
    JButton add_performance;

    Choice choiceName;
    JComboBox departmentBox, degree, review, experience;

    AddPerformance() {

        // Create two panels for the main frame
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        rightPanel.setBounds(0,0,250,700);
        rightPanel.setBackground(new Color(135,196,255));
        rightPanel.setLayout(null);
        add(rightPanel);

        leftPanel.setBounds(250,0,750,700);
        leftPanel.setLayout(null);
        add(leftPanel);

        // Right panel

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
        home_btn.setBounds(30,550,180,40);
        home_btn.setBackground(new Color(57, 167, 255));
        home_btn.addActionListener(this);
        rightPanel.add(home_btn);

        JLabel employee_performance = new JLabel("Employee Performance");
        employee_performance.setFont(new Font("serif", Font.BOLD, 40));
        employee_performance.setBounds(168,30,400,50);
        leftPanel.add(employee_performance);

        JLabel employee_name = new JLabel("Employee Name               : ");
        employee_name.setFont(new Font("serif", Font.BOLD, 23));
        employee_name.setBounds(70, 140,300,40);
        leftPanel.add(employee_name);

        choiceName = new Choice();
        choiceName.setBounds(400,140,200,300);
        choiceName.setFont(new Font("serif", Font.BOLD, 20));
        choiceName.setSize(200,100);
        leftPanel.add(choiceName);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employeedetail");
            while (resultSet.next()) {
                choiceName.add(resultSet.getString("name"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JLabel employee_department = new JLabel("Employee Department    : ");
        employee_department.setFont(new Font("serif", Font.BOLD, 23));
        employee_department.setBounds(70, 220,300,40);
        leftPanel.add(employee_department);

        String[] departments = {"IT"," HR"," Service "," Finance "," Security", " Management "," Stock"};
        departmentBox = new JComboBox(departments);
        departmentBox.setBounds(400,220,200,30);
        departmentBox.setFont(new Font("serif", Font.BOLD, 20));
        leftPanel.add(departmentBox);

        JLabel employee_experience = new JLabel("Employee Experience      : ");
        employee_experience.setFont(new Font("serif", Font.BOLD, 23));
        employee_experience.setBounds(70, 300,300,40);
        leftPanel.add(employee_experience);


        String[] experiences = {"Entry", "Junior", "Senior", "Middle" ,"Executive"};
        experience = new JComboBox(experiences);
        experience.setBounds(400,300,200,30);
        experience.setFont(new Font("serif", Font.BOLD, 20));
        leftPanel.add(experience);


        JLabel employee_degree = new JLabel("Employee Degree             : ");
        employee_degree.setFont(new Font("serif", Font.BOLD, 23));
        employee_degree.setBounds(70, 380,300,40);
        leftPanel.add(employee_degree);

        String[] degrees = {"Associate","Bachelor", "Master", "Doctoral"};
        degree = new JComboBox(degrees);
        degree.setBounds(400,380,200,30);
        degree.setFont(new Font("serif", Font.BOLD, 20));
        leftPanel.add(degree);


        JLabel employee_review = new JLabel("Employee Review            : ");
        employee_review.setFont(new Font("serif", Font.BOLD, 23));
        employee_review.setBounds(70, 460,300,40);
        leftPanel.add(employee_review);

        String[] reviews = {"Excellent", "Very Good", "Good", "Not Bad", "Bad"};
        review = new JComboBox(reviews);
        review.setFont(new Font("serif", Font.BOLD, 20));
        review.setBounds(400,460,200,30);
        leftPanel.add(review);

        add_performance = new JButton("Add Performance");
        add_performance.setFont(new Font("serif", Font.BOLD, 23));
        add_performance.setBounds(200,550,300,40);
        add_performance.setBackground(new Color(57, 167, 255));
        add_performance.addActionListener(this);
        leftPanel.add(add_performance);


        // Set frame
        setTitle("Employee Management System");
        setLocation(350,150);
        setSize(1000, 700);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add_performance) {
            String emp_name = choiceName.getSelectedItem();
            String emp_department = (String) departmentBox.getSelectedItem();
            String emp_experience = (String) experience.getSelectedItem();
            String emp_degree = (String) degree.getSelectedItem();
            String emp_review = (String) review.getSelectedItem();

            try {

                Conn conn = new Conn();
                String query1 = "select count(emp_name) from employeesystem.employee_performace where emp_name = '"+ emp_name+"' ";
                ResultSet resultSet1 = conn.statement.executeQuery(query1);
                if (resultSet1.next()) {
                    int count = resultSet1.getInt(1);
                    if (count > 0) {
                        JOptionPane.showMessageDialog(null, "Employee has already been added");
                    }
                    else {
                        String query2 = "insert into employeesystem.employee_performace values('"+emp_name+"', '"+emp_department+"', '"+emp_experience+"', '"+emp_degree+"', '"+emp_review+"')";
                        conn.statement.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null,"Information added successfully");
                    }
                }
            }
            catch (Exception E) {
                E.printStackTrace();
            }
        }

        if (e.getSource() == home_btn) {
            new Main();
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new AddPerformance();

    }

}
