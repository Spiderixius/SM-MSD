Hello Reader

[ABOUT]
Following is my attempt at an internal domain specific language (DSL).
I have chosen to make a DSL for both a Boom Barrier and a Microwave. 


[HOW TO]
Code was created using Eclipse Oxygen. I assume you can simply import the project.

[CODE STRUCTURE]

The package [dsl_library] contains the following:
   State.java
      |_ Represent a state object in a state machine
   StateMachineGenerator.java
      |_ Builder Bob that builds the DSL definition by using the meta model
   StateMachineMetaModel.java
      |_ The blueprint for all my DSL models
   Transition.java
      |_ Helps us get from one state to another
   
The package (dsl_machines) contains the following:
   BoomBarrierMachine.java
      |_ Contains the DSL definition for the Boom Barrier machine
   MachineRunner.java
      |_ CLI visualisation of machines.
   MicroWaveMachine.java
      |_ Contains the DSL definition for the Microwave machine
      
[COPYRIGHT]
Feel free to do what you want with it. However if you happen to be from SM-MSD course, 
please give credit where it is due, especially if this is for the assignment delivery.