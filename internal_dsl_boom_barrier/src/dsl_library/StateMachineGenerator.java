package dsl_library;


public class StateMachineGenerator {
	
	private StateMachineMetaModel metaModel;
	private State currentState;
	private String targetTransition;
	private String pendingEvent;

	public StateMachineGenerator() {
		metaModel = new StateMachineMetaModel();
	}
	
	public StateMachineGenerator state(String stateName) {
		if (currentState != null) {
			flushTransition();
			metaModel.addState(currentState);
		}
		
		currentState = new State(stateName);
		return this;
	}

	public StateMachineGenerator transition(String transitionName) {
		if (pendingEvent != null) {
			flushTransition();
		}
		pendingEvent = transitionName;
		return this;
	}

	public StateMachineGenerator to(String toState) {
		targetTransition = toState;
		return this;
	}

	public StateMachineGenerator ifTicketValid(boolean validity) {
		
		for (Transition transition : currentState.getTransitions()) {
			if (transition.getPendingEvent().equals(pendingEvent)){
				transition.setCondition(validity);
			}
		}
		
		return this;
	}

	public StateMachineGenerator whenTimeOut(String name) {
		// TODO Auto-generated method stub
		return this;
	}

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

	public StateMachineMetaModel end() {
		flushTransition();
		metaModel.addState(currentState);
		return metaModel;
	}

	
	
}
