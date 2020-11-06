package App.BusinessLayer.Services;

import App.BusinessLayer.Pojo.FavoriteDirectionPOJO;
import App.BusinessLayer.Repositories.FavoriteDirectionRepository;
import App.DataLayer.Models.FavoriteDirectionModel;

public class FavoriteDirectionService {

    private FavoriteDirectionRepository favoriteDirectionRepository;

    public FavoriteDirectionService( FavoriteDirectionRepository favoriteDirectionRepository ){
        this.favoriteDirectionRepository = favoriteDirectionRepository;
    }

    public FavoriteDirectionModel findById(Integer idFavoriteDirection ){
        return favoriteDirectionRepository.findById( idFavoriteDirection ).orElse( null );
    }

    public void save( FavoriteDirectionModel favoriteDirection ){
        favoriteDirectionRepository.save( favoriteDirection );
    }
    public void deleteById(int idFavoriteDirection){
        favoriteDirectionRepository.deleteById(idFavoriteDirection);
    }


}
