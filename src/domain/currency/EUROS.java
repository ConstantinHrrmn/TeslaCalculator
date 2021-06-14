package domain.currency;

import domain.StrategiePrix;

public class EUROS extends StrategiePrix {

    public EUROS(float a_prix, float a_taux){
        super(a_prix, a_taux);
    }

    public EUROS(float a_taux){
        this(0f, a_taux);
    }

    @Override
    public float CalculPrix() {
        return Math.round((this.getPrix() * this.getTauxDeChange()) * 100.0f) / 100.0f;
    }

    @Override
    public String PrintPrix() {
        return this.getPrix() + " € ("+CalculPrix()+" CHF)";
    }

}
