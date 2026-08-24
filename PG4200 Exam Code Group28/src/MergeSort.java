import java.util.ArrayList;


public class MergeSort {
    ////////////////////////////////////////////////////////
    /// author: GeeksForGeeks                            ///
    /// gathered: 5.04.2026                              ///
    /// url: https://www.geeksforgeeks.org/dsa           ///
    /// /merge-sort/                                     ///
    /// title: Merge Sort                                ///
    /// last updated: 3 oct, 2025                        ///
    ////////////////////////////////////////////////////////

    //L is Left
    //M is Mid
    //R is Right
    //shortend for efficiency reasons

    static int counter = 0;

    public static void mergeSort(ArrayList<Wines> wineList, int L, int R) {
        if (L < R) {
            int M = L + (R - L) / 2;

            mergeSort(wineList, L, M);
            mergeSort(wineList, M + 1, R);

            merge(wineList, L, M, R);
        }
    }
    public static void merge(ArrayList<Wines> list, int L, int M, int R) {
        counter++;

        int n1 = M - L + 1;
        int n2 = R - M;

        ArrayList<Wines> tempL = new ArrayList<>();
        ArrayList<Wines> tempR = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            tempL.add(list.get(L + i));
        }
        for (int j = 0; j < n2; j++) {
            tempR.add(list.get(M + 1 + j));
        }
        int i = 0, j = 0;

        int k = L;
        while (i < n1 && j < n2) {
            if (tempL.get(i).alcohol <= tempR.get(j).alcohol) {
                list.set(k, tempL.get(i));
                i++;
            } else {
                list.set(k, tempR.get(j));
                j++;
            }
            k++;
        }
        while (i < n1) {
            list.set(k, tempL.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            list.set(k, tempR.get(j));
            j++;
            k++;
        }
    }
    public static void sortUniqueAlcohol() {
        counter = 0;
        CSVApplication csvApp = new CSVApplication();
        ArrayList<Wines> uniqueWines = csvApp.filereaderUnique();
        mergeSort(uniqueWines, 0, uniqueWines.size() - 1);
        System.out.println("unique alcohol values:" + uniqueWines.size());

        for (Wines w : uniqueWines) {
            System.out.println("Alcohol: " + w.alcohol);
        }

        System.out.println("Number of merge operations: " + counter);
        counter = 0;
    }
}
