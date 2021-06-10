package domain;

import java.util.ArrayList;
import java.util.List;

public class Month {
    private int month;
    private int year;

    private List<Charge> charges;

    public Month(int a_month, int a_year){
        this.month = a_month;
        this.year = a_year;

        this.charges = new ArrayList<>();
    }

    public void AddCharge(Charge a_charge){
        this.charges.add(a_charge);
    }

    public List<Charge> GetCharges(){
        return this.charges;
    }

    public String toString(){
        return this.month + " / " + this.year + " [" + this.charges.size() + "] --> " + this.TotalKwh() + " KWH | " + this.TotalPrice() + " CHF" ;
    }

    public float TotalPrice(){
        float i = 0;

        for (Charge charge :
                this.charges) {
            i += charge.getPrice();
        }

        return i;
    }

    public float TotalKwh(){
        float i = 0;

        for (Charge charge :
                this.charges) {
            i += charge.getKwh();
        }

        return i;
    }

    public String PrintCharges(){
        String str = "";
        for (Charge charge:
             this.charges) {
            str += charge.toString() + "\n";
            //System.out.println(charge);
        }
        return str;
    }

}
