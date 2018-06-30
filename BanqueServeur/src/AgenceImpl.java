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
	public Compte creerCompte(String login, String nom, String prenom, String pass, float solde, int nocompte) {
		System.out.println("Création d'un compte : " + nom + "" + prenom + " Numéro compte :" + nocompte  + "(" + solde
				+ " €)");

		CompteImpl cpt = new CompteImpl(login,nom,prenom,pass,solde,nocompte);
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
		System.out.println("Info: Affichage liste comptes de l'agence : " + this.nom);
		String desc = "";

		for (Compte cpt : this.listeComptes) {
			desc += cpt.infosCompte() + "_";
		}
		return desc;
	}

	@Override
	public String afficherInfoBanque() {

		System.out.println("Info: Affichage des infos de la Banque");
		StringBuilder infos = new StringBuilder(64);
		infos.append("<html><h1>Banque Intergalactique - Accessible dans tous l'univers<h1> <br/><br/>").
				append("<p>Fidèle à l?ambition de progrès social qui a présidé à la création de la première Caisse en 1818 sur la planète Terre, la Banque Intergalactique témoigne au quotidien de son engagement sur le terrain." +
						"Le financement de nombreux projets d'intérêt général, sa politique de responsabilité sociale, sa lutte contre l?exclusion bancaire et financière, la Fondation de l'espoir" +
						" pour la solidarité témoignent des valeurs qui font de la Banque Intergalactique une banque différente depuis 28890 ans. " +
						"Enfin, sa politique de mécénat-sponsoring vient en appui des ambitions de développement et de renforcement de la marque.</p>").
				append("</html>");

		return infos.toString();
	}

	@Override
	public boolean ConnexionBanque(String login, String pass) {
		System.out.println("Info: Tentative de connexion à la Banque");

		for (Compte cpt : this.listeComptes) {
			System.out.println(cpt.loginClient() + cpt.passClient());
			if(login.equals(cpt.loginClient()) && pass.equals(cpt.passClient()))
			{
				return true;
			}
			else {

			}
		}

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
