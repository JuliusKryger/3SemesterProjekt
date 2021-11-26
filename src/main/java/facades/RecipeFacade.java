package facades;

import dtos.UserDTO;
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


    public UserDTO saveMealPlanToUser() {
        /** Skal tage imod en liste af RecipeDTO's??? og derefter gemme dem til useren, ved at kalde en form for user.setRecipeList() **/
        return null;
    }


}
