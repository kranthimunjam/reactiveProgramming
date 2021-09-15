package observables.singleCompletableMaybe;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * Emits exactly one value.
 * onNext() and onComplete() combine to form onSuccess()
 * onComplete() is not required because observer knows that no more items will come after first one.
 */
public class SingleObservable {
    public static void main(String[] args) {
        Single.just("Hello!")
                .map(String::length)
                .subscribe(System.out::println, (e)-> e.getMessage());

        // Single can be created from Observable.
        Observable<String> observable = Observable.just( "Alpha", "Bravo", "Charlie");

        observable.first("N/A")    // if first item not available then default "N/A" will be returned.
                .subscribe(System.out::println, (e)-> e.getMessage());

    }
}
