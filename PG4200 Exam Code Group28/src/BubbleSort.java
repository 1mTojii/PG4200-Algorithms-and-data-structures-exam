import java.util.ArrayList;

public class BubbleSort {

        public static void sortUniqueAlcoholUnOpt() {
            CSVApplication csvApplication = new CSVApplication();
            ArrayList<Wines> wineList = csvApplication.filereaderUnique();
            bubbleSortUnOpt(wineList);
        }
        public static void sortUniqueAlcoholOpt() {
            CSVApplication csvApplication = new CSVApplication();
            ArrayList<Wines> wineList = csvApplication.filereaderUnique();
           bubbleSortOpt(wineList);
        }
        //this is the unoptimised bubble sort we used
        //this bubblesort has been inspired and by geeksforgeeks
        ////////////////////////////////////////////////////////
        /// author: GeeksForGeeks                            ///
        /// gathered: 26.03.2026                             ///
        /// url: https://www.geeksforgeeks.org/dsa           ///
        /// /java-program-for-bubble-sort/                   ///
        /// title: Java Program for Bubble Sort              ///
        /// last updated: 23 jul, 2025                       ///
        ////////////////////////////////////////////////////////
        public static int bubbleSortUnOpt (ArrayList<Wines> uniqueWines) {
            int size = uniqueWines.size();

            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - i - 1; j++) {
                    if (uniqueWines.get(j).alcohol > uniqueWines.get(j + 1).alcohol) {
                        Wines temp = uniqueWines.get(j);
                        uniqueWines.set(j, uniqueWines.get(j + 1));
                        uniqueWines.set(j + 1, temp);
                    }
                }

            }
            System.out.println("unique alcohol values:" + uniqueWines.size());
            for (Wines w : uniqueWines) {
                System.out.println(" Alcohol: " + w.alcohol);
            }
            return size;
        }

    //this is the optimised bubble sort we used
    //this bubblesort has been inspired and by geeksforgeeks
    ////////////////////////////////////////////////////////
    /// author: GeeksForGeeks                            ///
    /// gathered: 28.03.2026                             ///
    /// url: https://www.geeksforgeeks.org/dsa           ///
    /// /bubble-sort-algorithm/                          ///
    /// title: Bubble Sort                               ///
    /// last updated: 8 dec, 2025                       ///
    ////////////////////////////////////////////////////////
        public static int bubbleSortOpt (ArrayList<Wines> uniqueWines) {
            int size = uniqueWines.size();
            boolean swapped;
            for (int i = 0; i < size - 1; i++) {
                swapped = false;
                for (int j = 0; j < size - i - 1; j++) {
                    if (uniqueWines.get(j).alcohol > uniqueWines.get(j + 1).alcohol) {

                        Wines temp = uniqueWines.get(j);
                        uniqueWines.set(j, uniqueWines.get(j + 1));
                        uniqueWines.set(j + 1, temp);
                        swapped = true;
                    }
                }


                if (swapped == false)
                    break;
            }
            System.out.println("unique alcohol values:" + uniqueWines.size());
            for (Wines w : uniqueWines) {
                System.out.println(" Alcohol: " + w.alcohol);
            }
            return size;
        }

}
