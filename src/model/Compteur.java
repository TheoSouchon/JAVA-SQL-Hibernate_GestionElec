package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Compteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCompteur;

	private String modele;
	private int maxVolumeElecCompteur;
	private LocalDate dateInstallation;

	@OneToOne
	private Contrat contrat;

	@OneToMany(mappedBy = "idReleveCompteur", cascade = CascadeType.ALL)
	private List<ReleveCompteur> listReleve;

	public int getIdCompteur() {
		return idCompteur;
	}

	public void setIdCompteur(int idCompteur) {
		this.idCompteur = idCompteur;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getMaxVolumeElecCompteur() {
		return maxVolumeElecCompteur;
	}

	public void setMaxVolumeElecCompteur(int maxVolumeElecCompteur) {
		this.maxVolumeElecCompteur = maxVolumeElecCompteur;
	}

	public LocalDate getDateInstallation() {
		return dateInstallation;
	}

	public void setDateInstallation(LocalDate dateInstallation) {
		this.dateInstallation = dateInstallation;
	}

	public List<ReleveCompteur> getListReleve() {
		return listReleve;
	}

	public void addReleve(ReleveCompteur releve) {
		this.listReleve.add(releve);
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Compteur(String modele, int maxVolumeElecCompteur, LocalDate dateInstallation) {
		this.listReleve = new ArrayList<ReleveCompteur>();
		this.modele = modele;
		this.maxVolumeElecCompteur = maxVolumeElecCompteur;
		this.dateInstallation = dateInstallation;
	}

	public Compteur() {
		super();
	}

	@Override
	public String toString() {
		return "Compteur [idCompteur=" + idCompteur + ", modele=" + modele + ", maxVolumeElecCompteur="
				+ maxVolumeElecCompteur + ", dateInstallation=" + dateInstallation + ", listReleve=" + listReleve
				+ "]\n";
	}

}
