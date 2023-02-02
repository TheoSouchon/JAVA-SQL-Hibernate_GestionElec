package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ReleveCompteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReleveCompteur;

	private String operateur;
	private int montantElec;
	private LocalDateTime dateReleve;

	@ManyToOne(cascade = CascadeType.ALL)
	private Compteur compteur;

	@ManyToMany(mappedBy = "listReleve")
	private List<Facture> listFacture;

	public int getIdReleveCompteur() {
		return idReleveCompteur;
	}

	public void setIdReleveCompteur(int idReleveCompteur) {
		this.idReleveCompteur = idReleveCompteur;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public int getMontantElec() {
		return montantElec;
	}

	public void setMontantElec(int montantElec) {
		this.montantElec = montantElec;
	}

	public LocalDateTime getDateReleve() {
		return dateReleve;
	}

	public void setDateReleve(LocalDateTime dateReleve) {
		this.dateReleve = dateReleve;
	}

	public Compteur getCompteur() {
		return compteur;
	}

	public void setCompteur(Compteur compteur) {
		this.compteur = compteur;
	}

	public List<Facture> getListFacture() {
		return listFacture;
	}

	public void addFacture(Facture facture) {
		this.listFacture.add(facture);
	}

	public ReleveCompteur(String operateur, int montantElec, LocalDateTime dateReleve) {
		this.listFacture = new ArrayList<Facture>();
		this.operateur = operateur;
		this.montantElec = montantElec;
		this.dateReleve = dateReleve;
	}

	public ReleveCompteur() {
		super();
	}

	@Override
	public String toString() {
		return "ReleveCompteur [idReleveCompteur=" + idReleveCompteur + ", operateur=" + operateur + ", montantElec="
				+ montantElec + ", dateReleve=" + dateReleve + "]";
	}
}
