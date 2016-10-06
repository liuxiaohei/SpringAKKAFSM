package com.fusemachines.akka;

import com.fusemachines.ContextContainer;
import com.fusemachines.config.SpringExtension;
import com.fusemachines.domain.Transaction;
import com.fusemachines.fsm.MyFSMBase.State;

import akka.actor.ActorRef;

public class AkkaInitializer {
	
	private ActorRef actorRef ;
	public AkkaInitializer() {
		SpringExtension ext = ContextContainer.getContext().getBean(SpringExtension.class);
		ext.initialize(ContextContainer.getContext());	
		
		this.actorRef  = AkkaFactory.getActorSystem()
				.actorOf(ext.props("FiniteStateMachine"),"fsm");
		
		actorRef.tell(new Transaction(1, "First Transaction", false), null);	
		actorRef.tell(new Transaction(2, "Second Transaction", false), null);
		actorRef.tell(new Transaction(3, "Third Transaction", false), null);
		actorRef.tell(new Transaction(4, "Fourth Transaction", false), null);
		actorRef.tell(new Transaction(5, "Fifth Transaction", false), null);
		
		actorRef.tell("end", null);
		
		
		
		actorRef.tell(State.SECOND_STATE, null);
		
		actorRef.tell(State.THIRD_STATE, null);
		
	}
	

}
