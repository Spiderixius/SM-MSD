package internal_dsl_boom_barrier;

import dsl_library.StateMachineMetaModel;


/**
 * This class is simply used to display the machine information (transitions, states)
 * and display the interpretation of an event.
 * 
 * @author spider
 * 
 * No inspiration, hence the mess. Sorry for the verbosity.
 */
public class MachineRunner {
	
	/**
	 * Reference to the meta model for the two different DSL definitions.
	 */
	static MicroWaveMachine microWaveMachine = new MicroWaveMachine();
	static StateMachineMetaModel metaModelMicroWave = microWaveMachine.generateMicroWaveMachine();
	
	static BoomBarrierMachine boomBarrierMachine = new BoomBarrierMachine();
	static StateMachineMetaModel metaModelBoomBarrier = boomBarrierMachine.generateBoomBarrierMachine();

	/**
	 * To control the printing of machineInfo()
	 */
	static boolean isMicroWavePrinted = false;
	static boolean isBoomBarrierPrinted = false;
	
	/**
	 * Transition Events for Microwave Machine
	 * I added the microwave machine to see how well it works with my meta model
	 */
	public static final String START = "START";
	public static final String STOP = "STOP";
	public static final String TIMER = "TIMER";
	
	/**
	 * Transition Events for Boom Barrier
	 */
	public static final String TICKET_SCAN_REJECT = "TICKET_SCAN_REJECT";
	public static final String TICKET_SCAN_ACCEPT = "TICKET_SCAN_ACCEPT";
	public static final String WAIT = "WAIT";
	
	public static void main(String[] args) {	
		/**
		 * Microwave Machine example
		 */		
		// If we start the microwave then it should be cooking
		printMicroWaveMachine(START, metaModelMicroWave);
		
		// If we stop the microwave then it should be inactive
		printMicroWaveMachine(STOP, metaModelMicroWave);
		
		/**
		 * Boom Barrier example
		 */		
		// If we have a ticket that is accepted 
		// then the barrier should go up
		printBoomBarrierMachine(TICKET_SCAN_ACCEPT, metaModelBoomBarrier);
		
		// If we have a ticket that is rejected 
		// then the barrier should go down
		printBoomBarrierMachine(TICKET_SCAN_REJECT, metaModelBoomBarrier);
		
		// The barrier should go down after waiting
		printBoomBarrierMachine(WAIT, metaModelBoomBarrier);
	}
		
	/**
	 * Simple print method created for the sole purpose to interact with the interpreter.
	 * @param eventName - The name of the event to test on the interpreter.
	 * @param metaModel - Name of the meta model to use with the interpreter. 
	 */
	public static void printMicroWaveMachine(String eventName, StateMachineMetaModel metaModel) {
		if (isMicroWavePrinted == false) {
			System.out.println("====================================\n"
							 + "=-------------[Machine]------------=\n"         
							 + "====================================");
			metaModel.machineInfo();
			isMicroWavePrinted = true;
		} 
		System.out.println("\n[Interpreting]");
		printEvent(eventName);
		metaModel.processEvent(eventName);
		System.out.println("------------------------------------");
	}
	
	
	/**
	 * Simple print method created for the sole purpose to interact with the interpreter.
	 * @param eventName - The name of the event to test on the interpreter.
	 * @param metaModel - Name of the meta model to use with the interpreter. 
	 */
	public static void printBoomBarrierMachine(String eventName, StateMachineMetaModel metaModel) {
		if (isBoomBarrierPrinted == false) {
			System.out.println("====================================\n"
							 + "=-------------[Machine]------------=\n"         
							 + "====================================");
			metaModel.machineInfo();
			isBoomBarrierPrinted = true;
		} 
		System.out.println("\n[Interpreting]");
		printEvent(eventName);
		metaModel.processEvent(eventName);
		System.out.println("------------------------------------");
	}
		
	
	/**
	 * Simple helper method to print events. 
	 * @param eventName - The name of the event to test on the interpreter.
	 */
	public static void printEvent(String eventName) {
		System.out.println("------------------------------------");
		System.out.println("|\tEvent: " + eventName);

	}
}
