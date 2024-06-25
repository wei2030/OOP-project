import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Lecturer extends User {
    private String address;
    private String lectID;
    private String lectRoom;
    private ArrayList<Course> courses;
    
    public Lecturer(String fname, String lname, int age, String email, String address, String lectID, String lectRoom) {
        super(fname, lname, age, email);
        this.address = address;
        this.lectID = lectID;
        this.lectRoom = lectRoom;
        courses = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLectID() {
        return lectID;
    }

    public void setLectID(String lectID) {
        this.lectID = lectID;
    }

    public String getLectRoom() {
        return lectRoom;
    }

    public void setLectRoom(String lectRoom) {
        this.lectRoom = lectRoom;
    }

    public void register(Course c) {
        courses.add(c);
        c.setLecturer(this);
    }

    public void displayInformation() {
        JFrame frame = new JFrame("Lecturer Information");
        frame.setSize(600, 400);
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
        sb.append("Staff ID.  : ").append(lectID).append("\n");
        sb.append("Room no.   : ").append(lectRoom).append("\n");

        if (courses.size() > 0) {
            sb.append("\nList of course(s) registered\n");
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
