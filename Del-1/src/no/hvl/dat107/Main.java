package no.hvl.dat107;

public class Main {

	public static void main(String[] args) {

		AnsattEAO aeo = new AnsattEAO();

		Ansatt a2 = aeo.finnVitnemalPaaPK(1);

		System.out.println(a2);
	}

}