package com.mynextcomp.ClientSimulatorCli;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello user, how many HTTP clients would you like to simulate?");
        Scanner cmdReader = new Scanner(System.in);
        String input = cmdReader.nextLine();
        //TBD - validate the input !!!
        System.out.println( "Simulation of " + input + " Http Clients has begun, press any key to stop the process !");
        //TBD - create and run the HTTP Client Runnable Threads - interrupt them on any key press !!!
        System.out.println(cmdReader.next());
        cmdReader.close();
        System.exit(0);
    }
}
