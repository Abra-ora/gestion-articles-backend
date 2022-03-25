package fstt.sim.gestion_articles.Services;

import fstt.sim.gestion_articles.Repo.CategoryRepo;
import fstt.sim.gestion_articles.modules.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public List<Categorie> getAll(){
        return (List<Categorie>) categoryRepo.findAll();
    }

    public Categorie getById(int id){
        return categoryRepo.findById(id).get();
    }

    public Categorie addCategorie(Categorie c){
        return categoryRepo.save(c);
    }

    public Categorie save(Categorie categorie){
        return categoryRepo.save(categorie);
    }

    public void deleteById(int cat_id){
        categoryRepo.deleteById(cat_id);
    }
}
