package fr.eql.ai109.ai109Translate;

/**
 * Main only testing
 * maiki93
 */
public class Translate {

	public static void main(String[] args) {

		System.out.println("== Welcome to a very advanced translation program ==");

		ParserLarousse parserLarousse = new ParserLarousse();
		String result = parserLarousse.findTraduction("dog", false);
		System.out.println("Traduction de dog : " + result);

		result = parserLarousse.findTraduction("chien", true);
		System.out.println("Traduction de chien : " + result);
	}

}
