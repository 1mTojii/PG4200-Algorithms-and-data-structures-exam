import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;



public class Wines {
    double fixedAcidity;
    double volatileAcidity;
    double citricAcid;
    double residualSugar;
    double chlorides;
    double freeSulfurDioxide;
    double totalSulfurDioxide;
    double density;
    double pH;
    double sulphates;
    double alcohol;
    int quality;


    /*this construcktor is for the nonunique wines it is out of scope but we wanted to leave it in since
    we made it before we noticed the UNIQUE WINE VALUES part in the task*/
    public Wines(double fixedAcidity, double volatileAcidity, double citricAcid, double residualSugar, double chlorides, double freeSulfurDioxide, double totalSulfurDioxide, double density, double pH, double sulphates, double alcohol, int quality) {
        this.fixedAcidity = fixedAcidity;
        this.volatileAcidity = volatileAcidity;
        this.citricAcid = citricAcid;
        this.residualSugar = residualSugar;
        this.chlorides = chlorides;
        this.freeSulfurDioxide = freeSulfurDioxide;
        this.totalSulfurDioxide = totalSulfurDioxide;
        this.density = density;
        this.pH = pH;
        this.sulphates = sulphates;
        this.alcohol = alcohol;
        this.quality = quality;
    }


    //this construcktor is for the unqiue wines
    public Wines(double alcohol)
    {
        this.alcohol = alcohol;
    }


    //this boolean checks if an object is identical to the other
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Wines that = (Wines) obj;
        return Double.compare(this.alcohol, that.alcohol) == 0;
    }

    public int hashCode() {
        return Objects.hash(alcohol);
    }


    public String toString() {
        return "Alcohol: " + alcohol;
    }

    public static ArrayList<Wines> readUniqueWineFiles(String fileName) {
        ArrayList<Wines> wineList = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            boolean header = true;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] token = line.split(";");

                if (header) {
                    header = false;
                    continue;
                }
                double uniqueWine = Double.parseDouble(token[10]);
                wineList.add(new Wines(uniqueWine));
            }
            scanner.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return wineList;
    }
    public static ArrayList<Wines> readWineFiles(String fileName) {
        ArrayList<Wines> wineList = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            boolean header = true;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] token = line.split(";");

                if (header) {
                    header = false;
                    continue;
                }
                Wines wine = new Wines(
                        Double.parseDouble(token[0]),
                        Double.parseDouble(token[1]),
                        Double.parseDouble(token[2]),
                        Double.parseDouble(token[3]),
                        Double.parseDouble(token[4]),
                        Double.parseDouble(token[5]),
                        Double.parseDouble(token[6]),
                        Double.parseDouble(token[7]),
                        Double.parseDouble(token[8]),
                        Double.parseDouble(token[9]),
                        Double.parseDouble(token[10]),
                        Integer.parseInt(token[11])
                );
                wineList.add(wine);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return wineList;



    }}
