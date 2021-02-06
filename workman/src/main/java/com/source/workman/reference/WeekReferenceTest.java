package com.source.workman.reference;

import java.lang.ref.WeakReference;

/**
 * @author liuzh
 */
public class WeekReferenceTest {
    public static void main(String[] args) {
//        Car car = new Car(22000,"silver");
        WeakReference<Car> m = new WeakReference<Car>(new Car());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

//        ThreadLocal<Car> tl = new ThreadLocal<Car();
//        tl.set(new Car());
//        tl.remove();
    }
}