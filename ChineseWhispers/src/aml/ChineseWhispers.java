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
		String text = "This is a test.";
		out("Original:\n\t" + text);
		final Language from = Language.ENGLISH;
		final Language to = Language.ALBANIAN;
		for (int i = 0; i < n; i++) {
			out("Iteration " + (i + 1) + ":\t");
			text = Translate.execute(text, from, to);
			out("\t" + text);
			text = Translate.execute(text, to, from);
			out("\t" + text);
		}
		System.out.println("Finally:\n\t" + text);
	}

	// public static void main(String[] args) throws Exception {
	// TranslatorFrame t = new TranslatorFrame();
	// t.setVisible(true);
	// }

	private static void out(String s) {
		System.out.println(s);
	}
}
