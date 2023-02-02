package controleur;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import bddutils.EntityClass;
import model.Compteur;

public class CompteurDAO {
	public static List<Compteur> getCompteurModel(String modele) {
		List<Compteur> listCompteur = new ArrayList<Compteur>();
		Query query = EntityClass.em.createQuery("from Compteur c where c.modele = :modelCompteur");
		query.setParameter("modelCompteur", modele);
		listCompteur = query.getResultList();
		return listCompteur;
	}
}
