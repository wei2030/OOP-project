import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Student extends User{
    private String address;
    private String stdMatrix;
    private ArrayList<Course> courses;

    public Student(String fname, String lname, int age, String email, String address, String stdMatrix) {
        super(fname, lname, age, email);
        this.address = address;
        this.stdMatrix = stdMatrix;
        courses = new ArrayList<>();
    }

    public void setName(String fname, String lname) {
        this.name = new Name(fname, lname);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStdMatrix() {
        return stdMatrix;
    }

    public void setStdMatrix(String stdMatrix) {
        this.stdMatrix = stdMatrix;
    }

    public void register(Course c) {
        courses.add(c);
    }

    public void displayInformation() {
        JFrame frame = new JFrame("Student Information");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));

        StringBuilder sb = new StringBuilder();
        sb.append("Name       : ").append(name).append("\n");
        sb.append("Age        : ").append(age).append("\n");
        sb.append("Email      : ").append(email).append("\n");
        sb.append("Address    : ").append(address).append("\n");
        sb.append("Matric no. : ").append(stdMatrix).append("\n\n");

        if (courses.size() > 0) {
            sb.append("List of course(s) registered\n");
            sb.append("------------------------------\n");

            for (int i = 0; i < courses.size(); i++) {
                sb.append("[").append(i + 1).append("]").append(courses.get(i).toString1()).append("\n\n");
            }
        }

        textArea.setText(sb.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
        
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
