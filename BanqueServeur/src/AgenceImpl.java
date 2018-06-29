import java.util.Vector;

import org.omg.CORBA.Object;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import Banque.AgenceHelper;
import Banque.AgencePOA;
import Banque.Compte;
import Banque.Compte;
import Banque.CompteHelper;
import Banque.ComptePOA;

public class AgenceImpl extends AgencePOA {

	// Attributs
	private String nom;
	private Vector<Compte> listeComptes = new Vector<Compte>();

	// Constructeur
	public AgenceImpl(String nom) {
		this.nom = nom;
	}

	// Méthodes ou services fournis par l'objet distant (déclarés dans l'IDL)
	@Override
	public String nom() {
		return this.nom;
	}

	@Override
	public void nom(String newNom) {
		this.nom = newNom;
	}


	@Override
	public Compte creerCompte(String nom,int nocompte, float solde) {
		System.out.println("Création d'un compte : " + nom + " Numéro compte :" + nocompte  + "(" + solde
				+ " €)");

		CompteImpl cpt = new CompteImpl(nom,nocompte,solde);
		// Conversion de CompteImpl => Compte
		Compte unCompte = null;

		try {
			unCompte = CompteHelper.narrow(_poa().servant_to_reference(cpt));
			listeComptes.add(unCompte);
		} catch (ServantNotActive e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongPolicy e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Ajouter le compte à la liste des comptes

		return unCompte;
	}

	@Override
	public boolean supprimerCompte(String nom) {
		System.out.println("Suppression d'un compte : " + nom);
		// Rechercher le compte
		Compte cpt = this.rechercherCompte(nom);

		if (cpt != null) {
			// Suppression du compte
			this.listeComptes.remove(cpt);
			return true;
		}

		return false;
	}

	@Override
	public Compte rechercherCompte(String nom) {
		System.out.println("Info: Recherche d'un compte : " + nom);
		for (Compte cpt : listeComptes) {
			if (cpt.nomClient().equals(nom)) {
				return cpt;
			}
		}
		return null;
	}

	@Override
	public String afficherListeCompte() {
		System.out.println("Info: Affichage liste comptes de l'agence : "
				+ this.nom);
		String desc = "Nom Agence : " + this.nom + "\n";

		for (Compte cpt : this.listeComptes) {
			desc += cpt.infosCompte() + "\n";
		}
		return desc;
	}

	@Override
	public String afficherInfoBanque() {

		System.out.println("Info: Affichage des infos de la Banque");
		String infos = "Banque Intergalactique - Numéro accessible dans tous l'univers";

		return infos;
	}

	@Override
	public boolean ConnexionBanque(String login, String pass) {
		System.out.println("Info: Tentative de connexion à la Banque");

		if(login.equals("admin") && pass.equals("admin")) {
			System.out.println("Info:Connexion OK");
			return true;
		}
		else {
			System.out.println("Info: Echec connexion");
			return false;
		}
	}
}
