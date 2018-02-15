package internal_dsl_boom_barrier;

import dsl_library.StateMachineGenerator;

public class BoomBarrierMachine extends StateMachineGenerator {

	// State machine definition
	@Override
	protected void build() {
		state("BARRIER_DOWN").
			transition("TICKET_SCAN_ACCEPT").to("BARRIER_UP").ifTicketValid("TRUE").
			transition("TICKET_SCAN_REJECT").to("BARRIER_DOWN").ifTicketValid("FALSE").
		state("BARRIER_UP").
			transition("WAIT").to("BARRIER_DOWN").whenTimeOut("10");
	}
}
