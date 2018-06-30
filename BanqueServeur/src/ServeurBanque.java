import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Banque.*;

public class ServeurBanque {

	public static void main(String[] args) {
		try {
			// creer et initialiser l'ORB qui integre
			// le service de noms
			ORB orb = ORB.init(args, null);
			// obtenir la reference de rootpoa &			
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			// activer le POAManager
			rootpoa.the_POAManager().activate();
			
			// creer le servant
			AgenceImpl AgenceRef = new AgenceImpl("Banque Intergalactique");
			CompteImpl CompteRef = new CompteImpl("admin","admin","admin","admin",0,0);
			
			// obtenir la reference CORBA du servant
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(AgenceRef);
			org.omg.CORBA.Object refcompte = rootpoa.servant_to_reference(CompteRef);
			
			Agence href = AgenceHelper.narrow(ref);
			Compte hrefcompte = CompteHelper.narrow(refcompte);
			
			// obtenir la reference du contexte de nommage
			org.omg.CORBA.Object objRef = orb
					.resolve_initial_references("NameService");
			
			// Utiliser NamingContextExt qui est Interoperable
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			// enregistrer le servant dans le service de nommage
			String name = "Agence";
			NameComponent path[] = ncRef.to_name(name);
			ncRef.rebind(path, href);

			// enregistrer le servant dans le service de nommage
			String nameCompte = "Compte";
			NameComponent pathcompte[] = ncRef.to_name(nameCompte);
			ncRef.rebind(pathcompte, hrefcompte);

			
			System.out.println("Banque est prête et est en attente.");
			// attendre les invocations des clients
			orb.run();
		} catch (Exception e) {
			System.err.println("Erreur : " + e);
			e.printStackTrace(System.out);
		}
	}

}
