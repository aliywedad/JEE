
import Entity.Voiture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Transactional
public class Servises {
    @PersistenceContext
    private EntityManager em;

    public List<Voiture> getAllVoitures() {
        return em.createQuery("SELECT v FROM Voiture v", Voiture.class).getResultList();
    }

    public Voiture getVoitureById(Integer id) {
        return em.find(Voiture.class, id);
    }

    public Voiture saveVoiture(Voiture voiture) {
        if (voiture.getId() == null) {
            em.persist(voiture);
            return voiture;
        } else {
            return em.merge(voiture);
        }
    }

    public void deleteVoiture(Integer id) {
        Voiture voiture = getVoitureById(id);
        if (voiture != null) {
            em.remove(voiture);
        }
    }
}
