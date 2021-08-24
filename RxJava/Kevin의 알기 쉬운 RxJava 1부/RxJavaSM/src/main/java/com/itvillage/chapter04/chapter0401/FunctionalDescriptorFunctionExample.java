package com.itvillage.chapter04.chapter0401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

// 함수 디스크럽터의 Function 예제
public class FunctionalDescriptorFunctionExample {
    public static void main(String[] args) {
        List<Character> charList = Arrays.asList('a', 'b', 'c', 'd', 'e');
//        List<Integer> asciiNumbers = map(charList, character -> (int) character);
        List<Integer> asciiNumbers = map(charList, character -> (int) character);

        for (int asciiNumber : asciiNumbers)
            System.out.println(asciiNumber);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list)
            result.add(f.apply(t));
        return result;
    }
}
