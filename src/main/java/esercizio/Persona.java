package esercizio;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persone")
@Getter
@Setter
@NoArgsConstructor
public class Persona {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataNascita;
	private String sesso;

	@OneToMany(mappedBy = "persona")
	private Set<Partecipazione> partecipazione;

	public Persona(String nome, String cognome, String email, LocalDate dataNascita, String sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
		}

	@Override
	public String toString() {
		return "Persona [ \nid=" + id + ",\n nome=" + nome + ",\n cognome=" + cognome + ",\n email=" + email
				+ ",\n dataNascita=" + dataNascita + ",\n sesso=" + sesso
				+ "]";
	}
}
