package observables;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableCreationDemo {
    public static void main(String[] args) throws InterruptedException {

        // Creating observable through Observable.create() factory method.
        Observable<String> observableEntity = Observable.create( emitter -> {
            emitter.onNext("Alpha");
            emitter.onNext("Beta");
            emitter.onNext("Gamma");
            emitter.onComplete();
        });
        Disposable disposable = observableEntity.subscribe(System.out::println);
        disposable.dispose();


        // Creating observable using  just().
        Observable<String> observableSource = Observable.just( "Alpha", "Bravo", "Charlie");
        observableSource.subscribe(System.out::println);

        // Creating observable fromIterable()
        List<String> list = List.of("Delta","Echo", "Foxtrot");
        Observable<String> observable = Observable.fromIterable(list);
        observable.subscribe(System.out::println);

        // Creating observable from range()
        Observable.range(10,5).subscribe(System.out::println);
        // rangeLong() is long equivalent of the range()
        Observable.rangeLong(Integer.MAX_VALUE,5).subscribe(System.out::println);

        // Creating observable that emits at specified intervals. This is cold observable.
        Observable.interval(1, TimeUnit.SECONDS).subscribe(System.out::println);
        Thread.sleep(3000);
    }
}
