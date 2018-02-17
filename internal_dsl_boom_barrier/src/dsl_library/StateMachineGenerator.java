package dsl_library;

/**
 * The Builder Bob class
 * In this class I have everything I need to build my DSL definition
 * 
 * Inspired by: https://github.com/ulrikpaghschultz/MDSD/blob/master/src/statemachine/year3/dsl/FluentMachine.java
 * 
 * @author spider
 * 
 */
public class StateMachineGenerator {
	
	// Reference to my meta model
	private StateMachineMetaModel metaModel;
	
	// The state which we are currently in
	private State currentState;
	
	// The target of the current transition
	private String targetTransition;
	
	// Current event that transitions are being defined for
	private String pendingEvent;

	/**
	 * Initialise the meta model
	 */
	public StateMachineGenerator() {
		metaModel = new StateMachineMetaModel();
	}
	
	/**
	 * Start a new state with whatever name is passed to stateName
	 * @param stateName - name of the state
	 * @return - the current object instance
	 */
	public StateMachineGenerator state(String stateName) {
		if (currentState != null) {
			flushTransition();
			metaModel.addState(currentState);
		}		
		currentState = new State(stateName);
		return this;
	}

	/**
	 * Transition for a given state
	 * @param transitionName - name of the transition
	 * @return - the current object instance
	 */
	public StateMachineGenerator transition(String transitionName) {
		if (pendingEvent != null) {
			flushTransition();
		}
		pendingEvent = transitionName;
		return this;
	}

	/**
	 * Which state are we going to
	 * @param toState - name of the current state
	 * @return - the current object instance
	 */
	public StateMachineGenerator to(String toState) {
		targetTransition = toState;
		return this;
	}

	/**
	 * Condition to check for validity
	 * @param validity
	 * @return
	 */
	public StateMachineGenerator ifTicketValid(boolean validity) {
		
		for (Transition transition : currentState.getTransitions()) {
			if (transition.getPendingEvent().equals(pendingEvent)){
				transition.setCondition(validity);
			}
		}	
		return this;
	}

	/**
	 * To prevent from getting duplicate states/transition a flush is necessary
	 */
	public void flushTransition() {	
		
		if (pendingEvent == null || pendingEvent == "") {
			return;
		}
		if (targetTransition == null || targetTransition == "") {
			return;
		}
		Transition transition = new Transition(targetTransition, pendingEvent);
		currentState.addTransition(transition);	
		
		targetTransition = "";
		pendingEvent = "";
	}

	/**
	 * Finalises the build
	 * @return - the model
	 */
	public StateMachineMetaModel end() {
		flushTransition();
		metaModel.addState(currentState);
		return metaModel;
	}	
}
