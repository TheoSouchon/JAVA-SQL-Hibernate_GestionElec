package controleur;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import bddutils.EntityClass;
import model.Periode;

public class PeriodeDAO {
	public static Periode getPeriode(LocalDate dateDbt, LocalDate dateFin) {
		Query query = EntityClass.em.createQuery(
				"SELECT prixElec FROM Periode where cast(dateDebt as LocalDate)= :date_debut_param AND cast(dateFin as LocalDate)= :date_fin_param ");
		query.setParameter("date_debut_param", dateDbt);
		query.setParameter("date_fin_param", dateFin);

		List<Integer> prix = query.getResultList();
		if (prix.isEmpty()) {
			System.out.println("La période n'existe pas\n");
			System.exit(-1);
		}
		Periode p = new Periode(dateDbt, dateFin, prix.get(0));
		return p;

	}
}
