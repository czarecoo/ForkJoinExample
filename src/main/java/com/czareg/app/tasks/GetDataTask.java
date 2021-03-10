package com.czareg.app.tasks;

import com.czareg.app.client.Client;
import com.czareg.app.tasks.board.GetBoardTask;
import com.czareg.app.tasks.irmc.GetIrmcTask;
import com.czareg.app.tasks.memory.GetMemoryTask;

import java.util.concurrent.RecursiveTask;

public class GetDataTask extends RecursiveTask<Data> {
    @Override
    protected Data compute() {
        Client client = new Client();

        GetBoardTask getBoardTask = new GetBoardTask(client);
        GetMemoryTask getMemoryTask = new GetMemoryTask(client);
        GetIrmcTask getIrmcTask = new GetIrmcTask(client);

        getBoardTask.fork();
        getMemoryTask.fork();
        getIrmcTask.fork();

        return new Data(getBoardTask.join(), getIrmcTask.join(), getMemoryTask.join());
    }
}