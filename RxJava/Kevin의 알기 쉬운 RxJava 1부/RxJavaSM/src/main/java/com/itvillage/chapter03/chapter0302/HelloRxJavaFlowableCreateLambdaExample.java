package com.itvillage.chapter03.chapter0302;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class HelloRxJavaFlowableCreateLambdaExample {
    public static void main(String[] args) throws InterruptedException {

        // 생산자 쪽에서 데이터 생성하는 부분
        Flowable<String> flowable = Flowable.create(emitter -> {
            String[] datas = {"Hello", "RxJava!"};
            for (String data : datas) {
                // 구독이 해지되면 처리 중단
                if (emitter.isCancelled())
                    return;
                // 데이터 통지
                emitter.onNext(data);
            }
            // 데이터 통지 완료를 알린다
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER); // 구독자의 처리가 늦을 경우 데이터를 버퍼에 담아두는 설정.

        // 소비자 쪽에서 데이터를 구독하고 처리하는 과정
        flowable.observeOn(Schedulers.computation())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE),
                        subscription -> subscription.request(Long.MAX_VALUE));
        Thread.sleep(500);
    }
}
