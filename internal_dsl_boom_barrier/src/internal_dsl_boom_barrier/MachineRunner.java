package internal_dsl_boom_barrier;

import dsl_library.StateMachineMetaModel;

public class MachineRunner {

	public static void main(String[] args) {
		
		MicroWaveMachine microWaveMachine = new MicroWaveMachine();
		StateMachineMetaModel metaModelMicroWave = microWaveMachine.generateMicroWaveMachine();
		metaModelMicroWave.stateInfo();
		metaModelMicroWave.processEvent("START");
		metaModelMicroWave.processEvent("STOP");
		
		BoomBarrierMachine boomBarrierMachine = new BoomBarrierMachine();
		StateMachineMetaModel metaModelBoomBarrier = boomBarrierMachine.generateBoomBarrierMachine();
		metaModelBoomBarrier.stateInfo();
		metaModelBoomBarrier.processEvent("TICKET_SCAN_REJECT");
		metaModelBoomBarrier.processEvent("TICKET_SCAN_ACCEPT");
		metaModelBoomBarrier.processEvent("WAIT");
	}

}
