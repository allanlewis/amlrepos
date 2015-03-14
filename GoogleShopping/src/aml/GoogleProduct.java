/**
 * 
 */
package aml;

import java.text.DecimalFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Represents a result from a Google Shopping search.
 * 
 * @author allan.lewis
 */
public class GoogleProduct implements Comparable<GoogleProduct> {
	private final String brand, title, description, retailer, link, imageLink;
	private final String priceString;
	private final double price;
	private final DecimalFormat currency = new DecimalFormat("\u00A40.00");

	/**
	 * Default constructor.
	 * 
	 * @param product
	 *            A JSON object representing a result from a Google Shopping
	 *            search.
	 * @throws JSONException
	 *             Thrown if <tt>product</tt> is invalid.
	 */
	public GoogleProduct(JSONObject product) throws JSONException {
		// Simple strings
		brand = product.has("brand") ? product.getString("brand") : "";
		title = product.has("title") ? product.getString("title") : "";
		description = product.has("description") ? product
				.getString("description") : "";
		link = product.has("link") ? product.getString("link") : "";

		// Retailer is within the "author" object
		JSONObject author = new JSONObject();
		if (product.has("author")) {
			author = product.getJSONObject("author");
		}
		retailer = author.has("name") ? author.getString("name") : "";

		// Price is within the "inventories" array
		JSONArray inv = new JSONArray();
		JSONObject inv0 = new JSONObject();
		if (product.has("inventories")) {
			inv = product.getJSONArray("inventories");
			if (inv.length() > 0) {
				inv0 = inv.getJSONObject(0);
			}
		}
		price = inv0.has("price") ? inv0.getDouble("price") : 0.0;
		priceString = currency.format(price);

		// Image link is within the "images" array
		JSONArray images = new JSONArray();
		JSONObject image0 = new JSONObject();
		if (product.has("images")) {
			images = product.getJSONArray("images");
			if (images.length() > 0) {
				image0 = images.getJSONObject(0);
			}
		}
		imageLink = image0.has("link") ? image0.getString("link") : "";
	}

	@Override
	public int compareTo(GoogleProduct o) {
		if (price < o.price)
			return -1;
		else if (price > o.price)
			return 1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return brand + ": " + title + "\n" + retailer + ": " + priceString
				+ "\n";
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            Command-line arguments.
	 * @throws JSONException
	 *             JSON exception.
	 */
	public static void main(String args[]) throws JSONException {
		new GoogleProduct(new JSONObject());
	}

	/**
	 * @return the price
	 */
	public final double getPrice() {
		return price;
	}

	/**
	 * @return the brand
	 */
	public final String getBrand() {
		return brand;
	}

	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @return the retailer
	 */
	public final String getRetailer() {
		return retailer;
	}

	/**
	 * @return the link
	 */
	public final String getLink() {
		return link;
	}

	/**
	 * @return the imageLink
	 */
	public final String getImageLink() {
		return imageLink;
	}

	/**
	 * @return the priceString
	 */
	public final String getPriceString() {
		return priceString;
	}
}
