package guest;
 
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
 
@Component
public class GuestDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new guest:
    @Transactional
    public void persist(Guest guest) {
        em.persist(guest);
    }
 
    // Retrieves all the guests:
    public List<Guest> getAllGuests() {
    	Query query = em.createQuery(
            "SELECT g FROM Guest g ORDER BY g.id");
    	return query.getResultList();
    }
}