package domain.currency;

import domain.StrategiePrix;

public class CHF extends StrategiePrix {

    public CHF(float a_prix, float a_taux){
        super(a_prix, a_taux);
    }

    public CHF(float a_taux){
        this(0f, a_taux);
    }

    @Override
    public String PrintPrix() {
        return this.getPrix() + " CHF";
    }
}
