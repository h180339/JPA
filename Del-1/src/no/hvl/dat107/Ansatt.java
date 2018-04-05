package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Ansatt", schema = "oblig3")

public class Ansatt {

	@Id
	private String brukerNavn;
	private String forNavn;
	private String etterNavn;
	private LocalDate datoAns;
	private String stilling;
	private int maanedslonn;

	@Override
	public String toString() {
		return "Ansatt{" +
			"brukerNavn='" + brukerNavn + '\'' +
			", forNavn='" + forNavn + '\'' +
			", etterNavn='" + etterNavn + '\'' +
			", datoAns=" + datoAns +
			", stilling='" + stilling + '\'' +
			", maanedslonn=" + maanedslonn +
			'}';
	}

	public Ansatt() {

	}

	public Ansatt(String brukerNavn, String forNavn, String etterNavn, LocalDate ansettelseDato,
		String stilling, int maanedslonn, String avdeling) {

		this.brukerNavn = brukerNavn;
		this.forNavn = forNavn;
		this.etterNavn = etterNavn;
		this.datoAns = ansettelseDato;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;

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

	public int getMaanedsloen() {
		return maanedslonn;
	}

	public void setMaanedsloen(int maanedsloen) {
		this.maanedslonn = maanedsloen;
	}


}
