package GUI;

import BusinessLogic.*;
import Model.Client;
import Model.Coada;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulareFrame extends JFrame{

    private JPanel mainPanel;
    int xPrim, yPrim;

    public SimulareFrame(){
        mainPanel = new JPanel();
    }

    public void repaintFrame(int timp, Organizare organizare, ArrayList<Client> generareClienti){
        mainPanel.removeAll();
        mainPanel.setLayout(null);
        JPanel aux = new JPanel();
        aux.setLayout(new BoxLayout(aux, BoxLayout.Y_AXIS));
        JLabel timpLabel = new JLabel("Timp: " + timp);
        timpLabel.setBounds(300, 20, 150, 50);
        timpLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        mainPanel.add(timpLabel);
        JLabel coziLabel = new JLabel("Cozi:");
        coziLabel.setBounds(50, 40, 100, 50);
        coziLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        mainPanel.add(coziLabel);
        coziAfis(organizare);
        JLabel clientiLabel = new JLabel("Clienti:");
        clientiLabel.setBounds(1000, 5, 100, 50);
        clientiLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        mainPanel.add(clientiLabel);
        clientiAfis(generareClienti);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(screenSize);
        this.setTitle("Simulare");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void coziAfis(Organizare organizare){
        int nrCoada = 0;
        xPrim = 20;
        yPrim = 90;
        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
        separator.setBounds(0, yPrim-5,950,2);
        separator.setBackground(Color.BLACK);
        mainPanel.add(separator);
        for(Coada coada : organizare.getCozi()){
            JPanel content = new JPanel();
            content.setLayout(new FlowLayout());
            nrCoada++;
            JLabel coadaLabel = new JLabel("Queue " + nrCoada);
            coadaLabel.setBounds(xPrim,yPrim,70,30);
            coadaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
            mainPanel.add(coadaLabel);
            if(!coada.getClienti().isEmpty()){
                Client cl = coada.getClienti().peek();
                cl.label.setText(cl.toString());
            }
            int x2 = xPrim;
            int nr = 0;
            for(Client c:coada.getClienti()){
                nr++;
                x2 +=70;
                c.label.setBounds(x2,yPrim,60,25);
                mainPanel.add(c.label);
                if(nr == 12){
                    break;
                }
            }
            yPrim += 35;
            separator = new JSeparator(JSeparator.HORIZONTAL);
            separator.setBounds(0, yPrim-5,950,2);
            separator.setBackground(Color.BLACK);
            mainPanel.add(separator);
        }
    }

    private void clientiAfis(List<Client> generareClienti){
        JSeparator separator = new JSeparator(JSeparator.VERTICAL);
        separator.setBounds(950, 0,2,1000);
        separator.setBackground(Color.BLACK);
        mainPanel.add(separator);
        xPrim = 970;
        int x2 = xPrim;
        yPrim =45;
        int nrLinie = 0;
        int nrColoana = 0;
        for(Client client:generareClienti){
            client.label.setBounds(x2,yPrim,60,25);
            mainPanel.add(client.label);
            nrColoana++;
            if(nrColoana == 8){
                nrColoana = 0;
                yPrim +=30;
                x2 = xPrim;
                nrLinie++;
            }else{
                x2 += 65;
            }
            if(nrLinie == 25){
                break;
            }
        }
    }
}

