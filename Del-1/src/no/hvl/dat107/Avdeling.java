package no.hvl.dat107;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Avdeling", schema = "oblig3")
public class Avdeling {



	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int avdelingId;
	private String navn;

	@OneToOne
	@JoinColumn(name = "aId", referencedColumnName = "aId")
	private Ansatt aId;


	@OneToMany(
		mappedBy = "avd",
		fetch = FetchType.EAGER,
		cascade = {CascadeType.PERSIST, CascadeType.MERGE},
		orphanRemoval = true)
	private List<Ansatt> avdListe;

	public Avdeling() {

	}

	public Avdeling( String navn, Ansatt aId) {
		this.navn = navn;
		this.aId = aId;
	}

	public int getAvdelingId() {
		return avdelingId;
	}

	public void setAvdelingId(int avdelingId) {
		this.avdelingId = avdelingId;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Ansatt getaId() {
		return aId;
	}

	public void setaId(Ansatt aId) {
		this.aId = aId;
	}

	public List<Ansatt> getAvdListe() {
		return avdListe;
	}

	public void setAvdListe(List<Ansatt> avdListe) {
		this.avdListe = avdListe;
	}

	@Override
	public String toString() {
		return "Avdeling{" +
			"avdelingId=" + avdelingId +
			", navn='" + navn + '\'' +
			", avdelingSjef=" + aId +
			'}';
	}
}
