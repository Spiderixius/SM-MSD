package dsl_library;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the logic for my meta model, my blueprint of all my models (DSL definitions)
 * I have chosen to do both the meta model and machine executer (interpreter) in this class.
 * 
 * Inspired by: 
 * 		https://github.com/ulrikpaghschultz/MDSD/blob/master/src/statemachine/year3/dsl/MachineMetaModel.java
 * 		https://github.com/ulrikpaghschultz/MDSD/blob/master/src/statemachine/year2/framework/MachineExecutor.java
 * 
 * @author spider
 *
 */
public class StateMachineMetaModel {

	// List of all my states
	private List<State> states;
	
	// The state which we are currently in
	private State currentState;
	
	/**
	 * Initialise the meta model 
	 */
	public StateMachineMetaModel() {
		states = new ArrayList<>();
	}

	/**
	 * Used for adding states to the list of states
	 * @param newState - the new state to be added
	 */
	public void addState(State newState) {
		states.add(newState);
	}
	
	/**
	 * The processMachine method is the interpreter that can interpret my model
	 * @param eventName - the event to be processed
	 */
	public void processEvent(String eventName) {
		if (currentState == null) {
			currentState = states.get(0);
		}
		String targetState = currentState.processEvent(eventName);
		
		for (State state : states) {
			if (state.getStateName().equals(targetState)) {
				currentState = state;
			}
		}
		System.out.println(currentState.getStateName());
		
	}
	
	/**
	 * Used for printing machine information
	 * Which is basically what states and transitions there are in my DSL definition
	 */
	public void machineInfo() {
		System.out.println(toString());
	}
	
	/**
	 * I chose to visualise the meta model which lets you see the DSL definition
	 */
	@Override
	public String toString() {
		String stateInfo = "State Machine created.\nFollowing is the state machine: \n";
		
		for (State state : states) {
			stateInfo += "\nState: " + state.getStateName() + "\nTransition To: ";
			for (Transition transition : state.getTransitions()) {
				stateInfo += "\n " + transition.toString();
			}			
		}
		return stateInfo;
	}
	
	
	
	
}
