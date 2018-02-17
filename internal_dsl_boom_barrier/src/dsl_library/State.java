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
	
	public String processEvent(String eventName) {
		for (Transition transition : transitions) {
			if (transition.getPendingEvent().equals(eventName)) {
				if (transition.isApplicable()) {
					return transition.getTargetTransition();
				} else {
					return stateName;
				}
			}
		}
		return stateName;
	}
}