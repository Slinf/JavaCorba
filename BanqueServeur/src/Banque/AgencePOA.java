package Banque;


/**
* Banque/AgencePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from specification.idl
* vendredi 29 juin 2018 10 h 22 CEST
*/

public abstract class AgencePOA extends org.omg.PortableServer.Servant
 implements Banque.AgenceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_nom", new java.lang.Integer (0));
    _methods.put ("_set_nom", new java.lang.Integer (1));
    _methods.put ("creerCompte", new java.lang.Integer (2));
    _methods.put ("supprimerCompte", new java.lang.Integer (3));
    _methods.put ("rechercherCompte", new java.lang.Integer (4));
    _methods.put ("afficherListeCompte", new java.lang.Integer (5));
    _methods.put ("afficherInfoBanque", new java.lang.Integer (6));
    _methods.put ("ConnexionBanque", new java.lang.Integer (7));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Banque/Agence/_get_nom
       {
         String $result = null;
         $result = this.nom ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // Banque/Agence/_set_nom
       {
         String newNom = in.read_string ();
         this.nom (newNom);
         out = $rh.createReply();
         break;
       }

       case 2:  // Banque/Agence/creerCompte
       {
         String nom = in.read_string ();
         int nocompte = in.read_long ();
         float solde = in.read_float ();
         Banque.Compte $result = null;
         $result = this.creerCompte (nom, nocompte, solde);
         out = $rh.createReply();
         Banque.CompteHelper.write (out, $result);
         break;
       }

       case 3:  // Banque/Agence/supprimerCompte
       {
         String nom = in.read_string ();
         boolean $result = false;
         $result = this.supprimerCompte (nom);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // Banque/Agence/rechercherCompte
       {
         String nom = in.read_string ();
         Banque.Compte $result = null;
         $result = this.rechercherCompte (nom);
         out = $rh.createReply();
         Banque.CompteHelper.write (out, $result);
         break;
       }

       case 5:  // Banque/Agence/afficherListeCompte
       {
         String $result = null;
         $result = this.afficherListeCompte ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 6:  // Banque/Agence/afficherInfoBanque
       {
         String $result = null;
         $result = this.afficherInfoBanque ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 7:  // Banque/Agence/ConnexionBanque
       {
         String login = in.read_string ();
         String pass = in.read_string ();
         boolean $result = false;
         $result = this.ConnexionBanque (login, pass);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Banque/Agence:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Agence _this() 
  {
    return AgenceHelper.narrow(
    super._this_object());
  }

  public Agence _this(org.omg.CORBA.ORB orb) 
  {
    return AgenceHelper.narrow(
    super._this_object(orb));
  }


} // class AgencePOA