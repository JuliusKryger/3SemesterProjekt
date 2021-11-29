package facades;

import dtos.UserDTO;
import entities.User;
import entities.WeeklyPlan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class RecipeFacade {

    // Vi skal have kaldt recpies dto i den her klasse
    //Username password

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
    //get trancation (begin and close) persist og merge med recipelist - i gang her


    public WeeklyPlan saveFoodPlanToUser(String userName, int weekNumber, String  json) {
        EntityManager em = emf.createEntityManager();

        WeeklyPlan wp = new WeeklyPlan();
        User user = new User();
        try{
            em.getTransaction().begin();
            user.setUserName(userName);
            wp.setUser(user);
            wp.setWeekNumber(weekNumber);
            wp.setJson(json);
            em.persist(wp);
            em.getTransaction().commit();

        }finally {
            em.close();
        }

        return wp;
    }



}
