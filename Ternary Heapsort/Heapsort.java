/**
 * This class implements ternary heapsort. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/29/22
 */
public class Heapsort
{
    public static void main(String[] args) 
    {
        Integer[] array = new Integer[101]; // start from 1, not 0
        
        for (int i = 1; i < array.length; i++) {
            array[i] = i;
        }
        
        // shuffle the array
        for (int i = 1; i < array.length; i++) {
            int randomIndex = (int)(Math.random()*(array.length - 1)) + 1;
            int temp = array[randomIndex];
            array[randomIndex] = array[i];
            array[i] = temp;
        }
        
        System.out.println("Original Array: ");
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        
        sort(array);
        
        System.out.println("\nSorted Array: ");
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    
    public static void sort(Comparable[] a)
    {
        int n = a.length-1;
        int k = n/3;
        
        // if there are two leftover child nodes, start sink at one node greater
        if ((n%3) == 2) {
            k += 1;
        }
        
        // heap construction
        for (; k >= 1; k--) {
            sink(a, k, n);
        }
        
        // sortdown
        while (n > 1) {
            exchange(a, 1, n--);
            sink(a, 1, n);
        }
    }
    
    private static void sink(Comparable[] a, int k, int n)
    {
        while ((3*k - 1) <= n) {
            int j = 3*k - 1;
            
            // check left and middle child nodes
            if ((j < n) && less(a[j], a[j+1])) {
                j++;
            }
            
            // if left child node is bigger, compare with right child node
            if (j == (3*k - 1)) {
                if (((j+1) < n) && less(a[j], a[j+2])) {
                    j += 2;
                }
            }
            else { // if middle child node is bigger, compare with right child node
                if ((j < n) && less(a[j], a[j+1])) {
                    j++;
                }
            }
            
            if (!less(a[k],a[j])) {
               break; 
            }
            
            exchange(a, k, j);
            k = j;
        }
    }
    
    private static boolean less(Comparable i, Comparable j) 
    {
        return i.compareTo(j) < 0;
    }
    
    private static void exchange(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
