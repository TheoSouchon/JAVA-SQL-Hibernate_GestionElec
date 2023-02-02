package controleur;

import java.util.List;

public class ControlleurCompteur {
	public static List<model.Compteur> getCompteurModele(String modele) {
		return CompteurDAO.getCompteurModel(modele);
	}
}
