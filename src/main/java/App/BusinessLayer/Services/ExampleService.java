
package App.BusinessLayer.Services;

import App.DataLayer.Models.ExampleModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import App.BusinessLayer.Repositories.ExampleRepository;
import javax.persistence.EntityNotFoundException;

@Service
public class ExampleService {
        @Autowired
    private ExampleRepository exampleRepository;

    public List<ExampleModel> findAll(){
        return (List<ExampleModel>) exampleRepository.findAll();
    }

    public ExampleModel findById(int id){
        return exampleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public ExampleModel save(ExampleModel touristModel){
        return exampleRepository.save(touristModel);
    }

    public void deleteById(int id){
        exampleRepository.deleteById(id);
    }
}
