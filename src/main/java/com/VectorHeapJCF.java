package com;

import java.util.PriorityQueue;
import java.util.Vector;

/*
 * Clase VectorHeap
 * Esta clase extiende la coleccion de PriorityQueue de Java Collections Framework
 * Utiliza un Vector para almacenar los elementos
 * Ordena los elementos en un heap dependiendo su prioridad
 * Devuelve valores String de los elementos (toString)
 */

public class VectorHeapJCF<E extends Comparable<E>> extends PriorityQueue<E> {

    protected Vector<E> data; // the data, kept in heap order

    public VectorHeapJCF(Vector<E> v){
        // post: constructs a new priority queue from an unordered vector
        int i;
        data = new Vector<E>(v.size()); 
        for (i = 0; i < v.size(); i++)
        { // add elements to heap
            add(v.get(i));
        }

        
    }

    protected static int parent(int i) { // post: returns parent of node at index i
        return (i - 1) / 2;
    }

    protected static int left(int i) {// post: returns left child of node at index i
        return 2 * i + 1;
    }

    protected static int right(int i) {// post: returns right child of node at index i
        return (i + 1) * 2;
    }

    protected void percolateUp(int leaf)
    // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
        (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    protected void pushDownRoot(int root)
    // pre: 0 <= root < size   
    // post: moves node at index root down to appropriate position in subtree
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo(value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root,value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root,value);
                return;
            }
        }
    }

    public E getIndex(int i) { // post: returns the element at index i
        return data.get(i);
    }

    public int size() { // post: returns number of elements within queue
        return data.size();
    }

    public void addData(E value)
    // pre: value is non-null comparable
    // post: value is added to priority queue
    {
        data.add(value);
        percolateUp(data.size() - 1);
    }

}
