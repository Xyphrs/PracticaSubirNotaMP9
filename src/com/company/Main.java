package com.company;

public class Main {

    public static void main(String[] args) {
        Bany bany = new Bany();
        Persona persona1 = new Persona("Paco", "Hombre", bany);
        Persona persona2 = new Persona("Maria", "Mujer", bany);
        Persona persona3 = new Persona("Jesus", "Hombre", bany);
        Persona persona4 = new Persona("Laura", "Mujer", bany);
        Persona persona5 = new Persona("Jose", "Hombre", bany);


        persona1.start();
        persona2.start();
        persona3.start();
        persona4.start();
        persona5.start();
    }
}
