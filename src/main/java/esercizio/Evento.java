package esercizio;

import java.time.LocalDate;

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
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
public class Evento {

	@Id
	@GeneratedValue
	private long id;

	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	private int numeroMassimoPartecipanti;

	@ManyToOne
	@JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
	private Location location;

	@ManyToOne
	@JoinColumn(name = "partecipazione_id", referencedColumnName = "id", nullable = false)
	private Partecipazione partecipazione;

	public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti) {
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	@Override
	public String toString() {
		return "Evento [ \n id = " + id + ",\n titolo = " + titolo + ", \n data dell' evento = " + dataEvento
				+ ", \n descrizione = " + descrizione + ", \n numero Massimo Partecipanti = "
				+ numeroMassimoPartecipanti + ", \n tipo di evento = " + tipoEvento + "]";
	}
}
