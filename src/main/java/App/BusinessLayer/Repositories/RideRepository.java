package App.BusinessLayer.Repositories;

import App.DataLayer.Models.RideModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cesar
 */
public interface RideRepository extends CrudRepository<RideModel, Integer>{
    
}
