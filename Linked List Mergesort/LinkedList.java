/**
 * This class implements mergesort using a linked list.
 *
 * @author Ranjana Rajagopalan
 * @version 10/16/22
 */
public class LinkedList
{
    private Node head;
    private int length; // length of linked list
    
    /**
     * Constructor for objects of class LinkedList
     */
    public LinkedList(String str)
    {
        this.head = null;
        length = 0;
        
        // insert a node for every character of the string
        for (int i = 0; i < str.length(); i++)
        {
            insertEndNode(str.charAt(i));
        }
    }
    
    public class Node
    {
        private char c;
        public Node next;
        
        /**
         * Constructor for objects of class Node
         */
        public Node(char c)
        {
            this.c = c;
            this.next = null;
        }
    }
    
    // This method inserts a node at the end of the linked list. 
    public void insertEndNode(char c)
    {
        if (head == null)
        {
            head = new Node(c);
            length++;
            return;
        }
        
        Node currentNode = head;
        for (; currentNode.next != null; currentNode = currentNode.next)
        {
            
        }
        
        Node last = new Node(c);
        currentNode.next = last;
        
        length++;
    }
    
    // This method executes mergesort. 
    public void mergeSort()
    {
        int len = 1;
        while (len < length) {
            Node list1 = head, 
            prev1 = null, // points to node before list 1
            prev2 = null; // points to node before list 2
            
            while (list1 != null) {
                prev2 = getList2Prev(len, list1);
                
                if (prev2 == null) {
                    break;
                }
                
                Node list2 = prev2.next;
                if (list2 == null) {
                    break;
                }

                prev1 = merge(len, list1, list2, prev1, prev2); 
                
                if (prev1 == null) {
                    break;
                }
                
                list1 = prev1.next;
            }
            printList(); // print after every iteration
            len *= 2; 
        }
    }
    
    // This method returns a pointer to the first list given 
    // the pointer to the second list and the length of the list. 
    private Node getList1Prev(int len, Node list2)
    {
        Node p = list2; 
        
        for (int i = 0; i < (len - 1); i++)
        {        
            if (p.next == null)
            {
                return null;
            }
            
            p = p.next;
        }
        
        return p;
    }
    
    // This method returns the pointer to the second list given the 
    // first list pointer and the length of the list. 
    private Node getList2Prev(int len, Node list1)
    {
        Node p = list1;
        
        for (int i = 0; i < len - 1; i++)
        {
            if (p.next == null)
            {
                return null;
            }
            
            p = p.next;
        }
        
        return p;
    }
    
    // This method merges two linked lists in place given the pointers to the
    // linked list, the length of the list, and the previous pointers. 
    private Node merge(int len, Node list1, Node list2, Node prev1, Node prev2)
    {
        Node p1 = list1, p2 = list2;
        Node newList1Prev = getList1Prev(len, list2); // get end of the list after merge
        int p1count = 0, p2count = 0; 
        
        while ((p1count < len) && (p2count < len) && (p2 != null))
        {
            if (p1.c <= p2.c) // if an element in list 1 is smaller, increase list 1
            {
                prev1 = p1;
                p1 = p1.next;
                p1count++;
            }
            else // if an element in list 2 is bigger
            {
                if (prev1 == null)
                {
                    head = p2;
                }
                else {
                    prev1.next = p2;
                }
                prev2.next = p2.next;
                p2.next = p1;
                prev1 = p2;
                p2 = prev2.next;
                p2count++;
            }
        }
        
        if (p2 == null)
        {
            return null;
        }
        
        if (p2count == len) 
        {
            return prev2;
        }
        
        return newList1Prev;
    }
    
    // This method prints the contents of the linked list. 
    public void printList()
    {
        for (Node node = head; node != null; node = node.next)
        {
            System.out.print(node.c + " ");
        }
        
        System.out.println("\n");        
    }
}
