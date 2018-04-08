package no.hvl.dat107;

import java.time.LocalDate;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		AnsattEAO aeo = new AnsattEAO();
		AvdelingEAO avdelingEAO = new AvdelingEAO();


		Ansatt a2 = aeo.finnAnsattPaaPK(1);
		System.out.println("Finner ansatt på pk : 1");
		System.out.println(a2);
		System.out.println();


		Avdeling avd2 = avdelingEAO.finnAvdelingPK(1);
		Ansatt a3 = new Ansatt("GMB", "GrimMyBoi", "GrimMyBoi", LocalDate.now(), "pro programmer", 20, avd2);
		System.out.println("setter inn ansatt: ");
		aeo.leggTilAnsatt(a3);
		Ansatt utigjen = aeo.finnAnsattPaaPK(2);
		System.out.println(utigjen);
		System.out.println();

		System.out.println("finner Ansatt på brukernavn");
		System.out.println(aeo.finnAnsattPaaNavn("EA"));

		System.out.println("Oppdaterer brukernavn til en ansatt:");
		a2.setBrukerNavn("AE");
		aeo.oppdaterAnsatt(a2);


		System.out.println("hele tabellen");
		aeo.skrivUtTabell();


		System.out.println("finn avdeling på avdNr");
		System.out.println(avdelingEAO.finnAvdelingPK(1));

		System.out.println();
		System.out.println("skriver ut alle ansatte på en avdeling: ");
		avdelingEAO.skrivUtAnsattePaaAvdeling(1);

		System.out.println();
		System.out.println("oppdaterer ansatt sin avdeling: ");
		aeo.oppdaterAnsattAvdeling(aeo.finnAnsattPaaPK(2), 2);

		System.out.println();
		System.out.println("legger til ny avdeling og setter ansatt som sjef i ny avdeling: ");
		Avdeling jobbeAvdeling = new Avdeling("Jobbe", aeo.finnAnsattPaaNavn("GMB"));
		System.out.println(avdelingEAO.leggTilAvdeling(jobbeAvdeling));

	}

}