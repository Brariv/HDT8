package com;


import java.util.Vector;

/*
 * Clase VectorHeap
 * Esta clase implementa la interfaz PriorityQueue
 * Utiliza un Vector para almacenar los elementos
 * Ordena los elementos en un heap dependiendo su prioridad
 * Devuelve valores String de los elementos (toString)
 */


public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    protected Vector<E> data; // the data, kept in heap order

    public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
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
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
				((data.get(childpos+1)).compareTo
				(data.get(childpos)) < 0))
				{
					childpos++;
				}
			// Assert: childpos indexes smaller of two children
			if ((data.get(childpos)).compareTo
				(value) < 0)
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

    public void add(E value)
	// pre: value is non-null comparable
	// post: value is added to priority queue
	{
		data.add(value);
		percolateUp(data.size()-1);
	}

    public E remove()
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	{
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}

    public E getFirst() {
        // post: returns the first value in the heap
        return data.get(0);
    }

    public E getIndex(int i) {
        // post: returns the value at index i
        return data.get(i);
    }

    public int size() {
        // post: returns the size of the heap
        return data.size();
    }


    public String toString() {
        // post: returns the string representation of the heap object
        return data.toString();
    }

    public void clear() {
        // post: removes all elements from the heap
        data.clear();
    }

    public boolean isEmpty() {
        // post: returns true if the heap is empty
        return data.isEmpty();
    }


    
}