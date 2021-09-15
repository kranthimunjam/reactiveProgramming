package observables;

import io.reactivex.rxjava3.core.Observable;

/**
 * Empty observable doesn't emit anything and calls onComplete()
 * Empty observables usually represent empty datasets.
 * They can also result from operators such as filter() when none of the emitted values pass filter criterion.
 */
public class EmptyObservable {
    public static void main(String[] args){
        Observable<String> emptyObservable = Observable.empty();
        emptyObservable.subscribe(System.out::println, (e)-> e.getMessage(), ()-> System.out.println("Completed!") );

    }
}

/* OUTPUT
Completed!

 */