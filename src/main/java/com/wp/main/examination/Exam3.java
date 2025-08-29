package com.wp.main.examination;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangpeng
 * @description 两个线程交替打印1-100
 * @date 2025/8/17 07:30
 **/
public class Exam3 {
    public static volatile int i = 0;

    public static void main(String[] args) {
        /** 1、创建lock锁以及分别控制偶数和奇数打印的condition **/
        // ReentrantLock默认创建的是非公平锁，如果fair参数为true则为公平锁
        ReentrantLock lock = new ReentrantLock();
        Condition odd = lock.newCondition();
        Condition even = lock.newCondition();


        /** 奇数线程 **/
        Runnable threadOdd = () -> {
            // 获取锁
            lock.lock();
            try {
                while (i <= 100) {
                    if (i % 2 == 1) {
                        System.out.println("奇数线程打印：" + i);
                        i++;
                    } else {
                        try {
                            even.signal();
                            odd.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                /** 执行完成后唤醒其他线程，防止其他线程一直处于阻塞状态 **/
                even.signal();
            } finally {
                // 手动释放锁
                lock.unlock();
            }
        };

        /** 偶数线程 **/
        Runnable threadEven = () -> {
            // 获取锁
            lock.lock();
            try {
                while (i <= 100) {
                    if (i % 2 == 0) {
                        System.out.println("偶数线程打印：" + i);
                        i++;
                    } else {
                        try {
                            odd.signal();
                            even.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                /** 执行完成后唤醒其他线程，防止其他线程一直处于阻塞状态 **/
                odd.signal();
            } finally {
                // 手动释放锁
                lock.unlock();
            }
        };

        /** 创建线程任务并执行 **/
        new Thread(threadOdd).start();
        new Thread(threadEven).start();
        System.out.println("主线程执行完成");
    }
}

