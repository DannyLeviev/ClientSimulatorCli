package com.mynextcomp.ClientSimulatorCli.runnablesImpl;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

import com.mynextcomp.ClientSimulatorCli.utils.Utils;

public class ClientRunnable implements Runnable {

	private static final AtomicBoolean stopRunning = new AtomicBoolean(true);

	private final String URL_STR = "http://localhost:8080/?clientID=";
	private static final Random rand = ThreadLocalRandom.current();
	private final int MAX_DELAY_4_RAND = 1000;
	private String threadName;

	public static void stopCliens() {
		stopRunning.set(true);
	}

	public void run() {
		threadName = Thread.currentThread().getName();
		System.out.println("Client_" + threadName + " is alive !");
		stopRunning.set(false);
		while (!stopRunning.get()) {
			int responseCode = Utils.sendRequest(URL_STR + threadName);
			System.out.println("Client_" + threadName + " received status code : " + responseCode);
			try {
				Thread.sleep(rand.nextInt(MAX_DELAY_4_RAND));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("Client_" + threadName + " was stopped !");
	}

}
