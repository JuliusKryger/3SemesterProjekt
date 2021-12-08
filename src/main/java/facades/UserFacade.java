package facades;

import entities.Role;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import security.errorhandling.AuthenticationException;

public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
        /** Maybe we can check if username is already taken, and would be fun to check password "Strongness" as well for added security. **/
    }

    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    public User CreateNewUser(User user) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();

        try {
            /**
             * Okay her skal vi have gjort så når en ny user bliver oprettet bliver de tildelt user rollen ligenu
             * Så bliver nye users ikke tildelt en ny rolle, men se evt. i SetUpTestUsers hvordan der bliver tildelt roller der.
             **/
            Role userRole = new Role("user");
            em.getTransaction().begin();
            
            user.setUserName(user.getUserName());
            user.addRole(userRole);
            //user.setUserPass(user.getUserPass());
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return user;
    }

}
