package employee.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Main extends JFrame implements ActionListener {

    JButton home_btn,add_employee_btn, view_employee_btn, graph_btn, logout_btn, add_performance_btn;

    int num_of_employee;

    Main() {

        // Create JPanel for heading section

        JPanel heading_panel = new JPanel();
        heading_panel.setLayout(null);
        heading_panel.setBounds(0,0,1000,150);
        heading_panel.setBackground(new Color(135,196,255));
        add(heading_panel);

        // Create employee logo in heading

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Images/emp-logo.png"));
        Image image1 = image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(image1);
        JLabel logo = new JLabel(image2);
        logo.setBounds(50,25,100,100);
        heading_panel.add(logo);

        // Create employee title

        JLabel title = new JLabel("OfficePilot");
        title.setFont(new Font("serif", Font.BOLD, 50));
        title.setBounds(180,20,400,100);
        heading_panel.add(title);

        // Create panel for displaying information

        JPanel totalEmp = new JPanel() {
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

        JPanel totalDepartment = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;

                Color startColor = new Color(221, 214, 243);
                Color endColor = new Color(250, 172, 168);

                GradientPaint gp = new GradientPaint(0, 0, startColor, 300, 150, endColor);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        // Get data from database, total employee

        try {
            Conn conn = new Conn();
            String query = "select count(*) from employeedetail";
            ResultSet resultSet = conn.statement.executeQuery(query);

            if(resultSet.next()) {
                num_of_employee = resultSet.getInt(1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        totalEmp.setBounds(150, 170, 350, 150);
        totalEmp.setSize(320,150);
        totalEmp.setLayout(new BorderLayout());
        add(totalEmp);

        totalDepartment.setBounds(530,170,350,150);
        totalDepartment.setSize(320,150);
        totalDepartment.setLayout(new BorderLayout());
        add(totalDepartment);

        ImageIcon employee = new ImageIcon(ClassLoader.getSystemResource("Images/emp-logo.png"));
        Image employee1 = employee.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon employee2 = new ImageIcon(employee1);
        JLabel employee_image = new JLabel(employee2);
        employee_image.setBorder(new EmptyBorder(20,20,20,20));
        totalEmp.add(employee_image, BorderLayout.WEST);

        JLabel total_employee = new JLabel("Total Employee : " + num_of_employee);
        total_employee.setFont(new Font("serif", Font.BOLD, 20));
        totalEmp.add(total_employee, BorderLayout.CENTER);

        ImageIcon house = new ImageIcon(ClassLoader.getSystemResource("Images/house.png"));
        Image house1 = house.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon house2 = new ImageIcon(house1);
        JLabel house_image = new JLabel(house2);
        house_image.setBorder(new EmptyBorder(20,20,20,20));
        totalDepartment.add(house_image, BorderLayout.WEST);

        JLabel total_department = new JLabel("Total Department : 7 ");
        total_department.setFont(new Font("serif", Font.BOLD, 20));
        totalDepartment.add(total_department, BorderLayout.CENTER);

        // Create panel for button to link to other pages

        JPanel main_panel = new JPanel();
        main_panel.setBounds(150,360,700,450);
        main_panel.setLayout(new GridLayout(2,3,20,20));
        add(main_panel);

        // Create 6 panels for 6 buttons inside the main panel

        JPanel home_panel = new JPanel();
        home_panel.setBackground(new Color(135,196,255));
        home_panel.setLayout(null);
        main_panel.add(home_panel);

        ImageIcon home_icon = new ImageIcon(ClassLoader.getSystemResource("Images/home.png"));
        Image home_icon1 = home_icon.getImage().getScaledInstance(130,100,Image.SCALE_DEFAULT);
        ImageIcon home_icon2 = new ImageIcon(home_icon1);
        JLabel home_icon_image = new JLabel(home_icon2);
        home_icon_image.setBounds(35,20,150,100);
        home_panel.add(home_icon_image);

        home_btn = new JButton("HOME");
        home_btn.setFont(new Font("serif", Font.PLAIN, 18));
        home_btn.setBounds(20,140,180,40);
        home_btn.setBackground(new Color(57, 167, 255));
        home_btn.addActionListener(this);
        home_panel.add(home_btn);

        JPanel add_employee_panel = new JPanel();
        add_employee_panel.setBackground(new Color(135,196,255));
        add_employee_panel.setLayout(null);
        main_panel.add(add_employee_panel);

        ImageIcon add_emp_icon = new ImageIcon(ClassLoader.getSystemResource("Images/add.png"));
        Image add_emp_icon1 = add_emp_icon.getImage().getScaledInstance(130,100,Image.SCALE_DEFAULT);
        ImageIcon add_emp_icon2 = new ImageIcon(add_emp_icon1);
        JLabel add_emp_icon_image = new JLabel(add_emp_icon2);
        add_emp_icon_image.setBounds(35,20,150,100);
        add_employee_panel.add(add_emp_icon_image);

        add_employee_btn = new JButton("ADD EMPLOYEE");
        add_employee_btn.setFont(new Font("serif", Font.PLAIN, 18));
        add_employee_btn.setBounds(20,140,180,40);
        add_employee_btn.setBackground(new Color(57, 167, 255));
        add_employee_btn.addActionListener(this);
        add_employee_panel.add(add_employee_btn);

        JPanel view_employee_panel = new JPanel();
        view_employee_panel.setBackground(new Color(135,196,255));
        view_employee_panel.setLayout(null);
        main_panel.add(view_employee_panel);

        ImageIcon add_view_icon = new ImageIcon(ClassLoader.getSystemResource("Images/view.png"));
        Image add_view_icon1 = add_view_icon.getImage().getScaledInstance(130,100,Image.SCALE_DEFAULT);
        ImageIcon add_view_icon2 = new ImageIcon(add_view_icon1);
        JLabel add_view_icon_image = new JLabel(add_view_icon2);
        add_view_icon_image.setBounds(35,20,150,100);
        view_employee_panel.add(add_view_icon_image);

        view_employee_btn = new JButton("VIEW EMPLOYEE");
        view_employee_btn.setFont(new Font("serif", Font.PLAIN, 18));
        view_employee_btn.setBounds(20,140,180,40);
        view_employee_btn.setBackground(new Color(57, 167, 255));
        view_employee_btn.addActionListener(this);
        view_employee_panel.add(view_employee_btn);

        JPanel add_performance_panel = new JPanel();
        add_performance_panel.setBackground(new Color(135,196,255));
        add_performance_panel.setLayout(null);
        main_panel.add(add_performance_panel);

        ImageIcon add_perf_icon = new ImageIcon(ClassLoader.getSystemResource("Images/performance.png"));
        Image add_perf_icon1 = add_perf_icon.getImage().getScaledInstance(130,100,Image.SCALE_DEFAULT);
        ImageIcon add_perf_icon2 = new ImageIcon(add_perf_icon1);
        JLabel add_perf_icon_image = new JLabel(add_perf_icon2);
        add_perf_icon_image.setBounds(35,20,150,100);
        add_performance_panel.add(add_perf_icon_image);

        add_performance_btn = new JButton("ADD REVIEW");
        add_performance_btn.setFont(new Font("serif", Font.PLAIN, 18));
        add_performance_btn.setBounds(20,140,180,40);
        add_performance_btn.setBackground(new Color(57, 167, 255));
        add_performance_btn.addActionListener(this);
        add_performance_panel.add(add_performance_btn);

        JPanel graph_panel = new JPanel();
        graph_panel.setBackground(new Color(135,196,255));
        graph_panel.setLayout(null);
        main_panel.add(graph_panel);

        ImageIcon graph_icon = new ImageIcon(ClassLoader.getSystemResource("Images/report.png"));
        Image graph_icon1 = graph_icon.getImage().getScaledInstance(130,100,Image.SCALE_DEFAULT);
        ImageIcon graph_icon2 = new ImageIcon(graph_icon1);
        JLabel graph_icon_image = new JLabel(graph_icon2);
        graph_icon_image.setBounds(35,20,150,100);
        graph_panel.add(graph_icon_image);

        graph_btn = new JButton("VIEW REPORT");
        graph_btn.setFont(new Font("serif", Font.PLAIN, 18));
        graph_btn.setBounds(20,140,180,40);
        graph_btn.setBackground(new Color(57, 167, 255));
        graph_btn.addActionListener(this);
        graph_panel.add(graph_btn);

        JPanel logout_panel= new JPanel();
        logout_panel.setBackground(new Color(135,196,255));
        logout_panel.setLayout(null);
        main_panel.add(logout_panel);

        ImageIcon logout_icon = new ImageIcon(ClassLoader.getSystemResource("Images/logout2.png"));
        Image logout_icon1 = logout_icon.getImage().getScaledInstance(130,100,Image.SCALE_DEFAULT);
        ImageIcon logout_icon2 = new ImageIcon(logout_icon1);
        JLabel logout_icon_image = new JLabel(logout_icon2);
        logout_icon_image.setBounds(35,20,150,100);
        logout_panel.add(logout_icon_image);

        logout_btn = new JButton("LOG OUT");
        logout_btn.setFont(new Font("serif", Font.PLAIN, 18));
        logout_btn.setBounds(20,140,180,40);
        logout_btn.setBackground(new Color(57, 167, 255));
        logout_btn.addActionListener(this);
        logout_panel.add(logout_btn);


        // Set frame
        setTitle("Employee Management System");
        setLocation(350,20);
        setSize(1000, 900);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home_btn) {
            new Main();
            setVisible(false);
        }
        else if (e.getSource() == add_employee_btn ) {
            new AddEmployee();
            setVisible(false);
        }
        else if (e.getSource() == view_employee_btn ) {
            new ViewEmployee();
            setVisible(false);
        }
        else if (e.getSource() == add_performance_btn ) {
            new AddPerformance();
            setVisible(false);
        }
        else if (e.getSource() == graph_btn ) {
            new Graph();
            setVisible(false);
        }
        else if (e.getSource() == logout_btn ) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new Main();

    }

}
