import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;

public class LastOperation extends JFrame {

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    JLabel title;
    JButton btnBack;
    JButton btnAddOp;
    JLabel error;
    JLabel noCompteLbl;
    JTextField noCompteTxt;
    JLabel LstOplbl;

    JLabel montantLbl;
    JTextField montantTxt;

    JLabel infosuppLbl;
    JTextField infosuppTxt;

    JLabel listoperationLbl;
    JComboBox listoperation;
    JList lst;



    private LastOperation app;


    public LastOperation(){
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

    private String getListOp (){
        String value;
        value = ClientBanque.monCompteImpl.afficherCredits();
        value += ClientBanque.monCompteImpl.afficherDebits();
        value += ClientBanque.monCompteImpl.afficherVirements();

        return value;
    }

    private void build(){
        setTitle(toUTF8("Dernière Opération"));
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

        title = new JLabel(toUTF8("Gestions Opérations"));
        Font myFont = new Font("Serif", Font.BOLD, 20);
        title.setFont(myFont);
        title.setBounds(20,10,400,40);

        LstOplbl = new JLabel(toUTF8("Liste dernière opération"));
        LstOplbl.setFont(new Font("Serif", Font.ITALIC, 25));
        LstOplbl.setBounds(20,150,300,40);

        DefaultListModel  model=new DefaultListModel ();
        if(getListOp()!=null)
        {
            String str = toUTF8(getListOp());
            String [] parts = str.split("_");
            for (String op:parts) {
                System.out.println(op);
                model.addElement(op);
            }
        }
        lst = new JList(model);
        lst.setBounds(20,200,300,800);

        listoperationLbl = new JLabel(toUTF8("Type de l'opération :"));
        listoperationLbl.setBounds(400,370,220,30);
        listoperation = new JComboBox();
        listoperation.setBounds(400,400,220,30);
        listoperation.setPreferredSize(new Dimension(100, 20));
        listoperation.addItem(toUTF8("Débit"));
        listoperation.addItem(toUTF8("Crédit"));
        listoperation.addItem(toUTF8("Virement"));

        noCompteTxt = new JTextField();
        noCompteLbl= new JLabel(toUTF8("N° Compte"));
        noCompteLbl.setBounds(400,50,300,50);
        noCompteTxt.setBounds(400,100,300,50);
        noCompteTxt.setColumns(10);

        montantLbl= new JLabel("Montant :");
        montantLbl.setBounds(400,140,300,50);
        montantTxt = new JTextField();
        montantTxt.setBounds(400,180,300,50);
        montantTxt.setColumns(10);

        infosuppTxt = new JTextField();
        infosuppLbl= new JLabel("Commentaire : ");
        infosuppLbl.setBounds(400,230,320,50);
        infosuppTxt.setBounds(400,280,300,50);
        infosuppTxt.setColumns(10);



        btnAddOp = new JButton(toUTF8(" + Ajouter Opération"));
        btnAddOp.setBounds(400,520,300,50);
        btnAddOp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int index = listoperation.getSelectedIndex();

                    boolean succes =false;
                    String noComptest = noCompteTxt.getText();
                    String montantstr = montantTxt.getText();
                    String infosup = infosuppTxt.getText();
                    Float montant = null;
                    int noCompte = 0;

                    if(montantstr.isEmpty() || ((String) noComptest).isEmpty())
                    {
                        error.setVisible(true);
                    }
                    else if(Integer.valueOf(noComptest) == 0 || Float.parseFloat(montantstr)== 0)
                    {
                        error.setVisible(true);
                    }
                    else {

                        montant = Float.parseFloat(montantstr);
                        noCompte = Integer.valueOf(montantstr);

                        if (index == 0) {
                            succes = ClientBanque.monCompteImpl.debiter(montant,noCompte);
                            System.out.println(toUTF8("Opération de débit reussi :" + succes));
                        } else if (index == 1) {
                            succes = ClientBanque.monCompteImpl.crediter(montant,noCompte);
                            System.out.println(toUTF8("Opération de Crédit reussi : " + succes));
                        } else if (index == 2) {
                            succes =ClientBanque.monCompteImpl.virement(montant,noCompte);
                            System.out.println("Opération de Virement reussi : " + succes);
                        }

                        if (getListOp() != null)
                        {
                            model.clear();
                            String str = toUTF8(getListOp());
                            String[] parts = str.split("_");
                            for (String op : parts)
                            {
                                model.addElement(op);
                            }

                            lst.setModel(model);
                        }
                        if(succes == false)
                        {
                            error.setText(toUTF8("Opération refusé, vérifier votre solde"));
                            error.setVisible(true);
                        }
                    }
                }
                catch (Exception ex){
                    error.setText("Erreur, info : " + ex.getMessage());
                    error.setVisible(true);
                }
            }
        });


        error= new JLabel("Veuillez renseigner tous les champs");
        error.setForeground(Color.red);
        error.setBounds(400,320,300,50);
        error.setVisible(false);

        btnBack = new JButton(toUTF8("< Retour"));
        btnBack.setBounds(400,700,220,30);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                System.out.println("Go back");
                Menu menupage = new Menu();
                menupage.setVisible(true);//On la rend visible
            }
        });

        panelCreateAccount.add(error);
        panelCreateAccount.add(btnBack);
        panelCreateAccount.add(title);
        panelCreateAccount.add(listoperation);
        panelCreateAccount.add(listoperationLbl);
        panelCreateAccount.add(noCompteTxt);
        panelCreateAccount.add(noCompteLbl);
        panelCreateAccount.add(montantLbl);
        panelCreateAccount.add(montantTxt);
        panelCreateAccount.add(infosuppLbl);
        panelCreateAccount.add(infosuppTxt);
        panelCreateAccount.add(btnAddOp);
        panelCreateAccount.add(lst);
        panelCreateAccount.add(LstOplbl);


        return panelCreateAccount;
    }
}
