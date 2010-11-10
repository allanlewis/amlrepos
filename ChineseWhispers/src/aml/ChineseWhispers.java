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
	 * @throws Exception
	 *             If translation fails.
	 */
	public static void main(String[] args) throws Exception {
		// new ChineseWhispers();
		Translate.setHttpReferrer("http://www.google.co.uk/");

		int n = 2;
		String text = "Does the associative law apply to multiplicative equations in a Bernoulli system in a harmonised spatial plane?";
		out("Original:\n\t" + text);

		Language[] chain = { Language.ENGLISH, Language.CZECH, Language.DUTCH,
				Language.GERMAN };
		System.out.println("Result:\n\t" + bounceN(text, chain, 1));
	}

	private static String bounceN(String text, Language[] lang, int iterations)
			throws Exception {
		int i, j;
		Language from, to;

		for (i = 0; i < iterations; i++) {
			out("Iteration " + (i + 1) + ":\t");
			for (j = 0; j < lang.length; j++) {
				from = lang[j];
				to = (j == lang.length - 1) ? lang[0] : lang[j + 1];
				text = Translate.execute(text, from, to);
				out("\t" + text);
			}
		}
		return text;
	}

	private static void out(String s) {
		System.out.println(s);
	}
}
