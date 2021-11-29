package entities;

import javax.persistence.*;

@Entity
public class WeeklyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String json;

    @ManyToOne
    private User user;

    private int weekNumber;

    public WeeklyPlan() {
    }

    public WeeklyPlan(Integer id, String json, User user, int weekNumber) {
        this.id = id;
        this.json = json;
        this.user = user;
        this.weekNumber = weekNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
