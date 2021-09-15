package observables;

import io.reactivex.rxjava3.core.Observable;

/**
 * No emitted values and no execution of onComplete().
 * This observable is primarily used for testing, seldom used in production.
 */
public class ObservableNever {
    public static void main(String[] args){
        Observable<String> emptyObservable = Observable.never();
        emptyObservable.subscribe(System.out::println, (e)-> e.getMessage(), ()-> System.out.println("Completed!") );
    }
}

