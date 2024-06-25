import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Course {
    private String name;
    private String code;
    private int creditHour;
    private Date slot;
    private Lecturer teachedBy;

    public Course(String name, String code, int creditHour, String day, String time) {
        this.name = name;
        this.code = code;
        this.creditHour = creditHour;
        this.slot = new Date(day, time);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tName: ").append(name).append("\n");
        sb.append("\t\t\tCourse code: ").append(code).append("\n");
        sb.append("\t\t\tCredit hour: ").append(creditHour).append("\n");
        sb.append("\t\t\tDay: ").append(slot.getDay()).append("\n");
        sb.append("\t\t\tTime: ").append(slot.getTime()).append("\n");
        sb.append("\t\t\tLecturer: ").append(getLecturer());
        return sb.toString();
    }

    public String toString1() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tName: ").append(name).append("\n");
        sb.append("\tCourse code: ").append(code).append("\n");
        sb.append("\tCredit hour: ").append(creditHour).append("\n");
        sb.append("\tDay: ").append(slot.getDay()).append("\n");
        sb.append("\tTime: ").append(slot.getTime()).append("\n");
        sb.append("\tLecturer: ").append(getLecturer());
        return sb.toString();
    }

    public static void displayAllCoursesInFrame(ArrayList<Course> courses) {
        JFrame frame = new JFrame("All Courses Information");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < courses.size(); i++) {
            sb.append("[").append(i + 1).append("] ").append(courses.get(i).toString1()).append("\n\n");
        }
        textArea.setText(sb.toString());

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    public String getSlot() {
        return (slot.getDay() + ", " + slot.getTime());
    }

    public String getLecturer() {
        if(teachedBy == null) {
            return null;
        }
        return teachedBy.getName();
    }

    public void setLecturer(Lecturer l) {
        teachedBy = l;
    }

    public void setDay(String day) {
        this.slot.setDay(day);
    }

    public void setTime(String time) {
        this.slot.setTime(time);
    }
}
