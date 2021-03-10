package com.czareg.app.tasks.board;

import com.czareg.app.client.Client;

import java.util.concurrent.RecursiveTask;

public class GetBoardTask extends RecursiveTask<Board> {
    private Client client;

    public GetBoardTask(Client client) {
        this.client = client;
    }

    @Override
    protected Board compute() {
        return client.getBoard();
    }
}