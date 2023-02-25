package com.example.chapter01;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ToDoSample {
    public static void main(String[] args) throws InterruptedException {
        Observable.just(100, 200, 300, 400, 500)
                .doOnNext(data -> System.out.println(getThreadName() + " : #doOneNext() : " + data))
                .subscribeOn(Schedulers.io())           // 실행된 thread가 main Thread에서 실행되지 않음
                .observeOn(Schedulers.computation())    // 발행된 결과의 쓰레드가 다른걸로 작동하게됨
                .filter(number -> number > 300)
                .subscribe(num -> System.out.println(getThreadName() + " : result : " + num));

        Thread.sleep(500);
    }

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }
}
