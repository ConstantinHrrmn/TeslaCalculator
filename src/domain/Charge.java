package domain;

public class Charge {
    private String start;
    private String country;
    private String place;
    private float kwh;
    private float price;
    private boolean CHF;

    public Charge(String a_start, String a_country, String a_place, float a_kwh, float a_price, boolean a_CHF){
        this.start = a_start;
        this.country = a_country;
        this.place = a_place;
        this.kwh = a_kwh;
        this.price = a_price;
        this.CHF = a_CHF;
    }

    public float getPrice(){
        return this.CHF ? this.price : Math.round((this.price * 1.09f) * 100.0f) / 100.0f;
    }

    public String PrintPrice(){
        if (this.CHF){
             return this.price + " CHF";
        }else{
            return "["+this.price+" Euros] => " + this.getPrice() + " CHF";
        }
    }

    public float getKwh(){
        return this.kwh;
    }

    public String toString(){
        return this.start +
                " [" +
                this.place  +
                ", " +
                this.country +
                "] --> " +
                this.kwh +
                " kwh | "+
                this.PrintPrice();
    }

}
