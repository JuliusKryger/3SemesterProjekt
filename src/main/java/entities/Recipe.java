package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String title;
    private int readyInMinutes;
    private int servings;
    private String image;
    private String instructions;

    @OneToMany
    private List<Ingrediens> ingrediensList;

    public Recipe(Integer id, String title, int readyInMinutes, int servings, String image, String instructions, List<Ingrediens> ingrediensList) {
        this.id = id;
        this.title = title;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.image = image;
        this.instructions = instructions;
        this.ingrediensList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Recipe() {
    }


}
