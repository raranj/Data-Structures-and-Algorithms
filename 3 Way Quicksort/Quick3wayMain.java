
/**
 * This class tests the 3-way quicksort. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/30/22
 */
public class Quick3wayMain
{
    public static void main(String[] args) {
        Quick3way obj = new Quick3way();
        
        for (int i = 1000; i <= 1000000; i *= 10) { // different array sizes
            Comparable[] a = new Comparable[i];
            
            for (int k = 0; k < a.length; k++) { // enter random values in array
                int num = (int)(Math.random() * a.length) + 1;
                a[k] = num;
            }
            
            System.out.println("Size: " + i);
            for (int j = 0; j <= 30; j++) { // values for M from 0 to 30
                double avg = 0.0;
                
                for (int t = 0; t < 10; t++) { // taking average time over 10 trials
                    long start = System.nanoTime();
                    obj.sort(a, 0, a.length -1, j);
                    long end = System.nanoTime();
                    long microseconds = (end - start) / 1000;
                    avg += microseconds;
                }
                avg /= 10.0;
                System.out.print("M = " + j + "   ");
                System.out.println("Time taken: "+ avg +" microseconds");
            }
            System.out.println("\n");
        }
    }
}
