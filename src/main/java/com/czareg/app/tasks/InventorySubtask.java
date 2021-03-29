package com.czareg.app.tasks;

import lombok.extern.java.Log;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.function.Supplier;

import static java.util.logging.Level.WARNING;

@Log
public abstract class InventorySubtask<T> extends RecursiveTask<T> {
    public T getOrDefault(T defaultValue) {
        try {
            return get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.log(WARNING, "Failed to get data due to interrupted exception. Returning default value");
            return defaultValue;
        } catch (ExecutionException e) {
            log.log(WARNING, "Failed to get data due to execution exception. Returning default value", e.getCause());
            return defaultValue;
        } catch (CancellationException e) {
            log.log(WARNING, "Failed to get data due to cancellation exception. Returning default value");
            return defaultValue;
        }
    }

    public static <T> InventorySubtask<T> create(Supplier<T> supplier) {
        return new InventorySubtask<T>() {
            @Override
            protected T compute() {
                return supplier.get();
            }
        };
    }
}