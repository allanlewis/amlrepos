/**
 * Allan Lewis's personal Java package.
 */
package aml;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;

/**
 * Tool to bounce text around Google Translate.
 * 
 * @author allan.lewis
 */
public class ChineseWhispers {

	/**
	 * Default constructor.
	 */
	public ChineseWhispers() {

	}

	/**
	 * Main function.
	 * 
	 * @param args
	 *            Command-line arguments.
	 * @throws Exception If translation fails.
	 */
	public static void main(String[] args) throws Exception {
		// new ChineseWhispers();
		Translate.setHttpReferrer("http://www.google.co.uk/");

//		String translatedText = Translate.execute("Bonjour le monde",
//				Language.FRENCH, Language.ENGLISH);
//		System.out.println(translatedText);
		
		
	}

}
