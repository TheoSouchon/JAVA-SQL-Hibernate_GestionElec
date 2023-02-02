package view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import bddutils.EntityClass;
import controleur.ControlleurCompteur;
import controleur.ControlleurContrat;
import controleur.ControlleurFacture;
import model.Compteur;
import model.Contrat;

public class Application {

	public static void main(String[] args) {
		EntityClass.init();
//		Periode periode1 = new Periode(LocalDate.of(2001, 1, 1), LocalDate.of(2001, 6, 15), 70);
//		Periode periode2 = new Periode(LocalDate.of(2001, 6, 16), LocalDate.of(2001, 12, 31), 70);
//		ClientPro clientpro1 = new ClientPro(3);
//		ClientPrive clientpriv1 = new ClientPrive("0612987436");
//		Contrat contrat1 = new Contrat("3 rue boulevard", LocalDate.of(2001, 1, 6), LocalDate.of(2001, 6, 15), 200,
//				"Tours");
//		Compteur compteur1 = new Compteur("modelCompteur1", 200, LocalDate.of(1999, 1, 1));
//		ReleveCompteur releve1 = new ReleveCompteur("free", 10, LocalDateTime.of(2001, 1, 1, 00, 00, 00));
//		ReleveCompteur releve2 = new ReleveCompteur("free", 70, LocalDateTime.of(2001, 6, 15, 00, 00, 00));
//		Facture facture1 = new Facture(LocalDate.of(2001, 1, 1), LocalDate.of(2001, 6, 15), LocalDate.of(2001, 6, 23),
//				LocalDate.of(2001, 6, 30), 4200, 60);
//		contrat1.setClient(clientpriv1);
//		contrat1.setCompteur(compteur1);
//		compteur1.setContrat(contrat1);
//		releve1.setCompteur(compteur1);
//		releve2.setCompteur(compteur1);
//		compteur1.addReleve(releve1);
//		compteur1.addReleve(releve2);
//		releve1.addFacture(facture1);
//		releve2.addFacture(facture1);
//		compteur1.addReleve(releve2);

//		EntityClass.em.getTransaction().begin();
//		EntityClass.em.persist(periode1);
//		EntityClass.em.persist(periode2);
//		EntityClass.em.persist(clientpro1);
//		EntityClass.em.persist(clientpriv1);
//		EntityClass.em.persist(contrat1);
//		EntityClass.em.persist(compteur1);
//		EntityClass.em.persist(releve1);
//		EntityClass.em.persist(releve2);
//		EntityClass.em.persist(facture1);
//		EntityClass.em.getTransaction().commit();

		System.out.println("1. Émettre une nouvelle facture\n");
		System.out.println("2. Afficher les contrats d'une ville\n");
		System.out.println("3. Afficher les compteurs d'un modèle\n");
		System.out.println("4. Créer un nouveau contrat\n");
		System.out.println("Choisir une operation");
		Scanner scanner = new Scanner(System.in);
		int choix = scanner.nextInt();
		scanner.nextLine();

		switch (choix) {
		case 1:
			System.out.println("Le client est-il prive ou pro ? (priv/pro)");
			Scanner scanner2 = new Scanner(System.in);
			String typeClient = scanner2.nextLine();
			if (!typeClient.equals("priv") && !typeClient.equals("pro")) {
				System.out.println("Type client : " + typeClient + " invalide\n");
				System.exit(-1);
			}
			System.out.println("Entrer l'id du client à facture");
			int idClient = scanner2.nextInt();
			scanner2.nextLine();
			int idCompteur = -1;
			if (typeClient.equals("pro")) {
				System.out.println("Entrer id compteur de la facture");
				idCompteur = scanner2.nextInt();
				scanner2.nextLine();
			}
			System.out.println("Entrer date de début de facture (yyyy-MM-dd/yyyy-MM-dd HH:mm:ss)");
			String dateDbt = scanner2.nextLine();
			LocalDate dateDbt2 = LocalDate.parse(dateDbt.substring(0, 10));
			System.out.println("Entrer date de fin de facture (yyyy-mm-dd/yyyy-mm-dd hh:mm:ss)");
			String dateFin = scanner2.nextLine();
			LocalDate dateFin2 = LocalDate.parse(dateFin.substring(0, 10));
			scanner2.close();
			ControlleurFacture.addFacture(typeClient, idCompteur, idClient, dateDbt2, dateFin2);
			break;
		case 2:
			System.out.println("Entrer la ville des clients à chercher\n");
			Scanner scanner3 = new Scanner(System.in);
			String villeClient = scanner3.nextLine();
			List<Contrat> listContrat = ControlleurContrat.getContratVille(villeClient);
			System.out.println(listContrat);
			break;
		case 3:
			System.out.println("Entrer le modele de compteur a chercher\n");
			Scanner scanner4 = new Scanner(System.in);
			String modele = scanner4.nextLine();
			List<Compteur> listCompteur = ControlleurCompteur.getCompteurModele(modele);
			System.out.println(listCompteur);
			break;
		case 4:
			Scanner scanner5 = new Scanner(System.in);
			System.out.println("Entrer l'adresse du local\n");
			String adresselocal = scanner5.nextLine();
			System.out.println("Entrer la date de debut du contrat(YYYY-MM-JJ)\n");
			String datedebut = scanner5.nextLine();
			LocalDate datedebutcontrat = LocalDate.parse(datedebut);
			System.out.println("Entrer l'id du client\n");
			int idClient2 = scanner5.nextInt();
			scanner5.nextLine();
			System.out.println("Entrer le max de KwH délivré\n");
			int maxKwh = scanner5.nextInt();
			scanner5.nextLine();
			ControlleurContrat.addContrat(adresselocal, datedebutcontrat, idClient2, maxKwh);
			break;
		default:
			System.out.println("-------------------------\nAction non reconnu\n");
			break;
		}
		EntityClass.close();

	}
}
