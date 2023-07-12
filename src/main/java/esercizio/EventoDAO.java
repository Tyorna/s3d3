package esercizio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {

	private final EntityManager em;

	public EventoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Evento e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		System.out.println("Salvato!");
	}

	public Evento findById(long id) {
		// SELECT * FROM students WHERE id=id;
		Evento trova = em.find(Evento.class, id);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Evento non trovato");
		}
		return trova;
	}

	public void delete(long id) {
		Evento trova = em.find(Evento.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Evento eliminato");
		} else {
			System.out.println("Evento non trovato");
		}
	}

	public void refresh(long id) {
		Evento trova = em.find(Evento.class, id);
		em.refresh(trova);
		System.out.println("REFRESh effetturato");
		System.out.println(trova);

	}
}
