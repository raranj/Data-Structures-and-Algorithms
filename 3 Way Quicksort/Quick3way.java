/**
 * This class implements an optimized version of 3-way quicksort. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/30/22
 */
public class Quick3way
{   
    public void sort(Comparable[] a, int lo, int hi, int M) {
        if (hi <= lo) {
            return;
        }
        
        int lt = lo, i = lo, gt = hi;
        Comparable v = getPivot(a, lo, hi);
        
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            
            if (cmp < 0) {
                exchange(a, lt++, i++);
            }
            else if (cmp > 0) {
                exchange (a, i, gt--);
            }
            else {
                i++;
            }
        }
        
        if ((lt - 1) - lo + 1 > M) {
            sort(a, lo, lt - 1, M);
        }
        else {
            insertionSort(a, lo, lt - 1);
        }
        
        if (hi - (gt+1) > M) {
            sort(a, gt+1, hi, M);
        }
        else {
            insertionSort(a, gt+1, hi);
        }
    }
    
    private Comparable getPivot(Comparable[] a, int lo, int hi) {
        int num = ((int)(Math.random() * (hi - lo + 1)) + lo);
        return a[num];
    }
    
    private void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                exchange(a, j, j-1);
            }
        }
    }
    
    private void exchange(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    private boolean less(Comparable i, Comparable j) 
    {
        return i.compareTo(j) < 0;
    }
}
