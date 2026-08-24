import java.util.ArrayList;
import java.util.Collections;


public class CSVApplication {

    //Reads the dataset for non unique wine values
    public void filereader() {
        //these are the paths for the filreader so it can access the cvs files
        String fileWineR = "..\\PG4200 Exam Code Group28\\src\\Wines\\winequality-red.csv";
        String fileWineW = "..\\PG4200 Exam Code Group28\\src\\Wines\\winequality-white.csv";

        //these make sure the app reads files into a list
        ArrayList<Wines> whiteWine = Wines.readWineFiles(fileWineW);
        ArrayList<Wines> redWines = Wines.readWineFiles(fileWineR);

        //prints out the value for white and red wine
        System.out.println("Contents of white wine" + whiteWine.size());
        for (Wines w : whiteWine) {
            System.out.println("Alcohol perc" + w.alcohol + "%" + " // Quality of the wine " + w.quality + "/10");
        }
        System.out.println("\n\n\n\n\n\nContents of red wine" + redWines.size());
        for (Wines w : redWines) {
            System.out.println("Alcohol perc" + w.alcohol + "%" + " // Quality of the wine " + w.quality + "/10");
        }
    }

    //Reads the dataset for unqiue wine values
    public ArrayList<Wines> filereaderUnique(){
        //these are the paths for the cvs files
        String fileWineR = "..\\PG4200 Exam Code Group28\\src\\Wines\\winequality-red.csv";
        String fileWineW = "..\\PG4200 Exam Code Group28\\src\\Wines\\winequality-white.csv";
        //this combines lists and makes 1 list for unique wine values
        ArrayList<Wines> wineList = new ArrayList<>();
        ArrayList<Wines> redWineList = Wines.readUniqueWineFiles(fileWineR);
        ArrayList<Wines> whiteWineList = Wines.readUniqueWineFiles(fileWineW);

        //these loops make sure that duplicates are ignored
        for (Wines w : redWineList) {
            if (!wineList.contains(w)) {
                wineList.add(w);
            }
        }
        for (Wines w : whiteWineList) {
            if (!wineList.contains(w)) {
                wineList.add(w);
            }
        }
        //returns the list
        return wineList;
    }

    public ArrayList<Wines> shuffledList(){
        //fetches the wineList
        CSVApplication cvsApplication = new CSVApplication();
        ArrayList<Wines> wineList = cvsApplication.filereaderUnique();
        //shuffles it so it is random
        Collections.shuffle(wineList);
        //prints the size
        System.out.println("Shuffled the wines:" + wineList.size());
        //returns the list
        return wineList;
    }
}




