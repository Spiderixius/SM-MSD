package dsl_library;

public class Transition {
	
	private String targetTransition;
	public String getTargetTransition() {
		return targetTransition;
	}

	private String pendingEvent;
	
	
	private boolean condition = true;

	
	public Transition(String targetTransition, String pendingEvent) {
		this.targetTransition = targetTransition;
		this.pendingEvent = pendingEvent;
	}
	
	@Override
	public String toString() {
		
		String transitions = pendingEvent + " " + targetTransition; 
		return transitions;
		
	}
	
	public boolean getCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition &= condition;
	}
	
	public String getPendingEvent() {
		return pendingEvent;
	}

	public void setPendingEvent(String pendingEvent) {
		this.pendingEvent = pendingEvent;
	}

	public boolean isApplicable() {
		return true;
	}

	
}
