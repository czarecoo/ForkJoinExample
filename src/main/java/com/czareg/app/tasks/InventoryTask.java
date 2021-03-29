package com.czareg.app.tasks;

import com.czareg.app.client.Client;
import com.czareg.app.tasks.model.Board;
import com.czareg.app.tasks.model.Irmc;
import com.czareg.app.tasks.model.Memory;
import com.czareg.app.tasks.model.MyData;

import java.util.ArrayList;
import java.util.List;

public class InventoryTask extends InventorySubtask<MyData> {
    @Override
    protected MyData compute() {
        Client client = new Client();

        InventorySubtask<List<Board>> getBoardTask = create(() -> client.getBoards("1"));
        InventorySubtask<Memory> getMemoryTask = create(() -> client.getMemory("2"));
        InventorySubtask<Irmc> getIrmcTask = create(() -> client.getIrmc("3"));

        getBoardTask.fork();
        getMemoryTask.fork();
        getIrmcTask.fork();

        return new MyData(
                getBoardTask.getOrDefault(new ArrayList<>()),
                getIrmcTask.getOrDefault(new Irmc()),
                getMemoryTask.getOrDefault(new Memory()));
    }
}