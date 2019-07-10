package com.youngshaw.datasourcedemo.config;

import java.util.concurrent.atomic.AtomicInteger;

public class DBContextHolder {

    //将ThreadLocal设置为静态的，可以让当前线程中所有的类都能够共享
    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        System.out.println("切换到master");
    }

    public static void slave() {
        // 轮询
        int index = counter.getAndIncrement() % 2;
        if (counter.get() > 999) {
            counter.set(-1);
        }
        if (index == 0) {
            set(DBTypeEnum.SLAVE1);
            System.out.println("切换到slave1");
        } else {
            set(DBTypeEnum.SLAVE2);
            System.out.println("切换到slave2");
        }
    }
}
