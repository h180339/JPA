package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;

public class AnsattEAO {

	private EntityManagerFactory emf;

	public AnsattEAO() {
		emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	}

	public boolean leggTilAnsatt(Ansatt a) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		boolean gikkdet = false;
		try {
			tx.begin();

			em.persist(a);

			tx.commit();
			gikkdet = true;
		} catch(Throwable e) {

			e.printStackTrace();
			tx.rollback();

		} finally {
			em.close();
		}
		return gikkdet;
	}
/*
	public Karakter finnEnPaaMangesidenMedMatchPaaParametre() {

		String queryString = "";

		EntityManager em = emf.createEntityManager();

		Karakter mange = null;
		try {
			TypedQuery<Karakter> query = em.createQuery(queryString, Karakter.class);
			query.setParameter("???", null);
			query.setParameter("???", null);
			mange = query.getSingleResult();
		} finally {
			em.close();
		}
		return mange;
	}

	public void registrerKarakterForStudent(String kursKode, LocalDate eksDato, String kar, int studNr) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Vitnemal vitnemal = em.find(Vitnemal.class, studNr);

			Karakter karakter = new Karakter(kursKode, eksDato, kar, vitnemal);

			em.persist(karakter);

			vitnemal.addKarakter(karakter);

			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	} */

}
