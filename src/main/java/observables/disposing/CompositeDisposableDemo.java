package observables.disposing;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * Used to manage and dispose several subscriptions
 */
public class CompositeDisposableDemo {
    private static final CompositeDisposable compositeDisposable = new CompositeDisposable();
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable= Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable1 = observable.subscribe((i) -> System.out.println("Observer1: "+i));
        Disposable disposable2 = observable.subscribe((i) -> System.out.println("Observer2: "+i));

        Thread.sleep(4000);

        compositeDisposable.addAll(disposable1,disposable2);

        Thread.sleep(3000);
        // no emissions should be visible as both observers disposed their streams.

    }
}

/*  OUTPUT
Observer1: 0
Observer2: 0
Observer1: 1
Observer2: 1
Observer1: 2
Observer2: 2
Observer1: 3
Observer2: 3
Observer2: 4
Observer1: 4
Observer1: 5
Observer2: 5
Observer1: 6
Observer2: 6
 */
