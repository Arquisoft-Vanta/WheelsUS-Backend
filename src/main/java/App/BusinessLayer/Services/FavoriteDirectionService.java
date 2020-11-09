package App.BusinessLayer.Services;

import App.BusinessLayer.Pojo.FavoriteDirectionPOJO;
import App.BusinessLayer.Repositories.FavoriteDirectionRepository;
import App.DataLayer.Models.FavoriteDirectionModel;
import App.DataLayer.Models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteDirectionService {

    @Autowired
    private final FavoriteDirectionRepository favoriteDirectionRepository;

    public FavoriteDirectionService( FavoriteDirectionRepository favoriteDirectionRepository ){
        this.favoriteDirectionRepository = favoriteDirectionRepository;
    }

    public FavoriteDirectionModel findById(Integer idFavoriteDirection ){
        return favoriteDirectionRepository.findById( idFavoriteDirection ).orElse( null );
    }

    public FavoriteDirectionModel save(FavoriteDirectionModel favoriteDirection ){
        return favoriteDirectionRepository.save( favoriteDirection );
    }
    public void deleteById(int idFavoriteDirection){
        favoriteDirectionRepository.deleteById(idFavoriteDirection);
    }

    public List<FavoriteDirectionModel> getDirectionsByUser(UserModel user ){
        return favoriteDirectionRepository.getDirectionByUser( user);
    }
}
