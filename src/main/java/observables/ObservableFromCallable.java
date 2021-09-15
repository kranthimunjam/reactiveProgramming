package observables;

import io.reactivex.rxjava3.core.Observable;

/**
 * Used in the cases where initializing the emission has likelihood of throwing an error.
 * If any exceptions are thrown, onError() event is generated.
 */
public class ObservableFromCallable {
    public static void main(String[] args) {
        // For below code expectation is that exception will be thrown and e.geMessage() gets executed but that's not the case.
        // Exception occurs even before the observable is created.
        /*Observable.just(1/0)
                .subscribe(System.out::println, (e)-> e.getMessage() );*/

        // above situations can be handled
        Observable.fromCallable(() ->1/0)
                .subscribe(System.out::println, (e)-> System.out.println("Exception! "+e.getMessage()) );

    }

    /* OUTPUT
    Exception! / by zero
     */
}
