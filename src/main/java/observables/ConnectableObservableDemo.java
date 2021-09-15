package observables;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

/**
 * Connectable observer sends each emission to all observers at once, which is called 'Multicasting'
 * This is helpful in scenarios where we want to avoid replaying.
 * However, Connectable observer is Hot so if any observer subscribes after connect() it would miss previous emissions.
 */
public class ConnectableObservableDemo {
    public static void main(String[] args) throws InterruptedException {

        ConnectableObservable<Long> observableSource = Observable.interval( 100, TimeUnit.MILLISECONDS).publish();

        observableSource.subscribe((e)->System.out.println("Observer1: "+e), (e)-> e.getMessage(), ()-> System.out.println("Observer1 Completed!"));

        observableSource.subscribe((e)->System.out.println("Observer2: "+e), (e)-> e.getMessage(), ()-> System.out.println("Observer2 Completed!"));

        observableSource.connect(); // Emissions are multicasted to observer1 and observer2

        Thread.sleep(400);

        // Observer 3 subscribes after 4 emissions.
        observableSource.subscribe((e)->System.out.println("Observer3: "+e), (e)-> e.getMessage(), ()-> System.out.println("Observer3 Completed!") );

        Thread.sleep(300);
    }
}

/* OUTPUT
Observer1: 0
Observer2: 0
Observer1: 1
Observer2: 1
Observer1: 2
Observer2: 2
Observer1: 3
Observer2: 3
Observer1: 4
Observer2: 4
Observer3: 4
Observer1: 5
Observer2: 5
Observer3: 5
Observer1: 6
Observer2: 6
Observer3: 6
 */

/* OUTPUT:
Observer1: 10
Observer2: 10
Observer3: 10
Observer1: 11
Observer2: 11
Observer3: 11
Observer1: 12
Observer2: 12
Observer3: 12
Observer1: 13
Observer2: 13
Observer3: 13
Observer1: 14
Observer2: 14
Observer3: 14
Observer1 Completed!
Observer2 Completed!
Observer3 Completed!
 */