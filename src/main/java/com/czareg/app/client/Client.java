package com.czareg.app.client;

import com.czareg.app.tasks.model.Board;
import com.czareg.app.tasks.model.Irmc;
import com.czareg.app.tasks.model.Memory;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

public class Client {
    public List<Board> getBoards(String data) {
        System.out.println("Started waiting for board");
        System.out.println(Instant.now());
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted board sleep");
        }
        System.out.println("Finished waiting for board");
        System.out.println(Instant.now());
        return Collections.singletonList(new Board());
    }

    public Irmc getIrmc(String data) {
        System.out.println("Started waiting for irmc");
        System.out.println(Instant.now());
        try {
            Thread.sleep(9_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted irmc sleep");
        }
        System.out.println("Finished waiting for irmc");
        System.out.println(Instant.now());
        return new Irmc();
    }

    public Memory getMemory(String data) {
        System.out.println("Started waiting for memory");
        System.out.println(Instant.now());
        try {
            Thread.sleep(4_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted memory sleep");
        }
        System.out.println("Finished waiting for memory");
        System.out.println(Instant.now());
        return new Memory();
    }
}