package com.itvillage.chapter05.chapter0501;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

import java.time.LocalTime;

public class ObservableDeferExample {

    public static void main(String[] args) throws InterruptedException {
        Observable<LocalTime> observable = Observable.defer(() -> Observable.just(LocalTime.now()));
        Observable<LocalTime> observableJust = Observable.just(LocalTime.now());

        observable.subscribe(time -> Logger.log(LogType.PRINT, " # defer() 구독1의 구독시간: " + time));
        observableJust.subscribe(time -> Logger.log(LogType.PRINT, " # just() 구독1의 구독시간: " + time));

        Thread.sleep(3000);

        observable.subscribe(time -> Logger.log(LogType.PRINT, " # defer() 구독2의 구독시간: " + time));
        observableJust.subscribe(time -> Logger.log(LogType.PRINT, " # just() 구독2의 구독시간: " + time));
    }
}
