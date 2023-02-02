package controleur;

import java.time.LocalDate;

import model.Periode;

public class ControlleurPeriode {
	public static Periode getPeriodeFacture(LocalDate dateDbt, LocalDate dateFin) {
		return PeriodeDAO.getPeriode(dateDbt, dateFin);
	}
}
