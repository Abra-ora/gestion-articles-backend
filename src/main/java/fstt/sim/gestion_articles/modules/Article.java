package fstt.sim.gestion_articles.modules;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Categorie categorie;
    private String libelle;
    private Long pu;

    public Article(String libelle, Long pu){
        this.libelle = libelle;
        this.pu = pu;
    }

}
