package bdd;

import domain.Charge;
import domain.Month;
import domain.StrategiePrix;
import domain.currency.CurrencyFactory;

import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static List<String> fichiers = new ArrayList<>();

    // Chargement des tous les fichiers CSV provenant de TESLA.COM
    private static void LoadFiles(){
        fichiers.add("03.2021.csv");
        fichiers.add("04.2021.csv");
        fichiers.add("05.2021.csv");
        fichiers.add("06.2021.csv");
        fichiers.add("07.2021.csv");
        fichiers.add("08.2021.csv");
        fichiers.add("09.2021.csv");
    }

    public static List<Month> LoadMonths(){
        // On charge tous les noms de fichiers
        LoadFiles();
        List<Month> months = new ArrayList<>();

        // On parcours un fichier (aka: mois) après l'autre
        for (String s:
             fichiers) {

            int month = Integer.parseInt(s.split("\\.")[0]);
            int year = Integer.parseInt(s.split("\\.")[1]);

            // On fait la cération du mois de la recharge
            Month m = new Month(month, year);

            // On lit le fichier en mettant les infos dans un tableau
            String[][] fichier = FileToStr.lireCsv(s);

            for (String[] data:
             fichier) {
                data = data[0].split(",");

                // On vérifie que la donnée est bien une recharge
                if (data[7].contains("CHARGING")){

                    // On récupère la date et l'heure du début de la charge
                    String[] start = data[0].split("T");

                    String startDate = start[0];
                    String startHour = start[1].split("\\+")[0];

                    // On récupère le pays
                    String country = data[5].split("\"")[1];

                    // On récupère la ville
                    String place = data[6].split("\"")[0];

                    // On récupère le nombre de KWH rechargés
                    float kwh = Float.parseFloat(data[8].split(" ")[0]);

                    // On récupère le prix de la charge
                    float price = Float.parseFloat(data[17]);

                    // On vérifie si c'est en CHF ou en EUROS
                    boolean CHF = data[4].equals("CH");

                    StrategiePrix strategie = CurrencyFactory.CreateCurrency(data[4]);
                    strategie.setPrix(price);

                    // Ajout de la charge dans les charges du mois
                    m.AddCharge(new Charge(startDate, startHour, country, place, kwh, strategie));
                }
            }
            // Ajout du mois dans la liste des mois
            months.add(m);
        }

        return months;
    }
}
