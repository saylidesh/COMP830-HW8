package hw8;

public interface PublisherInterface {

	public void registerObserver(ObserverInterface o);

	public void removeObserver(ObserverInterface o);

	public void notifyObservers(Event E);

}
