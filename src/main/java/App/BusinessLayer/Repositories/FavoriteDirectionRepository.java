package App.BusinessLayer.Repositories;

import App.DataLayer.Models.FavoriteDirectionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteDirectionRepository extends JpaRepository<FavoriteDirectionModel, Integer> {
}
