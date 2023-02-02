package controleur;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import bddutils.EntityClass;
import model.Contrat;

public class ContratDAO {
	public static List<Contrat> getContratVille(String Ville) {
		List<Contrat> listContrat = new ArrayList<Contrat>();
		Query query = EntityClass.em.createQuery("from Contrat p where p.ville = :ville_parm ");
		query.setParameter("ville_parm", Ville);
		listContrat = query.getResultList();
		return listContrat;
	}
}
