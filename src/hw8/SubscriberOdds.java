package hw8;

public class SubscriberOdds implements ObserverInterface{

	public boolean notifyObserver(Event event) {
		if (event.getEventData() % 2 != 0) {
			System.out.printf("Event %d is odd: %d%n", event.getEventNumber(), event.getEventData());
			return true;
		}
		return false;
	}
}
