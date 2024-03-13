package BusinessLogic;

import Model.Client;
import Model.Coada;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Organizare {
    private List<Coada> cozi;
    private float sumaTimpAsteptare;
    public Organizare(int maxNoCozi) {
        this.cozi = new ArrayList<>();
        for (int i = 0; i < maxNoCozi; i++) {
            Coada c = new Coada();
            cozi.add(c);
            Thread thread = new Thread(c);
            thread.start();
        }
        this.sumaTimpAsteptare = 0;
    }

    public List<Coada> getCozi() {
        return cozi;
    }

    public float getSumaTimpAsteptare() {
        return sumaTimpAsteptare;
    }

    public void setSumaTimpAsteptare(float sumaTimpAsteptare) {
        this.sumaTimpAsteptare = sumaTimpAsteptare;
    }

    public void dispatchClient(Client client) {
        Coada coada = cozi.get(0);
        for (Coada c : cozi) {
            if (c.getTimpAsteptare().get() < coada.getTimpAsteptare().get()) {
                coada = c;
            }
        }
        coada.adaugaClient(client);
        this.sumaTimpAsteptare += coada.getTimpAsteptare().get();
    }

    public void afisareCozi(FileWriter myWriter) {
        int i = 0;
        try {
            for (Coada c : cozi) {
                i++;
                myWriter.write("Queue " + i + ": " + c.toString() + "\n");
            }
            myWriter.write("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
