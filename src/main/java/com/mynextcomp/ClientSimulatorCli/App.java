package com.mynextcomp.ClientSimulatorCli;

import java.io.IOException;

import com.mynextcomp.ClientSimulatorCli.runnablesImpl.KeyBoardWatcherRunnable;
import com.mynextcomp.ClientSimulatorCli.utils.Utils;

public class App {

	private static final String SAY_HI = "Hello user.";
	private static final String ASK_2_TYPE_NUM_OF_CLIENTS = "How many HTTP clients would you like to simulate?";

	public static void main(String[] args) {
		System.out.println(SAY_HI);
		System.out.println(ASK_2_TYPE_NUM_OF_CLIENTS);
		// Get from user (and validate) number of Clients:
		int numOfClients = Utils.getValidNumOfClientsFromUser();

		// Initiate and start keyBoardWatcher thread:
		Thread keyBoardWatcher = new Thread(new KeyBoardWatcherRunnable(numOfClients));
		keyBoardWatcher.start();
		// Listen to the keyboard to know when to stop the clients:
		try {
			System.in.read();
		} catch (IOException e) {
			// No need to handle, has no meaning!
		}
		// Signal to the Clients to stop running:
		// TBD - signal !!!
		System.exit(0);
	}
}
