package com.czareg.app.tasks.irmc;

import com.czareg.app.client.Client;

import java.util.concurrent.RecursiveTask;

public class GetIrmcTask extends RecursiveTask<Irmc> {
    private Client client;

    public GetIrmcTask(Client client) {
        this.client = client;
    }

    @Override
    protected Irmc compute() {
        return client.getIrmc();
    }
}