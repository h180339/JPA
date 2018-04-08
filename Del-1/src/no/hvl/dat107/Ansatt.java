package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Ansatt", schema = "oblig3")

public class Ansatt {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int aid;
	private String brukerNavn;
	private String forNavn;
	private String etterNavn;
	private LocalDate datoAns;
	private String stilling;
	private int maanedslonn;

	@ManyToOne
	@JoinColumn(name = "avdelingId", referencedColumnName = "avdelingId")
	private Avdeling avd;


	public Ansatt() {

	}

	public Ansatt(String brukerNavn, String forNavn, String etterNavn, LocalDate ansettelseDato,
		String stilling, int maanedslonn, Avdeling avdeling) {

		this.brukerNavn = brukerNavn;
		this.forNavn = forNavn;
		this.etterNavn = etterNavn;
		this.datoAns = ansettelseDato;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
		this.avd = avdeling;

	}

	public String getBrukerNavn() {
		return brukerNavn;
	}

	public void setBrukerNavn(String brukerNavn) {
		this.brukerNavn = brukerNavn;
	}

	public String getForNavn() {
		return forNavn;
	}

	public void setForNavn(String forNavn) {
		this.forNavn = forNavn;
	}

	public String getEtterNavn() {
		return etterNavn;
	}

	public void setEtterNavn(String etterNavn) {
		this.etterNavn = etterNavn;
	}

	public LocalDate getAnsettelseDato() {
		return datoAns;
	}

	public void setAnsettelseDato(LocalDate ansettelseDato) {
		this.datoAns = ansettelseDato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(int maanedsloen) {
		this.maanedslonn = maanedsloen;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public Avdeling getAvd() {

		return avd;
	}

	public void setAvd(Avdeling avd) {
		this.avd = avd;
	}

	@Override
	public String toString() {
		return
			"ansattId=" + aid +
			", brukerNavn='" + brukerNavn + '\'' +
			", forNavn='" + forNavn + '\'' +
			", etterNavn='" + etterNavn + '\'' +
			", datoAns=" + datoAns +
			", stilling='" + stilling + '\'' +
			", maanedslonn=" + maanedslonn +
			", avdelingId=" + avd.getAvdelingId() +
			'}';
	}
}
