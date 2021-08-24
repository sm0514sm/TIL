package com.itvillage.chapter03.chapter0303;

import com.itvillage.utils.DateUtil;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MaybeCreateLambdaExample {
    public static void main(String[] args) {
        // just로 1건 생성해서 subscribe 테스트
        Maybe.just(DateUtil.getNowDate())
                .subscribe(
                        data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜 시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
        Maybe.empty()
                .subscribe(
                        data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜 시각: " + data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
    }
}
