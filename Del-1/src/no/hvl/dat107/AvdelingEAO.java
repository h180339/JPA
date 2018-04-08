package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AvdelingEAO {

	private EntityManagerFactory emf;

	public AvdelingEAO() {
		emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	}

	public Avdeling finnAvdelingPK(int avdNr) {
		EntityManager em = emf.createEntityManager();
		Avdeling avd = null;
		try {
			avd = em.find(Avdeling.class, avdNr);
		} finally {
			em.close();
		}
		return avd;
	}

	public void skrivUtAnsattePaaAvdeling(int avdNr) {

		String queryString = "SELECT t FROM Avdeling t ";

		EntityManager em = emf.createEntityManager();

		Avdeling avd = null;

		try {
			avd = em.find(Avdeling.class, avdNr);

			List<Ansatt> ansattListe = avd.getAvdListe();

			for(Ansatt ansatt : ansattListe) {
				System.out.println(ansatt);
			}

		} finally {
			em.close();
		}
	}
	public boolean leggTilAvdeling(Avdeling a) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		boolean gikkdet = false;
		try {
			tx.begin();

			em.persist(a);

			tx.commit();
			gikkdet = true;
			AnsattEAO ansattEAO = new AnsattEAO(); //Oppdaterer ansatt tabellen til å vise at sjefen i avdelingen jobber i avdelingen
			ansattEAO.oppdaterAnsattAvdeling(ansattEAO.finnAnsattPaaPK(a.getaId().getAid()), a.getAvdelingId());
		} catch(Throwable e) {

			e.printStackTrace();
			tx.rollback();

		} finally {
			em.close();
		}
		return gikkdet;
	}


}
