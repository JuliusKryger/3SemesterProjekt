package facades;

import entities.User;

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


    public User saveMealPlanToUser() {

        return null;
    }


}
