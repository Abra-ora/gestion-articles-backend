package fstt.sim.gestion_articles.Controller;

import fstt.sim.gestion_articles.Repo.ArticleRepo;
import fstt.sim.gestion_articles.Services.ArticleService;
import fstt.sim.gestion_articles.Services.CategoryService;
import fstt.sim.gestion_articles.modules.Article;
import fstt.sim.gestion_articles.modules.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAll();
        if(articles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") int id) {
        Article art = articleService.getById(id);
        return new ResponseEntity<>(art, HttpStatus.OK);
    }

    @PostMapping("/articles")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article _article = articleService.save(new Article(article.getLibelle(), article.getPu()));
        return new ResponseEntity<>(_article, HttpStatus.CREATED);
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") int id, @RequestBody Article article) {
        Article _article = articleService.getById(id);
        _article.setLibelle(article.getLibelle());
        _article.setPu(article.getPu());
        return new ResponseEntity<>(articleService.save(_article), HttpStatus.OK);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<HttpStatus> deleteArticle(@PathVariable("id") int id) {
        articleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/articles/{id}/category")
    public ResponseEntity<Categorie> getArticleCategory(@PathVariable("id") int id) {

        Article article = articleService.getById(id);
        Categorie category = article.getCategorie();

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/articles/{id}/category")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") int id, @RequestBody Categorie categorie) {
        Article _article = articleService.getById(id);
        _article.setCategorie(categorie);
        return new ResponseEntity<>(articleService.save(_article), HttpStatus.OK);
    }

}
