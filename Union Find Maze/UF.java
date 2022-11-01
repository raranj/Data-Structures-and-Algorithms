/**
 * This class implements the union find algorithm. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/03/22
 */
public class UF
{
    private int[] id;
    private int count;

    /**
     * Constructor for objects of class UF
     */
    public UF(int n)
    {
        count = n;
        id = new int[n+1];
        for (int i = 0; i <= n; i++) {
            id[i] = i;
        }
    }
    
    public int count() {
        return count;
    }
    
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    
    public int find(int p)
    {
        return id[p];
    }
    
    public void union(int p, int q)
    {
        int pID = find(p);
        int qID = find(q);
        
        if (pID == qID) {
            return;
        }
        
        for (int i = 1; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        
        count--;
    }
}
