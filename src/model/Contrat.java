package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Contrat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdContrat;
	private String ville;
	private String adresseLocal;
	private LocalDate dateSignature;
	private LocalDate dateDebut;
	private int maxVolumeElecContrat;

	@ManyToOne(cascade = CascadeType.ALL)
	private Client client;

	@OneToOne(cascade = CascadeType.ALL)
	private Compteur compteur;

	public int getIdContrat() {
		return IdContrat;
	}

	public void setIdContrat(int idContrat) {
		IdContrat = idContrat;
	}

	public String getAdresseLocal() {
		return adresseLocal;
	}

	public void setAdresseLocal(String adresseLocal) {
		this.adresseLocal = adresseLocal;
	}

	public LocalDate getDateSignature() {
		return dateSignature;
	}

	public void setDateSignature(LocalDate dateSignature) {
		this.dateSignature = dateSignature;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Compteur getCompteur() {
		return compteur;
	}

	public void setCompteur(Compteur compteur) {
		this.compteur = compteur;
	}

	public int getMaxVolumeElecContrat() {
		return maxVolumeElecContrat;
	}

	public void setMaxVolumeElecContrat(int maxVolumeElecContrat) {
		this.maxVolumeElecContrat = maxVolumeElecContrat;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Contrat(String adresseLocal, LocalDate dateSignature, LocalDate dateDebut, int maxVolumeElecContrat,
			String ville) {
		this.adresseLocal = adresseLocal;
		this.dateSignature = dateSignature;
		this.dateDebut = dateDebut;
		this.maxVolumeElecContrat = maxVolumeElecContrat;
		this.ville = ville;
	}

	public Contrat() {
		super();
	}

	@Override
	public String toString() {
		return "Contrat [IdContrat=" + IdContrat + ", adresseLocal=" + adresseLocal + ", dateSignature=" + dateSignature
				+ ", dateDebut=" + dateDebut + ", compteur=" + compteur + ", maxVolumeElecContrat="
				+ maxVolumeElecContrat + "]\n";
	}

}
