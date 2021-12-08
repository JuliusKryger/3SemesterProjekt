package facades;

import dtos.IngredientsDTO;
import dtos.UserDTO;
import entities.Ingredients;
import entities.User;
import entities.WeeklyPlan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import java.util.List;

public class RecipeFacade {

    private static EntityManagerFactory emf;
    private static RecipeFacade instance;
    User user;


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

    // methode String (return statement) der henter ned fra databassen username og week number senere hen
    // skal hive ud JSON String
    // endpoint get
    // EM find username med find på user name

    /**
     *     public PersonsDTO getAllPersons(){
     *         EntityManager em = emf.createEntityManager();
     *         try{
     *             em.getTransaction().begin();
     *             TypedQuery <Person> typedQuery = em.createNamedQuery("Person.getAllRows", Person.class);
     *             List<Person> personList = typedQuery.getResultList();
     *             PersonsDTO personsDTO = new PersonsDTO(personList);
     *             em.getTransaction().commit();
     *             return personsDTO;
     *         }
     *         finally {
     *             em.close();
     *         }
     *     }
     * **/

    public String getGroceryList(String userName, int weekNumber) {
        EntityManager em = emf.createEntityManager();
        /** Vi skal i pricippet også give den user med, men for nu lad os bare hente den ud baseret på weekNumber. **/
        //User user = em.find(User.class, userName);
        try {
            em.getTransaction().begin();
            TypedQuery<WeeklyPlan> typedQuery = em.createNamedQuery("WeeklyPlanner.getJson", WeeklyPlan.class);
            typedQuery.setParameter("weekNumber", weekNumber);
            typedQuery.setParameter("userName", userName);
            WeeklyPlan wp = typedQuery.getSingleResult();
            if (wp != null) {
                return wp.getJson();
            }else {
                throw new WebApplicationException("Weekplan dosen't exist.", 400);
            }

        } finally {
            em.close();
        }
    }
}














