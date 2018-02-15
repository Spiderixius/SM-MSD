package dsl_library;

public abstract class StateMachineGenerator {

	
	private StateMachineMetaModel metaModel = new StateMachineMetaModel();
	
	
	protected abstract void build();

	
	public StateMachineGenerator state(String name) {
		
		return this;
	}
	
	public StateMachineGenerator transition(String event) {

		return this;
	}

	public StateMachineGenerator to(String state) {
		
		return this;
	}


	public StateMachineGenerator ifTicketValid(String string) {
		// TODO Auto-generated method stub
		return this;
	}


	public StateMachineGenerator whenTimeOut(String string) {
		// TODO Auto-generated method stub
		return this;
		
	}
	
}
