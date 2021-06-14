package domain;

public abstract class StrategiePrix {

    private float prix;
    private float tauxDeChange;

    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public float getTauxDeChange() {
        return tauxDeChange;
    }
    public void setTauxDeChange(float tauxDeChange) {
        this.tauxDeChange = tauxDeChange;
    }

    public float CalculPrix(){ return this.prix * this.tauxDeChange; }
    public String PrintPrix(){ return this.prix + " NO CURRENCY"; }
    public void SetPrix(float prix){this.setPrix(prix); }

    public StrategiePrix(float a_prix, float a_taux){
        this.prix = a_prix;
        this.tauxDeChange = a_taux;
    }
}
