package dsl_library;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the state object that a state machine can be in.
 * All logic regarding state is in here and contains a name and a list of transitions.
 * 
 * Inspired by: https://github.com/ulrikpaghschultz/MDSD/blob/master/src/statemachine/year2/framework/State.java
 * 
 * @author spider
 *
 */
public class State {
	
	// Name of a given state
	private String stateName;
	
	// A state can have a list of transitions
	private List<Transition> transitions;
	
	/**
	 * State is instantiated with a state name and the list of the transitions 
	 * @param stateName - Name of the state
	 */
	public State(String stateName) {
		this.stateName = stateName;
		transitions = new ArrayList<>();
	}

	/**
	 * Returns the name of a state
	 * @return - the state name
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * Returns the transitions for a state
	 * @return - transitions
	 */
	public List<Transition> getTransitions() {
		return transitions;
	}

	/**
	 * Add transitions for a state
	 * @param newTransition - the transition to be added 
	 */
	public void addTransition(Transition newTransition) {
		transitions.add(newTransition);
	}
	
	/**
	 * Process' an event if applicable and returns the name of the state that it has processed to
	 * @param eventName - name of the event happening
	 * @return name of the new state name
	 */
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