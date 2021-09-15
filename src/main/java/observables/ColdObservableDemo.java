package observables;

import io.reactivex.rxjava3.core.Observable;

/**
 * Everytime an observer subscribes to a cold observable, it emits all events/data from the start for that observer.
 * So, in the case of cold observable, an observer never misses any emission regardless of when he subscribed.
 * EACH OBSERVABLE GETS A STREAM. So even if observer(s) modifies stream with operators that doesn't affect subsequent observers.
 * Since observers get different streams, if the state of observable changes, then observers get different emissions.
 */
public class ColdObservableDemo {
    public static void main(String[] args){
        int start =10, count = 5;
        Observable<Integer> observableSource = Observable.range( start, count);

        observableSource.subscribe((e)->System.out.println("Observer1: "+e), (e)-> e.getMessage(), ()-> System.out.println("Observer1 Completed!") );

        // when this second observer is subscribed, all the emissions are 'replayed' from the beginning. This happens everytime an observer subscribes.
        observableSource.subscribe((e)->System.out.println("Observer2: "+e), (e)-> e.getMessage(), ()-> System.out.println("Observer2 Completed!") );

        // the state changes
        count = 10;

        observableSource.subscribe((e)->System.out.println("Observer3: "+e), (e)-> e.getMessage(), ()-> System.out.println("Observer3 Completed!") );

    }
}
