/**
 * This class tests a doubly linked list. 
 *
 * @author Ranjana Rajagopalan
 * @version 09/19/22
 */
public class DoublyLinkedListTester
{
    public static void main(String[] args)
    {
        DoublyLinkedList list = new DoublyLinkedList();
        
        list.insertEndNode('C');
        list.insertEndNode('O');
        list.insertEndNode('M');
        list.insertEndNode('P');
        list.insertEndNode('U');
        list.insertEndNode('T');
        list.insertEndNode('E');
        list.insertEndNode('R');
        
        System.out.println("Printing the list: ");
        list.printList();
        
        System.out.println("Inserting M at the beginning: ");
        list.insertStartNode('M');
        list.printList();
        
        System.out.println("Inserting A at the end: ");
        list.insertEndNode('A');
        list.printList();
        
        System.out.println("Removing from beginning: ");
        list.removeStartNode();
        list.printList();
        
        System.out.println("Removing from end: ");
        list.removeEndNode();
        list.printList();
        
        System.out.println("Inserting M before P: ");
        list.insertBeforeGivenNode('P', 'M');
        list.printList();
        
        System.out.println("Inserting H before M: ");
        list.insertBeforeGivenNode('M', 'H');
        list.printList();
        
        System.out.println("Inserting B before A: ");
        list.insertBeforeGivenNode('A', 'B');
        list.printList();
        
        System.out.println("Inserting C after P: ");
        list.insertAfterGivenNode('P', 'C');
        list.printList();
        
        System.out.println("Inserting L after M: ");
        list.insertAfterGivenNode('M', 'L');
        list.printList();
        
        System.out.println("Removing M: ");
        list.removeGivenNode('M');
        list.printList();
        
        System.out.println("Removing G: ");
        list.removeGivenNode('G');
        list.printList();
        
        System.out.println("Moving P to the front of the list: ");
        list.moveToFront('P');
        list.printList();
        
        System.out.println("Moving L to the end of the list: ");
        list.moveToEnd('L');
        list.printList();
        
        System.out.println("Printing reverse list: ");
        //testing if the previous pointers are ok
        list.printReverseList();
    }
}
