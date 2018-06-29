import javax.swing.*;
import java.awt.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;


public class MainWindow extends JFrame{

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    JLabel title;
    JButton btnLogin;
    JTextField logintextField;
    JTextField passtextField;
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
        setSize(400,400);
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
        title.setBounds(10,10,400,40);
        title.setFont(new Font("Serif", Font.PLAIN, 20));
        btnLogin = new JButton(new Action(this, "Connexion"));
        btnLogin.setBounds(90,250,220,30);
        logintextField = new JTextField(10);
        logintextField.setBounds(90,80,220,20);
        logintextField.setColumns(10);
        passtextField = new JPasswordField(10);
        passtextField.setBounds(90,110,220,20);
        passtextField.setColumns(10);
        txt = new JLabel("");
        txt.setBounds(90,140,220,20);


        panel.add(passtextField);
        panel.add(logintextField);
        panel.add(btnLogin);
        panel.add(title);
        panel.add(txt);

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
