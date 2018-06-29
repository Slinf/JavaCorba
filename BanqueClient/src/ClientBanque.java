
import Banque.Agence;
import Banque.AgenceHelper;
import Banque.Compte;
import Banque.CompteHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import javax.swing.*;

public class ClientBanque {

	static Agence monAgenceImpl;
	static Compte monCompteImpl;

	public static void main(String args[]) {
		try {

			MainWindow app = new MainWindow();
			app.setVisible(true);//On la rend visible

			//creer et initialiser l'ORB
			ORB orb = ORB.init(args, null);
			// obtenir une reference au service de nommage
			org.omg.CORBA.Object objRef = orb
					.resolve_initial_references("NameService");
			// Utiliser NamingContextExt au lieu de NamingContext.
			// car interoperable
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			// demander la reference de l'objet au service de noms
			String nomserviceAgence = "Agence";
			monAgenceImpl = AgenceHelper.narrow(ncRef.resolve_str(nomserviceAgence));

			ORB orb2 = ORB.init(args, null);
			// obtenir une reference au service de nommage
			org.omg.CORBA.Object objRef2 = orb2
					.resolve_initial_references("NameService");
			NamingContextExt ncCRef = NamingContextExtHelper.narrow(objRef2);
			String nomserviceCompte = "Compte";
			monCompteImpl = CompteHelper.narrow(ncCRef.resolve_str(nomserviceCompte));

			//System.out.println(monAgenceImpl.afficherListeCompte());
			//Compte a = monAgenceImpl.creerCompte("Jean",12,20000);
			//System.out.println(a);


		} catch (Exception e) {
			System.out.println("Erreur : " + e);
			e.printStackTrace(System.out);
		}
	} // fin du main

} // fin de la classe ReverseClient