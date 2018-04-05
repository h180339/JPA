package no.hvl.dat107;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		AnsattEAO aeo = new AnsattEAO();

		Ansatt a2 = aeo.finnVitnemalPaaPK(1);
		System.out.println(a2);

		Ansatt a3 = new Ansatt("GrimMyBoi", "GrimMyBoi", "GrimMyBoi", LocalDate.now(), "pro programmer", 20);
		System.out.println(a3);

		aeo.leggTilAnsatt(a3);

		Ansatt utigjen = aeo.finnVitnemalPaaPK(2);

		System.out.println("utigjen");
		System.out.println(utigjen);
	}

}