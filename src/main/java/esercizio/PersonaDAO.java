package esercizio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
	private final EntityManager em;

	public PersonaDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Persona e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		System.out.println("Salvata!");
	}

	public Persona findById(long id) {
		Persona trova = em.find(Persona.class, id);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Persona non trovata");
		}
		return trova;
	}

	public void delete(long id) {
		Persona trova = em.find(Persona.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Persona eliminato");
		} else {
			System.out.println("Persona non trovato");
		}
	}

	public void refresh(long id) {
		Persona trova = em.find(Persona.class, id);
		em.refresh(trova);
		System.out.println("REFRESh effetturato");
		System.out.println(trova);

	}
}
