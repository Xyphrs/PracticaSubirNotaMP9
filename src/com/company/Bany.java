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
            if (capacidad >= 3 && estat == estatBany.OCUPADO) wait();
            generoOcupado = genero;
            capacidad++;
            estat = estatBany.OCUPADO;
            Thread.sleep((long) (Math.random()*1000)+500);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void libre() {
        capacidad--;
        estat = estatBany.LIBRE;
        notifyAll();
    }
}
