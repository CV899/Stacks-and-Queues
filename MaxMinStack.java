

/*
Author: Christian Vincent (N01393413)
Course: COP3530
Last edited: 2-20-2019
*/

//Note that <E extends Comparable>. Therefore you should use Comparable
//instead of Object while creating arrays and casting them to generic type.
//Also use compareTO() instead of < or > while comparing generic elements
public class MaxMinStack<E extends Comparable<E>> {
    
    private E[] data;
    private E[] minArray;
    private E[] maxArray;
    private int ary_size;
    private int t = -1; //number of actual elements in the arrays
    
    //the default constructor
    public MaxMinStack() {
        this(10);
    }
    
    //another constructor which returns a stack of specified size
    @SuppressWarnings("unchecked")
    public MaxMinStack(int ary_size) {
        
        this.ary_size = ary_size;
        data = (E[]) new Comparable[ary_size];
        minArray = (E[]) new Comparable[ary_size];
        maxArray = (E[]) new Comparable[ary_size];
       
    }
    
    //return the element on top of the stack without removing it. return null
    // if stack is empty
    public E top() {
        
        if(isEmpty())
            return null;
        
        return data[t];
    }
    
    //return the number of elements in the stack
    public int size() {
        
        return t + 1;
        
    }
    
    //test if the stack is empty 
    public boolean isEmpty() {
        
        return (t == -1);
        
    }
    
    //return the actual capacity of the stack(not the number of elements
    //stored in it)
    public int capacity() {
        
        return ary_size;
        
    }
    
    //return the maximum value stored in the stack. return null if stack
    //is empty 
    public E maximum() {
        if(isEmpty())
            return null;
        
        return maxArray[t];
        
    }
    
    //return the minimum value stored in the stack. return null if stack
    //is empty 
    public E minimum() {
        if(isEmpty())
            return null;
        
        return minArray[t];
        
    }
    
    //push a new element onto the stack 
    public void push(E e) throws IllegalStateException {
        
        if(size() == ary_size) 
            throw new IllegalStateException("Stack is full");
        
        if(t == -1) {
            t = 0;
            data[t] = e;
            minArray[t] = e;
            maxArray[t] = e; 
        }
        else
        {
            t++;
            
            data[t] = e;
            
            if(data[t].compareTo(minArray[t-1]) < 0)
                minArray[t] = data[t];
            else
                minArray[t] = minArray[t-1];
            
            if(data[t].compareTo(maxArray[t-1]) > 0)
                maxArray[t] = data[t];
            else
                maxArray[t] = maxArray[t-1];
            
        }
         
        
    }
    
    //pop the element on top of the stack and return it. return null
    //if stack is empty 
    public E pop() {
        
        if(isEmpty())
            return null;
        
        E answer = data[t];
        data[t] = null;
        minArray[t] = null;
        maxArray[t] = null;
        t--;
        
        return answer;
         
    }
    
}
