package fstt.sim.gestion_articles.Controller;

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
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @GetMapping("/categories")
    public ResponseEntity<List<Categorie>> getAllCategories() {
        List<Categorie> categories = categoryService.getAll();
        if(categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);


    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Categorie> getCategoryById(@PathVariable("id") int id) {
        Categorie categorie = categoryService.getById(id);
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<Categorie> createCategory(@RequestBody Categorie categorie) {
        System.out.println("entering the new categorie method");
        Categorie _category = categoryService.save(new Categorie(categorie.getDesignation()));
        return new ResponseEntity<>(_category, HttpStatus.CREATED);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Categorie> updateCategory(@PathVariable("id") int id, @RequestBody Categorie categorie) {
        Categorie _category = categoryService.getById(id);
        _category.setDesignation(categorie.getDesignation());
        return new ResponseEntity<>(categoryService.save(_category), HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/categories/{id}/articles")
    public ResponseEntity<List<Article>> getCategoryArticles(@PathVariable("id") int id) {
        List<Article> articles = new ArrayList<Article>();
        Categorie categorie = categoryService.getById(id);
        articles = categorie.getArticles();
        if(articles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(articles, HttpStatus.OK);


    }

}
