public class Operation  {

    //Type 0 = Debit
    //Type 1 = Crédit
    //Type 2 = Virement
    //Type 3 = Ajout Bénéficiaaires

    private int type;
    private float montant;
    private long nocompte;
    private String info;


    public  Operation(int typeassocier, long nocompteassocier, float montantoperation, String infosupp )
    {
        type= typeassocier;
        nocompte = nocompteassocier;
        montant = montantoperation;
        info = infosupp;
    }

    public int getType() {
        return type;
    }

    public float getMontant() {
        return montant;
    }

    public long getNocompte() {
        return nocompte;
    }

    public String getInfo() {
        return info;
    }
}
