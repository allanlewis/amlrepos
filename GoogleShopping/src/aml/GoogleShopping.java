/**
 * 
 */
package aml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Google Shopping API test.
 * 
 * @author allan.lewis
 */
public class GoogleShopping {
	final String apiKey = "AIzaSyCnO_iAve82KRrjfFzjLEkGxH5IE-rEGyo";
	final String query = "digital camera".replace(" ", "+");
	final URL urlBase = new URL(
			"https://www.googleapis.com/shopping/search/v1/public/products?key="
					+ apiKey + "&country=GB&q=" + query);

	/**
	 * Default constructor.
	 * 
	 * @throws IOException
	 *             Data retrieval failed.
	 * @throws JSONException
	 *             JSON parsing failed.
	 */
	public GoogleShopping() throws IOException, JSONException {
		BufferedReader in = new BufferedReader((Reader) new InputStreamReader(
				urlBase.openStream()));
		String inputLine;
		String content = "";
		while ((inputLine = in.readLine()) != null) {
			content = content + "\n" + inputLine;
		}
		in.close();

		JSONObject j = new JSONObject(content);
		JSONArray items = j.getJSONArray("items");
		JSONObject product = new JSONObject();
		ArrayList<GoogleProduct> products = new ArrayList<GoogleProduct>();
		for (int i = 0; i < items.length(); i++) {
			product = items.getJSONObject(i).getJSONObject("product");
			printProduct(product);
			products.add(new GoogleProduct(product));
		}
		CompPriceAscending asc = new CompPriceAscending();
		CompPriceDescending desc = new CompPriceDescending();
		CompBrand cBrand = new CompBrand();
		
		Collections.sort(products, asc);
		print(products.get(0).getPriceString());	

		// Collections.sort(products, desc);
		// print(products.get(0).getPriceString());
		//
		// Collections.sort(products, cBrand);
		// print(products.get(0).getBrand());
		
		print("");
		for (int i = 0; i < products.size(); i++) {
			print(products.get(i).toString());
		}
	}

	/**
	 * Main function.
	 * 
	 * @param args
	 *            Command-line arguments.
	 * @throws IOException
	 *             Data retrieval failed.
	 * @throws JSONException
	 *             JSON parsing failed.
	 */
	public static void main(String[] args) throws IOException, JSONException {
		new GoogleShopping();
	}

	private void print(String s) {
		System.out.println(s);
		return;
	}

	@SuppressWarnings("unused")
	private void printJSON(JSONObject j) throws JSONException {
		print(j.toString(2));
		return;
	}

	private void printProduct(JSONObject product) throws JSONException,
			IOException {
		String retailer = product.getJSONObject("author").getString("name");
		// String brand = product.getString("brand");
		String description = product.getString("description");
		/*
		 * URL imageURL = null; try { imageURL = new
		 * URL(product.getJSONArray("images").getJSONObject(0)
		 * .getString("link")); } catch (MalformedURLException e) {
		 * e.printStackTrace(); } BufferedImage image = ImageIO.read(imageURL);
		 */
		double price = product.getJSONArray("inventories").getJSONObject(0)
				.getDouble("price");
		DecimalFormat df = new DecimalFormat("\u00A40.00");
		String priceString = df.format(price);
		// URL link = new URL(product.getString("link"));
		String title = product.getString("title");

		print(title);
		print(description);
		print(retailer + ": " + priceString);
		print("");

		return;
	}
}
