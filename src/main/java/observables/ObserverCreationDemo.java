package observables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Observer subscribes to an observable.
 * Disposable in onSubscribe gives observer control to dispose the resources( like streams)
 * when it ends subscription(doesn't want to process the emissions anymore)
 * Once disposed, observer will not receive further emissions from that observable.
 */
public class ObserverCreationDemo {
    public static void main(String[] args){
        Observable<String> observableSource = Observable.just( "Alpha", "Bravo", "Charlie");

        // Creating observer using anonymous class.
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("received "+ integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error occurred: "+ e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed! ");
            }
        };

        observableSource.map(String::length)
                .filter(i-> i>5)
                .subscribe(observer);

        // we can create the observer equivalent to above using only lambdas and overloaded subscribe().
        observableSource.map(String::length)
                .filter(i-> i>5)
                .subscribe(System.out::println, (e)-> e.getMessage(), ()-> System.out.println("Completed!") );


    }
}
