package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

// DROP_OLDEST
public class BackpressureBufferExample02 {
    public static void main(String[] args) {
        System.out.println("# start: " + TimeUtil.getCurrentTimeFormatted());
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log("# interval doOnNext", data))
                .onBackpressureBuffer(
                        2,  // 버퍼의 수용량
                        () -> Logger.log("Overflow!!"),
                        BackpressureOverflowStrategy.DROP_OLDEST)
                .doOnNext(data -> Logger.log("# onBackpressureBuffer doOnNext()", data))
                .observeOn(Schedulers.computation(), false, 1) // bufferSize: 소비자측에서 요청하는 개수
                .subscribe(
                        data -> {
                            TimeUtil.sleep(1000L);
                            Logger.log(LogType.ON_NEXT, data);
                        },
                        error -> Logger.log(LogType.ON_ERROR, error)
                );
        TimeUtil.sleep(2800);
    }
}
