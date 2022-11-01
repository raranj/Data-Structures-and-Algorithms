/**
 * This class represents an edge between two cells in the maze. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/03/22
 */
public class Edge
{
    private int low;
    private int high;
    
    /**
     * Constructor for objects of class Edge
     */
    public Edge(int low, int high)
    {
        this.low = low;
        this.high = high;
    }
    
    public int getLow()
    {
        return low;
    }
    
    public int getHigh()
    {
        return high;
    }
}
