import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;

public class GestionCompte extends JFrame {

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    JLabel error;
    JLabel title;
    JButton btnValid;
    JButton btnBack;
    JTextField logintextField;
    JTextField NomtextField;
    JTextField PrenontextField;
    JTextField passtextField;
    JTextField SoldetextField;
    JTextField NoComptetextField;
    JLabel LstComptelbl;



    JLabel Soldelbl;
    JLabel NoComptelbl;
    JLabel loginlbl;
    JLabel Nomlbl;
    JLabel Prenonlbl;
    JLabel passlbl;
    JList lst;
    DefaultListModel  model=new DefaultListModel ();
    private GestionCompte app;

    private String getListCompte (){
        return ClientBanque.monAgenceImpl.afficherListeCompte();
    }


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
        Font myFont = new Font("Serif", Font.BOLD, 20);
        title.setFont(myFont);
        title.setBounds(20,10,400,40);

        LstComptelbl = new JLabel(toUTF8("Liste des Comptes :"));
        LstComptelbl.setFont(new Font("Serif", Font.ITALIC, 25));
        LstComptelbl.setBounds(60,150,250,40);

        btnValid = new JButton(toUTF8("Valider Informations"));
        btnValid.setBounds(400,620,300,50);
        btnValid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String login = logintextField.getText();
                    String nom = NomtextField.getText();
                    String prenom= PrenontextField.getText();
                    String pass = passtextField.getText();
                    String soldestr = SoldetextField.getText();
                    String noComptestr = NoComptetextField.getText();
                    Float solde = null;
                    int noCompte=0;

                    if(login.isEmpty() || nom.isEmpty() || prenom.isEmpty() || pass.isEmpty() || soldestr.isEmpty() || noComptestr.isEmpty())
                    {
                        error.setVisible(true);
                    }
                    else if(Integer.valueOf(noComptestr) == 0 || Float.parseFloat(soldestr)== 0){
                        error.setVisible(true);
                    }
                    else {
                        solde = Float.parseFloat(soldestr);
                        noCompte = Integer.valueOf(noComptestr);
                        ClientBanque.monAgenceImpl.creerCompte(login, nom, prenom, pass, solde, noCompte);

                        if (getListCompte() != null)
                        {
                            model.clear();
                            String str = toUTF8(getListCompte());
                            String[] parts = str.split("_");
                            for (String benef : parts)
                            {
                                model.addElement(benef);
                            }

                            lst.setModel(model);
                        }

                    }

                }
                catch (Exception ex){
                    error.setText("Erreur, info : " + ex.getMessage());
                    error.setVisible(true);
                }


            }
        });


        if(getListCompte()!=null)
        {
            String str = toUTF8(getListCompte());
            String [] parts = str.split("_");
            for (String compte:parts) {
                System.out.println(compte);
                model.addElement(compte);
            }
        }
        lst = new JList(model);
        lst.setBounds(60,200,220,800);


        btnBack = new JButton(toUTF8("< Retour"));
        btnBack.setBounds(400,700,220,30);
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
        Prenonlbl.setBounds(400,50,300,50);
        PrenontextField.setBounds(400,100,300,50);
        PrenontextField.setColumns(10);

        Nomlbl= new JLabel("Nom :");
        Nomlbl.setBounds(400,140,300,50);
        NomtextField = new JTextField();
        NomtextField.setBounds(400,180,300,50);
        NomtextField.setColumns(10);

        passtextField = new JTextField();
        passlbl= new JLabel("Mot de passe : ");
        passlbl.setBounds(400,230,320,50);
        passtextField.setBounds(400,280,300,50);
        passtextField.setColumns(10);

        loginlbl = new JLabel("Identifiant :");
        loginlbl.setBounds(400,320,300,50);
        logintextField = new JTextField();
        logintextField.setBounds(400,370,300,50);
        logintextField.setColumns(10);

        Soldelbl = new JLabel("Solde :");
        Soldelbl.setBounds(400,410,300,50);
        SoldetextField= new JTextField();
        SoldetextField.setBounds(400,450,300,50);

        NoComptelbl= new JLabel(toUTF8("N° compte :"));
        NoComptelbl.setBounds(400,500,300,50);
        NoComptetextField= new JTextField();
        NoComptetextField.setBounds(400,540,300,50);

        error= new JLabel("Veuillez renseigner tous les champs");
        error.setForeground(Color.red);
        error.setBounds(400,590,300,50);
        error.setVisible(false);

        panelCreateAccount.add(lst);
        panelCreateAccount.add(error);
        panelCreateAccount.add(Nomlbl);
        panelCreateAccount.add(Prenonlbl);
        panelCreateAccount.add(passlbl);
        panelCreateAccount.add(loginlbl);
        panelCreateAccount.add(Soldelbl);
        panelCreateAccount.add(NoComptelbl);
        panelCreateAccount.add(LstComptelbl);


        panelCreateAccount.add(btnBack);
        panelCreateAccount.add(btnValid);

        panelCreateAccount.add(PrenontextField);
        panelCreateAccount.add(NomtextField);
        panelCreateAccount.add(passtextField);
        panelCreateAccount.add(logintextField);
        panelCreateAccount.add(SoldetextField);
        panelCreateAccount.add(NoComptetextField);
        panelCreateAccount.add(title);

        return panelCreateAccount;
    }
}
