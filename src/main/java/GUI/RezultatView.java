package GUI;

import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.*;

public class RezultatView extends JFrame{

    public RezultatView(String s1, String s2, String s3){
        JLabel labelRezultat1 = new JLabel(s1);
        labelRezultat1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelRezultat1.setPreferredSize(new Dimension(200, 30));
        JLabel labelRezultat2 = new JLabel(s2);
        labelRezultat2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelRezultat2.setPreferredSize(new Dimension(200, 30));
        JLabel labelRezultat3 = new JLabel(s3);
        labelRezultat3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelRezultat3.setPreferredSize(new Dimension(200, 30));


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(labelRezultat1);
        mainPanel.add(labelRezultat2);
        mainPanel.add(labelRezultat3);
        Dimension screenSize = getDefaultToolkit().getScreenSize();
        this.setContentPane(mainPanel);
        this.setTitle("Rezultate simulare");
        this.pack();
        this.setBounds(screenSize.width/2, screenSize.height /2, 400, 130);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
