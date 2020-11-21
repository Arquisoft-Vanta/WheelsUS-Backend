package App.BusinessLayer.Pojo;

public class RatingPOJO {
    private int idRating;


    private int grader;

    private int graded;

    private byte grade;

    private String rideId;

    public int getIdRating() {
        return idRating;
    }

    public void setIdRating(int idRating) {
        this.idRating = idRating;
    }

    public int getGrader() {
        return grader;
    }

    public void setGrader(int grader) {
        this.grader = grader;
    }

    public int getGraded() {
        return graded;
    }

    public void setGraded(int graded) {
        this.graded = graded;
    }

    public byte getGrade() {
        return grade;
    }

    public void setGrade(byte grade) {
        this.grade = grade;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }
}
