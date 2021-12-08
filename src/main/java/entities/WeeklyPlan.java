package entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "WeeklyPlanner.getJson", query = "SELECT w from WeeklyPlan w where w.weekNumber = :weekNumber AND w.user.userName = :userName")
})
@Entity
public class WeeklyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "json", columnDefinition="LONGTEXT")
    private String json;

    @ManyToOne
    private User user;

    private int weekNumber;

    public WeeklyPlan() {
    }

    public WeeklyPlan(String json, User user, int weekNumber) {
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

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }
}
