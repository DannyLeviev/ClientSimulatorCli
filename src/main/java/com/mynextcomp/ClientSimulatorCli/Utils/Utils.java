package com.mynextcomp.ClientSimulatorCli.Utils;

import java.util.Scanner;

public class Utils {

	public static int getValidNumOfClientsFromUser() {
		int result = -1;
		Scanner cmdReader = new Scanner(System.in);

		do {
			while (!cmdReader.hasNextInt()) {
				String input = cmdReader.next();
				System.out.printf("\"%s\" is not a valid number.\n", input);
			}
			result = cmdReader.nextInt();
		} while (result < 0);

		cmdReader.close();
		return result;
	}

}
