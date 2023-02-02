package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ClientPrive extends Client {
	private String numTel;
	@OneToOne(cascade = CascadeType.ALL)
	private Contrat contrat;

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public ClientPrive(String numTel) {
		super();
		this.numTel = numTel;
	}

	public ClientPrive() {
		super();
	}

}
