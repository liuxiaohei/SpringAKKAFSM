package com.fusemachines.fsm;

import akka.actor.UntypedActor;

public abstract class MyFSMBase extends UntypedActor{
	
	public enum State{
		FIRST_STATE, SECOND_STATE, THIRD_STATE;
	}
	
	private State state = State.FIRST_STATE;
	
	protected void setState(State s){
		this.state = s;
	}
	

	
	protected State getState(){
		return state;
	}
	
	
	
}
