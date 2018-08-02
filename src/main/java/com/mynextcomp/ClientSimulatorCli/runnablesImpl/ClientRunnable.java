package com.mynextcomp.ClientSimulatorCli.runnablesImpl;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.mynextcomp.ClientSimulatorCli.utils.Utils;

public class ClientRunnable implements Runnable {

	private static volatile boolean shouldContinueRunning = true;
	//private final static Logger LOGGER = LoggerFactory.getLogger(ClientRunnable.class);

	private final String URL_STR = "http://localhost:8080/?clientID=";
	private static final Random rand = ThreadLocalRandom.current();
	private final int MAX_DELAY_4_RAND = 1000; // Max delay between (each) client calls to the DdosProtector service.

	public void run() {
		System.out.println("Client_" + Thread.currentThread().getName() + " is alive !");
		//LOGGER.info("Client_{} is alive !", Thread.currentThread().getName());
		while (shouldContinueRunning && !Thread.currentThread().isInterrupted()) {
			int responseCode = Utils.performHttpRequest(URL_STR + Thread.currentThread().getName());
			System.out.println("Client_" + Thread.currentThread().getName() + " received status code : " + responseCode);
			//LOGGER.info("Client_{} received status code : ", Thread.currentThread().getName(), responseCode);
			try {
				Thread.sleep(rand.nextInt(MAX_DELAY_4_RAND));
			} catch (InterruptedException e) {
				// Do nothing, to enable "gracefully drain all the requests" !
				//LOGGER.warn("Client_{} was interrupted !", Thread.currentThread().getName());
			}
		}
		System.out.println("Client_" + Thread.currentThread().getName() + " was gracefully stopped !");
		//LOGGER.warn("Client_{} was gracefully stopped !", Thread.currentThread().getName());
	}

	public static void setShouldContinueRunning(boolean isOn) {
		shouldContinueRunning = isOn;
	}

}
