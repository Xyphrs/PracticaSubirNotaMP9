package com.company;

public class Bany {
    int capacidad;
    String generoOcupado = null;

    public enum estatBany {
        LIBRE, OCUPADO
    }

    private Enum<estatBany> estat;

    public Bany() {
        estat = estatBany.LIBRE;
    }

    public synchronized Enum<estatBany> getEstat() {
        return estat;
    }

    public synchronized void ocupado(String genero) {
        try {
            while (estat == estatBany.OCUPADO && capacidad >= 3) wait();
            generoOcupado = genero;
            capacidad++;
            estat = estatBany.OCUPADO;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void libre() throws InterruptedException {
        capacidad--;
        Thread.sleep(2000);
        estat = estatBany.LIBRE;
        notifyAll();
    }
}
