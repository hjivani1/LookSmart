package club.looksmart.looksmartwebapp.model;

public class Tutor extends User{

    private final String[] coursesTaught;

    public Tutor(String pantherID, String email, String password, int uType, String[] coursesTaught) {
        super(pantherID, email, password, uType);
        this.coursesTaught = coursesTaught;
    }

    public Tutor(Tutor tutor) {
        super(tutor);
        this.coursesTaught = tutor.coursesTaught;
    }
}
