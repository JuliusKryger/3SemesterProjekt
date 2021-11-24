package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingrediens {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    Recipe recipe;

    public Ingrediens() {
    }

    public Ingrediens(Integer id, Recipe recipe) {
        this.id = id;
        this.recipe = recipe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
