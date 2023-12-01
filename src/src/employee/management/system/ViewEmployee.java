package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {

    JButton home_btn;
    JButton searchBtn1, updateBtn, viewDetailBtn, removeBtn, performanceBtn;

    Choice choice;
    JTable table;

    int num_of_full_time, num_of_cambodian;
    String performance;

    ViewEmployee() {

        try {

            Conn conn = new Conn();
            String query1 = "select count(status) from employeedetail where status = 'Full Time'";
            ResultSet resultSet = conn.statement.executeQuery(query1);

            if (resultSet.next()) {
                num_of_full_time = resultSet.getInt(1);
            }

            String query2 = "select count(nationality) from employeedetail where nationality = 'Cambodian' ";
            ResultSet resultSet2 = conn.statement.executeQuery(query2);

            if (resultSet2.next()) {
                num_of_cambodian = resultSet2.getInt(1);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        // Create two panels for the main frame
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        rightPanel.setBounds(0,0,250,800);
        rightPanel.setBackground(new Color(135,196,255));
        rightPanel.setLayout(null);
        add(rightPanel);

        leftPanel.setBounds(250,0,880,800);
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
        home_btn.setBounds(30,650,180,40);
        home_btn.setBackground(new Color(57, 167, 255));
        home_btn.addActionListener(this);
        rightPanel.add(home_btn);


        // Left panel

        JLabel heading = new JLabel("View Employee");
        heading.setFont(new Font("serif", Font.BOLD, 40));
        heading.setBounds(310,20,300,60);
        leftPanel.add(heading);

        JPanel totalFEmp = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;

                Color startColor = new Color(238, 156, 167);
                Color endColor = new Color(255, 221, 225);

                GradientPaint gp = new GradientPaint(0, 0, startColor, 0, 150, endColor);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        JPanel totalKh = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;

                Color startColor = new Color(238, 156, 167);
                Color endColor = new Color(255, 221, 225);

                GradientPaint gp = new GradientPaint(0, 0, startColor, 0, 150, endColor);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        totalFEmp.setBounds(65, 120, 300, 150);
        totalFEmp.setSize(300,150);
        totalFEmp.setLayout(new BorderLayout());
        leftPanel.add(totalFEmp);

        totalKh.setBounds(490,120,300,150);
        totalKh.setSize(300,150);
        totalKh.setLayout(new BorderLayout());
        leftPanel.add(totalKh);

        ImageIcon full_time = new ImageIcon(ClassLoader.getSystemResource("Images/full.png"));
        Image full_time1 = full_time.getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT);
        ImageIcon full_time2 = new ImageIcon(full_time1);
        JLabel full_time_image = new JLabel(full_time2);
        full_time_image.setBorder(new EmptyBorder(20,20,20,20));
        totalFEmp.add(full_time_image, BorderLayout.WEST);

        JLabel total_full_time = new JLabel("Full-Time : " + num_of_full_time);
        total_full_time.setFont(new Font("serif", Font.BOLD, 18));
        totalFEmp.add(total_full_time, BorderLayout.CENTER);

        ImageIcon nationality = new ImageIcon(ClassLoader.getSystemResource("Images/nationality.png"));
        Image nationality1 = nationality.getImage().getScaledInstance(115,115,Image.SCALE_DEFAULT);
        ImageIcon nationality2 = new ImageIcon(nationality1);
        JLabel nationality_image = new JLabel(nationality2);
        nationality_image.setBorder(new EmptyBorder(20,20,20,20));
        totalKh.add(nationality_image, BorderLayout.WEST);

        JLabel total_cambodian = new JLabel("Cambodian : " + num_of_cambodian);
        total_cambodian.setFont(new Font("serif", Font.BOLD, 18));
        totalKh.add(total_cambodian, BorderLayout.CENTER);


        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select name, gender, salary, empID, title from employeedetail");

            // Convert ResultSet to a DefaultTableModel
            DefaultTableModel model = (DefaultTableModel) DbUtils.resultSetToTableModel(resultSet);

            // Set custom column headings
            String[] columnHeadings = {"Employee Name", "Gender", "Salary", "Employee ID", "Title"};
            model.setColumnIdentifiers(columnHeadings);

            // Set the modified model to the JTable
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create JScrollPane with vertical and horizontal scrollbars
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(62, 480, 738, 250);
        leftPanel.add(jp);

        JLabel search = new JLabel("Search by Employee's Name : ");
        search.setBounds(65,300,400,30);
        search.setFont(new Font("serif", Font.PLAIN, 20));
        leftPanel.add(search);

        choice = new Choice();
        choice.setBounds(65,355,200,50);
        choice.setFont(new Font("serif", Font.PLAIN, 18));
        choice.setSize(200,50);
        leftPanel.add(choice);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employeedetail");
            while (resultSet.next()) {
                choice.add(resultSet.getString("name"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        searchBtn1 = new JButton("Search");
        searchBtn1.setBounds(65,415,110,35);
        searchBtn1.setFont(new Font("serif", Font.BOLD, 20));
        searchBtn1.setBackground(new Color(57, 167, 255));
        searchBtn1.setForeground(Color.BLACK);
        searchBtn1.addActionListener(this);
        leftPanel.add(searchBtn1);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(220,415,110,35);
        updateBtn.setFont(new Font("serif", Font.BOLD, 20));
        updateBtn.setBackground(new Color(57, 167, 255));
        updateBtn.setForeground(Color.BLACK);
        updateBtn.addActionListener(this);
        leftPanel.add(updateBtn);

        viewDetailBtn = new JButton("Detail");
        viewDetailBtn.setBounds(375,415,110,35);
        viewDetailBtn.setFont(new Font("serif", Font.BOLD, 20));
        viewDetailBtn.setBackground(new Color(57, 167, 255));
        viewDetailBtn.setForeground(Color.BLACK);
        viewDetailBtn.addActionListener(this);
        leftPanel.add(viewDetailBtn);

        removeBtn = new JButton("Remove");
        removeBtn.setBounds(535,415,110,35);
        removeBtn.setFont(new Font("serif", Font.BOLD, 20));
        removeBtn.setBackground(new Color(57, 167, 255));
        removeBtn.setForeground(Color.BLACK);
        removeBtn.addActionListener(this);
        leftPanel.add(removeBtn);

        performanceBtn = new JButton("Review");
        performanceBtn.setBounds(690,415,110,35);
        performanceBtn.setFont(new Font("serif", Font.BOLD, 20));
        performanceBtn.setBackground(new Color(57, 167, 255));
        performanceBtn.setForeground(Color.BLACK);
        performanceBtn.addActionListener(this);
        leftPanel.add(performanceBtn);


        // Set frame
        setTitle("Employee Management System");
        setLocation(350,50);
        setSize(1130, 800);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == searchBtn1) {
            String query = "select name, gender, empID, salary, title from employeedetail where name = '"+choice.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);

                // Convert ResultSet to a DefaultTableModel
                DefaultTableModel model = (DefaultTableModel) DbUtils.resultSetToTableModel(resultSet);

                // Set custom column headings
                String[] columnHeadings = {"Employee Name", "Gender", "Salary", "Employee ID", "Title"};
                model.setColumnIdentifiers(columnHeadings);

                // Set the modified model to the JTable
                table.setModel(model);
            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else if (e.getSource() == updateBtn) {
            setVisible(false);
            new UpdateEmployee(choice.getSelectedItem());
        }

        else if (e.getSource() == viewDetailBtn) {
            new ViewDetail(choice.getSelectedItem());
        }
        else if (e.getSource() == removeBtn) {

            int result;

            result = JOptionPane.showConfirmDialog(null, "Do you want to remove this employee? ", "Confirmation", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                try {
                    Conn c = new Conn();
                    String query = "delete from employeedetail where name = '"+choice.getSelectedItem()+"'";
                    c.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Employee Deleted Successfully");
                    setVisible(false);
                    new ViewEmployee();

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
            else if (result == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null,"Operation canceled");
            }
        }
        else if (e.getSource() == performanceBtn) {

            try {

                Conn conn = new Conn();
                String query = "select count(*) from employeesystem.employee_performace where emp_name = '"+choice.getSelectedItem()+"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()) {
                    int count;
                    count = resultSet.getInt(1);
                    if (count > 0 ) {
                        String query1 = "select emp_review from employeesystem.employee_performace where emp_name = '"+choice.getSelectedItem()+"'";
                        ResultSet resultSet1 = conn.statement.executeQuery(query1);
                        if (resultSet1.next()) {
                            performance = resultSet1.getString(1);
                            String text = choice.getSelectedItem() + " performance is " + performance;
                            JOptionPane.showMessageDialog(null, text);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Employee Performance has not yet been added!!!");
                    }
                }

            }catch (Exception E) {
                E.printStackTrace();
            }
        }

        if (e.getSource() == home_btn) {
            new Main();
            setVisible(false);
        }

    }

    public static void main(String[] args) {

        new ViewEmployee();

    }

}
