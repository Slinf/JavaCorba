package Banque;


/**
* Banque/CompteOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from specification.idl
* vendredi 29 juin 2018 10 h 25 CEST
*/

public interface CompteOperations 
{
  String nomClient ();
  void nomClient (String newNomClient);
  float solde ();
  boolean debiter (float somme, int nocompte);
  boolean crediter (float somme, int nocompte);
  boolean virement (float somme, int nocompte);
  String infosCompte ();
  void ajouterBenef (String nomBenef, int nocompte);
  String afficherBeneficiaire ();
  String afficherDebits ();
  String afficherCredits ();
  String afficherAjoutBeneficiaire ();
  String afficherVirements ();
} // interface CompteOperations
