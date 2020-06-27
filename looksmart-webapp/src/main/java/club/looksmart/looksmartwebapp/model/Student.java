package club.looksmart.looksmartwebapp.model;

public class Student extends User {

    private final String[] coursesEnrolled;

    public Student( String pantherID, String email, String password, String firstName,
                    String lastName, UserType uType, String[] coursesEnrolled) {
        super(pantherID, email, password, firstName, lastName, uType);
        this.coursesEnrolled = coursesEnrolled;
    }

    public Student(Student student) {
        super(student);
        this.coursesEnrolled = student.coursesEnrolled;
    }
}
