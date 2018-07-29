package com.mynextcomp.ClientSimulatorCli.RunnablesImpl;

public class KeyBoardWatcherRunnable implements Runnable {

	private final int numOfClients;
	private final String URL_STR = "http://localhost:8080/?clientID=";

	public KeyBoardWatcherRunnable(int numOfClients) {
		this.numOfClients = numOfClients;
	}

	public void run() {
		while (true) {
			System.out.println(numOfClients);
		}
	}

}
