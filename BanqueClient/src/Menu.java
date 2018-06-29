import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.Charset;

public class Menu extends JFrame {

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private Menu app;

    JLabel title;
    JButton btnCreate;
    JButton btnLastOpe;
    JButton btnBeneficiaire;
    JButton btnInfoBanque;
    JButton btnDisconnect;

    JLabel txt;


    public Menu(){
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
        setTitle(toUTF8("Application Gestion Bancaire"));
        setSize(800,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildAccountCreation());
    }

    private JPanel buildAccountCreation(){
        JPanel panelCreateAccount = new JPanel();
        panelCreateAccount.setLayout(null);
        panelCreateAccount.setBackground(Color.white);

        title = new JLabel(toUTF8("Menu gestion bancaire"));;
        title.setFont(new Font("Serif", Font.ITALIC, 30));
        title.setBounds(50,20,300,50);
        title.setBackground(Color.white);
        title.setOpaque(true);

        btnLastOpe = new JButton(toUTF8("Dernières opérations"));
        btnLastOpe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                System.out.println("Go to Bénéficiaire");
                LastOperation lastoperationpage = new LastOperation();
                lastoperationpage.setVisible(true);//On la rend visible
            }
        });


        btnCreate = new JButton(toUTF8("Créer un Compte"));
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                System.out.println("Go to Bénéficiaire");
                GestionCompte createaccountpage = new GestionCompte();
                createaccountpage.setVisible(true);//On la rend visible
            }
        });




        btnBeneficiaire = new JButton(toUTF8("Gérer Bénéficiaire"));
        btnBeneficiaire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                System.out.println("Go to Bénéficiaire");
                Beneficiaire benefpage = new Beneficiaire();
                benefpage.setVisible(true);//On la rend visible
            }
        });


        btnInfoBanque = new JButton(toUTF8("Informations de la Banque"));
        btnInfoBanque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                System.out.println("Go to InfoBanque");
                InfoBanque infopage = new InfoBanque();
                infopage.setVisible(true);//On la rend visible
            }
        });

        btnDisconnect = new JButton(toUTF8("Déconnexion"));
        btnDisconnect.setForeground(Color.red);
        btnDisconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setVisible(false);
                System.out.println("Disconnect");
                MainWindow mainpage = new MainWindow();
                mainpage.setVisible(true);//On la rend visible
            }
        });

        BufferedImage wPic = null;
        try {
            wPic = ImageIO.read(this.getClass().getResource("background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel wIcon = new JLabel(new ImageIcon(wPic));
        wIcon.setBounds(0,0,800,800);;


        btnCreate.setBounds(250,500,300,50);
        btnLastOpe.setBounds(250,400,300,50);
        btnBeneficiaire.setBounds(250,300,300,50);
        btnInfoBanque.setBounds(250,200,300,50);
        btnDisconnect.setBounds(250,700,300,50);

        panelCreateAccount.add(title);
        panelCreateAccount.add(btnCreate);
        panelCreateAccount.add(btnLastOpe);
        panelCreateAccount.add(btnBeneficiaire);
        panelCreateAccount.add(btnInfoBanque);
        panelCreateAccount.add(btnDisconnect);
        panelCreateAccount.add(wIcon);


        return panelCreateAccount;
    }
}
