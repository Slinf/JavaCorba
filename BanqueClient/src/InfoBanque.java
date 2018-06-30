import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
        getInfos();
        build();//On initialise notre fenêtre
    }

    private String getInfos() {
        String infos = ClientBanque.monAgenceImpl.afficherInfoBanque();
        return infos;
    }

    //Problème d'encodage compilation Hors IDE
    public String toUTF8(String myString){
        byte[] ptext = myString.getBytes(ISO_8859_1);
        String value = new String(ptext, UTF_8);
        return value;
    }


    private void build(){
        setTitle(toUTF8("Information de la Banque"));
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

        infos = new JLabel(toUTF8("Aucunes Informations disponibles"));
        if (getInfos()!=null)
            infos.setText(getInfos());
        infos.setBounds(20,100,700,400);

        title = new JLabel(toUTF8("Informations de la Banque"));
        title.setFont(new Font("Serif", Font.PLAIN, 25));
        title.setBounds(20,10,400,40);
        btnContact = new JButton(toUTF8("Contacter votre conseiller"));
        btnContact.setBounds(20,600,220,30);
        btnContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop;
                if (Desktop.isDesktopSupported()
                        && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
                    URI mailto = null;
                    try {
                        mailto = new URI("mailto:banqueintergalactique@example.com?subject=Contact%20conseiller");
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        desktop.mail(mailto);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    // TODO fallback to some Runtime.exec(..) voodoo?
                    throw new RuntimeException("desktop doesn't support mailto; mail is dead anyway ;)");
                }
            }
        });


        btnBack = new JButton(toUTF8("< Retour"));
        btnBack.setBounds(20,650,90,30);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                System.out.println("Go back from InfoBank");
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
