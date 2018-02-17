package internal_dsl_boom_barrier;

import dsl_library.StateMachineGenerator;

public class BoomBarrierMachine extends StateMachineGenerator {

	
	public void generateBoomBarrierMachine() {
         state("BARRIER_DOWN").
		 	transition("TICKET_SCAN_ACCEPT").to("BARRIER_UP").ifTicketValid(true).
		 	transition("TICKET_SCAN_REJECT").to("BARRIER_DOWN").ifTicketValid(false).
	 	 state("BARRIER_UP").
	 	 	transition("WAIT").to("BARRIER_DOWN").end();
	 }
}
