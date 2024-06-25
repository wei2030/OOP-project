import javax.swing.*;
import java.awt.*;

public class Admin extends User {

    public Admin(String fname, String lname, int age, String email) {
        super(fname, lname, age, email);
    }

    public void displayInformation() {
        JFrame frame = new JFrame("User Information");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));

        StringBuilder sb = new StringBuilder();
        sb.append("Name       : ").append(name).append("\n");
        sb.append("Age        : ").append(age).append("\n");
        sb.append("Email      : ").append(email).append("\n");

        textArea.setText(sb.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
    
}
