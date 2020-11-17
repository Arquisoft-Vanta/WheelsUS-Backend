package App.BusinessLayer.Repositories;

import App.DataLayer.Models.FavoriteDirectionModel;
import App.DataLayer.Models.UserModel;
import App.DataLayer.Models.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author cesar
 */
public interface VehicleRepository extends CrudRepository<VehicleModel, Integer>{
    @Query("SELECT a FROM VehicleModel a WHERE a.userModel = :user")
    List<VehicleModel> getVehicleByUser(UserModel user);


}
