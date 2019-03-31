package hw8;

public class SubscriberThrees implements ObserverInterface{
	
	public boolean notifyObserver(Event event) {
		if (event.getEventData() % 3 == 0) {
			System.out.printf("Event %d is divisible by 3: %d%n", event.getEventNumber(), event.getEventData());
			return true;
		}
		return false;
	}

}
