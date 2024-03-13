package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewDate extends JFrame{
    private JTextField nrClientiTextField;
    private JTextField nrCoziTextField;
    private JTextField timpSimulareTextField;
    private JTextField timpSosireTextField1;
    private JTextField timpSosireTextField2;
    private JTextField timpServireTextField1;
    private JTextField timpServireTextField2;
    private JButton start;

    public ViewDate(){
        JLabel nrClienti = new JLabel("Numar de clienti:");
        nrClienti.setFont(new Font("Tahoma", Font.BOLD, 13));
        nrClientiTextField = new JTextField();
        nrClientiTextField.setPreferredSize(new Dimension(80,20));

        JLabel nrCozi = new JLabel("Numar de cozi:");
        nrCozi.setFont(new Font("Tahoma", Font.BOLD, 13));
        nrCoziTextField = new JTextField();
        nrCoziTextField.setPreferredSize(new Dimension(80,20));

        JLabel timpSimulareLabel = new JLabel("Timp de simulation:");
        timpSimulareLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        timpSimulareTextField = new JTextField();
        timpSimulareTextField.setPreferredSize(new Dimension(80,20));

        JLabel timpSosireLabel = new JLabel("Timp de sosire:");
        timpSosireLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        timpSosireTextField1 = new JTextField();
        timpSosireTextField1.setPreferredSize(new Dimension(100,20));
        timpSosireTextField2 = new JTextField();
        timpSosireTextField2.setPreferredSize(new Dimension(100,20));

        JLabel timpServireLabel = new JLabel("Timp de servire:");
        timpServireLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        timpServireTextField1 = new JTextField();
        timpServireTextField1.setPreferredSize(new Dimension(100,20));
        timpServireTextField2 = new JTextField();
        timpServireTextField2.setPreferredSize(new Dimension(100,20));

        start = new JButton("START");
        start.setPreferredSize(new Dimension(80, 40));

        JPanel label = new JPanel();
        label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
        label.add(nrClienti);
        label.add(Box.createRigidArea(new Dimension(0, 10)));
        label.add(nrCozi);
        label.add(Box.createRigidArea(new Dimension(0, 10)));
        label.add(timpSimulareLabel);
        label.add(Box.createRigidArea(new Dimension(0, 10)));
        label.add(timpSosireLabel);
        label.add(Box.createRigidArea(new Dimension(0, 10)));
        label.add(timpServireLabel);
        label.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel sosire = new JPanel();
        sosire.setLayout(new FlowLayout());
        sosire.add(timpSosireTextField1);
        sosire.add(timpSosireTextField2);

        JPanel servire = new JPanel();
        servire.setLayout(new FlowLayout());
        servire.add(timpServireTextField1);
        servire.add(timpServireTextField2);

        JPanel textField = new JPanel();
        textField.setLayout(new BoxLayout(textField, BoxLayout.Y_AXIS));
        textField.add(nrClientiTextField);
        textField.add(Box.createRigidArea(new Dimension(0, 5)));
        textField.add(nrCoziTextField);
        textField.add(Box.createRigidArea(new Dimension(0, 5)));
        textField.add(timpSimulareTextField);
        textField.add(sosire);
        textField.add(servire);

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(label);
        content.add(textField);

        JPanel titlu = new JPanel();
        JLabel titluLabel = new JLabel("Date de intrare");
        titluLabel.setPreferredSize(new Dimension(200, 50));
        titluLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titlu.add(titluLabel);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(titlu);
        mainPanel.add(content);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(start);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        this.setContentPane(mainPanel);
        this.pack();
        this.setBounds(400, 250, 500, 400);
        this.setTitle("Date simulare");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void startButton(ActionListener actionListener){
        this.start.addActionListener(actionListener);
    }

    public String getNrClientiTextField() {
        return nrClientiTextField.getText();
    }

    public String getNrCoziTextField() {
        return nrCoziTextField.getText();
    }

    public String getTimpSimulareTextField() {
        return timpSimulareTextField.getText();
    }

    public String getTimpSosireTextField1() {
        return timpSosireTextField1.getText();
    }

    public String getTimpSosireTextField2() {
        return timpSosireTextField2.getText();
    }

    public String getTimpServireTextField1() {
        return timpServireTextField1.getText();
    }

    public String getTimpServireTextField2() {
        return timpServireTextField2.getText();
    }
    public void showNumberError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
