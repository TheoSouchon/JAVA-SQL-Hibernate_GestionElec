package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Periode {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPeriode;
	private LocalDate dateDebt;
	private LocalDate dateFin;
	private int prixElec;

	public int getPrixElec() {
		return prixElec;
	}

	public void setPrixElec(int prixElec) {
		this.prixElec = prixElec;
	}

	public Periode(LocalDate dateDebt, LocalDate dateFin, int prixElec) {
		this.dateDebt = dateDebt;
		this.dateFin = dateFin;
		this.prixElec = prixElec;
	}

	public Periode() {
		super();
	}

	@Override
	public String toString() {
		return "Periode [dateDebt=" + dateDebt + ", dateFin=" + dateFin + ", prixElec=" + prixElec + "]";
	}
}
