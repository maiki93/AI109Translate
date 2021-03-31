package fr.eql.ai109.ai109Translate;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*; //Document;
import org.jsoup.select.Elements;

public class ParserLarousse {

	// indicates if we query French to English (true) or english to French (False)
	private boolean frToEng;
	private String url;
	
	private static final String URL_LAROUSSE = "https://www.larousse.fr/dictionnaires/";
	
	// constructor, default is fine
	//ParserLarousse() {}
	
	public String findTraduction(String nom, boolean frToEng) {
		this.frToEng = frToEng;
		this.createUrl(nom);
		
		String traduction = this.parse();
		System.out.println("Traduction found "+ traduction);
		return traduction;
	}
	
	private void createUrl(String nom) {
		if( this.frToEng) 
			this.url = URL_LAROUSSE + "francais-anglais/" + nom.strip();
		else
			this.url = URL_LAROUSSE + "anglais-francais/" + nom.strip();
		System.out.println("created url "+ this.url);
	}
	
	private String parse() {
		String traduction="";
		Document doc = null;
		//Jsoup
		try {// https://en.wikipedia.eng
			//doc = Jsoup.connect("https://www.larousse.fr/dictionnaires/anglais-francais/dog").get();
			doc = Jsoup.connect(this.url).get();
			// String title = doc.title();
			// System.out.println("title "+ title);
		} catch (IOException ex) {
			System.err.println("Oups... IOException\n" + ex);
		}

		// search for <article class="content fr-en" role="article">
		//Elements content = doc.getElementsByClass("content fr-en");    //ById("content");
		Elements content = doc.getElementsByClass("Traduction"); // & lang=fr 
		/*for( Element link : content) {
			System.out.println("new link");
			System.out.println(" " + link.text());
		}*/
		
		// return the name and the gender
		String result = content.first().text();
		traduction = result.split(" ")[0];
		return traduction;
	}
		
	
}
