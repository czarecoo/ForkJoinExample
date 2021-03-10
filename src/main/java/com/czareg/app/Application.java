package com.czareg.app;

import com.czareg.app.tasks.Data;
import com.czareg.app.tasks.GetDataTask;

import java.util.concurrent.ForkJoinPool;

public class Application implements Runnable {
    @Override
    public void run() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Data data = forkJoinPool.invoke(new GetDataTask());
        System.out.println(data);
    }
}