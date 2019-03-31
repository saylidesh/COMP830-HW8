package hw8;

public class RunHW4 {

	public static void main(String[] args) {

		PublisherImplementation pub = new PublisherImplementation();
		SubscriberOdds odd = new SubscriberOdds();
		SubscriberEvens even = new SubscriberEvens();
		SubscriberThrees three = new SubscriberThrees(); 
		pub.registerObserver(odd);
		pub.registerObserver(even);
		pub.registerObserver(three);
		
		pub.runSimulation();
	
	}

}
