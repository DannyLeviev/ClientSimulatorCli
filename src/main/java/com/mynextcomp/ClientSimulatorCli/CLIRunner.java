package com.mynextcomp.ClientSimulatorCli;

import java.io.IOException;
import java.util.Scanner;

import com.mynextcomp.ClientSimulatorCli.runnablesImpl.ClientRunnable;
import com.mynextcomp.ClientSimulatorCli.utils.Utils;

public class CLIRunner {

	private static final String SAY_HI = "Hello user.";
	private static final String ASK_4_NUM_OF_CLIENTS = "How many HTTP clients would you like to simulate?";

	public static void main(String[] args) {
		System.out.println(SAY_HI);
		System.out.println(ASK_4_NUM_OF_CLIENTS);

		try (Scanner cmdReader = new Scanner(System.in)) {
			int numOfClients = Utils.getValidNumOfClientsFromUser(cmdReader);

			Thread[] clients = new Thread[numOfClients];
			for (int i = 0; i < numOfClients; i++) {
				clients[i] = new Thread(new ClientRunnable(), Integer.toString(i));
			}
			for (Thread t : clients) {
				t.start();
			}
			System.in.read();
			ClientRunnable.stopCliens();
			//Join the threads for graceful shutdown
			for (Thread t : clients) {
				t.join();
			}
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("Leaving the Client Simulator CLI !");
	}
}
