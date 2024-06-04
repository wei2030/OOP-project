public class Name {
    private String fname;
    private String lname;
    
    public Name(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    @Override
    public String toString() {
        return (fname + " " + lname);
    }
}
