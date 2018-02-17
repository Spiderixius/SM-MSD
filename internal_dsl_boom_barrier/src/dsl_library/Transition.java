package dsl_library;

public class Transition {
	
	private String targetTransition;
	private String pendingEvent;
	
	public Transition(String targetTransition, String pendingEvent) {
		this.targetTransition = targetTransition;
		this.pendingEvent = pendingEvent;
	}
	
	@Override
	public String toString() {
		
		String transitions = pendingEvent + " " + targetTransition; 
		return transitions;
		
	}
}
