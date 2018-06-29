import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;

public class InfoBanque extends JFrame {

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private InfoBanque app;

    JLabel title;
    JLabel infos;
    JButton btnContact;
    JButton btnBack;


    public InfoBanque(){
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
        setTitle(toUTF8("Information de la Banque"));
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

        infos = new JLabel(toUTF8("test"));
        infos.setBounds(180,200,400,40);

        title = new JLabel(toUTF8("Informations de la Banque"));
        title.setFont(new Font("Serif", Font.PLAIN, 25));
        title.setBounds(20,10,400,40);
        btnContact = new JButton(toUTF8("Contacter votre conseiller"));
        btnContact.setBounds(20,250,220,30);


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

        panelCreateAccount.add(btnBack);
        panelCreateAccount.add(btnContact);
        panelCreateAccount.add(infos);

        panelCreateAccount.add(title);

        return panelCreateAccount;
    }
}
