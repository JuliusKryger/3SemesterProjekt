package facades;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

public class Populator {
    private static EntityManagerFactory emf;
    private static UserFacade facade;

    private static User user1 = new User("SuperAwesomeUser","SuperSecretPass");

    public static void populate() {
        emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        UserFacade userFacade = UserFacade.getUserFacade(emf);
        try {
            em.getTransaction().begin();

            //Creating our first user 1
            // --- We can persist the user like this no problem --- em.persist(user1);
            userFacade.CreateNewUser(user1);

            em.getTransaction().commit();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        populate();
    }
}
