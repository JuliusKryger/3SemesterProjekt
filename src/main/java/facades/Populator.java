package facades;

import javax.persistence.EntityManagerFactory;

import utils.EMF_Creator;

public class Populator {

    public static void populate() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    }

    public static void main(String[] args) {
        populate();
    }
}
