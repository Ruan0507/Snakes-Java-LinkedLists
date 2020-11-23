
public class SinglyLinkedList 
{   
    private Element head;  // list header
    private Element tail;
    public SinglyLinkedList()
    {  head = null;  
        tail = null;        
    }

    public void purge()
    {
        head=null;
        tail=null;
    }   

    public Element getTail()
    {
        return tail;
    } 

    public Element getHead()
    {
        return head;
    }   

    public boolean append(SnakeElement newElement) //insert at tail
    {  
        Element temp = new Element(newElement);
        if(temp == null) // out of memory
            return false;
        else
        {  
            if (head==null)
            {
                head = temp;
                tail = temp;
            }
            else
            {
                tail.next = temp;
                tail = temp;
            }
        }
        return true;   
    }

    public boolean prepend(SnakeElement newElement)
    {
        Element temp = new Element(newElement);
        if(temp == null) // out of memory
            return false;
        else
        {  
            if (head==null)
            {
                head = temp;
                tail = temp;
            }
            else
            {
                temp.next = head;
                head = temp;
            }
        }
        return true; 
    }

    public boolean remove(SnakeElement newElement)
    {
        Element ptr = head;
        Element prevPtr = null;
        
        while (ptr!= null&& ptr.getData() != newElement)
        {
            prevPtr=ptr;
            ptr=ptr.next;
        }
            
        if (ptr==tail)
        {
            tail = prevPtr;
            tail.next = null;
        }
        return true;
    }

    public boolean checkRowCol(int row,int col)
    {
        Element ptr = head.getNext();
        SnakeElement tmp;
        while (ptr!= null && ptr != tail.next)
        {
            tmp = (SnakeElement)ptr.data;
            if (tmp.getRow()==row && tmp.getCol()==col)
                return true;
            ptr=ptr.next;
        }   
        return false;
    }
    
    public boolean checkAppleCollision(int row,int col)
    {
        Element ptr = head;
        SnakeElement tmp;
        while (ptr!= null && ptr != tail.next)
        {
            tmp = (SnakeElement)ptr.data;
            if (tmp.getRow()== row && tmp.getCol()== col)
                return true;
            ptr=ptr.next;
        }   
        return false;
    }

    public class Element
    {   private SnakeElement data;
        private Element next;
        public Element(SnakeElement param)
        {
            data = param;
        }

        public Element getNext()
        {
            return next;
        }    

        public SnakeElement getData()
        {
            return data;  
        }   
    }// end of inner class Node
}//end SinglyLinkedList outer class
