package employee.management.system;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Graph extends JFrame implements ActionListener {

    int num_female, num_male, num_employee;
    int num_it, num_hr, num_service, num_security, num_management, num_stock, num_finance;
    int num_associate, num_bachelor, num_master, num_doctoral;

    JButton back_btn;

    public Graph() {
        try {
            Conn conn = new Conn();

            String query1 = "select count(gender) from employeedetail where gender = 'Female'";
            ResultSet resultSet1 = conn.statement.executeQuery(query1);
            if (resultSet1.next()) {
                num_female = resultSet1.getInt(1);
            }

            String query2 = "select count(gender) from employeedetail where gender = 'Male'";
            ResultSet resultSet2 = conn.statement.executeQuery(query2);
            if (resultSet2.next()) {
                num_male = resultSet2.getInt(1);
            }

            // Calculate percentages
            DefaultPieDataset dataset1 = getDefaultPieDataset();

            String emp_query = "select count(*) from employeedetail";
            ResultSet resultSetEmp = conn.statement.executeQuery(emp_query);
            if (resultSetEmp.next()) {
                num_employee = resultSetEmp.getInt(1);
            }

            DefaultPieDataset dataset2 = new DefaultPieDataset();
            dataset2.setValue("Employee (" + num_employee + ")", num_employee);

            String it_query = "SELECT department, COUNT(*) AS it_depart FROM employeedetail WHERE department = 'IT'";
            ResultSet resultSetIt = conn.statement.executeQuery(it_query);
            if (resultSetIt.next()) {
                num_it = resultSetIt.getInt("it_depart");
            }

            String hr_query = "SELECT department, COUNT(*) AS hr_depart FROM employeedetail WHERE department = ' HR'";
            ResultSet resultSetHr = conn.statement.executeQuery(hr_query);
            if (resultSetHr.next()) {
                num_hr = resultSetHr.getInt("hr_depart");
            }

            String service_query = "SELECT department, COUNT(*) AS service_depart FROM employeedetail WHERE department = ' Service '";
            ResultSet resultSetService = conn.statement.executeQuery(service_query);
            if (resultSetService.next()) {
                num_service = resultSetService.getInt("service_depart");
            }

            String security_query = "SELECT department, COUNT(*) AS security_depart FROM employeedetail WHERE department = ' Security'";
            ResultSet resultSetSecurity = conn.statement.executeQuery(security_query);
            if (resultSetSecurity.next()) {
                num_security = resultSetSecurity.getInt("security_depart");
            }

            String finance_query = "SELECT department, COUNT(*) AS finance_depart FROM employeedetail WHERE department = ' Finance '";
            ResultSet resultSetFinance = conn.statement.executeQuery(finance_query);
            if (resultSetFinance.next()) {
                num_finance = resultSetFinance.getInt("finance_depart");
            }

            String management_query = "SELECT department, COUNT(*) AS management_depart FROM employeedetail WHERE department = ' Management '";
            ResultSet resultSetManagement = conn.statement.executeQuery(management_query);
            if (resultSetManagement.next()) {
                num_management = resultSetManagement.getInt("management_depart");
            }

            String stock_query = "SELECT department, COUNT(*) AS stock_depart FROM employeedetail WHERE department = ' Stock'";
            ResultSet resultSetStock = conn.statement.executeQuery(stock_query);
            if (resultSetStock.next()) {
                num_stock = resultSetStock.getInt("stock_depart");
            }

            String associate_query = "SELECT emp_degree, COUNT(*) AS associate_degree FROM employeesystem.employee_performace WHERE emp_degree = 'Associate'";
            ResultSet resultSetAssociate = conn.statement.executeQuery(associate_query);
            if (resultSetAssociate.next()) {
                num_associate = resultSetAssociate.getInt("associate_degree");
            }

            String bachelor_query = "SELECT emp_degree, COUNT(*) AS bachelor_degree FROM employeesystem.employee_performace WHERE emp_degree = 'Bachelor'";
            ResultSet resultSetBachelor = conn.statement.executeQuery(bachelor_query);
            if (resultSetBachelor.next()) {
                num_bachelor = resultSetBachelor.getInt("bachelor_degree");
            }

            String master_query = "SELECT emp_degree, COUNT(*) AS master_degree FROM employeesystem.employee_performace WHERE emp_degree = 'Master'";
            ResultSet resultSetMaster = conn.statement.executeQuery(master_query);
            if (resultSetMaster.next()) {
                num_master = resultSetMaster.getInt("master_degree");
            }

            String doctoral_query = "SELECT emp_degree, COUNT(*) AS doctoral_degree FROM employeesystem.employee_performace WHERE emp_degree = 'Doctoral'";
            ResultSet resultSetDoctoral = conn.statement.executeQuery(doctoral_query);
            if (resultSetDoctoral.next()) {
                num_doctoral = resultSetDoctoral.getInt("doctoral_degree");
            }

            DefaultCategoryDataset departmentDataset = getDefaultCategoryDataset();

            DefaultCategoryDataset degreeDataset = new DefaultCategoryDataset();
            degreeDataset.addValue(num_associate, "Associate", "Associate");
            degreeDataset.addValue(num_bachelor, "Bachelor", "Bachelor");
            degreeDataset.addValue(num_master, "Master", "Master");
            degreeDataset.addValue(num_doctoral, "Doctoral", "Doctoral");

            // Create bar chart for educational degree distribution
            JFreeChart degreeChart = ChartFactory.createBarChart(
                    "Employee Educational Degree Distribution",
                    "Degree",
                    "Number of Employees",
                    degreeDataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );

            // Create bar chart for department distribution
            JFreeChart departmentChart = ChartFactory.createBarChart(
                    "Employee Department Distribution",
                    "Department",
                    "Number of Employees",
                    departmentDataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );


            // Create charts
            JFreeChart chart1 = ChartFactory.createPieChart(
                    "Employee Gender Distribution",  // chart title
                    dataset1,
                    true,  // include legend
                    true,
                    false);

            JFreeChart chart2 = ChartFactory.createPieChart(
                    "Number of Employee",  // chart title
                    dataset2,
                    true,  // include legend
                    true,
                    false);

            // Set the background color of the charts
            chart1.setBackgroundPaint(Color.white);
            chart2.setBackgroundPaint(Color.white);
            departmentChart.setBackgroundPaint(Color.white);
            degreeChart.setBackgroundPaint(Color.white);


            // Create Panels
            ChartPanel chartPanel1 = new ChartPanel(chart1);
            chartPanel1.setPreferredSize(new Dimension(400, 300));

            ChartPanel chartPanel2 = new ChartPanel(chart2);
            chartPanel2.setPreferredSize(new Dimension(400, 300));

            ChartPanel chartPanel3 = new ChartPanel(departmentChart);
            chartPanel3.setPreferredSize(new Dimension(600,400));

            ChartPanel chartPanel4 = new ChartPanel(degreeChart);
            chartPanel4.setPreferredSize(new Dimension(600,400));


            // Create a panel to hold the charts
            JPanel chartsPanel = new JPanel(new GridLayout(2, 2));
            chartsPanel.add(chartPanel1);
            chartsPanel.add(chartPanel2);
            chartsPanel.add(chartPanel3);
            chartsPanel.add(chartPanel4);

            // Create a panel to hold chartsPanel and the BACK button
            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(chartsPanel, BorderLayout.CENTER);

            // Create a panel for the "BACK" button and center it
            JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            back_btn = new JButton("BACK");
            back_btn.setFont(new Font("serif", Font.BOLD, 20));
            back_btn.setForeground(Color.BLACK);
            back_btn.setBackground(new Color(57, 167, 255));
            back_btn.addActionListener(this);
            backButtonPanel.add(back_btn);

            mainPanel.add(backButtonPanel, BorderLayout.SOUTH);

            // Add the panel to the frame
            setContentPane(mainPanel);

        } catch (Exception e) {
            e.printStackTrace();
        }


        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private DefaultPieDataset getDefaultPieDataset() {
        int total = num_female + num_male;
        double percentage_female = (double) num_female / total * 100;
        double percentage_male = (double) num_male / total * 100;

        // Create datasets
        DefaultPieDataset dataset1 = new DefaultPieDataset();
        dataset1.setValue("Female (" + String.format("%.1f", percentage_female) + "%)", num_female);
        dataset1.setValue("Male (" + String.format("%.1f", percentage_male) + "%)", num_male);
        return dataset1;
    }

    private DefaultCategoryDataset getDefaultCategoryDataset() {
        DefaultCategoryDataset departmentDataset = new DefaultCategoryDataset();
        departmentDataset.addValue(num_it, "IT", "IT");
        departmentDataset.addValue(num_hr, "HR", "HR");
        departmentDataset.addValue(num_service, "Service", "Service");
        departmentDataset.addValue(num_security, "Security", "Security");
        departmentDataset.addValue(num_finance, "Finance", "Finance");
        departmentDataset.addValue(num_management, "Management", "Management");
        departmentDataset.addValue(num_stock, "Stock", "Stock");
        return departmentDataset;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back_btn) {
            new Main();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Graph());
    }


}
