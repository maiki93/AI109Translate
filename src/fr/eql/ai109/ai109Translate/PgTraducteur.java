package fr.eql.ai109.ai109Translate;

import java.util.Scanner;

public class PgTraducteur {

	public static void main(String[] args) {


		Dico dictionnaire = new Dico();         //création d'un dictionnaire vide
		Scanner scan = new Scanner(System.in);                

		ParserLarousse parserLarousse = new ParserLarousse();
		
		String entrée="";
		do {

			System.out.println("Saisissez un mot à traduire ou un ajout sous la forme '+ chat cat' pour ajouter un nouveau mot au dictionnaire, "
					+ "ou 'exit' quand vous avez terminé.");
			entrée = scan.nextLine();


			if (entrée.charAt(0)=='+'){   //l'utilisateur a saisi 2 mots, on crée une nouvelle instance de la classe Mots

				String [] motsSéparés = entrée.split(" ");  
				Mots M = new Mots(motsSéparés [1], motsSéparés[2]);     //création d'une instance de Mots avec les nouveaux mots
				dictionnaire.ajoute(M);                                 //ajout de ces 2 mots à l'array Dico

			}

			if (entrée.charAt(0)=='-'){   //l'utilisateur a saisi 2 mots, on crée une nouvelle instance de la classe Mots
				String [] motsSéparés = entrée.split(" ");  
				
				String traduction = parserLarousse.findTraduction(motsSéparés[1], true);
				Mots M = new Mots(motsSéparés [1], traduction);     //création d'une instance de Mots avec les nouveaux mots
				dictionnaire.ajoute(M);                                 //ajout de ces 2 mots à l'array Dico

			}

			else  {     //l'utilisateur a saisi un mot français ou anglais, on veut afficher sa traduction

				System.out.println(dictionnaire.TraduitMot(entrée));
			}
		} while (! entrée.equals("exit"));

		scan.close();
	}
}
