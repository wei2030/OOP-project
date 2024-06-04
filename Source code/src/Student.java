import java.util.ArrayList;

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
        System.out.println("\n\t\tName       : " + name);
        System.out.println("\t\tAge        : " + age);
        System.out.println("\t\tEmail      : " + email);
        System.out.println("\t\tAddress    : " + address);
        System.out.println("\t\tMatric no. : " + stdMatrix);

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
}
