package bdd;

import domain.Charge;
import domain.Month;

import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static List<String> fichiers = new ArrayList<>();

    private static void LoadFiles(){
        fichiers.add("03.2021.csv");
        fichiers.add("04.2021.csv");
        fichiers.add("05.2021.csv");
    }

    public static List<Month> LoadMonths(){
        LoadFiles();
        List<Month> months = new ArrayList<>();

        for (String s:
             fichiers) {

            int month = Integer.parseInt(s.split("\\.")[0]);
            int year = Integer.parseInt(s.split("\\.")[1]);

            Month m = new Month(month, year);

            String[][] fichier = FileToStr.lireCsv(s);

            for (String[] data:
             fichier) {
                data = data[0].split(",");

                if (data[7].contains("CHARGING")){

                    String start = data[0];
                    String country = data[5].split("\"")[1];
                    String place = data[6].split("\"")[0];

                    //System.out.println(data[8].split(" ")[0]);
                    float kwh = Float.parseFloat(data[8].split(" ")[0]);
                    float price = Float.parseFloat(data[17]);
                    boolean CHF = data[4].equals("CH");

                    //PrintData(data);
                    //System.out.println(CHF);
                    m.AddCharge(new Charge(start, country, place, kwh, price, CHF));


                }

            }

            months.add(m);
        }

        return months;
    }

    public static void PrintData(String[] data){
        int i = 0;
        for (String s:
             data) {
            System.out.println("[" + i + "] " + s);
            i++;
        }
    }
}
