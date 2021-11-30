package facades;

import dtos.UserDTO;
import entities.User;
import entities.WeeklyPlan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class RecipeFacade {

    private static EntityManagerFactory emf;
    private static RecipeFacade instance;


    public RecipeFacade() {
    }

    public static RecipeFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RecipeFacade();
        }
        return instance;

    }

    public WeeklyPlan saveFoodPlanToUser(String userName, int weekNumber, String json) {
        EntityManager em = emf.createEntityManager();
        WeeklyPlan wp = new WeeklyPlan();
        User user = em.find(User.class, userName);
        if (user != null) {
            wp.setUser(user);
            wp.setWeekNumber(weekNumber);
            wp.setJson(json);
            user.addWeekPlan(wp);
        }
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return wp;
    }


}
