package dsl_library;

public class Transition {

	// Target state which to transition to.
	private String targetState;
	
	// Create a transition that targets the given state
	public Transition(String targetState) {
		this.targetState = targetState;
	}

	// Gives the name of the target state to transition to
	public String getTargetState() {
		return targetState;
	}
	
	// 
	protected boolean isApplicable() {
        return true;
    }
	
}
