package observables;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * We can create observable from future.
 * Two overloaded methods are 1. fromFuture( future<>) 2. fromFuture(future<>, timeout)
 */
public class ObservableFromFuture {
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();
    public static void main(String[] args){

        Future<Integer> future = executorService.submit( () -> 10);
        Observable.fromFuture(future).subscribe(System.out::println);
        executorService.shutdown();
    }
}
