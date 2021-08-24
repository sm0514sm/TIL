package com.itvillage.chapter03.chapter0303;

import com.itvillage.utils.DateUtil;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class MaybeFromSingleExample {
    public static void main(String[] args) {
        Single<String> single = Single.just(DateUtil.getNowDate());
        Maybe.fromSingle(single)
                .subscribe(
                        data -> Logger.log(LogType.ON_SUCCESS, "# 현재 날짜 시각: " + data),
                        e -> Logger.log(LogType.ON_ERROR, e),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
    }
}
