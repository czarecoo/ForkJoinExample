package com.czareg.app.tasks.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MyData {
    private List<Board> boards;
    private Irmc irmc;
    private Memory memory;
}