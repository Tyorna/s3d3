package esercizio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
	private final EntityManager em;

	public PartecipazioneDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Partecipazione e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		System.out.println("Salvata!");
	}

	public Partecipazione findById(long id) {
		Partecipazione trova = em.find(Partecipazione.class, id);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Partecipazione non trovata");
		}
		return trova;
	}

	public void delete(long id) {
		Partecipazione trova = em.find(Partecipazione.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Partecipazione eliminato");
		} else {
			System.out.println("Partecipazione non trovato");
		}
	}

}
