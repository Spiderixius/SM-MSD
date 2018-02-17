package internal_dsl_boom_barrier;

public class MachineRunner {

	public static void main(String[] args) {
		MicroWaveMachine microWaveMachine = new MicroWaveMachine();
		
		microWaveMachine.generateMicroWaveMachine();
		microWaveMachine.stateInfo();
	}

}
