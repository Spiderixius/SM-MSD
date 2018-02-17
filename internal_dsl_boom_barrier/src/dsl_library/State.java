package dsl_library;

import java.util.ArrayList;
import java.util.List;

public class State {
	
	private String stateName;
	private List<Transition> transitions;
	
	
	public State(String stateName) {
		this.stateName = stateName;
		transitions = new ArrayList<>();
	}

	public String getStateName() {
		return stateName;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void addTransition(Transition newTransition) {
		transitions.add(newTransition);
	}
}