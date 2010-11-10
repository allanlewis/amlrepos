package aml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public class GoogleDirectionsSummary {

	enum eUnits {
		imperial, metric
	};

	public GoogleDirectionsSummary() {
		URL url = getGoogleMapsURL("NW4 2AR", "AL10 9BD", true, eUnits.imperial);
		final JSONObject j = getJSON(url);
		/*
		 * try { System.out.println(j.toString(4)); } catch (JSONException e) {
		 * e.printStackTrace(); System.exit(-1); }
		 */
		Iterator<String> i = j.keys();
		String s = "";
		while (i.hasNext()) {
			s = i.next();
			System.out.println(s);
		}

	}

	public static void main(String[] args) {
		new GoogleDirectionsSummary();
	}

	private JSONObject getJSON(URL url) {
		BufferedReader br;
		String content = "";
		try {
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			while (br.ready()) {
				content = content + br.readLine() + "\n";
			}
			return new JSONObject(content);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private URL getGoogleMapsURL(String origin, String dest, boolean alt,
			eUnits units) {
		final String urlBase = "http://maps.googleapis.com/maps/api/directions/json?";
		origin = origin.replaceAll(" ", "+");
		dest = dest.replaceAll(" ", "+");
		final String params = "origin=" + origin + "&destination=" + dest
				+ "&alternatives=" + Boolean.toString(alt) + "&units="
				+ units.toString() + "&region=uk"
				+ "&language=en-GB&sensor=false";
		URL url = null;
		try {
			url = new URL(urlBase + params);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return url;
	}
}
