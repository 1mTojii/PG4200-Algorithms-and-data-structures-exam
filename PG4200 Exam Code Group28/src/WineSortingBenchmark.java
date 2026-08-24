import java.util.ArrayList;
import java.util.Collections;

public class WineSortingBenchmark {

    public static void run(){
        CSVApplication application = new CSVApplication();
        ArrayList<Wines> wines = application.filereaderUnique();

        System.out.println("----------Benchamrk Starting ---------");
        System.out.println("Dataset size: " + wines.size() + "unique alcohol values");

        //Both optimised and un-optimised benchmarks for BubbleSort with and without shuffle

    // benchBubbleSortUnOpt(wines, false, 100000);
    //    benchBubbleSortUnOpt(wines, false, 1000000);
        benchBubbleSortOpt(wines, false, 1000000);
    //    benchBubbleSortOpt(wines, true, 100);

        // Benchmark for InsertionSort with and without shuffle
    //    benchInsertionSort(wines, false, 1000000);
    //    benchInsertionSort(wines, true, 100000);

        //Benchmark for MergeSort with and without shuffle
    //     benchMergeSort(wines, false, 100000);
    //    benchMergeSort(wines, true, 100000);

        //Benchmark for QucikSort with and without shuffle, and with number of comparisons per pivot strategy
    //    benchQuickSort(wines, false, 10000, 1, "QuickSort (first element pivot )");
    //    benchQuickSort(wines, false, 10000, 2, "QuickSort (last element pivot )");
    //    benchQuickSort(wines, false, 10000, 3, "QuickSort (random  element pivot )");
    //    benchQuickSort(wines, false, 10000, 4, "QuickSort (median element pivot )");
    }

    private static void benchBubbleSortUnOpt(ArrayList<Wines> wines, boolean shuffle, int repetitions) {
        System.out.println("----------Benchmark BubbleSort (non-optimised) Starting ---------");
        Timer timer = new Timer();
        long totalTime = 0;

        for (int i = 0; i < repetitions; i++) {
            ArrayList<Wines> copy = new ArrayList<>(wines);
            if (shuffle) Collections.shuffle(copy);

            timer.start();
            BubbleSort.bubbleSortUnOpt(copy);
            timer.end();

            totalTime += timer.getElapsedTime() / 1000;
        }

        timeResult("BubbleSort (non-optimised)", shuffle, repetitions, totalTime);
    }
    private static void benchBubbleSortOpt(ArrayList<Wines> wines, boolean shuffle, int repetitions) {
        System.out.println("----------Benchmark BubbleSort (optimised) Starting ---------");
        Timer timer = new Timer();
        long totalTime = 0;

        for (int i = 0; i < repetitions; i++) {
            ArrayList<Wines> copy = new ArrayList<>(wines);
            if (shuffle) Collections.shuffle(copy);

            timer.start();
            BubbleSort.bubbleSortOpt(copy);
            timer.end();

            totalTime += timer.getElapsedTime() / 1000;
        }

        timeResult("BubbleSort (optimised)", shuffle, repetitions, totalTime);
    }

    private static void benchInsertionSort(ArrayList<Wines> wines, boolean shuffle, int repetitions) {
        System.out.println("----------Benchmark IntersionSort (non-optimised) Starting ---------");
        Timer timer = new Timer();
        long totalTime = 0;

        for (int i = 0; i < repetitions; i++) {
            ArrayList<Wines> copy = new ArrayList<>(wines);
            if (shuffle) Collections.shuffle(copy);

            timer.start();
            InsertionSort.insertionSort(copy);
            timer.end();

            totalTime += timer.getElapsedTime() / 1000;
        }

        timeResult("InsertionSort", shuffle, repetitions, totalTime);
    }

    private static void benchMergeSort(ArrayList<Wines> wines, boolean shuffle, int repetitions) {
        System.out.println("----------Benchmark MergeSort Starting ---------");
        Timer timer = new Timer();
        long totalMergeOpn = 0;
        long totalTime = 0;


        for (int i = 0; i < repetitions; i++) {
            ArrayList<Wines> copy = new ArrayList<>(wines);
            if (shuffle) Collections.shuffle(copy);
            MergeSort.counter = 0;

            timer.start();
            MergeSort.mergeSort(copy, 0, copy.size() - 1);
            timer.end();

            totalTime += timer.getElapsedTime() / 1000;
            totalMergeOpn += MergeSort.counter;
        }
        timeResult("MergeSort", shuffle, repetitions, totalTime);
        System.out.println("Average MergeSort operations over " + repetitions + " test: " + (totalMergeOpn / repetitions));
    }

    private static void benchQuickSort(ArrayList<Wines> wines, boolean shuffle, int repetitions, int pivotMode, String name) {
        System.out.println("----------Benchmark QuickSort Starting ---------");
        Timer timer = new Timer();
        long totalComparisions= 0;
        long totalTime = 0;

        for (int i = 0; i < repetitions; i++) {
            ArrayList<Wines> copy = new ArrayList<>(wines);
            if (shuffle) Collections.shuffle(copy);
            QuickSort.counter = 0;

            timer.start();
            QuickSort.quickSort(copy, 0, copy.size() - 1, pivotMode);
            timer.end();

            totalTime += timer.getElapsedTime() / 1000;
            totalComparisions += QuickSort.counter;
        }
        timeResult(name, shuffle, repetitions, totalTime);
        System.out.println("Average comparions over " + repetitions + " test of " + name + ": " + (totalComparisions / repetitions));
    }

    private static void timeResult(String name, boolean shuffle, int repetitions, long totalTime){
        String shuffleLabel;
        if (shuffle) {
            shuffleLabel = "shuffle";
        } else {
            shuffleLabel = "not shuffle";
        }
        long avgTime = totalTime / repetitions;

        System.out.println("Algorithm       : " + name);
        System.out.println("Shuffle         : " + shuffleLabel);
        System.out.println("Repetitions     : " + repetitions);
        System.out.println("total time      : " + totalTime + "µs  (" + (totalTime /
                1000.0) + "ms)  (" + (totalTime / 1000000.0) + "s)" );
        System.out.println("Average time    : " + avgTime + "µs  (" + (avgTime /
                1000.0) + "ms)  (" + (avgTime / 1000000.0) + "s)");




    }
}
