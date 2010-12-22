/**
 * 
 */
package aml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

/**
 * @author allan.lewis
 * 
 */
public class GoogleShopping {
	final URL x = new URL(
			"https://www.googleapis.com/shopping/search/v1/public/products?key=AIzaSyCnO_iAve82KRrjfFzjLEkGxH5IE-rEGyo&country=US&q=digital+camera");

	/**
	 * asd
	 * @throws IOException asd
	 */
	public GoogleShopping() throws IOException {
		BufferedReader in = new BufferedReader((Reader) new InputStreamReader(
				x.openStream()));

		String inputLine;

		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);

		in.close();

	}

	/**
	 * asd
	 * @param args asd
	 * @throws IOException asd
	 */
	public static void main(String[] args) throws IOException {
		new GoogleShopping();
	}

}
