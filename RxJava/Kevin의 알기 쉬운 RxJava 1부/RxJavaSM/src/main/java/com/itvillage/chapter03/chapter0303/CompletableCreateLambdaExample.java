package com.itvillage.chapter03.chapter0303;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CompletableCreateLambdaExample {
    public static void main(String[] args) {
        Completable completable = Completable.create(emitter -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            Logger.log(LogType.PRINT, "# 합계: " + sum);
            emitter.onComplete();
        });

        completable.subscribeOn(Schedulers.computation())
                .subscribe(() -> Logger.log(LogType.ON_COMPLETE),
                        e -> Logger.log(LogType.ON_ERROR, e));
        TimeUtil.sleep(100L);
    }
}
