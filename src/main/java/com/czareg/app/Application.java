package com.czareg.app;

import com.czareg.app.tasks.InventoryTask;
import com.czareg.app.tasks.model.MyData;

import java.util.concurrent.*;

public class Application implements Runnable {
    @Override
    public void run() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinTask<MyData> myDataForkJoinTask = forkJoinPool.submit(new InventoryTask());
        MyData myData = null;
        try {
            myData = myDataForkJoinTask.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(myData);
    }
}