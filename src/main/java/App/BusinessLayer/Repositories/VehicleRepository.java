package App.BusinessLayer.Repositories;

import App.DataLayer.Models.VehicleModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cesar
 */
public interface VehicleRepository extends CrudRepository<VehicleModel, Integer>{
    
}
