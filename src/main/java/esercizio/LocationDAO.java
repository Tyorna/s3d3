package esercizio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
	private final EntityManager em;

	public LocationDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Location e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		System.out.println("Salvata!");
	}

	public Location findById(long id) {
		Location trova = em.find(Location.class, id);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Location non trovata");
		}
		return trova;
	}

	public void delete(long id) {
		Location trova = em.find(Location.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Location eliminato");
		} else {
			System.out.println("Location non trovato");
		}
	}

}
