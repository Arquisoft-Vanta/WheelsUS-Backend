package App.BusinessLayer.Services;

import App.BusinessLayer.Repositories.RideRepository;
import App.DataLayer.Models.RideModel;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar
 */
@Service
public class RideService {
    
    @Autowired
    private RideRepository rideRepository;

    public List<RideModel> findAll(){
        return (List<RideModel>) rideRepository.findAll();
    }

    public RideModel findById(int id){
        return rideRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public RideModel save(RideModel rideModel){
        return rideRepository.save(rideModel);
    }

    public void deleteById(int id){
        rideRepository.deleteById(id);
    }
    
    
}
