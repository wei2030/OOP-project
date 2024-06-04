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
        return ("Name: " + name + "\n\t\t\tCourse code: " + code + "\n\t\t\tCredit hour: " + creditHour + 
                "\n\t\t\tDay: " + slot.getDay() + "\n\t\t\tTime: " + slot.getTime() + "\n\t\t\tLecturer: " + getLecturer());
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
