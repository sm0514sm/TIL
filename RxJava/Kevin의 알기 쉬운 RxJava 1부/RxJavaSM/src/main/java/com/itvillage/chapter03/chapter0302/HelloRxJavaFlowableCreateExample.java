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

public class HelloRxJavaFlowableCreateExample {
    public static void main(String[] args) throws InterruptedException {

        // 생산자 쪽에서 데이터 생성하는 부분
        Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            // FlowableEmitter: 데이터를 통지하는 역할
            // 소비자 쪽에서 onSubscribe 메서드 실행 이후 아래 실행
            public void subscribe(@NonNull FlowableEmitter<String> emitter) throws Exception {
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
            }
        }, BackpressureStrategy.BUFFER); // 구독자의 처리가 늦을 경우 데이터를 버퍼에 담아두는 설정.

        // 소비자 쪽에서 데이터를 구독하고 처리하는 과정
        flowable.observeOn(Schedulers.computation())
                .subscribe(new Subscriber<String>() {
                    // 데이터 개수 요청 및 구독을 취소하기 위한 Subscription 객체
                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        // 소비자 쪽에서 생산자에게 준비되었으니 데이터 달라 요청
                        this.subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(String data) {
                        Logger.log(LogType.ON_NEXT, data);
                    }

                    @Override
                    public void onError(Throwable error) {
                        Logger.log(LogType.ON_ERROR, error);
                    }

                    @Override
                    // emitter.onComplete(); 실행 완료시 아래 실행
                    public void onComplete() {
                        Logger.log(LogType.ON_COMPLETE);
                    }
                });
        Thread.sleep(500);
    }
}
