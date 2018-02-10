package dsl_sketch_boom_barrier;

public class BoomBarrier extends FluentMachine{
	
	// Constants
	private static final String BARRIER_DOWN = "BARRIER_DOWN";
	private static final String BARRIER_UP = "BARRIER_UP";
	private static final String TICKET_SCAN = "TICKET_SCAN";
	private static final String TICKET_ACCEPT = "TICKET_ACCEPT";
	
	private static final int WAIT = 10;
	private static final boolean WAIT_COMPLETE = false;


	// State machine definition
	protected void build() {
		initialState(BARRIER_DOWN).
		transition(TICKET_SCAN).to(TICKET_ACCEPT).setState(BARRIER_UP).transition(WAIT).to(WAIT_COMPLETE).setState(BARRIER_DOWN);
	}

	private Builder initialState(String barrierDown) {
		// TODO Auto-generated method stub
		return null;
	}


	public static class Builder {

		public Builder transition(String ticketScan) {
			// TODO Auto-generated method stub
			return null;
		}
		


		public Builder to(boolean waitComplete) {
			return null;
			// TODO Auto-generated method stub
			
		}



		public Builder transition(int wait) {
			// TODO Auto-generated method stub
			return null;
		}

		public Builder setState(String barrierUp) {
			// TODO Auto-generated method stub
			return null;
		}

		public Builder to(String ticketAccept) {
			// TODO Auto-generated method stub
			return null;
		}

		
	}

}
	
