package Banque;


/**
* Banque/_AgenceStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from specification.idl
* samedi 30 juin 2018 01 h 13 CEST
*/

public class _AgenceStub extends org.omg.CORBA.portable.ObjectImpl implements Banque.Agence
{

  public String nom ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_nom", true);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return nom (        );
            } finally {
                _releaseReply ($in);
            }
  } // nom

  public void nom (String newNom)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_set_nom", true);
                $out.write_string (newNom);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                nom (newNom        );
            } finally {
                _releaseReply ($in);
            }
  } // nom

  public Banque.Compte creerCompte (String login, String nom, String prenom, String pass, float solde, int nocompte)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("creerCompte", true);
                $out.write_string (login);
                $out.write_string (nom);
                $out.write_string (prenom);
                $out.write_string (pass);
                $out.write_float (solde);
                $out.write_long (nocompte);
                $in = _invoke ($out);
                Banque.Compte $result = Banque.CompteHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return creerCompte (login, nom, prenom, pass, solde, nocompte        );
            } finally {
                _releaseReply ($in);
            }
  } // creerCompte

  public boolean supprimerCompte (String nom)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("supprimerCompte", true);
                $out.write_string (nom);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return supprimerCompte (nom        );
            } finally {
                _releaseReply ($in);
            }
  } // supprimerCompte

  public Banque.Compte rechercherCompte (String nom)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("rechercherCompte", true);
                $out.write_string (nom);
                $in = _invoke ($out);
                Banque.Compte $result = Banque.CompteHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return rechercherCompte (nom        );
            } finally {
                _releaseReply ($in);
            }
  } // rechercherCompte

  public String afficherListeCompte ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("afficherListeCompte", true);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return afficherListeCompte (        );
            } finally {
                _releaseReply ($in);
            }
  } // afficherListeCompte

  public String afficherInfoBanque ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("afficherInfoBanque", true);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return afficherInfoBanque (        );
            } finally {
                _releaseReply ($in);
            }
  } // afficherInfoBanque

  public boolean ConnexionBanque (String login, String pass)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("ConnexionBanque", true);
                $out.write_string (login);
                $out.write_string (pass);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return ConnexionBanque (login, pass        );
            } finally {
                _releaseReply ($in);
            }
  } // ConnexionBanque

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Banque/Agence:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _AgenceStub
