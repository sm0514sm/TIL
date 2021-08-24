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
public class SingleCreateLambdaExample {
    public static void main(String[] args) {
        Single<String> single = Single.create(emitter -> emitter.onSuccess(DateUtil.getNowDate()));

        single.subscribe(
                date -> Logger.log(LogType.ON_SUCCESS, "# 날짜시각: " + date),
                e -> Logger.log(LogType.ON_ERROR, e)
        );
    }
}
