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
    JButton btnBack;
    JButton btnAjoutBenef;
    JLabel benefs;
    JList lst;

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
        title.setFont(new Font("Serif", Font.PLAIN, 25));
        title.setBounds(60,10,400,40);

        benefs = new JLabel(toUTF8("Aucun Bénéficiaires"));
        if (getListBenef()!=null)
            benefs.setText(toUTF8(getListBenef()));
        benefs.setBounds(60,200,400,40);
        benefs.setFont(new Font("Serif", Font.PLAIN, 20));


        btnAjoutBenef = new JButton(toUTF8(" + Ajout d'un Bénéficiaire"));
        btnAjoutBenef.setBounds(400,350,220,30);
        btnAjoutBenef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        Vector zeros=new Vector();
        zeros.add(new String("Benef 1"));
        zeros.add(new String("Benef 2"));
        zeros.add(new String("Benef 3"));
        lst = new JList(zeros);
        lst.setBounds(20,150,220,600);

        btnBack = new JButton(toUTF8("< Retour"));
        btnBack.setBounds(20,650,90,30);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                System.out.println("Go back");
                Menu menupage = new Menu();
                menupage.setVisible(true);//On la rend visible
            }
        });


        panelCreateAccount.add(lst);
        panelCreateAccount.add(btnBack);
        panelCreateAccount.add(btnAjoutBenef);
        panelCreateAccount.add(title);
        panelCreateAccount.add(benefs);

        return panelCreateAccount;
    }
}
