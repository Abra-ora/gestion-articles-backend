package fstt.sim.gestion_articles.Repo;

import fstt.sim.gestion_articles.modules.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepo extends CrudRepository<Article, Integer> {
}
