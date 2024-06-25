import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CourseRegisteration {

    public static void adminMenu(ArrayList<Student> stud, ArrayList<Lecturer> lect, ArrayList<Course> cour, Admin ad) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int choice;

        do {

            do {

                System.out.println("\n\n\n\n\t\tAdmin Menu");
                System.out.println("\t\t------------------------------");
                System.out.println("\t\t1. Display admin information");
                System.out.println("\t\t2. Display list of course(s)");
                System.out.println("\t\t3. Add course");
                System.out.println("\t\t4. Remove course");
                System.out.println("\t\t5. Update course");
                System.out.println("\t\t6. Back to login page");

                System.out.print("\n\n\t\tPlease enter your option: ");
                choice = input.nextInt();
                input.nextLine(); //clear buffer

                if(choice == 6) {

                    login(stud,lect,cour);
                    input.close();
                    return;

                }

            } while(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);

            switch(choice) {

                case 1:

                    ad.displayInformation();
                    break;

                case 2:

                    System.out.println("\n\n\t\tList of Course(s)");
                    System.out.println("\t\t---------------------");

                    if(cour.size() == 0) {

                        System.out.println("\n\t\tNo course added");
                        break;

                    } else {
                        Course.displayAllCoursesInFrame(cour);
                    }

                    break;

                case 3:

                    System.out.println("\n\n\t\tAdd course");
                    System.out.println("\t\t--------------------");

                    System.out.print("\t\tEnter course name: ");
                    String name = input.nextLine();

                    System.out.print("\t\tEnter course code: ");
                    String code = input.nextLine();

                    System.out.print("\t\tEnter credit hour: ");
                    int credit = input.nextInt();
                    input.nextLine(); // clear buffer

                    System.out.print("\t\tEnter day of lecture: ");
                    String day = input.nextLine();

                    System.out.print("\t\tEnter time of lecture on " + day + " (HH:MM): ");
                    String time = input.nextLine();

                    cour.add(new Course(name, code, credit, day, time));

                    break;
                
                case 4:

                    System.out.println("\n\n\t\tRemove course");
                    System.out.println("\t\t---------------------");

                    System.out.println("\n\n\t\tList of Course(s)");
                    System.out.println("\t\t---------------------");

                    if(cour.size() == 0) {

                        System.out.println("\n\t\tNo course added");
                        break;

                    } else {

                        for(int i=0; i<cour.size(); i++) {
                            System.out.print("\t\t[" + (i) + "]");
                            System.out.println(cour.get(i));
                            System.out.println();
                        }

                    }

                    System.out.print("\n\n\t\tPlease enter index to be delete: ");
                    int rmv = input.nextInt();

                    cour.remove(rmv);
                    
                    break;

                case 5:

                    System.out.println("\n\n\t\tUpdate course");
                    System.out.println("\t\t---------------------");
                    System.out.println("\n\n\t\tList of Course(s)");
                    System.out.println("\t\t---------------------");

                    if(cour.size() == 0) {

                        System.out.println("\n\t\tNo course added");
                        break;

                    } else {

                        for(int i=0; i<cour.size(); i++) {
                            System.out.print("\t\t[" + (i) + "]");
                            System.out.println(cour.get(i));
                            System.out.println();
                        }

                    }

                    System.out.print("\n\n\t\tPlease enter index to be update: ");
                    int update = input.nextInt();
                    input.nextLine(); // clear buffer

                    int edit;

                    do {

                        do {

                            System.out.println("\n\n\n\t\tWhich detail would you like to edit?");
                            System.out.println("\t\t------------------------------");
                            System.out.println("\t\t1. Edit course name");
                            System.out.println("\t\t2. Edit course code");
                            System.out.println("\t\t3. Edit credit hour");
                            System.out.println("\t\t4. Edit slot(day)");
                            System.out.println("\t\t5. Edit slot(time)");
                            System.out.println("\t\t6. Back to menu page");

                            System.out.print("\n\n\t\tPlease enter your option: ");
                            edit = input.nextInt();
                            input.nextLine(); // clear buffer

                            if(edit == 6) {

                                break;
            
                            }

                        } while(edit != 1 && edit != 2 && edit != 3 && edit != 4 && edit != 5);
                        
                        switch(edit){
                            
                            case 1:

                                System.out.print("\n\n\t\tEnter new course name: ");
                                String updname = input.nextLine();
                                cour.get(update).setName(updname);
                                break;
                                
                            case 2:

                                System.out.print("\n\n\t\tEnter new course code: ");
                                String updcode = input.nextLine();
                                cour.get(update).setCode(updcode);
                                break;

                            case 3:

                                System.out.print("\n\n\t\tEnter new credit hour: ");
                                int updCredit = input.nextInt();
                                input.nextLine(); // clear buffer
                                cour.get(update).setCreditHour(updCredit);
                                break;

                            case 4:

                                System.out.print("\n\n\t\tEnter new day of lecture: ");
                                String updday = input.nextLine();
                                cour.get(update).setDay(updday);
                                break;

                            case 5:

                                System.out.print("\n\n\t\tEnter new time of lecture (HH:MM): ");
                                String updtime = input.nextLine();
                                cour.get(update).setDay(updtime);
                                break;
                                
                        }

                    } while(edit == 1 || edit == 2 || edit == 3 || edit == 4 || edit == 5);

                    break;

            }

        } while(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5);

        input.close();

    }

    public static void adminLogin(ArrayList<Student> stud, ArrayList<Lecturer> lect, ArrayList<Course> cour) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        boolean login = false;

        do {

            System.out.print("\n\n\t\tEnter username: ");
            String username = input.nextLine();

            if(username.equals("hanwei")) {

                System.out.print("\t\tEnter password: ");
                String password = input.nextLine();

                if(password.equals("abc123")) {
                    login = true;
                }

            } else {

                int retry;

                do {

                    System.out.println("\n\n\t\tDo you wish to retry");
                    System.out.println("\t\t[1] Retry");
                    System.out.println("\t\t[2] Back to login page");
                    
                    System.out.print("\n\t\tYour choice: ");
                    retry = input.nextInt();

                } while(retry != 1 && retry != 2);

                if(retry == 2) {

                    login(stud,lect,cour);
                    input.close();
                    return;
                }
            }

        } while(!login);

        Admin admin = new Admin("Han", "Wei", 30, "soh.wei@graduate.utm.my");

        adminMenu(stud,lect,cour,admin);

        input.close();
    }

    public static void lecturerMenu(ArrayList<Student> stud, ArrayList<Lecturer> lect, ArrayList<Course> cour, Lecturer lec) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int choice;

        do {

            do {
                System.out.println("\n\n\n\n\t\tLecturer Menu");
                System.out.println("\t\t------------------------------");
                System.out.println("\t\t1. Display lecturer information");
                System.out.println("\t\t2. Edit lecturer profile");
                System.out.println("\t\t3. Register a course");
                System.out.println("\t\t4. Generate course registration slip");
                System.out.println("\t\t5. Back to login page");

                System.out.print("\n\n\t\tPlease enter your option: ");
                choice = input.nextInt();
                input.nextLine(); // clear buffer

                if(choice == 5) {

                    login(stud,lect,cour);
                    input.close();
                    return;

                }

            } while(choice != 1 && choice != 2 && choice != 3 && choice != 4);

            switch(choice) {

                case 1:

                    lec.displayInformation();
                    break;

                case 2:

                    int edit;

                    do {

                        do {

                            System.out.println("\n\n\n\t\tWhich detail would you like to edit?");
                            System.out.println("\t\t------------------------------");
                            System.out.println("\t\t1. Edit name");
                            System.out.println("\t\t2. Edit age");
                            System.out.println("\t\t3. Edit address");
                            System.out.println("\t\t4. Edit lecturer id");
                            System.out.println("\t\t5. Edit room no.");
                            System.out.println("\t\t6. Back to menu page");

                            System.out.print("\n\n\t\tPlease enter your option: ");
                            edit = input.nextInt();
                            input.nextLine(); // clear buffer

                            if(edit == 6) {

                                break;
            
                            }

                        } while(edit != 1 && edit != 2 && edit != 3 && edit != 4 && edit != 5);
                        
                        switch(edit){
                            
                            case 1:

                                System.out.print("\n\n\t\tEnter new first name: ");
                                String fname = input.nextLine();
                                System.out.print("\t\tEnter new last name: ");
                                String lname = input.nextLine();
                                lec.setName(fname,lname);
                                break;
                                
                            case 2:

                                System.out.print("\n\n\t\tEnter new age: ");
                                int age = input.nextInt();
                                input.nextLine(); // clear buffer
                                lec.setAge(age);
                                break;

                            case 3:

                                System.out.print("\n\n\t\tEnter new address: ");
                                String address = input.nextLine();
                                lec.setAddress(address);
                                break;

                            case 4:

                                System.out.print("\n\n\t\tEnter new lecturer id: ");
                                String matric = input.nextLine();
                                lec.setLectID(matric);
                                break;

                            case 5:

                                System.out.print("\n\n\t\tEnter new room no: ");
                                String room = input.nextLine();
                                lec.setLectRoom(room);
                                break;
                                
                        }

                    } while(edit == 1 || edit == 2 || edit == 3 || edit == 4 || edit == 5);
                    
                    break;
                
                case 3:

                    System.out.printf("\n\n\t\t%-4s%-8s%-10s%-13s%-20s\n","No","Name","Code","Credit hour","Slot(s)");
                    System.out.printf("\t\t%-4s%-8s%-10s%-13s%-20s\n","--","----","----","-----------","-------");

                    if(cour.size() == 0) {

                        System.out.println("\n\t\tNo course added...");

                    } else {

                        for(int i=0; i<cour.size(); i++) {
                            
                            Course c = cour.get(i);
                            if(c.getLecturer() == null) {
                                System.out.printf("\t\t%-4d%-8s%-10s%-13d%-20s\n",(i),c.getName(),c.getCode(),c.getCreditHour(),c.getSlot());
                            }

                        }

                        int indexCourse;
                        
                        do {

                            System.out.print("\n\t\tSelect course to teach: ");
                            indexCourse = input.nextInt();

                        } while(indexCourse < 0 || indexCourse > cour.size());

                        lec.register(cour.get(indexCourse));

                    }

                    break;

                case 4:
                    Slip.generateSlip(lec);
                    break;

            }

        } while(choice == 1 || choice == 2 || choice == 3 || choice == 4);

        input.close();

    }

    public static void lecturerLogin(ArrayList<Student> stud, ArrayList<Lecturer> lect, ArrayList<Course> cour) throws FileNotFoundException {

        String emailInput = JOptionPane.showInputDialog("Enter EMAIL:");

        if(emailInput == null) {

            login(stud,lect,cour);
            return;
    
        } else {

            Lecturer l = null;

            for(int i=0; i<lect.size(); i++) {

                if(lect.get(i).getEmail().equals(emailInput)) {

                    l = lect.get(i);
                    break;

                }

            }

            if(l == null) {

                login(stud,lect,cour);
                return;

            } else {

                lecturerMenu(stud,lect,cour,l);

            }

        }

    }

    public static void studentMenu(ArrayList<Student> stud, ArrayList<Lecturer> lect, ArrayList<Course> cour,Student stu) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int choice;

        do {

            do {

                System.out.println("\n\n\n\n\t\tStudent Menu");
                System.out.println("\t\t------------------------------");
                System.out.println("\t\t1. Display student information");
                System.out.println("\t\t2. Edit student profile");
                System.out.println("\t\t3. Register a course");
                System.out.println("\t\t4. Generate course registration slip");
                System.out.println("\t\t5. Back to login page");

                System.out.print("\n\n\t\tPlease enter your option: ");
                choice = input.nextInt();
                input.nextLine(); // clear buffer

                if(choice == 5) {

                    login(stud,lect,cour);
                    input.close();
                    return;

                }

            } while(choice != 1 && choice != 2 && choice != 3 && choice != 4);

            switch(choice) {

                case 1:

                    stu.displayInformation();
                    break;

                case 2:

                    int edit;

                    do {

                        do {

                            System.out.println("\n\n\n\t\tWhich detail would you like to edit?");
                            System.out.println("\t\t------------------------------");
                            System.out.println("\t\t1. Edit name");
                            System.out.println("\t\t2. Edit age");
                            System.out.println("\t\t3. Edit address");
                            System.out.println("\t\t4. Edit matric no.");
                            System.out.println("\t\t5. Back to menu page");

                            System.out.print("\n\n\t\tPlease enter your option: ");
                            edit = input.nextInt();
                            input.nextLine(); // clear buffer

                            if(edit == 5) {

                                break;
            
                            }

                        } while(edit != 1 && edit != 2 && edit != 3 && edit != 4);
                        
                        switch(edit){
                            
                            case 1:

                                System.out.print("\n\n\t\tEnter new first name: ");
                                String fname = input.nextLine();
                                System.out.print("\t\tEnter new last name: ");
                                String lname = input.nextLine();
                                stu.setName(fname,lname);
                                break;
                                
                            case 2:

                                System.out.print("\n\n\t\tEnter new age: ");
                                int age = input.nextInt();
                                input.nextLine(); // clear buffer
                                stu.setAge(age);
                                break;

                            case 3:

                                System.out.print("\n\n\t\tEnter new address: ");
                                String address = input.nextLine();
                                stu.setAddress(address);
                                break;

                            case 4:

                                System.out.print("\n\n\t\tEnter new matric no: ");
                                String matric = input.nextLine();
                                stu.setStdMatrix(matric);
                                break;
                                
                        }

                    } while(edit == 1 || edit == 2 || edit == 3 || edit == 4);
                    
                    break;
                
                case 3:

                    System.out.printf("\n\n\t\t%-4s%-8s%-10s%-13s%-20s%-15s\n","No","Name","Code","Credit hour","Slot(s)","Lecturer");
                    System.out.printf("\t\t%-4s%-8s%-10s%-13s%-20s%-15s\n","--","----","----","-----------","-------","--------");

                    if(cour.size() == 0) {

                        System.out.println("\n\t\tNo course added...");

                    } else {

                        for(int i=0; i<cour.size(); i++) {

                            Course c = cour.get(i);
                            System.out.printf("\t\t%-4d%-8s%-10s%-13d%-20s",(i),c.getName(),c.getCode(),c.getCreditHour(),c.getSlot());

                            if(c.getLecturer() == null) {

                                System.out.printf("%-15s\n", "");

                            } else {

                                System.out.printf("%-15s\n", c.getLecturer());

                            }

                        }

                        int indexCourse;
                        
                        do {

                            System.out.print("\n\n\t\tSelect course to register [0-" + cour.size() + "]: ");
                            indexCourse = input.nextInt();

                        } while(indexCourse < 0 || indexCourse > cour.size());

                        stu.register(cour.get(indexCourse));
                    }

                    break;
                
                case 4:
                    Slip.generateSlip(stu);
                    break;

            }

        } while(choice == 1 || choice == 2 || choice == 3 || choice == 4);

        input.close();

    }

    public static void studentLogin(ArrayList<Student> stud, ArrayList<Lecturer> lect, ArrayList<Course> cour) throws FileNotFoundException {

        String emailInput = JOptionPane.showInputDialog("Enter EMAIL:");

        if(emailInput == null) {

            login(stud,lect,cour);
            return;
    
        } else {

            Student s = null;

            for(int i=0; i<stud.size(); i++) {

                if(stud.get(i).getEmail().equals(emailInput)) {

                    s = stud.get(i);
                    break;

                }

            }

            if(s == null) {

                login(stud,lect,cour);
                return;

            } else {

                studentMenu(stud,lect,cour,s);

            }

        }

    }

    public static void login(ArrayList<Student> stud, ArrayList<Lecturer> lect, ArrayList<Course> cour) throws FileNotFoundException {

        String c;
        int choice;

        do {

            c = JOptionPane.showInputDialog("WHO ARE YOU?\n1. STUDENT\n2. LECTURER\n3. ADMIN\n4. EXIT\n\nYOUR CHOICE ->");
            choice = Integer.parseInt(c);

            if(choice == 4) {

                JOptionPane.showMessageDialog(null, "Thank you for choosing us!");
                System.exit(4);

            }

        } while(choice != 1 && choice != 2 && choice != 3);

        if(choice == 1) {

            studentLogin(stud,lect,cour);

        } else if(choice == 2) {

            lecturerLogin(stud,lect,cour);

        } else {

            adminLogin(stud,lect,cour);

        }

    }

    public static void loadAll(ArrayList<Student> stud, ArrayList<Lecturer> lect, ArrayList<Course> cour) throws FileNotFoundException {

        if(stud.size() > 0) {
            stud.clear();
        }

        if(lect.size() > 0) {
            lect.clear();
        }

        if(cour.size() > 0) {
            cour.clear();
        }

        Scanner readStudents = new Scanner(new File("Student.txt"));
        Scanner readLecturers = new Scanner(new File("Lecturer.txt"));
        Scanner readCourses = new Scanner(new File("Courses.txt"));

        while(readStudents.hasNextLine()) {

            String studentLine = readStudents.nextLine();

            Scanner readStudentLine = new Scanner(studentLine);
            readStudentLine.useDelimiter(" ");

            String email = readStudentLine.next();
            String fname = readStudentLine.next();
            String lname = readStudentLine.next();
            int age = readStudentLine.nextInt();
            String matrix = readStudentLine.next();
            String address = readStudentLine.nextLine().trim();

            readStudentLine.close();

            stud.add(new Student(fname, lname, age, email, address, matrix));

        }

        while(readLecturers.hasNextLine()) {

            String lecturerLine = readLecturers.nextLine();

            Scanner readLecturerLine = new Scanner(lecturerLine);
            readLecturerLine.useDelimiter(" ");

            String email = readLecturerLine.next();
            String fname = readLecturerLine.next();
            String lname = readLecturerLine.next();
            int age = readLecturerLine.nextInt();
            String lectID = readLecturerLine.next();
            String room = readLecturerLine.next();
            String address = readLecturerLine.nextLine().trim();

            readLecturerLine.close();

            lect.add(new Lecturer(fname, lname, age, email, address, lectID, room));

        }

        int courseCount = 0;

        while(readCourses.hasNextLine()) {

            String courseLine = readCourses.nextLine();

            Scanner readCourseLine = new Scanner(courseLine);
            readCourseLine.useDelimiter(" ");

            String name = readCourseLine.next();
            String code = readCourseLine.next();
            int credit = readCourseLine.nextInt();
            String day = readCourseLine.next();
            String time = readCourseLine.next();

            cour.add(new Course(name, code, credit, day, time));

            String lectID = readCourseLine.next();

            for(int i=0; i<lect.size(); i++) {
                if(lectID.equals(lect.get(i).getLectID())) {
                    cour.get(courseCount).setLecturer(lect.get(i));
                    lect.get(i).register(cour.get(courseCount));
                }
            }

            courseCount++;

            readCourseLine.close();

        }

        readStudents.close();
        readLecturers.close();
        readCourses.close();
        
    }

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

        loadAll(students,lecturers,courses);
        
        login(students,lecturers,courses);

    }
}
