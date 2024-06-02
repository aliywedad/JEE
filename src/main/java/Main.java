import Entity.Voiture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Create instances of Voiture with data
        Voiture voiture1 = new Voiture("Toyota", 20000);
        Voiture voiture3 = new Voiture("test", 22000);

        // Create EntityManagerFactory and EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Start transaction
        entityManager.getTransaction().begin();

        // Persist Voiture entities
        entityManager.persist(voiture1);
        entityManager.persist(voiture3);

        // Commit transaction
        entityManager.getTransaction().commit();

        // Clear the persistence context
        entityManager.clear();

        // Close EntityManager and EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
