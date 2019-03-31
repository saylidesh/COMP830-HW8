package hw8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PublisherImplementation implements PublisherInterface {

	//ArrayList to maintain all subscribers or observers
	private List<ObserverInterface> observers = new ArrayList<ObserverInterface>();
	private Random random = new Random();

	@Override
	public void registerObserver(ObserverInterface o) {
		observers.add(o);
	}

	//De-registers the ibserver
	@Override
	public void removeObserver(ObserverInterface o) {
		if (observers.contains(o)) {
			observers.remove(o);
		}
	}

	/*
	 * This method does the following things: It notifies all observers about the
	 * event. It then counts odd numbers and de-registers(using removeObserver method)
	 * the odd subscriber if the count is more than 20. Then it counts the numbers
	 * divisible by three and de-registers(using removeObserver method) the threes
	 * subscriber if the count is more than 6. Finally, if the event number is either 40,
	 * 80, 120, 160, 200 (or divisible by 40), then re-register Odds and Threes
	 * subscriber, if the subscribers have been de-registered.
	 */
	@Override
	public void notifyObservers(Event event) {
		int oddsCount = 0;
		int threesCount = 0;

		for (ObserverInterface o : observers) {
			boolean response = o.notifyObserver(event);

			if (o instanceof SubscriberOdds && response && oddsCount++ > 20) {
				oddsCount = 0;
				removeObserver(o);
			}
			if (o instanceof SubscriberThrees && response && threesCount++ > 6) {
				threesCount = 0;
				removeObserver(o);
			}
		}

		if (event.getEventNumber() % 40 == 0) {
			if (!hasSubscriberOdds()) {
				registerObserver(new SubscriberOdds());
			}
			if (!hasSubscriberThrees()) {
				registerObserver(new SubscriberThrees());
			}
		}
	}

	// Generate event object
	private Event generateEvent(int number) {
		int rand = random.nextInt(5000) + 1;
		return new Event(number, rand);
	}

	// This method generates 200 events and notifies the subscribers about each
	// event by calling notifyObservers
	public void runSimulation() {
		for (int i = 1; i <= 200; i++) {
			Event event = generateEvent(i);
			notifyObservers(event);
		}
	}

	// Check if SubscriberOdds is listening to the publisher
	private boolean hasSubscriberOdds() {
		for (ObserverInterface o : observers) {
			if (o instanceof SubscriberOdds) {
				return true;
			}
		}
		return false;
	}

	// Check if SubscriberThrees is listening to the publisher
	private boolean hasSubscriberThrees() {
		for (ObserverInterface o : observers) {
			if (o instanceof SubscriberThrees) {
				return true;
			}
		}
		return false;
	}
}
