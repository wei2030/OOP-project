import java.util.ArrayList;

public class Slip {
    public static void generateSlip(Student user) {
            
        System.out.println("\n\n\t\t-------------------------------------------------");
        System.out.println("\t\tName: " + user.getName());
        System.out.println("\t\tAge: " + user.getAge());
        System.out.println("\t\tEmail: " + user.getEmail());
        System.out.println("\t\tAddress: " + user.getAddress());
        System.out.println("\t\tMatric no.: " + user.getStdMatrix());

        System.out.println("\n\n\t\t-------------------------------------------------");
        System.out.println("\t\tList of course(s) registered");
        System.out.println("\t\t------------------------------");

        ArrayList<Course> cour = user.getCourses();

        for(int i=0; i<cour.size(); i++) {

            System.out.print("\t\t[" + (i+1) + "]\t");
            System.out.println(cour.get(i));
            System.out.println();

        }

    }

    public static void generateSlip(Lecturer user) {
            
        System.out.println("\n\n\t\t-------------------------------------------------");
        System.out.println("\t\tName: " + user.getName());
        System.out.println("\t\tAge: " + user.getAge());
        System.out.println("\t\tEmail: " + user.getEmail());
        System.out.println("\t\tAddress: " + user.getAddress());
        System.out.println("\t\tStaff ID.: " + user.getLectID());
        System.out.println("\t\tRoom no.: " + user.getLectRoom());

        System.out.println("\n\n\t\t-------------------------------------------------");
        System.out.println("\t\tList of course(s) registered");
        System.out.println("\t\t------------------------------");

        ArrayList<Course> cour = user.getCourses();

        for(int i=0; i<cour.size(); i++) {

            System.out.print("\t\t[" + (i+1) + "]\t");
            System.out.println(cour.get(i));
            System.out.println();

        }

    }
}
