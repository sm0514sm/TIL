package com.itvillage.chapter03.chapter0303;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Maybe;

public class MaybeJustExample {
    public static void main(String[] args) {
        Maybe<String> maybe = Maybe.create(emitter -> {
//            emitter.onSuccess(DateUtil.getNowDate());
            emitter.onComplete();
        });

        maybe.subscribe(data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜 시각: " + data),
                e -> Logger.log(LogType.ON_ERROR, e),
                () -> Logger.log(LogType.ON_COMPLETE)
        );
    }
}
