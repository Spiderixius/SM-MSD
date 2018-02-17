package dsl_library;

public class Transition {
	
	private String targetTransition;
	private String pendingEvent;
	
	
	private boolean isValidTicket;

	
	public Transition(String targetTransition, String pendingEvent) {
		this.targetTransition = targetTransition;
		this.pendingEvent = pendingEvent;
	}
	
	@Override
	public String toString() {
		
		String transitions = pendingEvent + " " + targetTransition; 
		return transitions;
		
	}
	
	public boolean isValidTicket() {
		return isValidTicket;
	}

	public void setValidTicket(boolean isValidTicket) {
		this.isValidTicket = isValidTicket;
	}
	
	public String getPendingEvent() {
		return pendingEvent;
	}

	public void setPendingEvent(String pendingEvent) {
		this.pendingEvent = pendingEvent;
	}

	
}
