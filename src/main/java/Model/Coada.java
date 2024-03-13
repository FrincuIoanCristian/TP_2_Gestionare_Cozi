package Model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Coada implements Runnable{
    private BlockingQueue<Client> clienti;
    private AtomicInteger timpAsteptare;
    private boolean threadRun;

    public Coada() {
        this.clienti = new LinkedBlockingQueue<>();
        this.timpAsteptare = new AtomicInteger(0);
        this.threadRun = true;
    }

    public BlockingQueue<Client> getClienti() {
        return clienti;
    }

    public AtomicInteger getTimpAsteptare() {
        return timpAsteptare;
    }

    public void setThreadRun(boolean threadRun) {
        this.threadRun = threadRun;
    }

    public void adaugaClient(Client client){
        this.clienti.add(client);
        this.timpAsteptare.addAndGet(client.getTimpServire());
    }


    @Override
    public void run() {
        while(threadRun){
            try {
                if(clienti.isEmpty()){
                    continue;
                }
                Client client = clienti.peek();
                Thread.sleep(1000);
                this.timpAsteptare.addAndGet(-1);
                client.setTimpServire(client.getTimpServire() - 1);
                if(client.getTimpServire() == 0) {
                    clienti.remove(client);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString(){
        String s = "";
        if(this.clienti.isEmpty()){
            s = "Closed";
        }else{
            s = this.clienti.toString();
        }
        return s;
    }
}
