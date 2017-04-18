package com.nanddgroup.itea_project;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by vrungel on 18.04.17.
 */

public class RxBus {

  private final PublishSubject<Object> mBusSubject;

  public RxBus() {
    mBusSubject = PublishSubject.create();
  }

  public void post(Object event) {
    mBusSubject.onNext(event);
  }

  public Observable<Object> observable() {
    return mBusSubject;
  }

  public <T> Observable<T> filteredObservable(final Class<T> eventClass) {
    return mBusSubject.ofType(eventClass);
  }

  public boolean hasObservers() {
    return mBusSubject.hasObservers();
  }
}