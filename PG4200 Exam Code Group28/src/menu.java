import java.util.ArrayList;
import java.util.Scanner;


public class menu{
    /*this is out menu we made sure to implement a menu to make it easier
    for the instructor to navigate through the completed tasks*/
    public void menu() {
    int choice = 0;
    Scanner menuinput = new Scanner(System.in);
    while (choice != 15) {
        System.out.println("---//// The Wine Menu ////---");
        System.out.println("what do you want to do?\n");
        System.out.println("Do you wish to print out all the wine? press0\n" +
                "Do you wish to shuffle? you can sort it later :) press1\n" +
                "Do you wish to Bubblesort(Unoptimized)? press 2\n" +
                "Do you wish to Bubblesort(Optimized)? press 3\n" +
                "Do you wish to sort a shuffled bubblesort(Unoptimized)? press 4\n" +
                "Do you wish to sort a shuffled bubblesort(Optimized)? press 5\n" +
                "Do you wish to insertionSort? press 6\n" +
                "Do you wish to sort a shuffled insertionsort? press 7\n" +
                "Do you wish to mergeSort? press 8\n" +
                "Do you wish to sort a shuffled mergeSort? press 9\n" +
                "Do you wish to quickSort (first element as pivot) ? press 10\n" +
                "Do you wish to quickSort (last element as pivot)? press 11\n" +
                "Do you wish to quickSort (random element as pivot)? press 12\n" +
                "Do you wish to quickSort (median of three as pivot)? press 13\n" +
                "Do you wish to use the Benchmark? press 14\n" +
                "Do you wish to quit the menu? press15\n" );
        choice = menuinput.nextInt();
        switch (choice) {
            case 0 -> reader();
            case 1 -> Shuffle();
            case 2 -> nonOptimizedBBLS();
            case 3 -> optimizedBBLS();
            case 4 -> shufflednonOptimizedBBLS();
            case 5 -> shuffledOptimizedBBLS();
            case 6 -> insertionSort();
            case 7 -> shuffledIS();
            case 8 -> mergeSort();
            case 9 -> shuffledMS();
            case 10 -> QSFirst();
            case 11 -> QSLast();
            case 12 -> QSRandom();
            case 13 -> QSMedian();
            case 14 -> WineSortingBenchmark.run();
            case 15 -> exit();
        }

    }
    }




    //calls upon the reader method in the CVSApplication class
    //which reads all the values in the cvs files
    public void reader() {
        CSVApplication fr = new CSVApplication();
        fr.filereader(); //calls upon CVSApp
    }
    //calls upon the readerUnique method in the CVSApplication class
    //which lists the unique wine values
    public void readerUnique() {
        CSVApplication fru = new CSVApplication();
        fru.filereaderUnique();
    }

    //calls upon the nonoptimized Bubble sort method in the Bubblesort class
    //this sorts the unique wine values
    public void nonOptimizedBBLS() {
        Timer timer = new Timer();
        timer.start();
        BubbleSort.sortUniqueAlcoholUnOpt();
        timer.end();
        System.out.printf("Time: %.4f ms%n", timer.durationMillis());
        System.out.println("Time (ns); " + timer.getElapsedTime() + "ns");
    }

    public void optimizedBBLS() {
        Timer timer = new Timer();
        timer.start();
        BubbleSort.sortUniqueAlcoholOpt();
        timer.end();
        System.out.printf("Time: %.4f ms%n", timer.durationMillis());
        System.out.println("Time (ns); " + timer.getElapsedTime() + "ns");
    }
    public void Shuffle() {
        CSVApplication shy = new CSVApplication();
        shy.shuffledList();
    }
    public void shufflednonOptimizedBBLS() {
        Timer timer = new Timer();
        timer.start();

        CSVApplication app = new CSVApplication();
        ArrayList<Wines> shuffled = app.shuffledList(); //shuffled list

        BubbleSort.bubbleSortUnOpt(shuffled); //sort it

        timer.end();
        System.out.printf("Time: %.4f ms%n", timer.durationMillis());
        System.out.println("Time (ns); " + timer.getElapsedTime() + "ns");
    }
    public void shuffledOptimizedBBLS() {
        Timer timer = new Timer();
        timer.start();

        CSVApplication app = new CSVApplication();
        ArrayList<Wines> shuffled = app.shuffledList(); //shuffled list

        BubbleSort.bubbleSortOpt(shuffled); //sort it

        timer.end();
        System.out.printf("Time: %.4f ms%n", timer.durationMillis());
        System.out.println("Time (ns); " + timer.getElapsedTime() + "ns");
    }

    private void insertionSort() {
        Timer timer = new Timer();
        timer.start();
        InsertionSort.sortUniqueAlcohol();
        timer.end();
        System.out.printf("Time: %.4f ms%n", timer.durationMillis());
        System.out.println("Time (ns); " + timer.getElapsedTime() + "ns");

    }
    private void shuffledIS() {
        Timer timer = new Timer();
        timer.start();

        CSVApplication app = new CSVApplication();
        ArrayList<Wines> shuffled = app.shuffledList();//shuffled list

        InsertionSort.insertionSort(shuffled); //sort it
        timer.end();
        System.out.printf("Time: %.4f ms%n", timer.durationMillis());
        System.out.println("Time (ns); " + timer.getElapsedTime() + "ns");
    }

    private void mergeSort() {
        Timer timer = new Timer();
        timer.start();

        MergeSort.sortUniqueAlcohol();

        timer.end();
        System.out.printf("Time: %.4f ms%n", timer.durationMillis());
        System.out.println("Time (ns); " + timer.getElapsedTime() + "ns");
    }

    private void shuffledMS() {
        CSVApplication app = new CSVApplication();
        ArrayList<Wines> shuffled = app.shuffledList();//shuffled list

        MergeSort.mergeSort(shuffled, 0, shuffled.size() - 1);

        for (Wines w : shuffled) {
            System.out.println("Alcohol: " + w.alcohol);
        }
        System.out.println("Merge operations: " + MergeSort.counter);
    }
    private void QSFirst() {
        Timer timer = new Timer();
        timer.start();
        QuickSort.QSFirst();
        timer.end();
        System.out.printf("Time: %.4f ms%n", timer.durationMillis());
        System.out.println("Time (ns); " + timer.getElapsedTime() + "ns");

    }
    private void QSLast() {
        Timer timer = new Timer();
        timer.start();
        QuickSort.QSLast();
        timer.end();
        System.out.printf("Time: %.4f ms%n", timer.durationMillis());
        System.out.println("Time (ns); " + timer.getElapsedTime() + "ns");


    }

    private void QSRandom() {
        Timer timer = new Timer();
        timer.start();
        QuickSort.QSRandom();
        timer.end();
        System.out.printf("Time: %.4f ms%n", timer.durationMillis());
        System.out.println("Time (ns); " + timer.getElapsedTime() + "ns");

    }
    private void QSMedian() {
        Timer timer = new Timer();
        timer.start();
        QuickSort.QSMedianThree();
        timer.end();
        System.out.printf("Time: %.4f ms%n", timer.durationMillis());
        System.out.println("Time (ns); " + timer.getElapsedTime() + "ns");
    }

    public void exit() {
        System.out.println("Goodbye!");
    }




}
