## Introduction
This module adds the minimum classes to `RxJava` that
make writing reactive components in Android applications
easy and hassle-free. More specifically, it provides a
`Scheduler` that schedules on the main thread or any
given `Looper`.

### Observing on the main thread

One of the most common operations when dealing with asynchronous tasks
on `Android` is to observe the task's result or outcome on the main
thread. Using vanilla Android, this would typically be accomplished
with an `AsyncTask`. With RxJava instead you would declare your
`Observable` to be observed on the main thread:
```java
Observable.just("one", "two", "three", "four", "five")
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(/* an Observer */);
```

This will execute the `Observable` on a new thread, and emit results
through `onNext` on the main thread.


### Observing on arbitrary loopers

The previous sample is merely a specialization of a more general
concept: binding asynchronous communication to an Android message
loop, or `Looper`. In order to observe an `Observable` on an
arbitrary `Looper`, create an associated `Scheduler` by calling
`AndroidSchedulers.from`:

```java
Looper backgroundLooper = // ...
Observable.just("one", "two", "three", "four", "five")
        .observeOn(AndroidSchedulers.from(backgroundLooper))
        .subscribe(/* an Observer */)
```

This will execute the `Observable` on a new thread and emit results
through `onNext` on whatever thread is running *backgroundLooper*.
