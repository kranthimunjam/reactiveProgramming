package observables;

import io.reactivex.rxjava3.core.Observable;

/**
 * Generates onError event with specified error message. All observers will receive onError event, it depends on how they handle errors.
 * This observable is primarily used for testing, seldom used in production.
 *
 */
public class ObservableError {
    public static void main(String[] args){
        Observable<String> emptyObservable = Observable.error(() -> new Exception("Error!"));
        emptyObservable.subscribe(System.out::println, (e)-> System.out.println("Something went wrong. "+ e.getMessage()), ()-> System.out.println("Completed!") );
        emptyObservable.subscribe(System.out::println, (e)-> System.out.println("Not working: "+ e.getMessage()), ()-> System.out.println("Completed!") );
    }
}
/* OUTPUT
Something went wrong. Error!
Not working: Error!

 */
