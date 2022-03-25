package fstt.sim.gestion_articles.Services;

import fstt.sim.gestion_articles.Repo.ArticleRepo;
import fstt.sim.gestion_articles.Repo.CategoryRepo;
import fstt.sim.gestion_articles.modules.Article;
import fstt.sim.gestion_articles.modules.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.webjars.NotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo articleRepo;
    @Autowired
    CategoryRepo categoryRepo;

    public List<Article> getAll(){
        return (List<Article>) articleRepo.findAll();
    }

    public Article getById(int art_id){
        return articleRepo.findById(art_id).get();
    }

    public Article save(Article article){
        return articleRepo.save(article);
    }

    public void deleteById(int art_id){
        articleRepo.deleteById(art_id);
    }

}
