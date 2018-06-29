import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;

public class GestionCompte extends JFrame {

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    JLabel title;
    JButton btnContact;
    JButton btnBack;
    JTextField logintextField;
    JTextField NomtextField;
    JTextField PrenontextField;
    JTextField passtextField;

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
        setSize(400,400);
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
        btnContact = new JButton(toUTF8("Créer"));
        btnContact.setBounds(90,240,220,30);

        btnBack = new JButton(toUTF8("< Retour"));
        btnBack.setBounds(20,300,90,30);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                System.out.println("Go back");
                Menu menupage = new Menu();
                menupage.setVisible(true);//On la rend visible
            }
        });

        logintextField = new JTextField();
        logintextField.setBounds(90,80,220,20);
        logintextField.setColumns(10);
        passtextField = new JTextField();
        passtextField.setBounds(90,120,220,20);
        passtextField.setColumns(10);
        NomtextField = new JTextField();
        NomtextField.setBounds(90,160,220,20);
        NomtextField.setColumns(10);
        PrenontextField = new JTextField();
        PrenontextField.setBounds(90,200,220,20);
        PrenontextField.setColumns(10);

        panelCreateAccount.add(btnBack);
        panelCreateAccount.add(btnContact);
        panelCreateAccount.add(PrenontextField);
        panelCreateAccount.add(NomtextField);
        panelCreateAccount.add(passtextField);
        panelCreateAccount.add(logintextField);
        panelCreateAccount.add(title);

        return panelCreateAccount;
    }
}
