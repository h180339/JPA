package no.hvl.dat107;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

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

	public Ansatt finnAnsattPaaPK(int ansNr) {

		EntityManager em = emf.createEntityManager();

		Ansatt a1 = null;
		try {
			a1 = em.find(Ansatt.class, ansNr);
		} finally {
			em.close();
		}
		return a1;
	}

	public Ansatt finnAnsattPaaNavn(String brukernavn) {

		String queryString = "SELECT t FROM Ansatt t "
			+ "WHERE t.brukerNavn = :navn";

		EntityManager em = emf.createEntityManager();

		Ansatt ansatt = null;
		try {
			TypedQuery<Ansatt> query
				= em.createQuery(queryString, Ansatt.class);
			query.setParameter("navn", brukernavn);
			ansatt = query.getSingleResult();

		} catch (NoResultException e) {
			// e.printStackTrace();
		} finally {
			em.close();
		}
		return ansatt;
	}

	public void slettAnsatt(Ansatt ansatt) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			//NB! Ikke nok med em.merge(liste); Det er den
			//returnerte listen som er managed.
			ansatt = em.merge(ansatt);

			em.remove(ansatt);

			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	public void oppdaterAnsatt(Ansatt ansatt) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.merge(ansatt);

			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	public void skrivUtTabell() {

		String queryString = "SELECT t FROM Ansatt t ";

		EntityManager em = emf.createEntityManager();

		List<Ansatt> ansatte = null;
		try {
			TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
			ansatte = query.getResultList();
			for(Ansatt ansatt : ansatte) {
				System.out.println(ansatt);
			}

		} finally {
			em.close();
		}
	}
	public void oppdaterAnsattAvdeling(Ansatt ansatt, int avdNr) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		if(ansatt.getAvd().getaId().getAid() != ansatt.getAid()) { //sammenligner sin egen avdelingsjefId med sin egen id

			AvdelingEAO avdelingEAO = new AvdelingEAO();
			Avdeling avdeling = avdelingEAO.finnAvdelingPK(avdNr);
			ansatt.setAvd(avdeling);
			try {
				tx.begin();

				em.merge(ansatt);

				tx.commit();
			} catch (Throwable e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				em.close();
			}
			System.out.println("success!, oppdaterte den ansatte sin avdeling");
		}else {
			System.out.println("Gikk ikke, den ansatte er allerede sjef i egen avdeling");
		}


	}

}
