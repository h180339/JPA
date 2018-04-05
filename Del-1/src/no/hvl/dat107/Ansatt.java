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
	private LocalDate ansettelseDato;
	private String stilling;
	private int maanedsloen;
	private String avdeling;

	public Ansatt() {

	}

	public Ansatt(String brukerNavn, String forNavn, String etterNavn, LocalDate ansettelseDato,
		String stilling, int maanedsloen, String avdeling) {

		this.brukerNavn = brukerNavn;
		this.forNavn = forNavn;
		this.etterNavn = etterNavn;
		this.ansettelseDato = ansettelseDato;
		this.stilling = stilling;
		this.maanedsloen = maanedsloen;
		this.avdeling = avdeling;
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
		return ansettelseDato;
	}

	public void setAnsettelseDato(LocalDate ansettelseDato) {
		this.ansettelseDato = ansettelseDato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getMaanedsloen() {
		return maanedsloen;
	}

	public void setMaanedsloen(int maanedsloen) {
		this.maanedsloen = maanedsloen;
	}

	public String getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(String avdeling) {
		this.avdeling = avdeling;
	}
}
