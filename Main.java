package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();


        int[]  numbersArray = new int[50];
            for(int i = 0; i< numbersArray.length;i++){
                numbersArray[i] = random.nextInt(100);
            }


        System.out.println(Arrays.toString(numbersArray));
        System.out.println(Arrays.toString(insertionSort(numbersArray)));
        System.out.println(Arrays.toString(sortDesc(numbersArray)));
        System.out.println(averageNum(numbersArray));
        System.out.println(howManyOf(27,numbersArray));
        System.out.println(sum(numbersArray));
        System.out.println(evenAndOdds(numbersArray));
        System.out.println();

        Scanner scan = new Scanner(System.in);
        System.out.println("Find number x in array, Enter x");
        int input = scan.nextInt();
        findXthBiggestNumber(input,numbersArray);


        //File file = new File("\\C:\\\textdateiVersuch.Trial.txt");
        //System.out.println(file);

    }

    private static int[] insertionSort(int[] array){

        for(int i = 1; i< array.length;i++){
            int temp = array[i];
            int j = i -1;

            while(j >= 0 && array[j] > temp){

                array[j +1] = array[j];
                j--;
            }
            array[j +1] = temp;
        }
        return array;
    }

    private static int[] sortDesc(int[] array){

        for(int i = array.length -2; i >= 0; i--){
            int current = array[i];
            int j = i +1;
            while(j < array.length && array[j] > current){
                array[j-1] = array[j];
                j++;
            }
            array[j -1] = current;
        }
        return array;
    }

    private static int averageNum(int[] array){
        int counter =0;
        int sum = 0;
        for(int nums : array){
            sum += nums;
            counter++;
        }
        if(counter != 0) {
            int average = sum / counter;
            return average;
        }
        return -1;
    }
    private static String howManyOf(int number, int[] array){
        int counter = 0;
        for(int nums : array){
            if(nums == number){
                counter++;
            }
        }
        return "There are " + counter + " iterations of " +number;
    }

    private static int sum(int[] array){
        int sum = 0;
        for(int nums : array){
            sum += nums;
        }
        return sum;
    }

    private static String evenAndOdds(int[] array){
        int evens = 0;
        int odds = 0;
        for(int nums : array){
            if(nums % 2 == 0){
                evens++;
            }
            else{
                odds++;
            }
        }
        return "There are " + evens + " even numbers and " + odds + " odd numbers";
    }

    private static void findXthBiggestNumber(int biggest,int[] array){
        if(biggest >= array.length || array.length <1){
            System.out.println("Array empty or too short");
        }
        for(int i = 1; i < array.length ;i++){
            int temp = array[i];
            int j = i -1;

            while(j >= 0 && array[j] > temp){
                array[j+1]  = array[j];
                j--;
            }
            array[j+1] = temp;

        }
        System.out.println(Arrays.toString(array));

        System.out.println( biggest + " number is : " + array[biggest -1]);

    }
}
