package observables.disposing;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

/**
 * Use ResourceObserver if you do not want to explicitly handle disposal.
 */
public class ResourceObserverDemo {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable= Observable.interval(1, TimeUnit.SECONDS);

        ResourceObserver<Long> observer = new ResourceObserver<Long>() {
            @Override
            public void onNext(@NonNull Long aLong) {
                System.out.println("Received: "+aLong);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error: "+ e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Done! ");
            }
        };

        // Capture disposable
        Disposable disposable = observable.subscribeWith(observer);

    }
}
