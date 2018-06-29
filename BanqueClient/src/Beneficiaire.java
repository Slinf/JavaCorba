import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;

public class Beneficiaire extends JFrame {

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    JLabel title;
    JButton btnBack;

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


    private void build(){
        setTitle(toUTF8("Gestion des Bénéficiare"));
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

        title = new JLabel(toUTF8("Gestion des Bénéficiare"));
        Font myFont = new Font("Serif", Font.BOLD, 25);
        title.setFont(myFont);
        title.setBounds(60,10,400,40);

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
        panelCreateAccount.add(title);

        return panelCreateAccount;
    }
}
