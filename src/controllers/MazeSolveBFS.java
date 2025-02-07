package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Cell;
import models.Maze;
import controllers.interfaces.MazeSolve;

public class MazeSolveBFS implements MazeSolve{

    @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end) {
        System.out.println("Implementacion BFS");
        List<Cell> lista = new ArrayList<>();
        return lista;
    }

}
