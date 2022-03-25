package fstt.sim.gestion_articles.Repo;

import fstt.sim.gestion_articles.modules.Categorie;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Categorie, Integer> {
//    Categorie finById(int id);
}
