package com.czareg.app.tasks;

import com.czareg.app.tasks.board.Board;
import com.czareg.app.tasks.irmc.Irmc;
import com.czareg.app.tasks.memory.Memory;

public class Data {
    private Board board;
    private Irmc irmc;
    private Memory memory;

    public Data(Board board, Irmc irmc, Memory memory) {
        this.board = board;
        this.irmc = irmc;
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Data{" +
                "board=" + board +
                ", irmc=" + irmc +
                ", memory=" + memory +
                '}';
    }
}