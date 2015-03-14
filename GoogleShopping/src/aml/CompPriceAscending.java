/**
 * 
 */
package aml;

import java.util.Comparator;

/**
 * Sorts <tt>GoogleProduct</tt>s by price (ascending).
 * 
 * @author allan.lewis
 */
public class CompPriceAscending implements Comparator<GoogleProduct> {

	/**
	 * Main function.
	 * 
	 * @param args
	 *            Command-line arguments
	 */
	public static void main(String[] args) {
	}

	@Override
	public int compare(GoogleProduct arg0, GoogleProduct arg1) {
		double price0 = arg0.getPrice();
		double price1 = arg1.getPrice();

		if (price0 < price1)
			return -1;
		else if (price0 > price1)
			return 1;
		else
			return 0;
	}

}
