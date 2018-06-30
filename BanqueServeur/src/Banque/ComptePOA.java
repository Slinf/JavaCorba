package Banque;


/**
* Banque/ComptePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from specification.idl
* dimanche 1 juillet 2018 00 h 51 CEST
*/

public abstract class ComptePOA extends org.omg.PortableServer.Servant
 implements Banque.CompteOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_nomClient", new java.lang.Integer (0));
    _methods.put ("_set_nomClient", new java.lang.Integer (1));
    _methods.put ("_get_loginClient", new java.lang.Integer (2));
    _methods.put ("_set_loginClient", new java.lang.Integer (3));
    _methods.put ("_get_passClient", new java.lang.Integer (4));
    _methods.put ("_set_passClient", new java.lang.Integer (5));
    _methods.put ("_get_solde", new java.lang.Integer (6));
    _methods.put ("debiter", new java.lang.Integer (7));
    _methods.put ("crediter", new java.lang.Integer (8));
    _methods.put ("virement", new java.lang.Integer (9));
    _methods.put ("infosCompte", new java.lang.Integer (10));
    _methods.put ("ajouterBenef", new java.lang.Integer (11));
    _methods.put ("afficherBeneficiaire", new java.lang.Integer (12));
    _methods.put ("afficherDebits", new java.lang.Integer (13));
    _methods.put ("afficherCredits", new java.lang.Integer (14));
    _methods.put ("afficherAjoutBeneficiaire", new java.lang.Integer (15));
    _methods.put ("afficherVirements", new java.lang.Integer (16));
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
       case 0:  // Banque/Compte/_get_nomClient
       {
         String $result = null;
         $result = this.nomClient ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // Banque/Compte/_set_nomClient
       {
         String newNomClient = in.read_string ();
         this.nomClient (newNomClient);
         out = $rh.createReply();
         break;
       }

       case 2:  // Banque/Compte/_get_loginClient
       {
         String $result = null;
         $result = this.loginClient ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // Banque/Compte/_set_loginClient
       {
         String newLoginClient = in.read_string ();
         this.loginClient (newLoginClient);
         out = $rh.createReply();
         break;
       }

       case 4:  // Banque/Compte/_get_passClient
       {
         String $result = null;
         $result = this.passClient ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 5:  // Banque/Compte/_set_passClient
       {
         String newPassClient = in.read_string ();
         this.passClient (newPassClient);
         out = $rh.createReply();
         break;
       }

       case 6:  // Banque/Compte/_get_solde
       {
         float $result = (float)0;
         $result = this.solde ();
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 7:  // Banque/Compte/debiter
       {
         float somme = in.read_float ();
         int nocompte = in.read_long ();
         boolean $result = false;
         $result = this.debiter (somme, nocompte);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 8:  // Banque/Compte/crediter
       {
         float somme = in.read_float ();
         int nocompte = in.read_long ();
         boolean $result = false;
         $result = this.crediter (somme, nocompte);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 9:  // Banque/Compte/virement
       {
         float somme = in.read_float ();
         int nocompte = in.read_long ();
         boolean $result = false;
         $result = this.virement (somme, nocompte);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 10:  // Banque/Compte/infosCompte
       {
         String $result = null;
         $result = this.infosCompte ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 11:  // Banque/Compte/ajouterBenef
       {
         String nomBenef = in.read_string ();
         String prenomBenef = in.read_string ();
         int nocompte = in.read_long ();
         this.ajouterBenef (nomBenef, prenomBenef, nocompte);
         out = $rh.createReply();
         break;
       }

       case 12:  // Banque/Compte/afficherBeneficiaire
       {
         String $result = null;
         $result = this.afficherBeneficiaire ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 13:  // Banque/Compte/afficherDebits
       {
         String $result = null;
         $result = this.afficherDebits ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 14:  // Banque/Compte/afficherCredits
       {
         String $result = null;
         $result = this.afficherCredits ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 15:  // Banque/Compte/afficherAjoutBeneficiaire
       {
         String $result = null;
         $result = this.afficherAjoutBeneficiaire ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 16:  // Banque/Compte/afficherVirements
       {
         String $result = null;
         $result = this.afficherVirements ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Banque/Compte:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Compte _this() 
  {
    return CompteHelper.narrow(
    super._this_object());
  }

  public Compte _this(org.omg.CORBA.ORB orb) 
  {
    return CompteHelper.narrow(
    super._this_object(orb));
  }


} // class ComptePOA
