package com.mynextcomp.ClientSimulatorCli.runnablesImpl;

import com.mynextcomp.ClientSimulatorCli.utils.Utils;

public class ClientRunnable implements Runnable {

	private final String URL_STR = "http://localhost:8080/?clientID=";

	public void run() {

		int responseCode = Utils
				.performHttpRequest("http://localhost:8080/?clientID=" + Thread.currentThread().getName());
		System.out.println(responseCode);

	}

}
