package club.looksmart.looksmartwebapp.model;

public class Tutor extends User{

    private final String[] coursesTaught;

    public Tutor(String pantherID, String email, String password, String firstName,
                 String lastName, UserType uType, String[] coursesTaught) {
        super(pantherID, email, password, firstName, lastName, uType);
        this.coursesTaught = coursesTaught;
    }

    public Tutor(Tutor tutor) {
        super(tutor);
        this.coursesTaught = tutor.coursesTaught;
    }
}
