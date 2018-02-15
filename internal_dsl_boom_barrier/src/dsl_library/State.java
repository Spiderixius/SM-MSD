package dsl_library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {
	
	// Name of the state
	private String name;
	
	// Each state can have several transitions
	private Map<String, List<Transition>> transitions = new HashMap<String, List<Transition>>();
	
    public State(String name) {
    	this.name = name;
    }
    
    // Add transitions to a state
    public void addTransition(String eventName, Transition transition) {
        
    }
    
    // Process the transition for a given state
    public void processTransition() {
    	
    }
}