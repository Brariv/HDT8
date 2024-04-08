package com;

import java.util.Vector;


public class Factory {
    
    public VectorHeap<Paciente> createVectorHeap() {
        return new VectorHeap<Paciente>(new Vector<Paciente>());
    }

    public VectorHeapJCF<Paciente> createVectorHeapJCF() {
        return new VectorHeapJCF<Paciente>(new Vector<Paciente>());
    }

    
}
