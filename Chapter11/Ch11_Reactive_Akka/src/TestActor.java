import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.packt.ch11.actors.Actor1;
import com.packt.ch11.beans.MyMessage;

public class TestActor {

	public static void main(String[] args) {
		ActorSystem actorSystem = ActorSystem.create("PacktSystem");
		ActorRef actorRef = actorSystem.actorOf(new Props(Actor1.class),
				"actor1");
		actorRef.tell(new MyMessage("Hello Welcome to Akka!"));

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}

		actorSystem.stop(actorRef);
		actorSystem.shutdown();

	}
}
