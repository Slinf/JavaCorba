package Banque;

/**
* Banque/CompteHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from specification.idl
* vendredi 29 juin 2018 10 h 22 CEST
*/

public final class CompteHolder implements org.omg.CORBA.portable.Streamable
{
  public Banque.Compte value = null;

  public CompteHolder ()
  {
  }

  public CompteHolder (Banque.Compte initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Banque.CompteHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Banque.CompteHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Banque.CompteHelper.type ();
  }

}
