import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Slip {
    public static void generateSlip(Student user) {
        
        JFrame frame = new JFrame("Student Information Slip");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        
        // Top Panel for Basic Information
        JPanel topPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        topPanel.add(new JLabel("Name:"));
        topPanel.add(new JLabel(user.getName()));
        topPanel.add(new JLabel("Age:"));
        topPanel.add(new JLabel(String.valueOf(user.getAge())));
        topPanel.add(new JLabel("Email:"));
        topPanel.add(new JLabel(user.getEmail()));
        topPanel.add(new JLabel("Address:"));
        topPanel.add(new JLabel(user.getAddress()));
        topPanel.add(new JLabel("Matric no.:"));
        topPanel.add(new JLabel(user.getStdMatrix()));

        panel.add(topPanel, BorderLayout.NORTH);
        
        // Table for Courses
        String[] columnNames = {"No.", "Course Code", "Course Name", "Credits", "Lecturer"};
        ArrayList<Course> courses = user.getCourses();
        Object[][] data = new Object[courses.size()][5];
        for (int i = 0; i < courses.size(); i++) {
            data[i][0] = i + 1;
            data[i][1] = courses.get(i).getCode();
            data[i][2] = courses.get(i).getName();
            data[i][3] = courses.get(i).getCreditHour();
            data[i][4] = courses.get(i).getLecturer();
        }
        
        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("List of Courses Registered"));
        panel.add(scrollPane, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.setVisible(true);

    }

    public static void generateSlip(Lecturer user) {
        
        JFrame frame = new JFrame("Lecturer Information Slip");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        
        // Top Panel for Basic Information
        JPanel topPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        topPanel.add(new JLabel("Name:"));
        topPanel.add(new JLabel(user.getName()));
        topPanel.add(new JLabel("Age:"));
        topPanel.add(new JLabel(String.valueOf(user.getAge())));
        topPanel.add(new JLabel("Email:"));
        topPanel.add(new JLabel(user.getEmail()));
        topPanel.add(new JLabel("Address:"));
        topPanel.add(new JLabel(user.getAddress()));
        topPanel.add(new JLabel("Staff ID:"));
        topPanel.add(new JLabel(user.getLectID()));
        topPanel.add(new JLabel("Room no.:"));
        topPanel.add(new JLabel(user.getLectRoom()));

        panel.add(topPanel, BorderLayout.NORTH);
        
        // Table for Courses
        String[] columnNames = {"No.", "Course Code", "Course Name", "Credits"};
        ArrayList<Course> courses = user.getCourses();
        Object[][] data = new Object[courses.size()][4];
        for (int i = 0; i < courses.size(); i++) {
            data[i][0] = i + 1;
            data[i][1] = courses.get(i).getCode();
            data[i][2] = courses.get(i).getName();
            data[i][3] = courses.get(i).getCreditHour();
        }
        
        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("List of Courses Registered"));
        panel.add(scrollPane, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
