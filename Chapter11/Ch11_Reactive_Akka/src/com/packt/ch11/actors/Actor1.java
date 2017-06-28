package com.packt.ch11.actors;

import com.packt.ch11.beans.MyMessage;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.UntypedActor;
import akka.actor.Props;

public class Actor1 extends UntypedActor {
	public void onReceive(Object message) {
		if (message instanceof MyMessage) {
			System.out.println("The message is: "
					+ ((MyMessage) message).getMessage());
		}
	}

	
}
