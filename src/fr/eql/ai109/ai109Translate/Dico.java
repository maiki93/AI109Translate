package fr.eql.ai109.ai109Translate;

import java.util.ArrayList;

public class Dico {

	private ArrayList<Mots> tab = new ArrayList<Mots>();   //cr�ation d'un array remplis avec des Mots {String motFran�ais;
	                                                       //                                           String motAnglais; }
	public void ajoute(Mots nouvMot) {

		this.tab.add(nouvMot);
	}

	public String TraduitMot(String n) {             //m�thode qui retourne le mot fran�ais correspondant au mot anglais ou vice versa
		String motTraduit=null;                                   
		
		for(Mots m:tab) {
			if(m.getMotAnglais().equals(n)) {
				motTraduit=m.getMotFrançais();
			}
			else if(m.getMotFrançais().equals(n)) {
				motTraduit=m.getMotAnglais();
			}
		}return motTraduit;
	}	
}
