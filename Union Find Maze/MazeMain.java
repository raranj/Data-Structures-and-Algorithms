import java.util.*;

/**
 * This class tests the Maze class by creating a maze. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/03/22
 */
public class MazeMain
{
    public static void main(String[] args)
    {
        Maze maze = new Maze(15, 15);
        maze.createMaze();
        
        ArrayList<Edge> edges = maze.getFinalEdges();
        
        // walls left in the maze not including the border
        System.out.println("\nWalls retained are: ");
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            System.out.println(edge.getLow() + " and " + edge.getHigh());
        }
    
        System.out.println("Starting cell number: " + maze.getStartCell());
        System.out.println("Ending cell number: " + maze.getEndCell());
    }
}
