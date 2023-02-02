package controleur;

import java.time.LocalDate;

import bddutils.EntityClass;
import model.Client;
import model.Facture;
import model.Periode;
import model.ReleveCompteur;

public class ControlleurFacture {

	public static int addFacture(String typeClient, int idCompteur, int idClient, LocalDate dateDbt2,
			LocalDate dateFin2) {
		Client client = EntityClass.em.find(Client.class, idClient);
		Facture f = new Facture();

		Periode periode = ControlleurPeriode.getPeriodeFacture(dateDbt2, dateFin2);
		ReleveCompteur releveDbt = null;
		ReleveCompteur releveFin = null;
		if (typeClient.equals("pro")) {
			releveDbt = EntityClass.em.find(ReleveCompteur.class,
					ControlleurReleveCompteur.getReleveDatePro(idClient, idCompteur, dateDbt2));
			System.out.println(releveDbt);
			releveFin = EntityClass.em.find(ReleveCompteur.class,
					ControlleurReleveCompteur.getReleveDatePro(idClient, idCompteur, dateFin2));
			System.out.println(releveFin);
		} else {
			releveDbt = EntityClass.em.find(ReleveCompteur.class,
					ControlleurReleveCompteur.getReleveDate(idClient, dateDbt2));
			System.out.println(releveDbt);
			releveFin = EntityClass.em.find(ReleveCompteur.class,
					ControlleurReleveCompteur.getReleveDate(idClient, dateFin2));
			System.out.println(releveFin);
		}

		int totalKwh = releveFin.getMontantElec() - releveDbt.getMontantElec();
		int prixTotal = totalKwh * periode.getPrixElec();
		System.out.println(releveDbt);
		System.out.println(releveFin);
		f.addReleve(releveDbt);
		f.addReleve(releveFin);
		f.setQuantiteElec(totalKwh);
		f.setMontantPaiement(prixTotal);

		EntityClass.em.getTransaction().begin();
		EntityClass.em.persist(f);
		EntityClass.em.getTransaction().commit();

		if (EntityClass.em.contains(f) || client == null) {
			return -1;
		} else {
			return 0;
		}
	}
}
