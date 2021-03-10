package com.czareg.app.tasks.memory;

import com.czareg.app.client.Client;

import java.util.concurrent.RecursiveTask;

public class GetMemoryTask extends RecursiveTask<Memory> {
    private Client client;

    public GetMemoryTask(Client client) {
        this.client = client;
    }

    @Override
    protected Memory compute() {
        return client.getMemory();
    }
}