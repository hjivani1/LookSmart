package club.looksmart.looksmartwebapp.model;

public class Review {

    private String studentName;
    private String tutorName;
    private String courseName;
    private String reviewContent;
    private int rating;

    public Review(String studentName, String tutorName, String courseName, String reviewContent, int rating) {
        this.studentName = studentName;
        this.tutorName = tutorName;
        this.courseName = courseName;
        this.reviewContent = reviewContent;
        this.rating = rating;
    }

    public Review(){}

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
