package dsl_machines;

import dsl_library.StateMachineGenerator;
import dsl_library.StateMachineMetaModel;

/**
 * The DSL definition for a microwave machine
 * 
 * Inspired by: https://github.com/ulrikpaghschultz/MDSD/blob/master/src/statemachine/year3/microwaveoven/MicrowaveMachine.java
 * 
 * @author spider
 *
 */
public class MicroWaveMachine extends StateMachineGenerator {
	  
	public StateMachineMetaModel generateMicroWaveMachine() {
        return state("INACTIVE").
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
