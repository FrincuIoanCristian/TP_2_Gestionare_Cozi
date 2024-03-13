package BusinessLogic;

import GUI.RezultatView;
import GUI.SimulareFrame;
import Model.Client;
import Model.Coada;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Simulare implements Runnable {
    public int numarClienti;
    public int numarCozi;
    public int timpLimita;
    public int minTimpSosire;
    public int maxTimpSosire;
    public int minTimpServire;
    public int maxTimpServire;
    private Organizare organizare;
    private ArrayList<Client> generareClienti;
    //max clienti per time
    private int maxClienti;
    private int timpMaxClienti;
    //media service time
    private float medieTimpServire;
    private SimulareFrame simulareFrame;

    public Simulare(int numarClienti, int numarCozi, int timpLimita, int minTimpSosire, int maxTimpSosire, int minTimpServire, int maxTimpServire) {
        this.numarClienti = numarClienti;
        this.numarCozi = numarCozi;
        this.timpLimita = timpLimita;
        this.minTimpSosire = minTimpSosire;
        this.maxTimpSosire = maxTimpSosire;
        this.minTimpServire = minTimpServire;
        this.maxTimpServire = maxTimpServire;
        this.organizare = new Organizare(numarCozi);
        this.generareClienti = new ArrayList<>();
        generareNRandomClienti();
        this.maxClienti = 0;
        mediaST();
        this.simulareFrame = new SimulareFrame();
    }

    private void generareNRandomClienti() {
        Random random = new Random();
        for (int i = 1; i <= this.numarClienti; i++) {
            int timpSosire = random.nextInt(this.minTimpSosire, this.maxTimpSosire + 1);
            int timpServire = random.nextInt(this.minTimpServire, this.maxTimpServire + 1);
            Client c = new Client(i, timpSosire, timpServire);
            generareClienti.add(c);
        }
        Comparator<Client> comparatorTimpSosire = new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getTimpSosire() - o2.getTimpSosire();
            }
        };
        Collections.sort(this.generareClienti, comparatorTimpSosire);
    }
    @Override
    public void run() {
        try {
            ArrayList<Client> clients = new ArrayList<>();
            int timpCurent = 0, i = 0;
            FileWriter myWriter = new FileWriter("log.txt");
            while (timpCurent <= this.timpLimita) {
                for(Client client: generareClienti){
                    if(client.getTimpSosire() == timpCurent) {
                        clients.add(client);
                    }else{
                        break;
                    }
                }
                for(Client client: clients){
                    organizare.dispatchClient(client);
                    generareClienti.remove(client);
                }
                clients.clear();
                printare(timpCurent, myWriter);
                nrMaxClienti(timpCurent);
                Thread.sleep(1000);
                timpCurent++;
            }
            for(Coada c: organizare.getCozi()){
                c.setThreadRun(false);
            }
            printareRezultate(myWriter);
            myWriter.close();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void mediaST(){
        this.medieTimpServire = 0;
        for(Client c:generareClienti){
            this.medieTimpServire += c.getTimpServire();
        }
        this.medieTimpServire /= numarClienti;
    }

    private void nrMaxClienti(int timpCurent){
        int nr = 0;
        for(Coada c : organizare.getCozi()){
            nr += c.getClienti().size();
        }
        if(nr > maxClienti){
            maxClienti = nr;
            timpMaxClienti = timpCurent;
        }
    }

    private void printare(int timpCurent, FileWriter myWriter){
        try {
            myWriter.write("Time: " + timpCurent + "\n");
            System.out.println("Time: " + timpCurent);
            myWriter.write("Clienti: ");
            myWriter.write(generareClienti.toString());
            myWriter.write("\n");
            organizare.afisareCozi(myWriter);
            simulareFrame.repaintFrame(timpCurent, organizare, generareClienti);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printareRezultate(FileWriter myWriter){
        try {
            String s1 = "Numar maxim de clienti: " + this.maxClienti + ", au fost la timpul: " + this.timpMaxClienti + ";";
            myWriter.write(s1 + "\n");
            String s2 = "Media timpului de servire este: " + this.medieTimpServire + ";";
            myWriter.write(s2 + "\n");
            organizare.setSumaTimpAsteptare(organizare.getSumaTimpAsteptare() / this.numarClienti);
            String s3 = "Media timpului de asteptare este: " + organizare.getSumaTimpAsteptare() + ";";
            myWriter.write(s3 + "\n");
            simulareFrame.dispose();
            new RezultatView(s1,s2,s3);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}