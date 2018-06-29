import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Action extends AbstractAction {

    private MainWindow app;

    public Action(MainWindow app, String texte){
        super(texte);
        this.app = app;
    }


    public void actionPerformed(ActionEvent e) {

        System.out.println("Info: Tentative de connexion à la Banque");
        String login = app.getlogintextField().getText();
        String pass = app.getpasstextField().getText();
        boolean conn = ClientBanque.monAgenceImpl.ConnexionBanque(login, pass);
        if(conn) {
            System.out.println("Info: Connexion OK");
            app.getLabel().setText("Connexion OK");
            app.getLabel().setForeground(Color.green);
            Menu Createpage = new Menu();
            Createpage.setVisible(true);//On la rend visible
            app.setVisible(false);
        }
        else
            System.out.println("Info: Erreur de connexion");
            app.getLabel().setText("Erreur de connexion");
            app.getLabel().setForeground(Color.red);
    }
}
