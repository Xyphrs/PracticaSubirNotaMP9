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
            bany.libre();
            System.out.println(getName() + " sale -");
            Thread.sleep((long) (Math.random()*1000)+500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ocupar() {
        try {
            bany.ocupado(genero);
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
