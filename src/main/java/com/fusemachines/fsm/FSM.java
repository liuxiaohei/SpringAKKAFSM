package com.fusemachines.fsm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fusemachines.domain.Transaction;


@Component("FiniteStateMachine")
@Scope("prototype")
public class FSM extends MyFSMBase{

	List<Transaction> transactionList = new ArrayList<Transaction>();

	@Override
	public void onReceive(Object object) throws Exception {
		State currentState = this.getState();
		
		
		
		if(currentState == State.FIRST_STATE){
			System.out.println("Current State: " + currentState);
			if(object instanceof Transaction){
				Transaction transaction = (Transaction) object;
				System.out.println("Inserting Transaction " + transaction.getName());
				transactionList.add(transaction);
			} else{
				System.out.println("Moving to Second State");
				this.setState(State.SECOND_STATE);
			}
		}
		
		if(currentState == State.SECOND_STATE){
			System.out.println("\n\nCurrent State: " + currentState);
			if(transactionList.isEmpty()){
				System.out.println("No Transasction");
				System.exit(0);
			} else{
				int counter = 0;
				System.out.println("All Transasctions:");
				for(Transaction transaction : transactionList){
					counter++;
					if(counter % 2 == 0)
						transaction.setVerify(true);
					else
						transaction.setVerify(false);
					System.out.println(transaction.getName());
				}
				
				this.setState(State.THIRD_STATE);
			}
			
		}
		
		if(currentState == State.THIRD_STATE){
			
			System.out.println("\n\nCurrent State: " + currentState);
			
			int counter = 0;
			
			if(transactionList.isEmpty()){
				System.out.println("No Transaction");
			} else{
				
				System.out.println("Verified Transactions:");
				
				for(Transaction transaction : transactionList){
					if(transaction.getVerify()){
						counter++;
						System.out.println(transaction.getName());
					}
				}
				if(counter == 0){
					System.out.println("Sorry no verified transaction");
					System.out.println("Please add verified transaction");
				}else{
					transactionList = new ArrayList<Transaction>();
				}
			}
			
		}
	}

}
