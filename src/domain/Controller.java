package domain;

import bdd.DataReader;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Month> months = new ArrayList<>();

    public Controller(){
        this.months = DataReader.LoadMonths();
    }

    public void PrintAllMonths(){
        for (Month m:
             this.months) {
            System.out.println(m.toString());
            System.out.println(m.PrintCharges());
        }

        System.out.println("-------");
        this.PrintTotal();
    }

    public void PrintTotal(){
        float kwh = 0;
        float price = 0;

        for (Month m :
                this.months) {
            kwh += m.TotalKwh();
            price += m.TotalPrice();
        }

        System.out.println("TOTAL : " + price + " CHF ["+ kwh + " kwh]");
    }
}
