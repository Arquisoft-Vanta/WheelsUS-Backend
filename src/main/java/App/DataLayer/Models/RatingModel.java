package App.DataLayer.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rating")
public class RatingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rating")
    private int idRating;


    private int grader;

    private int graded;

    private byte grade;

    private String rideId;

    @ManyToOne
    @JoinColumn(name = "grader", insertable=false, updatable=false)
    private UserModel userGrader;

    @ManyToOne
    @JoinColumn(name = "graded", insertable=false, updatable=false)
    private UserModel userGraded;
}
