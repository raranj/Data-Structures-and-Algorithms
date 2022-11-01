/**
 * This class implements a doubly linked list. 
 *
 * @author Ranjana Rajagopalan
 * @version 09/19/22
 */
public class DoublyLinkedList
{
    public class DoubleNode
    {
        private char c;
        public DoubleNode next;
        public DoubleNode prev;
        
        /**
         * Constructor for objects of class DoublyLinkedList
         */
        public DoubleNode(char c)
        {
            this.c = c;
            this.next = null;
            this.prev = null;
        }
    }

    private DoubleNode head;
    
    /**
     * Constructor for objects of class DoublyLinkedList
     */
    public DoublyLinkedList()
    {
        this.head = null;
    }
    
    // This method prints the contents of the linked list. 
    public void printList()
    {
        for (DoubleNode node = head; node != null; node = node.next)
        {
            System.out.print(node.c + " ");
        }
        System.out.println("\n");        
    }
    
    // This method prints the list in reverse. 
    public void printReverseList()
    {
        if (head == null)
        {
            return;
        }
        
        DoubleNode currentNode = head;
        for (; currentNode.next != null; currentNode = currentNode.next)
        {
            
        }
        
        for (DoubleNode current = currentNode; current != null; current = current.prev)
        {
            System.out.print(current.c + " ");
        }
        System.out.println("\n");
    }
    
    // This method inserts a node at the start of the linked list. 
    public void insertStartNode(char c)
    {
        DoubleNode oldHead = head;
        head = new DoubleNode(c);
        head.next = oldHead;
        oldHead.prev = head;
    }
    
    // This method inserts a node at the end of the linked list. 
    public void insertEndNode(char c)
    {
        if (head == null)
        {
            head = new DoubleNode(c);
            return;
        }
        
        DoubleNode currentNode = head;
        for (; currentNode.next != null; currentNode = currentNode.next)
        {
            
        }
        
        DoubleNode last = new DoubleNode(c);
        currentNode.next = last;
        last.prev = currentNode;
        last.next = null;
    }
    
    // This method removes the node at the beginning of the linked list. 
    public void removeStartNode()
    {
        head = head.next;
        head.prev = null;
    }
    
    // This method removes a node at the end of the linked list. 
    public void removeEndNode()
    {
        if (head == null)
        {
            return;
        }
        
        DoubleNode currentNode = head;
        for (; currentNode.next != null; currentNode = currentNode.next)
        {
            
        }
        
        DoubleNode previous = currentNode.prev;
        if (previous == null)
        {
            head = null;
            return;
        }
        currentNode.prev = null;
        previous.next = null;
    }
    
    // This method inserts a node before a given node in the linked list.
    // The parameter key indicates the given node and the character val is the new
    // node to be placed in the list. 
    public void insertBeforeGivenNode(char key, char val)
    {
        DoubleNode newNode = new DoubleNode(val);
        DoubleNode oldNode = null;
        
        for (DoubleNode node = head; node != null; node = node.next)
        {
            if (node.c == key)
            {
                newNode.prev = node.prev;
                node.prev = newNode;
                newNode.next = node;
                if (newNode.prev == null)
                {
                    head = newNode;
                    return;
                }
                (newNode.prev).next = newNode;
                return;
            }
            
            oldNode = node;
        }
        
        newNode.next = null;
        newNode.prev = oldNode;
        if (oldNode == null)
        {
            head = newNode;
            return;
        }
        oldNode.next = newNode;
    }
    
    // This method inserts a node after a given node in the linked list.
    // The parameter key indicates the given node and the character val is the new
    // node to be placed in the list. 
    public void insertAfterGivenNode(char key, char val)
    {
        DoubleNode newNode = new DoubleNode(val);
        DoubleNode oldNode = null;
        
        for (DoubleNode node = head; node != null; node = node.next)
        {
            if (node.c == key)
            {
                newNode.next = node.next;
                node.next = newNode;
                newNode.prev = node;
                if (newNode.next != null)
                {
                    newNode.next.prev = newNode;
                }
                return;
            }
            
            oldNode = node;
        }
        
        newNode.next = null;
        newNode.prev = oldNode;
        if (oldNode == null)
        {
            head = newNode;
            return;
        }
        oldNode.next = newNode;
    }
    
    // This method removes a given node (indicated by parameter key) from the linked list. 
    public void removeGivenNode(char key)
    {
        for (DoubleNode node = head; node != null; node = node.next)
        {
            if (node.c == key)
            {
                if (node == head)
                {
                    head = node.next;
                    if (head != null)
                    {
                        head.prev = null;
                        node.next = null;
                    }
                    return;
                }
                
                if (node.next == null)
                {
                    node.prev.next = null;
                    node.prev = null;
                    return;
                }
                
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
                return;
            }
        }
    }
    
    // This method moves a given node to the front of the linked list. 
    public void moveToFront(char key)
    {
        for (DoubleNode node = head; node != null; node = node.next)
        {
            if (node.c == key)
            {
                if (node == head)
                {
                    return;
                }
                
                if (node.next != null)
                {
                    node.next.prev = node.prev;
                }
                
                node.prev.next = node.next;
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
                return;
            }
        }
    }
    
    // This method moves a given node to the end of the linked list. 
    public void moveToEnd(char key)
    {
        DoubleNode node = head;
        for (; node != null; node = node.next)
        {
            if (node.c == key)
            {
               if (node.next == null)
               {
                   return;
               }
               
               if (node == head)
               {
                   head = node.next;
                   head.prev = null;
                   node.next = null;
                   break;
               }
               
               node.next.prev = node.prev;
               node.prev.next = node.next;
               node.next = null;
               node.prev = null;
               break;
            }
        }
        
        if (node == null)
        {
            return;
        }
        
        DoubleNode currentNode = head;
        for (; currentNode.next != null; currentNode = currentNode.next)
        {
            
        }
        
        currentNode.next = node;
        node.prev = currentNode;
        node.next = null;
    }
}
