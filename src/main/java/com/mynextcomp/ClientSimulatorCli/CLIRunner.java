package com.mynextcomp.ClientSimulatorCli;

import java.io.IOException;
import java.util.Scanner;

import com.mynextcomp.ClientSimulatorCli.runnablesImpl.ClientRunnable;
import com.mynextcomp.ClientSimulatorCli.utils.Utils;

public class CLIRunner {

	private static final String SAY_HI = "Hello user.";
	private static final String ASK_2_TYPE_NUM_OF_CLIENTS = "How many HTTP clients would you like to simulate?";

	//private final static Logger LOGGER = LoggerFactory.getLogger(CLIRunner.class);

	public static void main(String[] args) {
		System.out.println(SAY_HI);
		System.out.println(ASK_2_TYPE_NUM_OF_CLIENTS);

		Scanner cmdReader = new Scanner(System.in);
		//LOGGER.info("CLIRunner.main(): Getting (and validating) the number of Clients from user.");
		int numOfClients = Utils.getValidNumOfClientsFromUser(cmdReader);

		//LOGGER.info("CLIRunner.main(): Initiating and starting {} Client threads.",numOfClients);
		Thread[] clients = new Thread[numOfClients];
		for (int i = 0; i < numOfClients; i++) {
			clients[i] = new Thread(new ClientRunnable(), Integer.toString(i));
		}
		for (Thread t : clients) {
			t.start();
		}
		//LOGGER.info("CLIRunner.main(): Listening to the keyboard to know when to stop the Client threads.");
		try {
			System.in.read();
		} catch (IOException e) {
			// No need to handle, in the scope of this task !
		}
		//LOGGER.info("CLIRunner.main(): Signal to the Clients to stop running.");
		// could use also interrupt/AtomicBoolean but volatile is good enough for this scenario - just to keep it simple:
		ClientRunnable.setShouldContinueRunning(false);
		cmdReader.close();
		System.out.println("Leaving the Client Simulator CLI !");
	}
}
