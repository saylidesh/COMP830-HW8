package hw8;

public class Event {
	
	private int eventNumber;
	private int eventData;

	public Event(int eventNumber, int eventData) {
		this.eventNumber = eventNumber;
		this.eventData = eventData;
	}

	public int getEventData() {
		return eventData;
	}

	public int getEventNumber() {
		return eventNumber;
	}

}
