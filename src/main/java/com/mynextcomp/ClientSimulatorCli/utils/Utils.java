package com.mynextcomp.ClientSimulatorCli.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Utils {

	public static int getValidNumOfClientsFromUser(Scanner cmdReader) {
		int result = -1;
		do {
			while (!cmdReader.hasNextInt()) {
				String input = cmdReader.next();
				System.out.printf("\"%s\" is not a valid number.\n", input);
			}
			result = cmdReader.nextInt();
		} while (result < 0);
		return result;
	}

	
	public static int performHttpRequest(String urlStr) {
		int result = -1;
		try {
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			result = conn.getResponseCode();
			conn.disconnect();
		} catch (IOException e) {

			e.printStackTrace();

		}
		return result;
	}
}
