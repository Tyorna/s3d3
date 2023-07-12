package esercizio;

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
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
public class Location {
		@Id
		@GeneratedValue
		private long id;
		private String nome;
		private String citta;

		@OneToMany(mappedBy = "location")
		private Set<Evento> events;

		public Location(String nome, String citta) {
			this.nome = nome;
			this.citta = citta;
			}

		@Override
		public String toString() {
			return "Location [ \n id=" + id + ", \n nome=" + nome + ", \n citta=" + citta
					+ "]";
		}
}
