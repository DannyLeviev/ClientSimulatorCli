package com.mynextcomp.ClientSimulatorCli.runnablesImpl;

public class KeyBoardWatcherRunnable implements Runnable {

	private final int numOfClients;

	public KeyBoardWatcherRunnable(int numOfClients) {
		this.numOfClients = numOfClients;
	}

	public void run() {
		while (true) {
			System.out.println(numOfClients);
		}
	}

}
