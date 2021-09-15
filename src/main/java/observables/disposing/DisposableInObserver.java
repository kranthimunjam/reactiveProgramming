package observables.disposing;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * Disposable is passed in onSubscribe() method of an observer.
 * This gives observer control to dispose whenever.
 */
public class DisposableInObserver {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable= Observable.interval(1, TimeUnit.SECONDS);

        // Observer disposes after receiving first value;
        Observer<Long> observer= new Observer<Long>() {
            Disposable myDisposable;
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                this.myDisposable = d;
            }

            @Override
            public void onNext(@NonNull Long aLong) {
                System.out.println(" Received: "+ aLong);
                myDisposable.dispose();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                myDisposable.dispose();
            }

            @Override
            public void onComplete() {
                myDisposable.dispose();
            }
        };

        observable.subscribe(observer);
        Thread.sleep(4000);

    }
}

/* OUTPUT
Received: 0
 */