package dsl_library;

public abstract class FluentMachine {

	protected abstract void build();


	public FluentMachine state(String name) {
		
		return this;
	}
	
	public FluentMachine transition(String event) {

		return this;
	}

	public FluentMachine to(String state) {
		
		return this;
	}


	public FluentMachine ifTicketValid(boolean b) {
		// TODO Auto-generated method stub
		return this;
	}


	public FluentMachine whenTimeOut(int i) {
		// TODO Auto-generated method stub
		return this;
		
	}
	
}
