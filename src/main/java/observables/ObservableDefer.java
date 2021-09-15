package observables;

import io.reactivex.rxjava3.core.Observable;

/**
 * Defer creates a fresh observable for each subscription.
 * This thwarts the problem of Observable sources not capturing state changes.
 */
public class ObservableDefer {
    private static int start = 10, count=3;
    private static int start2 = 10, count2=3;
    public static void main(String[] args){
        Observable<Integer> source = Observable.range(start, count);
        source.subscribe( (i) -> System.out.println("Observer1: "+i));
        count = 5;

        // Even though the state is modified, observer2 doesn't see the change.
        source.subscribe( (i) -> System.out.println("Observer2: "+i));
        /* OUTPUT
            Observer1: 10
            Observer1: 11
            Observer1: 12
            Observer2: 10
            Observer2: 11
            Observer2: 12
         */

        Observable<Integer> deferedSource = Observable.defer( () -> Observable.range(start2, count2) );
        deferedSource.subscribe( (i) -> System.out.println("deferredObserver1: "+i));
        count2 = 5;

        // For this observer a new observable is created, observer2 sees the change.
        deferedSource.subscribe( (i) -> System.out.println("deferredObserver2: "+i));

        /* OUTPUT
            deferredObserver1: 10
            deferredObserver1: 11
            deferredObserver1: 12
            deferredObserver2: 10
            deferredObserver2: 11
            deferredObserver2: 12
            deferredObserver2: 13
            deferredObserver2: 14
         */
    }
}
