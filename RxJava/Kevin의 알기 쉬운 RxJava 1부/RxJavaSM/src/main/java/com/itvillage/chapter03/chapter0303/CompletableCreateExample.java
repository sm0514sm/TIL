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

public class CompletableCreateExample {
    public static void main(String[] args) {
        Completable completable = Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(@NonNull CompletableEmitter emitter) throws Exception {
                // 데이터를 통지하는게 아닌 특정 작업 수행 후, 완료 통지
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum += i;
                }
                Logger.log(LogType.PRINT, "# 합계: " + sum);
                emitter.onComplete();
            }
        });

        completable.subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        // 아무것도 하지않음
                    }

                    @Override
                    public void onComplete() {
                        Logger.log(LogType.ON_COMPLETE);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Logger.log(LogType.ON_ERROR, e);
                    }
                });
        TimeUtil.sleep(100L);
    }
}
