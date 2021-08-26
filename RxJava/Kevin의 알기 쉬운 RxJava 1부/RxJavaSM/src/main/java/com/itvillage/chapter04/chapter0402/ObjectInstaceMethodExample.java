package com.itvillage.chapter04.chapter0402;

import java.util.concurrent.Flow;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class ObjectInstaceMethodExample {
    public static void main(String[] args) {
        CarInventory carInventory = new CarInventory(10);

        Function<Integer, Integer> f1 = count -> carInventory.getExpectedTotalCount(count);
        Integer totalCount1 = f1.apply(10);
        System.out.println(totalCount1);

        Function<Integer, Integer> f2 = carInventory::getExpectedTotalCount;
        Integer totalCount2 = f2.apply(20);
        System.out.println(totalCount2);

        // T -> T (파라미터와 리턴값이 같은 경우 UnaryOperator)
        UnaryOperator<Integer> f3 = carInventory::getExpectedTotalCount;
        Integer totalCount3 = f3.apply(30);
        System.out.println(totalCount3);

        // Integer -> Integer
        IntUnaryOperator f4 = carInventory::getExpectedTotalCount;
        Integer totalCount4 = f4.applyAsInt(40);
        System.out.println(totalCount4);
    }
}
