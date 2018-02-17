package dsl_library;

import internal_dsl_boom_barrier.MachineRunner;

/**
 * This class represents the transition object that a state can have
 * All logic regarding transition is in here and contains a name, condition, target transition and pending transition
 * 
 * Inspired by: https://github.com/ulrikpaghschultz/MDSD/blob/master/src/statemachine/year2/framework/Transition.java
 * 
 * @author spider
 *
 */
public class Transition {
	
	// The target of the current transition
	private String targetTransition;
	
	// Current event that transitions are being defined for
	private String pendingEvent;
	
	// Condition for a state
	private boolean condition = true;

	/**
	 * Initialise the transition with target transition and pending event
	 * @param targetTransition - name of the target transition
	 * @param pendingEvent - name of the pending transition
	 */
	public Transition(String targetTransition, String pendingEvent) {
		this.targetTransition = targetTransition;
		this.pendingEvent = pendingEvent;
	}

	/**
	 * Get the target transition
	 * @return - the name of the target transition
	 */
	public String getTargetTransition() {
		return targetTransition;
	}
	
	/**
	 * Get the condition
	 * @return - the boolean condition
	 */
	public boolean getCondition() {
		return condition;
	}

	/**
	 * Set the condition
	 * @param condition - set the boolean condition
	 */
	public void setCondition(boolean condition) {
		this.condition &= condition;
	}
	
	/**
	 * Get the pending event
	 * @return - the name of the pending event
	 */
	public String getPendingEvent() {
		return pendingEvent;
	}

	/**
	 * Set the pending event
	 * @param pendingEvent  - set the pending event name
	 */
	public void setPendingEvent(String pendingEvent) {
		this.pendingEvent = pendingEvent;
	}

	/**
	 * Should a transition take place or not, can be overwritten if otherwise
	 * @return true
	 */
	public boolean isApplicable() {
		return true;
	}

	/**
	 * Used for when printing the DSL definition
	 * @see StateMachineMetaModel machineInfo() method
	 */
	@Override
	public String toString() {
		
		String transitions = pendingEvent + " " + targetTransition; 
		return transitions;
		
	}
	
}
