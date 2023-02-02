package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idFacture;

	private LocalDate dateDebt;
	private LocalDate dateFin;
	private LocalDate dateEmission; // date d'envoi de la facture
	private LocalDate datePaiement;
	private int montantPaiement;
	private int quantiteElec;

	@ManyToMany
	@JoinTable(name = "FACTURE_RELEVE", joinColumns = {
			@JoinColumn(name = "FACTURE_ID", referencedColumnName = "idFacture") }, inverseJoinColumns = {
					@JoinColumn(name = "RELEVE_ID", referencedColumnName = "idReleveCompteur") })
	private List<ReleveCompteur> listReleve;

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public LocalDate getDateDebt() {
		return dateDebt;
	}

	public void setDateDebt(LocalDate dateDebt) {
		this.dateDebt = dateDebt;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public LocalDate getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(LocalDate dateEmission) {
		this.dateEmission = dateEmission;
	}

	public LocalDate getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}

	public int getMontantPaiement() {
		return montantPaiement;
	}

	public void setMontantPaiement(int montantPaiement) {
		this.montantPaiement = montantPaiement;
	}

	public int getQuantiteElec() {
		return quantiteElec;
	}

	public void setQuantiteElec(int quantiteElec) {
		this.quantiteElec = quantiteElec;
	}

	public List<ReleveCompteur> getListReleve() {
		return listReleve;
	}

	public void addReleve(ReleveCompteur releve) {
		this.listReleve.add(releve);
	}

	public Facture(LocalDate dateDebt, LocalDate dateFin, LocalDate dateEmission, LocalDate datePaiement,
			int montantPaiement, int quantiteElec) {
		this.listReleve = new ArrayList<ReleveCompteur>();
		this.dateDebt = dateDebt;
		this.dateFin = dateFin;
		this.dateEmission = dateEmission;
		this.datePaiement = datePaiement;
		this.montantPaiement = montantPaiement;
		this.quantiteElec = quantiteElec;
	}

	public Facture() {
		listReleve = new ArrayList<>();
	}

}
