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

public class MaybeCreateExample {
    public static void main(String[] args) {
        Maybe<String> maybe = Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull MaybeEmitter<String> emitter) throws Exception {
//                emitter.onSuccess(DateUtil.getNowDate());
                emitter.onComplete();
            }
        });

        maybe.subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                // 아무것도 하지 않음
            }

            @Override
            public void onSuccess(@NonNull String data) {
                Logger.log(LogType.ON_SUCCESS, "# 현재 날짜 시각: " + data);
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
    }
}
