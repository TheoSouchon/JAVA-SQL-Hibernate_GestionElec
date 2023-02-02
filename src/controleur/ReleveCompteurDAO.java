package controleur;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import bddutils.EntityClass;

public class ReleveCompteurDAO {
	public static int getReleve(int idClient, LocalDate date) {
		Query query = EntityClass.em.createQuery(
				"Select r.idReleveCompteur FROM ReleveCompteur as r, Compteur as c, Contrat as ct, Client as cl INNER JOIN r.compteur INNER JOIN c.contrat INNER JOIN ct.client where cast(r.dateReleve as LocalDate)= :date_param AND cl.idClient= :idclient_param");
		query.setParameter("idclient_param", idClient);
		query.setParameter("date_param", date);

		List<Integer> rc = query.getResultList();
		if (rc.isEmpty()) {
			System.out.println("Relevé n'existe pas\n");
			System.exit(-1);
		}
		return rc.get(0);
	}

	public static int getRelevePro(int idClient, int idCompteur, LocalDate date) {
		Query query = EntityClass.em.createQuery(
				"Select r.idReleveCompteur FROM ReleveCompteur as r, Compteur as c, Contrat as ct, Client as cl INNER JOIN r.compteur INNER JOIN c.contrat INNER JOIN ct.client where cast(r.dateReleve as LocalDate)= :date_param AND cl.idClient= :idclient_param AND c.idCompteur= :idCompteur");
		query.setParameter("idclient_param", idClient);
		query.setParameter("date_param", date);
		query.setParameter("idCompteur", idCompteur);
		List<Integer> rc = query.getResultList();
		if (rc.isEmpty()) {
			System.out.println("Relevé n'existe pas\n");
			System.exit(-1);
		}
		return rc.get(0);

	}

}
