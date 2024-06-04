public class User {
    protected Name name;
    protected int age;
    protected String email;
    
    public User(String fname, String lname, int age, String email) {
        this.name = new Name(fname, lname);
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name.toString();
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String fname, String lname) {
        this.name = new Name(fname, lname);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
