package Model;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Client {
    private final int id;
    private final int timpSosire;
    private int timpServire;
    public JLabel label;


    public Client(int id, int timpSosire, int timpServire) {
        this.id = id;
        this.timpSosire = timpSosire;
        this.timpServire = timpServire;
        this.label = new JLabel(this.toString());
        this.label.setFont(new Font("Tahoma", Font.BOLD, 8));
        label.setPreferredSize(new Dimension(60, 25));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBorder(new LineBorder(Color.BLACK, 2));
    }
    public int getTimpSosire() {
        return timpSosire;
    }

    public int getTimpServire() {
        return timpServire;
    }

    public void setTimpServire(int timpServire) {
        this.timpServire = timpServire;
    }

    @Override
    public String toString() {
        return "(" + this.id + ", " + this.timpSosire + ", " + this.timpServire + ")";
    }
}
