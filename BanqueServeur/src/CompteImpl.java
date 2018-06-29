import Banque.*;

import java.util.ArrayList;
import java.util.List;

public class CompteImpl extends ComptePOA {
	//Attributs
	private String nomClient;
	private float solde;
	private int noCompte;
	private static List<CompteImpl> LstBenef;
	private static  List<Operation> LstOperation;


	//Constructeur
	public CompteImpl(String nom, int noComptebase,float soldeInitial){
		nomClient = nom;
		noCompte = noComptebase;
		solde = soldeInitial;
		LstBenef = new ArrayList<CompteImpl>();
		LstOperation = new ArrayList<Operation>();
	}

	//Pour Beneficiaire
	public CompteImpl(String nom, int noComptebase){
		nomClient = nom;
		noCompte = noComptebase;
		LstBenef = new ArrayList<CompteImpl>();
		LstOperation = new ArrayList<Operation>();
	}

	@Override
	public String nomClient() {
		return nomClient;
	}

	@Override
	public void nomClient(String newNomClient) {
		nomClient = newNomClient;
	}

	@Override
	public float solde() {
		return solde;
	}

	@Override
	public boolean debiter(float somme, int nocompte) {
		System.out.println("Appel de debiter");
		if (somme > 0 && solde > somme) {
			solde = solde - somme;
			Operation op = new Operation(0,nocompte,somme,"opération débit réussi");
			return true;
		}
		Operation op = new Operation(0,nocompte,somme,"opération débit refusé");
		LstOperation.add(op);
		return false;
	}

	@Override
	public boolean crediter(float somme,int nocompte) {
		System.out.println("Appel de crediter");
		if (somme > 0) {
			solde = solde + somme;
			Operation op = new Operation(1,nocompte,somme,"opération crédit réussi");
			return true;
		}

		Operation op = new Operation(1,nocompte,somme,"opération crédit refusé");
		LstOperation.add(op);
		return false;
	}

	@Override
	public boolean virement(float somme, int nocompte) {
		System.out.println("Appel de virement");
		if (somme > 0 && solde > somme) {
			solde = solde - somme;
			Operation op = new Operation(2,nocompte,somme,"opération virement réussi");
			return true;
		}
		Operation op = new Operation(2,nocompte,somme,"opération virement refusé");

		LstOperation.add(op);
		return false;
	}

	@Override
	public String infosCompte() {
		System.out.println("Demande infos compte!");
		return "\tNom client : " + nomClient() 
				+ "\n" + "\tSolde : " + solde() + "euros" ;
	}

	@Override
	public void ajouterBenef(String nomBenef, int nocompte) {
		CompteImpl newBenef = new CompteImpl(nomBenef,nocompte);
		Operation op = new Operation(3,nocompte,0,nomBenef);
		LstOperation.add(op);
		LstBenef.add(newBenef);
	}


	@Override
	public String afficherBeneficiaire() {
		String listString = "";

		for (CompteImpl c : LstBenef)
		{
			listString += " Client :" + c.nomClient + " Numéro de compte:" + c.noCompte + "\t";
		}

		return listString;
	}

	@Override
	public String afficherDebits() {
		String listString = "";
		for (Operation op : LstOperation)
		{
			if(op.getType() == 0)
				listString += " Débit de :" + op.getMontant() + " Numéro de compte:" + op.getNocompte() + "Informations supp : " + op.getInfo() + "\t";
		}
		return listString;
	}

	@Override
	public String afficherCredits() {
		String listString = "";
		for (Operation op : LstOperation)
		{
			if(op.getType() == 1)
				listString += " Crédit de :" + op.getMontant() + " Numéro de compte:" + op.getNocompte() + "Informations supp : " + op.getInfo() + "\t";
		}
		return listString;

	}

	@Override
	public String afficherVirements() {
		String listString = "";
		for (Operation op : LstOperation)
		{
			if(op.getType() == 2)
				listString += " Virement de :" + op.getMontant() + " Numéro de compte:" + op.getNocompte() + "Informations supp : " + op.getInfo() + "\t";
		}
		return listString;
	}

	@Override
	public String afficherAjoutBeneficiaire() {
		String listString = "";
		for (Operation op : LstOperation)
		{
			if(op.getType() == 3)
				listString += " Ajout Bénéficiare: Numéro de compte:" + op.getNocompte() + "Nom béneficiare: " + op.getInfo() + "\t";
		}
		return listString;
	}
}
