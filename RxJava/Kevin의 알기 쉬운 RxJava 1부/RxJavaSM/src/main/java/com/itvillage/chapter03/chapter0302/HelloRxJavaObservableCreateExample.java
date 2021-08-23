package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HelloRxJavaObservableCreateExample {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                String[] datas = {"Hello", "RxJava!"};
                for (String data : datas) {
                    if (emitter.isDisposed())
                        return;
                    emitter.onNext(data);
                }
                emitter.onComplete();
            }
        }); // 배압 전략이 없다!

        observable.observeOn(Schedulers.computation())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        // 배압 기능이 없으므로 아무 처리도 하지 않음.
                    }

                    @Override
                    public void onNext(@NonNull String data) {
                        Logger.log(LogType.ON_NEXT, data);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Logger.log(LogType.ON_ERROR, e);
                    }

                    @Override
                    public void onComplete() {
                        Logger.log(LogType.ON_COMPLETE);
                    }
                });
        Thread.sleep(500L);
    }
}
