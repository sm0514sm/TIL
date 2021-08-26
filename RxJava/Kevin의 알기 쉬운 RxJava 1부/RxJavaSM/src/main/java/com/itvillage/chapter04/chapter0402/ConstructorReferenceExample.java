package com.itvillage.chapter04.chapter0402;

import com.itvillage.common.Car;

import java.util.function.Function;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        Function<String, Car> f1 = s -> new Car(s);
        Car car1 = f1.apply("그랜저");
        System.out.println(car1.getCarName());

        Function<String, Car> f2 = Car::new;
        Car car2 = f2.apply("제네시스");
        System.out.println(car2);
    }
}
