package internal_dsl_boom_barrier;

import dsl_library.StateMachineGenerator;

public class MicroWaveMachine extends StateMachineGenerator {
	    
	
	public void generateMicroWaveMachine() {
	        state("INACTIVE").
	          transition("START").to("COOKING").
	        state("COOKING").
	          transition("TIMER").to("INACTIVE").
	          transition("STOP"). to("INACTIVE").
	          transition("OPEN"). to("DOOR_OPEN").
	        state("DOOR_OPEN").
	          transition("CLOSE").to("COOKING").
	          transition("STOP"). to("INACTIVE").end();
	    }
}