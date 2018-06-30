import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;
import java.util.Vector;

public class Beneficiaire extends JFrame {

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    JLabel title;
    JLabel error;
    JLabel LstBeneflbl;
    JButton btnBack;
    JButton btnAjoutBenef;
    JLabel benefs;
    JList lst;
    JTextField NomtextField;
    JTextField PrenontextField;
    JTextField NoComptetextField;

    JLabel NoComptelbl;
    JLabel Nomlbl;
    JLabel Prenonlbl;


    private Beneficiaire app;

    public Beneficiaire(){
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

    private String getListBenef (){
       return ClientBanque.monCompteImpl.afficherBeneficiaire();
    }


    private void build(){
        setTitle(toUTF8("Gestion des Bénéficiare"));
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

        title = new JLabel(toUTF8("Gestion des Bénéficiare"));
        title.setFont(new Font("Serif", Font.ITALIC, 20));
        title.setBounds(60,10,400,40);


        LstBeneflbl = new JLabel(toUTF8("Liste des Bénéficiaires :"));
        LstBeneflbl.setFont(new Font("Serif", Font.ITALIC, 25));
        LstBeneflbl.setBounds(60,150,250,40);

        DefaultListModel  model=new DefaultListModel ();
        if(getListBenef()!=null)
        {
            String str = toUTF8(getListBenef());
            String [] parts = str.split("_");
            for (String benef:parts) {
                System.out.println(benef);
                model.addElement(benef);
            }
        }
        lst = new JList(model);
        lst.setBounds(60,200,220,800);


        btnAjoutBenef = new JButton(toUTF8(" + Ajout d'un Bénéficiaire"));
        btnAjoutBenef.setBounds(400,410,300,50);

        btnAjoutBenef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String nom = NomtextField.getText();
                String prenom= PrenontextField.getText();
                String noCompte = NoComptetextField.getText();
                int noCompteInt = 0;

                if(nom.isEmpty() || prenom.isEmpty() || ((String) noCompte).isEmpty())
                {
                    error.setVisible(true);
                }
                else if(Integer.valueOf(noCompte) == 0)
                {
                    error.setVisible(true);
                }
                else {
                    noCompteInt = Integer.parseInt(noCompte);
                    ClientBanque.monCompteImpl.ajouterBenef(nom, prenom, noCompteInt);

                    if (getListBenef() != null)
                    {
                        model.clear();
                        String str = toUTF8(getListBenef());
                        String[] parts = str.split("_");
                        for (String benef : parts)
                        {
                            model.addElement(benef);
                        }

                        lst.setModel(model);
                    }
                }

            }
        });

        btnBack = new JButton(toUTF8("< Retour"));
        btnBack.setBounds(400,700,220,30);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                System.out.println("Go back from Benef");
                Menu menupage = new Menu();
                menupage.setVisible(true);//On la rend visible
            }
        });


        error= new JLabel("Veuillez renseigner tous les champs");
        error.setForeground(Color.red);
        error.setBounds(400,360,300,50);
        error.setVisible(false);

        PrenontextField = new JTextField();
        Prenonlbl= new JLabel(toUTF8("Prénom"));
        Prenonlbl.setBounds(400,100,300,50);
        PrenontextField.setBounds(400,150,300,50);
        PrenontextField.setColumns(10);

        Nomlbl= new JLabel("Nom :");
        Nomlbl.setBounds(400,190,300,50);
        NomtextField = new JTextField();
        NomtextField.setBounds(400,230,300,50);
        NomtextField.setColumns(10);

        NoComptelbl= new JLabel(toUTF8("N° compte :"));
        NoComptelbl.setBounds(400,280,320,50);
        NoComptetextField= new JTextField();
        NoComptetextField.setBounds(400,320,300,50);

        panelCreateAccount.add(lst);
        panelCreateAccount.add(error);
        panelCreateAccount.add(LstBeneflbl);
        panelCreateAccount.add(Nomlbl);
        panelCreateAccount.add(Prenonlbl);
        panelCreateAccount.add(PrenontextField);
        panelCreateAccount.add(NomtextField);
        panelCreateAccount.add(NoComptetextField);
        panelCreateAccount.add(NoComptelbl);
        panelCreateAccount.add(btnBack);
        panelCreateAccount.add(btnAjoutBenef);
        panelCreateAccount.add(title);

        return panelCreateAccount;
    }
}
