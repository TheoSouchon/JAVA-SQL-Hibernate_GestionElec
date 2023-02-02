package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ClientPro extends Client {
	private int nbBatiments;
	@OneToMany(mappedBy = "IdContrat", cascade = CascadeType.ALL)
	private List<Contrat> listContrats;

	public int getNbBatiments() {
		return nbBatiments;
	}

	public void setNbBatiments(int nbBatiments) {
		this.nbBatiments = nbBatiments;
	}

	public List<Contrat> getListContrats() {
		return listContrats;
	}

	public void addContrat(Contrat contrat) {
		listContrats.add(contrat);
	}

	public ClientPro(int nbBatiments) {
		listContrats = new ArrayList<Contrat>();
		this.nbBatiments = nbBatiments;
	}

	public ClientPro() {
		super();
	}

}
