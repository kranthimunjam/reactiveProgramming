package observables.singleCompletableMaybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

/**
 * Emits exactly zero or one value.
 * to emit one item Maybe.just() is used.
 * to emit zero items Maybe.empty() is used.
 */
public class MaybeObservable {
    public static void main(String[] args) {
        Maybe.just("Hello!")
                .map(String::length)
                .subscribe(System.out::println, (e)-> e.getMessage(), ()-> System.out.println(" Observer1 Completed!"));

        Maybe.empty()
                .subscribe(System.out::println, (e)-> e.getMessage(), ()-> System.out.println("Observer2 Completed!"));
    }
}

// "Observer1 Completed!" is not executed because there is no ambiguity. Observer knows that only one item is emitted, so it is implemented implicitly.

/* OUTPUT
6
Observer2 Completed!
 */
