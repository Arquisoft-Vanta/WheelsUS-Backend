package App.BusinessLayer.Repositories;

import App.DataLayer.Models.FavoriteDirectionModel;
import App.DataLayer.Models.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteDirectionRepository extends CrudRepository<FavoriteDirectionModel, Integer> {

    @Query("SELECT a FROM FavoriteDirectionModel a WHERE a.userModel = :user")
    List<FavoriteDirectionModel> getDirectionByUser(UserModel user);


}
