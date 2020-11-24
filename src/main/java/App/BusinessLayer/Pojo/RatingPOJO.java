package App.BusinessLayer.Pojo;

import App.BusinessLayer.Services.UserService;
import App.DataLayer.Models.RatingModel;

public class RatingPOJO {
    private int idRating;


    private String grader;

    private String graded;

    private byte grade;

    private String rideId;

    public RatingPOJO() {
    }

    public int getIdRating() {
        return idRating;
    }

    public void setIdRating(int idRating) {
        this.idRating = idRating;
    }

    public String getGrader() {
        return grader;
    }

    public void setGrader(String grader) {
        this.grader = grader;
    }

    public String getGraded() {
        return graded;
    }

    public void setGraded(String graded) {
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

    public RatingModel getModel(UserService userService) {
        RatingModel ratingModel = new RatingModel();
        ratingModel.setGrade(getGrade());
        int graded = userService.findByUserMail(getGraded()).getIdUser();
        ratingModel.setGraded(graded);
        int grader = userService.findByUserMail(getGrader()).getIdUser();
        ratingModel.setGrader(grader);
        ratingModel.setRideId(getRideId());
        return ratingModel;
    }

    public RatingPOJO(UserService userService, RatingModel ratingModel) {
        setGrade(ratingModel.getGrade());
        setGraded(userService.findById(ratingModel.getGraded()).getUserMail());
        setGrader(userService.findById(ratingModel.getGrader()).getUserMail());
        setRideId(ratingModel.getRideId());
    }


}