package dsl_library;

import java.util.ArrayList;
import java.util.List;

public class StateMachineMetaModel {
	
	private List<State> states;
	private String stateName;
	
//	public StateMachineMetaModel(String stateName) {
//		this.stateName = stateName;
//		states = new ArrayList<>();
//	}
	
	public StateMachineMetaModel() {
		states = new ArrayList<>();
	}


	public void addState(State newState) {
		states.add(newState);
	}
	
	
	public void stateInfo() {
		System.out.println(toString());
	}
	
	
	@Override
	public String toString() {
		String stateInfo = "State Machine " + stateName + " created.\nFollowing are the states: \n";
		
		for (State state : states) {
			stateInfo += "\nState: " + state.getStateName() + "\nTransition To: ";
			for (Transition transition : state.getTransitions()) {
				stateInfo += "\n " + transition.toString();
			}
		}
				
		return stateInfo;
	}
	
	public void processMachine() {
		
	}
	
}
