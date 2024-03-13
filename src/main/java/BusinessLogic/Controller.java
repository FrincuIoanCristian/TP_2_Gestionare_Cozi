package BusinessLogic;

import GUI.ViewDate;

public class Controller {
    public Controller(ViewDate viewDate){
        viewDate.startButton(e -> {
            try{
                int numarClienti = Integer.parseInt(viewDate.getNrClientiTextField());
                int numarCozi = Integer.parseInt(viewDate.getNrCoziTextField());
                int timpSimulare = Integer.parseInt(viewDate.getTimpSimulareTextField());
                int timpSosireMin = Integer.parseInt(viewDate.getTimpSosireTextField1());
                int timpSosireMax = Integer.parseInt(viewDate.getTimpSosireTextField2());
                int timpServireMin = Integer.parseInt(viewDate.getTimpServireTextField1());
                int timpServireMax = Integer.parseInt(viewDate.getTimpServireTextField2());

                Simulare s = new Simulare(numarClienti, numarCozi, timpSimulare, timpSosireMin, timpSosireMax, timpServireMin, timpServireMax);
                viewDate.dispose();
                Thread t = new Thread(s);
                t.start();
            }catch (NumberFormatException ex){
                viewDate.showNumberError("Date invalide");
            }
        });
    }
}
