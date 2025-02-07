package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controllers.interfaces.MazeSolve;
import models.Cell;
import models.Maze;

public class MazeSolverDPB implements MazeSolve{

    private Map<Cell, Boolean> memoria = new HashMap<>();

    @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end) {
        System.out.println("Implementacion BFS");
        List<Cell> lista = new ArrayList<>();
        if(grid == null || grid.length == 0) 
        return lista;
        
        if(findPath(grid, start.row, start.col, end, lista))
        return lista;

        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, int row, int col, Cell end, List<Cell> path) {
        Cell cell = new Cell(row, col);

        if(row >= grid.length || col >= grid[0].length || !grid[row][col] || memoria.containsKey(cell)){
            return false;
        }

        if(row == end.row && col == end.col){
            path.add(cell);
            return true;
        }

        if( findPath(grid, row+1, col, end, path) || findPath(grid,row, col+1, end, path)){
           path.add(cell);
            memoria.put(cell, true);
            return true; 
        } 

        memoria.put(cell, false);
        return false;
    }   
}
