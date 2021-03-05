package com.company;

public class Persona extends Thread {
    String genero;
    Bany bany;

    public Persona(String nom, String genero, Bany bany) {
        super(nom);
        this.genero = genero;
        this.bany = bany;
    }

    private void dejarlibre() {
        try {
            System.out.println(getName() + " sale -");
            bany.libre();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ocupar() {
        try {
            bany.ocupado(this.genero);
            System.out.println(getName() + " entra |");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for(;;) {
            ocupar();
            dejarlibre();
        }
    }
}
