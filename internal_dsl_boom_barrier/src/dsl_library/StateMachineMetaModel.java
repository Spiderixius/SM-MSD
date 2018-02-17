package dsl_library;

import java.util.ArrayList;
import java.util.List;

public class StateMachineMetaModel {

	private List<State> states;
	private State currentState;
	
	public StateMachineMetaModel() {
		states = new ArrayList<>();
	}

	public void addState(State newState) {
		states.add(newState);
	}
	
	
	public void machineInfo() {
		System.out.println(toString());
	}
	
	
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
	
	/** TODO: Implement the processMachine method
	 *  The processMachine method is the interpreter that can interpret my model.
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
		System.out.println("|\tCurrent state: " + currentState.getStateName());
	}
	
	
}
