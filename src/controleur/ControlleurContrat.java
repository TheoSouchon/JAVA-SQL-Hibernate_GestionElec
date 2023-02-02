package controleur;

import java.time.LocalDate;
import java.util.List;

import bddutils.EntityClass;
import model.Client;
import model.Contrat;

public class ControlleurContrat {
	public static List<Contrat> getContratVille(String Ville) {
		return ContratDAO.getContratVille(Ville);
	}

	public static int addContrat(String adresseLocal, LocalDate dateDebutContrat, int idClient, int maxKwh) {

		Client client = EntityClass.em.find(Client.class, idClient);

		Contrat c = new Contrat();
		c.setAdresseLocal(adresseLocal);
		c.setDateDebut(dateDebutContrat);
		c.setClient(client);
		c.setMaxVolumeElecContrat(maxKwh);

		EntityClass.em.getTransaction().begin();
		EntityClass.em.persist(c);
		EntityClass.em.getTransaction().commit();

		if (EntityClass.em.contains(c) || client == null) {
			return -1;
		} else {
			return 0;
		}

	}
}
