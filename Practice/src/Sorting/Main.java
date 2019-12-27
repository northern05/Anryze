package Sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


//        int [] array = new int[] {43, 32, 1, 4, 6, 9, 10, 11};
//        System.out.println(QuickSort.arrayToString(array));
//        QuickSort.quickSort(array, 0, array.length - 1);

        test1();

    }
    private static void test1() {
        int testLen = 100000;

        int[] arr1 = new int[testLen];
        int[] arr2 = new int[testLen];

        System.out.println("\n-----Случайный массив------");

        for (int i = 0; i < testLen; i++) {
            arr2[i] = arr1[i] = (int)Math.round(Math.random() * 10000);
        }

        System.out.println("Быстрая сортировка:");
        measureTime(() -> QuickSort.quickSort(arr1, 0, testLen - 1));

        System.out.println("Сортировка слиянием:");
        measureTime(() -> MergeSort.mergeSort(arr2));
    }

    private static void test2() {
        int testLen = 100000;

        int[] arr1 = new int[testLen];
        int[] arr2 = new int[testLen];

        System.out.println("\n-----Отсортированный массив------");

        for (int i = 0; i < testLen; i++) {
            arr2[i] = arr1[i] = i;
        }

        System.out.println("Быстрая сортировка:");
        measureTime(() -> QuickSort.quickSort(arr1, 0, testLen - 1));

        System.out.println("Сортировка пузырьком:");
        measureTime(() -> BubleSort.bubbleSort(arr2));

    }

    private static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время: " + elapsed + " ms");
    }

}


