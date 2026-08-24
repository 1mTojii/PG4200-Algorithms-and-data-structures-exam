import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
    static int counter = 0;


    ////////////////////////////////////////////////////////
    /// author: GeeksForGeeks                            ///
    /// gathered: 5.04.2026                              ///
    /// url: https://www.geeksforgeeks.org/dsa/          ///
    /// quick-sort-algorithm/                            ///
    /// title: Merge Sort                                ///
    /// last updated: 3 oct, 2025                        ///
    ////////////////////////////////////////////////////////

    public static void quickSort(ArrayList<Wines> wineList, int low, int high, int m) {
        if (low < high) {
            int pi = partition(wineList, low, high, m);

            quickSort(wineList, low, pi - 1, m);
            quickSort(wineList, pi + 1, high, m);
        }
    }
    public static int partition(ArrayList<Wines> wineList, int low, int high, int m) {
        //pivoting m = modes.
        switch (m) {
            //chosing the first element
            case 1:
                swap(wineList, low, high);
                break;
                //chosing last element.
                case 2:
                    break;
                    //chosing random element.
                    case 3:
                        Random r = new Random();
                        int random = low + r.nextInt(high - low + 1);
                        swap(wineList, random, low);
                        break;
                        //chosing median of three
                        case 4:
                            int mid = (low + high) / 2;
                            int median = medianOfThree(wineList, low, mid, high);
                            swap(wineList, median, high);
                            break;
        }
        double pivot = wineList.get(high).alcohol;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            counter++; // to count the number of comparison
            if (wineList.get(j).alcohol < pivot) {
                i++;
                swap(wineList, i, j);
            }
        }
        swap(wineList, i + 1, high);
        return i + 1;
    }

    public static int medianOfThree(ArrayList<Wines> wineList, int i, int j, int n) {
        double a = wineList.get(j).alcohol;
        double b = wineList.get(i).alcohol;
        double c = wineList.get(n).alcohol;

        if ((a > b && a < c) || (a < b && a > c)) return j;
        if ((b > a && b < c) || (b < a && b > c)) return i;
        return n;
    }

    public static void swap(ArrayList<Wines> wineList, int i, int j) {
        Wines w = wineList.get(i);
        wineList.set(i, wineList.get(j));
        wineList.set(j, w);
    }
    public static void sort(int m) {
        CSVApplication CVSapp = new CSVApplication();
        ArrayList<Wines> wineList = CVSapp.filereaderUnique();

        counter = 0; // just a simple reset before running

        quickSort(wineList, 0, wineList.size() - 1, m);

        for (Wines w : wineList) {
            System.out.println("Alcohol: " + w.alcohol);
        }
        System.out.println("Comparisons: " + counter);

    }
    // to call upon element first
    public static void QSFirst() {
        sort(1);
    }
    // to call upon element last
    public static void QSLast() {
        sort(2);
    }
    // to call upon random element
    public static void QSRandom() {
        sort(3);
    }

    // to call upon median of three
    public static void QSMedianThree() {
        sort(4);
    }
}
