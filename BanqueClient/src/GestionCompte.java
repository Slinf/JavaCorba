import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;

public class GestionCompte extends JFrame {

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    JLabel title;
    JButton btnValid;
    JButton btnBack;
    JTextField logintextField;
    JTextField NomtextField;
    JTextField PrenontextField;
    JTextField passtextField;
    JTextField SoldetextField;
    JTextField NoComptetextField;

    JLabel Soldelbl;
    JLabel NoComptelbl;
    JLabel loginlbl;
    JLabel Nomlbl;
    JLabel Prenonlbl;
    JLabel passlbl;

    private GestionCompte app;

    public GestionCompte(){
        super();
        this.app = this;
        build();//On initialise notre fenêtre
    }

    //Problème d'encodage compilation Hors IDE
    public String toUTF8(String myString){
        byte[] ptext = myString.getBytes(ISO_8859_1);
        String value = new String(ptext, UTF_8);
        return value;
    }


    private void build(){
        setTitle(toUTF8("Création d'un nouveau compte bancaire"));
        setSize(800,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(buildAccountCreation());
    }

    private JPanel buildAccountCreation(){
        JPanel panelCreateAccount = new JPanel();
        panelCreateAccount.setLayout(null);
        panelCreateAccount.setBackground(Color.white);

        title = new JLabel(toUTF8("Création d'un compte bancaire"));
        Font myFont = new Font("Serif", Font.BOLD, 25);
        title.setFont(myFont);
        title.setBounds(40,10,400,40);

        btnValid = new JButton(toUTF8("Valider Informations"));
        btnValid.setBounds(250,600,300,50);
        btnValid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = logintextField.getText();
                String nom = NomtextField.getText();
                String prenom= PrenontextField.getText();
                String pass = passtextField.getText();
                Float solde = Float.parseFloat(SoldetextField.getText());
                int noCompte = Integer.valueOf(NoComptetextField.getText());

                ClientBanque.monAgenceImpl.creerCompte(login,nom,prenom,pass,solde,noCompte);
            }
        });

        btnBack = new JButton(toUTF8("< Retour"));
        btnBack.setBounds(20,700,90,30);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                System.out.println("Go back from GestionCompte");
                Menu menupage = new Menu();
                menupage.setVisible(true);//On la rend visible
            }
        });

        PrenontextField = new JTextField();
        Prenonlbl= new JLabel(toUTF8("Prénom"));
        Prenonlbl.setBounds(250,100,300,50);
        PrenontextField.setBounds(250,150,300,50);
        PrenontextField.setColumns(10);

        Nomlbl= new JLabel("Nom :");
        Nomlbl.setBounds(250,190,300,50);
        NomtextField = new JTextField();
        NomtextField.setBounds(250,230,300,50);
        NomtextField.setColumns(10);

        passtextField = new JTextField();
        passlbl= new JLabel("Mot de passe : ");
        passlbl.setBounds(250,280,320,50);
        passtextField.setBounds(250,320,300,50);
        passtextField.setColumns(10);

        loginlbl = new JLabel("Identifiant :");
        loginlbl.setBounds(250,370,300,50);
        logintextField = new JTextField();
        logintextField.setBounds(250,410,300,50);
        logintextField.setColumns(10);

        Soldelbl = new JLabel("Solde :");
        Soldelbl.setBounds(250,460,300,50);
        SoldetextField= new JTextField();
        SoldetextField.setBounds(250,500,300,50);

        NoComptelbl= new JLabel("N° compte :");
        NoComptelbl.setBounds(250,550,300,50);
        NoComptetextField= new JTextField();
        NoComptetextField.setBounds(250,590,300,50);



        panelCreateAccount.add(Nomlbl);
        panelCreateAccount.add(Prenonlbl);
        panelCreateAccount.add(passlbl);
        panelCreateAccount.add(loginlbl);

        panelCreateAccount.add(btnBack);
        panelCreateAccount.add(btnValid);

        panelCreateAccount.add(PrenontextField);
        panelCreateAccount.add(NomtextField);
        panelCreateAccount.add(passtextField);
        panelCreateAccount.add(logintextField);
        panelCreateAccount.add(title);

        return panelCreateAccount;
    }
}
