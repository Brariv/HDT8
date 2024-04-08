package com;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    public void UI() {
        TxtReader txtReader = new TxtReader();
        Scanner scanner = new Scanner(System.in);
        Factory factory = new Factory();


        System.out.println("Bienvenido al sistema de prioridad de clientes");
        System.out.println("Ingrese el path del archivo: ");
        String path = scanner.nextLine();
        ArrayList<ArrayList<String>> data = txtReader.readTxTFile(path);
        //System.out.println(data);
        int option = 0;

        while (option != 3){
            System.out.println("Ingrese una opción: ");
            System.out.println("1. VectorHeap");
            System.out.println("2. Priority Queue");
            System.out.println("3. Salir");

            option = scanner.nextInt();

            ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

            for (int i = 0; i < data.size(); i++) {
                //create object paciente
                Paciente paciente = new Paciente(data.get(i).get(0), data.get(i).get(1), data.get(i).get(2));
                pacientes.add(paciente);
            }

            //System.out.println(pacientes.get(3).compareTo(pacientes.get(3)));
            //System.out.println(pacientes.get(3).compareTo(pacientes.get(2)));
            //System.out.println(pacientes.get(3).compareTo(pacientes.get(1)));
            //System.out.println(pacientes.get(3).compareTo(pacientes.get(0)));

            switch (option) {
                case 1:
                    VectorHeap<Paciente> vector = factory.createVectorHeap();
                    for (int i = 0; i < pacientes.size(); i++) {
                        if (vector.size() == 0) {
                            vector.add(pacientes.get(i));
                        } else {
                            if (pacientes.get(i).compareTo(vector.getFirst()) == 1) {
                                vector.add(pacientes.get(i));
                            } else {
                                vector.add(pacientes.get(i));
                            }
                        }
                    }
                    System.out.println("VectorHeap: ");
                    //System.out.println(vector.size());
                    for(int i = 0; i < vector.size(); i++) {
                        System.out.println(vector.getIndex(i).toString());
                    }
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;

                default:
                    break;
            }
        }



        scanner.close();
    }
}
