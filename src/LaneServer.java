import java.util.Iterator;
import java.util.Vector;

public class LaneServer {
	public LaneServer(){

		subscribers = new Vector();
	}
	private Vector subscribers;
	public void subscribe( LaneObserver adding ) {
		System.out.println(adding.toString());
		subscribers.add( adding );
	}

	/** unsubscribe
	 *
	 * Method that unsubscribes an observer from this object
	 *
	 * @param removing	The observer to be removed
	 */

	public void unsubscribe( LaneObserver removing ) {
		subscribers.remove( removing );
	}

	/** publish
	 *
	 * Method that publishes an event to subscribers
	 *
	 */

	public void publish() {
		if( subscribers.size() > 0 ) {
			Iterator eventIterator = subscribers.iterator();

			while ( eventIterator.hasNext() ) {
				( (LaneObserver) eventIterator.next()).receiveLaneEvent();
			}
		}
	}
}

