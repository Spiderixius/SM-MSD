package dsl_machines;

import dsl_library.StateMachineMetaModel;

/**
 * This class is simply used to display the machine information (transitions, states)
 * and display the interpretation of an event.
 * 
 * @author spider
 * 
 * No inspiration, hence the mess.
 */
public class MachineRunner {
	
	public static void main(String[] args) {	
		/**
		 * Microwave Machine
		 */
		MicroWaveMachine microWaveMachine = new MicroWaveMachine();
		StateMachineMetaModel metaModelMicroWave = microWaveMachine.generateMicroWaveMachine();
		System.out.println("=======================================\n"
						 + "=---------[Microwave Machine]---------=\n"
						 + "=======================================");
		metaModelMicroWave.machineInfo();
		System.out.println("\n");
		System.out.println("[Interpreting]");
		System.out.println("Event: START");
		metaModelMicroWave.processEvent("START");
		System.out.println("Event: OPEN");
		metaModelMicroWave.processEvent("OPEN");
		System.out.println("Event: CLOSE");
		metaModelMicroWave.processEvent("CLOSE");
		System.out.println("Event: TIMER");
		metaModelMicroWave.processEvent("TIMER");
		System.out.println("Event: START");
		metaModelMicroWave.processEvent("START");
		System.out.println("\n");

		/**
		 * Boom Barrier Machine
		 */
		BoomBarrierMachine boomBarrierMachine = new BoomBarrierMachine();
		StateMachineMetaModel metaModelBoomBarrier = boomBarrierMachine.generateBoomBarrierMachine();
		System.out.println("=======================================\n"
						 + "=-------[Boom Barrier Machine]--------=\n"
						 + "=======================================");
		metaModelBoomBarrier.machineInfo();
		System.out.println("\n");
		System.out.println("[Interpreting]");
		System.out.println("Event: TICKET_SCAN_REJECT");
		metaModelBoomBarrier.processEvent("TICKET_SCAN_REJECT");
		System.out.println("Event: TICKET_SCAN_ACCEPT");
		metaModelBoomBarrier.processEvent("TICKET_SCAN_ACCEPT");
		System.out.println("Event: WAIT");
		metaModelBoomBarrier.processEvent("WAIT");

		
	}
}
