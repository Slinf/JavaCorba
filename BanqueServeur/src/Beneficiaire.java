import java.util.ArrayList;

public class Beneficiaire {

    private String _prenom;
    private String _nom;
    private int _noComptebase;

    //Constructeur
    public Beneficiaire(String nom,String prenom,int noComptebase){
        _prenom=prenom;
        _nom = nom;
        _noComptebase = noComptebase;
    }

    public String getPrenom() {
        return _prenom;
    }

    public long getNocompte() {
        return _noComptebase;
    }

    public String getNom() {
        return _nom;
    }
}
