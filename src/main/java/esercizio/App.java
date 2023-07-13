package esercizio;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import util.JpaUtil;

public class App {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		PersonaDAO pr = new PersonaDAO(em);
		LocationDAO loc = new LocationDAO(em);
		EventoDAO ev = new EventoDAO(em);
		PartecipazioneDAO part = new PartecipazioneDAO(em);

		Persona pers1 = new Persona("A", "B", "a@mail.com", LocalDate.parse("2024-02-19"), "f");
		Location loc1 = new Location("Al", "Casa");
		pr.save(pers1);
		loc.save(loc1);
		Evento ev1 = new Evento("Evento2", LocalDate.parse("2014-02-19"), "beach-party", TipoEvento.PRIVATO, 55, loc1);
		ev.save(ev1);
		Partecipazione part1 = new Partecipazione(StatoPartec.Confermata, pers1, ev1);
		part.save(part1);

//		User u = ud.findById(4);
//		System.out.println(u.getDocument());
//
//		Document d = dd.findById(3);
//		System.out.println(d.getUser());

		em.close();
		emf.close();
	}

}
