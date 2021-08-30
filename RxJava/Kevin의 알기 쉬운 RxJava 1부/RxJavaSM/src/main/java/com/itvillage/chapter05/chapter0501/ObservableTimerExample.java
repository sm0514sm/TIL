package com.itvillage.chapter05.chapter0501;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableTimerExample {
    public static void main(String[] args) {
        Logger.log(LogType.PRINT, "# Start!");

        Observable<String> observable = Observable.timer(2000, TimeUnit.MILLISECONDS)
                .map(count -> "Do work!");

        observable.subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000);
    }
}
