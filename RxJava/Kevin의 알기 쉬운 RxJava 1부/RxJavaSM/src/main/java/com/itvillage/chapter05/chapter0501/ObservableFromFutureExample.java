package com.itvillage.chapter05.chapter0501;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class ObservableFromFutureExample {
    public static void main(String[] args) {
        Logger.log(LogType.PRINT, "# start time");

        // 긴 처리 시간이 걸리는 작업
        Future<Double> future = longTimeWork();

        // 짧은 처리 시간이 걸리는 작업
        shortTimeWork();

        Observable.fromFuture(future)
                .subscribe(data -> Logger.log(LogType.PRINT, "# 긴 처리 시간 작업 결과: " + data));

        Logger.log(LogType.PRINT, "# end time");
    }

    private static void shortTimeWork() {
        Logger.log(LogType.PRINT, "# 짧은 처리 시간이 걸리는 작업 중 ... ");
        TimeUtil.sleep(3000);
        Logger.log(LogType.PRINT, "# 짧은 처리 시간 작업 완료 !");
    }

    private static CompletableFuture<Double> longTimeWork() {
        return CompletableFuture.supplyAsync(() -> calculate());
    }

    private static Double calculate() {
        Logger.log(LogType.PRINT, "# 긴 처리 시간이 걸리는 작업 중 ... ");
        TimeUtil.sleep(6000);
        return 100000000000000.0;
    }
}
