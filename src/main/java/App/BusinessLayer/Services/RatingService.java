package App.BusinessLayer.Services;

import App.BusinessLayer.Repositories.RatingRepository;
import App.DataLayer.Models.RatingModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {
    Logger logger = LoggerFactory.getLogger(RatingService.class);

    @Autowired
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public RatingModel save(RatingModel ratingModel){
        return ratingRepository.save(ratingModel);
    }

    public float findBygraded(Integer id){
        ArrayList<RatingModel> ratingModels = (ArrayList<RatingModel>) ratingRepository.findBygraded(id);
        float sum = 0;
        for (RatingModel ratingModel : ratingModels) {
            sum = sum +ratingModel.getGrade();
        }
        return sum/ratingModels.size();
    }


}
