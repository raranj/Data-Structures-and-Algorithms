import java.util.*;

/**
 * This class implements the creation of an arbitrary maze. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/03/22
 */
public class Maze
{
    private int M, N, start, end;
    private ArrayList<Edge> edges;
    private ArrayList<Edge> finalEdges;
    private UF maze;
    
    /**
     * Constructor for objects of class Maze
     */
    public Maze(int M, int N)
    {
        this.N = N; // # columns
        this.M = M; // # rows 
        edges = new ArrayList<Edge>(); // contains all internal edges of maze
        finalEdges = new ArrayList<Edge>(); // contains remaining edges after maze is created
        fillEdges();
        maze = new UF(M*N);
        start = startCell();
        end = endCell();
    }

    /* This method fills the arraylist of edges with the
     * created edges of the cells, not including the borders.
     */
    private void fillEdges()
    {
        for (int r = 1; r <= M; r++)
        {
            for (int c = 1; c <= N; c++)
            {
                if (c != N) {
                    Edge edge = new Edge((N*(r-1))+c,(N*(r-1))+c+1);
                    edges.add(edge);
                }
                if (r != M) { 
                    Edge edge1 = new Edge((N*(r-1))+c, (N*(r-1))+c+N);
                    edges.add(edge1);
                }
            }
        }
    }

    public int startCell()
    {
        int num = (int)(Math.random() * (M-1)) + 1;
        return ((N*(num - 1)) + 1);
    }
    
    public int endCell()
    {
        int num = (int)(Math.random() * (M-1)) + 1;
        return ((N*(num - 1)) + N);
    }
    
    public void knockWall()
    {
        int num = (int)(Math.random() * edges.size()); 
        Edge edge = edges.get(num); // random edge from maze
        boolean connected = maze.connected(edge.getLow(), edge.getHigh());
        edges.remove(num);
        
        if (connected) // add edge as final edge if two cells are connected
        {
            finalEdges.add(edge);
        }
        else { // find union of two cells and print removed edge
            maze.union(edge.getLow(), edge.getHigh());
            System.out.println("Removing edge between " + edge.getLow() + " and " + edge.getHigh());
        }
    }
    
    public ArrayList<Edge> getFinalEdges()
    {
        return finalEdges;
    }
    
    public int getStartCell()
    {
        return start;
    }
    
    public int getEndCell()
    {
        return end;
    }
    
    public void createMaze()
    {   
        while (maze.count() > 1)
        {
            knockWall();
        }
        
        for (int i = 0; i < edges.size(); i++) // add the unaccounted edges to the final edges of the maze
        {
            finalEdges.add(edges.get(i));
        }
    }
}
