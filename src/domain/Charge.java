package domain;

public class Charge {

    private String startDate;
    private String startHour;
    private String country;
    private String place;
    private float kwh;

    private StrategiePrix strategie;

    public Charge(String a_startDate, String a_startHour, String a_country, String a_place, float a_kwh, StrategiePrix strategy){
        this.startDate = a_startDate;
        this.startHour = a_startHour;
        this.country = a_country;
        this.place = a_place;
        this.kwh = a_kwh;
        this.strategie = strategy;
    }

    public float getPrice(){
        return this.strategie.CalculPrix();
    }

    public String PrintPrice(){
        return this.strategie.PrintPrix();
    }

    public float getKwh(){
        return this.kwh;
    }

    public String toString(){
        return this.startDate +
                " (" +
                this.startHour +
                ") [" +
                this.place  +
                ", " +
                this.country +
                "] --> " +
                this.kwh +
                " kwh | "+
                this.PrintPrice();
    }

}
