

/* 
Author: Christian Vincent (N01393413)
Course: COP3530
Last edited: 2-20-2019 
*/

public class LinkedArrayQueue<E> {
    //don't forget memeber data
    SinglyLinkedList<E[]> list = new SinglyLinkedList<>();
    final int ARRAY_SIZE = 8;
    E[] array = (E[])new Object[ARRAY_SIZE];
    E[] localArray = (E[])new Object[ARRAY_SIZE];    //localArray used to modify the node arrays
    int numElements = 0;
    int front = 0;
    int back = 0;
    
    //the default constructor
    public LinkedArrayQueue() {
       
    }
    
    //return the number of elements in the queue
    public int size() {
        
        return numElements;
    }
    
    //return the number of arrays currently storing elements
    public int numArrays() {
        
        return list.size();
    }
    
    //test if the queue is empty
    public boolean isEmpty() {
        
        return numElements == 0;
    }
    
    //return the element at the front of the queue. return null if queue is empty
    public E first() {
      
       E[] localArray = list.first();
       return localArray[front];
    }
    
    //return the element at the back of the queue. return null if queue is empty
    public E last() {
       
       localArray = list.last();
       return localArray[back - 1];
    }
    
    //push e to the back of the queue
    public void enqueue(E e) {
        if(list.size() == 0) {
            list.addFirst(array);
            localArray = list.first();
            localArray[0] = e;
            numElements++; 
            back++;
        }
        else
        {
            if(back == 8) {
                list.addLast((E[]) new Object[8]);
                back = 0;
            }
            
            localArray = list.last();
            localArray[back] = e;
            back++;
            numElements++;
        }
            
    }
    
    //pop and return the element at the front of the queue. return null if queue is empty
    public E dequeue() {
        E answer;
        
        if(isEmpty())
            return null;
        
        if(front == 7) 
        {
            localArray = list.first();
            answer = localArray[front];
            list.removeFirst();
            front = 0;
            numElements--;
        }
        else
        {
            
            localArray = list.first();
            answer = localArray[front];
            localArray[front] = null;
            front++;
            numElements--;
        }
        
        return answer;
        
    } 
    
}
