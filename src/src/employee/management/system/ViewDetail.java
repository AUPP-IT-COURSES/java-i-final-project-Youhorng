package employee.management.system;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewDetail extends JFrame implements ActionListener {

    JButton back_btn;
    ViewDetail(String name) {

        try {
            Conn c = new Conn();
            String query = "select * from employeedetail where name = '" + name + "'";
            ResultSet resultSet = c.statement.executeQuery(query);

            String full_name = null;
            String gender = null;
            String nationality = null;
            String marital_status = null;
            String address = null;
            String phone_number = null;
            String email = null;
            String emergency_contact = null;
            String employee_id = null;
            String salary = null;
            String title = null;
            String department = null;
            String status = null;
            while (resultSet.next()) {
                full_name = resultSet.getString("name");
                gender = resultSet.getString("gender");
                nationality = resultSet.getString("nationality");
                marital_status = resultSet.getString("marital");
                address = resultSet.getString("address");
                phone_number = resultSet.getString("phone");
                email = resultSet.getString("email");
                emergency_contact = resultSet.getString("emergency");
                employee_id = resultSet.getString("empID");
                salary = resultSet.getString("salary");
                title = resultSet.getString("title");
                department = resultSet.getString("department");
                status = resultSet.getString("status");
            }
            JLabel heading = new JLabel("Employee Details");
            heading.setFont(new Font("serif", Font.BOLD, 40));
            heading.setBounds(300,20,300,60);
            add(heading);

            JLabel personal_detail = new JLabel("Personal Detail");
            personal_detail.setBounds(170,100,400,50);
            personal_detail.setFont(new Font("serif", Font.BOLD, 23));
            add(personal_detail);

            JLabel fname = new JLabel("Full Name : ");
            fname.setBounds(100,160,200,40);
            fname.setFont(new Font("serif", Font.PLAIN, 20));
            add(fname);

            JLabel fullName = new JLabel(full_name);
            fullName.setFont(new Font("serif", Font.PLAIN, 20));
            fullName.setBounds(250,160,200,40);
            add(fullName);

            JLabel label_gender = new JLabel("Gender : ");
            label_gender.setBounds(100,220,200,40);
            label_gender.setFont(new Font("serif", Font.PLAIN, 20));
            add(label_gender);

            JLabel data_gender = new JLabel(gender);
            data_gender.setFont(new Font("serif", Font.PLAIN, 20));
            data_gender.setBounds(250,220,200,40);
            add(data_gender);

            JLabel label_nationality = new JLabel("Nationality : ");
            label_nationality.setBounds(100,280,200,40);
            label_nationality.setFont(new Font("serif", Font.PLAIN, 20));
            add(label_nationality);

            JLabel data_nationality= new JLabel(nationality);
            data_nationality.setFont(new Font("serif", Font.PLAIN, 20));
            data_nationality.setBounds(250,280,200,40);
            add(data_nationality);

            JLabel label_marital = new JLabel("Marital status : ");
            label_marital.setBounds(100,340,200,40);
            label_marital.setFont(new Font("serif", Font.PLAIN, 20));
            add(label_marital);

            JLabel data_marital = new JLabel(marital_status);
            data_marital.setFont(new Font("serif", Font.PLAIN, 20));
            data_marital.setBounds(250,340,200,40);
            add(data_marital);

            JLabel contact_detail = new JLabel("Contact Detail");
            contact_detail.setBounds(580,100,400,50);
            contact_detail.setFont(new Font("serif", Font.BOLD, 23));
            add(contact_detail);

            JLabel label_address = new JLabel("Address : ");
            label_address.setBounds(520,160,200,40);
            label_address.setFont(new Font("serif", Font.PLAIN, 20));
            add(label_address);

            JLabel data_address = new JLabel(address);
            data_address.setFont(new Font("serif", Font.PLAIN, 20));
            data_address.setBounds(670,160,200,40);
            add(data_address);

            JLabel label_phone = new JLabel("Phone number : ");
            label_phone.setBounds(520,220,200,40);
            label_phone.setFont(new Font("serif", Font.PLAIN, 20));
            add(label_phone);

            JLabel data_phone = new JLabel(phone_number);
            data_phone.setFont(new Font("serif", Font.PLAIN, 20));
            data_phone.setBounds(670,220,200,40);
            add(data_phone);

            JLabel label_email = new JLabel("Email Address : ");
            label_email.setBounds(520,280,200,40);
            label_email.setFont(new Font("serif", Font.PLAIN, 20));
            add(label_email);

            JLabel data_email = new JLabel(email);
            data_email.setFont(new Font("serif", Font.PLAIN, 20));
            data_email.setBounds(670,280,250,40);
            add(data_email);

            JLabel label_emergency = new JLabel("Emergency: ");
            label_emergency.setBounds(520,340,200,40);
            label_emergency.setFont(new Font("serif", Font.PLAIN, 20));
            add(label_emergency);

            JLabel data_emergency = new JLabel(emergency_contact);
            data_emergency.setFont(new Font("serif", Font.PLAIN, 20));
            data_emergency.setBounds(670,340,200,40);
            add(data_emergency);

            JLabel employment_detail = new JLabel("Employment Details");
            employment_detail.setBounds(340,400,400,50);
            employment_detail.setFont(new Font("serif", Font.BOLD, 23));
            add(employment_detail);

            JLabel label_id = new JLabel("Employee ID : ");
            label_id.setBounds(250,480,200,40);
            label_id.setFont(new Font("serif", Font.PLAIN, 20));
            add(label_id);

            JLabel data_id = new JLabel(employee_id);
            data_id.setFont(new Font("serif", Font.PLAIN, 20));
            data_id.setBounds(500,480,200,40);
            add(data_id);

            JLabel label_salary = new JLabel("Employee Salary : ");
            label_salary.setBounds(250,540,200,40);
            label_salary.setFont(new Font("serif", Font.PLAIN, 20));
            add(label_salary);

            JLabel data_salary= new JLabel(salary);
            data_salary.setFont(new Font("serif", Font.PLAIN, 20));
            data_salary.setBounds(500,540,200,40);
            add(data_salary);

            JLabel label_title = new JLabel("Employee Title : ");
            label_title.setBounds(250,600,200,40);
            label_title.setFont(new Font("serif", Font.PLAIN, 20));
            add(label_title);

            JLabel data_title = new JLabel(title);
            data_title.setFont(new Font("serif", Font.PLAIN, 20));
            data_title.setBounds(500,600,200,40);
            add(data_title);

            JLabel label_department = new JLabel("Employee Department : ");
            label_department.setBounds(250,660,200,40);
            label_department.setFont(new Font("serif", Font.PLAIN, 20));
            add(label_department);

            JLabel data_department = new JLabel(department);
            data_department.setFont(new Font("serif", Font.PLAIN, 20));
            data_department.setBounds(500,660,200,40);
            add(data_department);

            JLabel label_status= new JLabel("Employee Status : ");
            label_status.setBounds(250,720,200,40);
            label_status.setFont(new Font("serif", Font.PLAIN, 20));
            add(label_status);

            JLabel data_status = new JLabel(status);
            data_status.setFont(new Font("serif", Font.PLAIN, 20));
            data_status.setBounds(500,720,200,40);
            add(data_status);

        }catch (Exception e){
            e.printStackTrace();
        }

        back_btn = new JButton("BACK");
        back_btn.setBounds(320,790,200,45);
        back_btn.setFont(new Font("serif", Font.BOLD, 20));
        back_btn.setForeground(Color.BLACK);
        back_btn.setBackground(new Color(57, 167, 255));
        back_btn.addActionListener(this);
        add(back_btn);

        setLocation(350,30);
        setSize(900, 900);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back_btn) {
            new ViewEmployee();
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new ViewDetail("");

    }

}
