package com.itvillage.chapter03.chapter0303;

import com.itvillage.utils.DateUtil;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

// Single 클래스를 사용하여 현재 날짜와 시각을 통지하는 예제
public class SingleCreateExample {
    public static void main(String[] args) {
        Single<String> single = Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<String> emitter) throws Exception {
                emitter.onSuccess(DateUtil.getNowDate());
            }
        });

        single.subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                // 아무것도 하지 않음
            }

            @Override
            public void onSuccess(@NonNull String date) {
                Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + date);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Logger.log(LogType.ON_ERROR, e);
            }
        });
    }
}
