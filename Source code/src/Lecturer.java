import java.util.ArrayList;

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
        System.out.println("\n\n\t\tName       : " + name);
        System.out.println("\t\tAge        : " + age);
        System.out.println("\t\tEmail      : " + email);
        System.out.println("\t\tAddress    : " + address);
        System.out.println("\t\tStaff ID.  : " + lectID);
        System.out.println("\t\tRoom no.   : " + lectRoom);

        if(courses.size() > 0) {
            System.out.println("\n\t\tList of course(s) registered");
            System.out.println("\t\t------------------------------");

            for(int i=0; i<courses.size(); i++) {
                System.out.print("\t\t[" + (i+1) + "]\t");
                System.out.println(courses.get(i));
                System.out.println();                
            }
        }
        
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
