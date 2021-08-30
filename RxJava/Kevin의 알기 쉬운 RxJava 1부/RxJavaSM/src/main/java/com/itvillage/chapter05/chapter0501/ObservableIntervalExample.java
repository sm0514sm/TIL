package com.itvillage.chapter05.chapter0501;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableIntervalExample {
    public static void main(String[] args) {
        Observable.interval(0, 1000, TimeUnit.MILLISECONDS)
                .map(num -> num + " count")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
        TimeUtil.sleep(3000);
    }
}
