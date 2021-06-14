package domain.currency;

import domain.StrategiePrix;

public class CurrencyFactory {
    public static StrategiePrix CreateCurrency(String name){

        switch (name){
            case "CH" : return new CHF(1f);
            case "FR" : return new EUROS(1.09f);
        }

        return null;
    }
}
