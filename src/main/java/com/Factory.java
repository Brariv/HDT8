package com;

import java.util.Vector;
import java.util.PriorityQueue;

public class Factory {
    
    public VectorHeap<Paciente> createVectorHeap() {
        return new VectorHeap<Paciente>(new Vector<Paciente>());
    }

    public PriorityQueue<Paciente> createPriorityQueue() {
        return new PriorityQueue<Paciente>();
    }

    
}
