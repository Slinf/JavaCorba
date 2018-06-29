import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;


public class MainWindow extends JFrame{

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    JLabel title;
    JButton btnLogin;
    JTextField logintextField;
    JTextField passtextField;
    JLabel loginlbl;
    JLabel passlbl;
    JLabel txt;



    public MainWindow(){
        super();
        build();//On initialise notre fenêtre
    }

    public String toUTF8(String myString){
        byte[] ptext = myString.getBytes(ISO_8859_1);
        String value = new String(ptext, UTF_8);
        return value;
    }


    private void build(){
        setTitle(toUTF8("Application Gestion Bancaire"));
        setSize(700,512);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPanel());

    }

    private JPanel buildContentPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);

        title = new JLabel(toUTF8("Bienvenue sur l'application de Gestion Bancaire EII"));
        title.setBounds(40,10,800,40);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        btnLogin = new JButton(new Action(this, "Connexion"));
        btnLogin.setBounds(400,270,220,50);

        logintextField = new JTextField(10);
        logintextField.setBounds(400,130,220,40);
        logintextField.setColumns(10);
        loginlbl = new JLabel("Identifiant :");
        loginlbl.setBounds(400,100,220,40);

        passlbl = new JLabel("Mot de Passe :");
        passlbl.setBounds(400,170,220,40);
        passtextField = new JPasswordField(10);
        passtextField.setBounds(400,200,220,40);
        passtextField.setColumns(10);


        txt = new JLabel("");
        txt.setBounds(450,240,210,20);

        BufferedImage wPic = null;
        try {
            wPic = ImageIO.read(this.getClass().getResource("login.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel wIcon = new JLabel(new ImageIcon(wPic));
        wIcon.setBounds(10,10,512,512);;

        panel.add(passtextField);
        panel.add(passlbl);
        panel.add(logintextField);
        panel.add(loginlbl);
        panel.add(btnLogin);
        panel.add(title);
        panel.add(txt);
        panel.add(wIcon);

        return panel;
    }

    public JTextField getpasstextField(){
        return passtextField;
    }
    public JTextField getlogintextField(){
        return logintextField;
    }


    public JLabel getLabel(){
        return txt;
    }
}
