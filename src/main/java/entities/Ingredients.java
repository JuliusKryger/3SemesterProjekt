package entities;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredients {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;

    @ManyToOne
    Recipe recipe;

    public Ingredients() {
    }

    public Ingredients(Integer id, Recipe recipe, String name) {
        this.id = id;
        this.recipe = recipe;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
