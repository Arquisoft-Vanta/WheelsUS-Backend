
package App.BusinessLayer.Repositories;

import App.DataLayer.Models.ExampleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends CrudRepository<ExampleModel, Integer>{
    
}
