import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controllers.MazeSolveBFS;
import controllers.MazeSolverDPB;
import controllers.MazeSolverRecursivo;
import controllers.interfaces.MazeSolve;
import models.Cell;
import models.Maze;

public class App {
    public static void main(String[] args) throws Exception {
        boolean[][] laberinto = {
            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false}, //antes {true, true, false, false},
            {true, true, true, true,},
        };

        Maze maze = new Maze(laberinto);
        System.out.println("---LABERINTO--");
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);

        List<MazeSolve> soluciones = Arrays.asList(
            //new MazeSolverRecursivo(),
            //new MazeSolveBFS()
            //new MazeSolverDPB()
            );

        List<MazeSolve> solucionesDOS = new ArrayList<>();
        solucionesDOS.add(new MazeSolverRecursivo());
        solucionesDOS.add(new MazeSolverDPB());
        solucionesDOS.add(new MazeSolveBFS());


        //Con scaner seleccionar la opcion
        //escojio la opcion 1
        int opcion = 1;

        MazeSolve solver = soluciones.get(opcion - 1);
        List<Cell> path = solver.getPath(maze, laberinto, start, end);
        System.out.println("Camino encontrado: "+path);

        maze.printMazeWithPath(path);
    }
}
