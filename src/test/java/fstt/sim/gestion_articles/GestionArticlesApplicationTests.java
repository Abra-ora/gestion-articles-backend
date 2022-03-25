package fstt.sim.gestion_articles;

import fstt.sim.gestion_articles.Repo.CategoryRepo;
import fstt.sim.gestion_articles.Services.ArticleService;
import fstt.sim.gestion_articles.Services.CategoryService;
import fstt.sim.gestion_articles.modules.Article;
import fstt.sim.gestion_articles.modules.Categorie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GestionArticlesApplicationTests {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ArticleService articleService;

    @Test
    void contextLoads() {

    }

}
