/**
 * 
 */
package aml;

import java.util.Comparator;

/**
 * Sorts <tt>GoogleProduct</tt>s alphabetically by brand.
 * 
 * @author allan.lewis
 */
public class CompBrand implements Comparator<GoogleProduct> {

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
		String brand0 = arg0.getBrand();
		String brand1 = arg1.getBrand();

		int result;
		if (brand0 == "")
			result = 1;
		else if (brand1 == "")
			result = -1;
		else
			result = brand0.compareTo(brand1);
		
		return result;
	}

}
