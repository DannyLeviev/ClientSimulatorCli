package com.mynextcomp.ClientSimulatorCli.runnablesImpl;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.mynextcomp.ClientSimulatorCli.utils.Utils;

public class ClientRunnable implements Runnable {

	private final String URL_STR = "http://localhost:8080/?clientID=";
	private static final Random rand = ThreadLocalRandom.current();
	private final int UPPER_TIME_LIMIT_4_RAND = 1000; // 1 sec

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(rand.nextInt(UPPER_TIME_LIMIT_4_RAND));
			} catch (InterruptedException e) {
				//Do nothing, to enable "gracefully drain all the requests" !
			}
			int responseCode = Utils.performHttpRequest(URL_STR + Thread.currentThread().getName());
			System.out.println("Client_" + Thread.currentThread().getName() + " received status code : " + responseCode);
		}
	}

}
