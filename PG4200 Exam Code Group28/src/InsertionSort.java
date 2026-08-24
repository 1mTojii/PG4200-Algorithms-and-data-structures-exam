import java.util.ArrayList;

public class InsertionSort {

    public static void sortUniqueAlcohol() {
        CSVApplication cvsApplication = new CSVApplication();
        ArrayList<Wines> wineList = cvsApplication.filereaderUnique();
        insertionSort(wineList);
    }

    ////////////////////////////////////////////////////////
    /// author: CodeGym                                  ///
    /// gathered: 01.04.2026                             ///
    /// url: https://codegym.cc/groups/posts/            ///
    ///      insertion-sort-in-java                      ///
    /// title: Insertion Sort in Java                    ///
    /// last updated: 14 jan, 2025                       ///
    ///////////////////////////////////////////////////////
    public static int[] insertionSort(ArrayList<Wines> uniqueWines) {
        int iterations = 0;
        int swaps = 0;

        for (int i = 1; i < uniqueWines.size(); i++) {
            Wines key = uniqueWines.get(i);
            int j = i - 1;

            while (j >= 0 && uniqueWines.get(j).alcohol > key.alcohol) {
                uniqueWines.set(j + 1, uniqueWines.get(j));
                j--;
                swaps++;
                iterations++;
            }
            uniqueWines.set(j + 1, key);
            iterations++;
        }

        System.out.println("Unique alcohol values: " + uniqueWines.size());
        for (Wines w : uniqueWines) {
            System.out.println("Alcohol: " + w.alcohol);
        }
        System.out.println("Iterations: " + iterations + " | Swaps: " + swaps);

        return new int[]{iterations, swaps};
    }

}