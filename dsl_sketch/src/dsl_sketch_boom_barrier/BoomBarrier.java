package dsl_sketch_boom_barrier;

/**
 * 
 * @author spider
 * 
 */


public class BoomBarrier extends FluentMachine{
	
	// Constants
	private static final String BARRIER_DOWN = "BARRIER_DOWN";
	private static final String BARRIER_GOING_DOWN = "BARRIER_GOING_DOWN";

	private static final String BARRIER_UP = "BARRIER_UP";
	private static final String BARRIER_GOING_UP = "BARRIER_GOING_UP";
	
	private static final String TICKET_SCAN = "TICKET_SCAN";
	private static final String TICKET_ACCEPT = "TICKET_ACCEPT";
	
	private static final int WAIT = 10;
	private static final boolean WAIT_COMPLETE = true;

	private Builder builder = new Builder();
	
	
	// State machine definition
	protected void build() {
		builder.setState(BARRIER_DOWN).
			transition(TICKET_SCAN).to(TICKET_ACCEPT).
			transition(BARRIER_GOING_UP).
		setState(BARRIER_UP).
		    transition(WAIT).to(WAIT_COMPLETE).
		    transition(BARRIER_GOING_DOWN).
	    setState(BARRIER_DOWN);
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
	
