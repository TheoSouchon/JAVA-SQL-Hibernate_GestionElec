package controleur;

import java.time.LocalDate;

public class ControlleurReleveCompteur {
	public static int getReleveDate(int idClient, LocalDate date) {
		return ReleveCompteurDAO.getReleve(idClient, date);
	}

	public static int getReleveDatePro(int idClient, int idCompteur, LocalDate date) {
		return ReleveCompteurDAO.getRelevePro(idClient, idCompteur, date);
	}

}
