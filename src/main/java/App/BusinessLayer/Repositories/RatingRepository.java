package App.BusinessLayer.Repositories;

import App.DataLayer.Models.RatingModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<RatingModel, Integer> {
    List<RatingModel> findBygraded(int graded);
}
