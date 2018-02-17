package internal_dsl_boom_barrier;

import dsl_library.StateMachineGenerator;
import dsl_library.StateMachineMetaModel;

/**
 * The DSL definition for a microwave machine
 * 
 * Inspired by: https://github.com/Spiderixius/SM-MSD/blob/master/dsl_sketch/src/dsl_sketch_boom_barrier/BoomBarrier.java
 * 
 * @author spider
 *
 */
public class BoomBarrierMachine extends StateMachineGenerator {
	
	public StateMachineMetaModel generateBoomBarrierMachine() {
	     return state("BARRIER_DOWN").
	    		 	transition("TICKET_SCAN_ACCEPT").to("BARRIER_UP").ifTicketValid(true).
	    		 	transition("TICKET_SCAN_REJECT").to("BARRIER_DOWN").ifTicketValid(false).
			 	state("BARRIER_UP").
			 	 	transition("WAIT").to("BARRIER_DOWN").end();
	}
}
