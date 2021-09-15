package observables.disposing;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * Disposes the resources so that they can be garbage collected.
 * Usually onComplete() disposes the resources for finite observables.
 * But for infinite observables it is good to dispose explicitly to prevent memory leaks.
 */
public class DisposableDemo {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable= Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = observable.subscribe(System.out::println);
        Thread.sleep(4000);

        // dispose the stream.
        disposable.dispose();


        // still no events.
        Thread.sleep(4000);

    }
}
/* OUTPUT
    0
    1
    2
    3

 */
