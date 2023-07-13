package esercizio;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partecipazioni")
@Getter
@Setter
@NoArgsConstructor
public class Partecipazione {
	@Id
	@GeneratedValue
	private long id;
	@Enumerated(EnumType.STRING)
	private StatoPartec stato;

	@ManyToOne
	@JoinColumn(name = "persona_id", referencedColumnName = "id", nullable = false)
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "evento_id", referencedColumnName = "id")
	private Evento evento;

	public Partecipazione(StatoPartec stato, Persona persona, Evento evento) {
		this.stato = stato;
		this.persona = persona;
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "Partecipazione [ \n id=" + id + ",\n stato=" + stato + ",\n persona=" + persona + "]";
	}
}
