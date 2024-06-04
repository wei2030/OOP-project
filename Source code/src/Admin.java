public class Admin extends User {

    public Admin(String fname, String lname, int age, String email) {
        super(fname, lname, age, email);
    }

    public void displayInformation() {
        System.out.println("\n\n\t\tName       : " + name);
        System.out.println("\t\tAge        : " + age);
        System.out.println("\t\tEmail      : " + email);
    }
    
}
