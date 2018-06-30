import Banque.*;

import java.util.ArrayList;
import java.util.List;

public class CompteImpl extends ComptePOA {

	//Attributs
	private String _nomClient;
	private String _login;
	private String _pass;
	private String _prenom;
	private float _solde;
	private int _noCompte;
	private static List<Beneficiaire> LstBenef;
	private static  List<Operation> LstOperation;


	//Constructeur
	public CompteImpl(String login,String nom,String prenom,String pass, float soldeInitial,int noComptebase){
		_login=login;
		_pass =pass;
		_prenom=prenom;
		_nomClient = nom;
		_noCompte = noComptebase;
		_solde = soldeInitial;
		LstBenef = new ArrayList<Beneficiaire>();
		LstOperation = new ArrayList<Operation>();
	}

	@Override
	public String nomClient() {
		return _nomClient;
	}

	@Override
	public void nomClient(String newNomClient) {
		_nomClient = newNomClient;
	}

	@Override
	public String loginClient() {
		return _login;
	}

	@Override
	public void loginClient(String newLoginClient) {

	}

	@Override
	public String passClient() {
		return _pass;
	}

	@Override
	public void passClient(String newPassClient) {

	}

	@Override
	public float solde() {
		return _solde;
	}

	@Override
	public boolean debiter(float somme, int nocompte) {
		System.out.println("Appel de debiter");
		if (somme > 0 && _solde > somme) {
			_solde = _solde - somme;
			Operation op = new Operation(0,nocompte,somme,"opération débit réussi");
			LstOperation.add(op);
			return true;
		}
		else{
			Operation op = new Operation(0,nocompte,somme,"opération débit refusé");
			LstOperation.add(op);
		}
		return false;
	}

	@Override
	public boolean crediter(float somme,int nocompte) {
		System.out.println("Appel de crediter");
		if (somme > 0) {
			_solde = _solde + somme;
			Operation op = new Operation(1,nocompte,somme,"opération crédit réussi");
			LstOperation.add(op);
			return true;
		}
		else
		{
			Operation op = new Operation(1,nocompte,somme,"opération crédit refusé");
			LstOperation.add(op);
		}
		return false;
	}

	@Override
	public boolean virement(float somme, int nocompte) {
		System.out.println("Appel de virement");
		if (somme > 0 && _solde > somme) {
			_solde = _solde - somme;
			Operation op = new Operation(2,nocompte,somme,"opération virement réussi");
			LstOperation.add(op);
			return true;
		}
		else {
			Operation op = new Operation(2, nocompte, somme, "opération virement refusé");
			LstOperation.add(op);
		}

		return false;
	}

	@Override
	public String infosCompte() {
		System.out.println("Demande infos compte!");
		return "\tNom client : " + nomClient() + "\n" + "\tSolde : " + solde() + "euros" ;
	}

	@Override
	public void ajouterBenef(String nomBenef,String prenomBenef, int nocompte) {
		Beneficiaire newBenef = new Beneficiaire(nomBenef,prenomBenef,nocompte);
		Operation op = new Operation(3,nocompte,0,nomBenef);
		LstOperation.add(op);
		LstBenef.add(newBenef);
	}


	@Override
	public String afficherBeneficiaire() {
		System.out.println("Affichage beneficiaire");
		String listString = "";
		if(LstBenef.isEmpty()) {
			listString="Aucun bénéficiare n'a été ajouté";
		}
		else {
			for (Beneficiaire b : LstBenef) {
				listString += b.getNom() + " " +  b.getPrenom() + " Num compte:" + b.getNocompte() + "_";
			}
		}
		System.out.println(listString);
		return listString;
	}

	@Override
	public String afficherDebits() {
		System.out.println("Affichage debits");
		String listString = "";
		for (Operation op : LstOperation)
		{
			if(op.getType() == 0)
				listString += " Débit de :" + op.getMontant() + " Num compte:" + op.getNocompte() + "_";
		}
		System.out.println(listString);
		return listString;
	}

	@Override
	public String afficherCredits() {
		System.out.println("Affichage credits");
		String listString = "";
		for (Operation op : LstOperation)
		{
			if(op.getType() == 1)
				listString += " Crédit de :" + op.getMontant() + " Num compte:" + op.getNocompte() + "_";
		}
		System.out.println(listString);
		return listString;

	}

	@Override
	public String afficherVirements() {
		System.out.println("Affichage virements");
		String listString = "";
		for (Operation op : LstOperation)
		{
			if(op.getType() == 2)
				listString += " Virement de :" + op.getMontant() + " Num compte:" + op.getNocompte() + "_";
		}
		System.out.println(listString);
		return listString;
	}

	@Override
	public String afficherAjoutBeneficiaire() {
		System.out.println("Ajout beneficiaire");
		String listString = "";
		for (Operation op : LstOperation)
		{
			if(op.getType() == 3)
				listString += " Ajout Bénéficiare: Numéro de compte:" + op.getNocompte() + "Nom béneficiare: " + op.getInfo() + "_";
		}
		return listString;
	}
}
