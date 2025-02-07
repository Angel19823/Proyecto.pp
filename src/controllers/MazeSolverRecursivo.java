package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import models.Cell;
import models.Maze;
import controllers.interfaces.MazeSolve;

public class MazeSolverRecursivo implements  MazeSolve{

    @Override
    public List<Cell> getPath(Maze maze,boolean[][] grid, Cell start, Cell end){
        
        List<Cell> path = new ArrayList<>();
        Set<Cell> visitadas = new HashSet<>();

        if (grid == null  || grid.length == 0) {
            return path;
        }
        // if (findPath(grid, start.row, start.col, end, path, visitadas)) {
        //     return path;
        // }
        // return new ArrayList<>();

        findPath(maze, grid, start.row, start.col, end, start, path, visitadas);
        List<Cell> exploredList = new ArrayList<>(visitadas);
        return path.isEmpty() ? exploredList: path; 
    }

    private boolean findPath(Maze maze,boolean[][] grid, int row, int col, Cell end,Cell start, List<Cell> path, Set<Cell> visitadas){
        //Verificar si la celda esta afuera de los limites o no es transitable
        Cell cell = new Cell(row, col);
        if (row < 0 || col < 0 || row >= grid.length || col > grid[0].length || !grid[row][col]) {
            return false;
        }
        
        if(visitadas.contains(cell)){
            return false; //Si ya visito, evitamos volver a la celda 
        }
        visitadas.add(cell);
        maze.updateMaze(cell, start, end);

        if (row == end.row && col == end.col) {   
            path.add(cell);
            return true;
        }

        // boolean[][] laberinto = {
        //     {true, true, true, true},
        //     {false, true, true, true},
        //     {true, true, false, false},
        //     {true, true, true, true,},
        // };

        if (findPath(maze, grid, row+1, col, end, start, path,visitadas)) {
            path.add(cell);
            return true;
        }
        if (findPath(maze, grid, row, col+1, end, start, path, visitadas)) {
            path.add(cell);
            return true;
        }

        //visitadas.remove(cell); // Importante: eliminamos la celda al retroceder 
        path.remove(cell);	

        return false;
    }
}
