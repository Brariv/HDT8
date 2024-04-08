package com;

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private String prioridad;

    public Paciente(String nombre, String sintoma, String prioridad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public String getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Paciente: " + nombre + ", sintoma:" + sintoma + ", prioridad:" + prioridad;
    }

    @Override
        public int compareTo(Paciente p) {
            return prioridad.compareTo(p.prioridad); 
        }

}
