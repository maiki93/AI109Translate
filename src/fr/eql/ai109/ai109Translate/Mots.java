package fr.eql.ai109.ai109Translate;

public class Mots {

	private String motFrançais;
	private String motAnglais;

	public Mots(String leMotFrançais, String leMotAnglais) {                 //constructeur
		setMotFrançais(leMotFrançais);
		setMotAnglais(leMotAnglais);	
	}

	public void setMotFrançais(String motFrançais) {                        //les setters et les getters
		this.motFrançais = motFrançais;
	}

	public String getMotFrançais() {
		return this.motFrançais;
	}

	public void setMotAnglais(String motAnglais) {
		this.motAnglais = motAnglais;
	}

	public String getMotAnglais() {
		return this.motAnglais;
	}

}
