package observables.singleCompletableMaybe;

import io.reactivex.rxjava3.core.Completable;

/**
 * Concerned with an action being executed, but doesn't receive any emissions. Not used much.
 * complete() immediately calls onComplete()
 * Completable.fromRunnable() performs the action and then calls onComplete().
 */
public class CompletableObservable {
    public static void main(String[] args) {
        Completable.complete()
                .subscribe(()-> System.out.println(" Observer1 Completed!"), (e)-> e.getMessage());

        Completable.fromRunnable(()-> System.out.println("Running some process..."))
                .subscribe(()-> System.out.println(" Observer2 Completed!"), (e)-> e.getMessage());
    }
}

/* OUTPUT
Observer1 Completed!
Running some process...
Observer2 Completed!
 */