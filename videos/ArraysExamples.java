package videos;

import java.util.Arrays;
import java.util.Random;

public class ArraysExamples {
    /* the declaration of an array
    array structure is : datatype[] name = new datatype[length of array we want]; the declared length is fixed
                         THIS DATA TYPE  ==   THIS DATA TYPE arrays can only return the same data type
   example
   int[] lottoTicket = new int[6];
   this creates an array of integers called lottoTicket that holds 6 elements (index 0-5)
     */

    private static final int LENGTH = 6; //LENGTH is in all caps meaning we've declared it as a constant variable
    private static final int MAXTICKETNUMBER = 25;
    public static void main(String[] args) {

        int[] ticket = generateNumbers();
        Arrays.sort(ticket);
        printTicket(ticket);
    }

    public static int[] generateNumbers() {
        int[] ticket = new int[LENGTH];
        Random random = new Random();
        for (int i=0; i<LENGTH; i++) {
            int randomNumber;

            /* generate a random number and search the array of ticket
            to make sure that number does not duplicate
             */
            do {
                randomNumber = random.nextInt(MAXTICKETNUMBER) + 1;
            } while(search(ticket, randomNumber))

                ticket[i] = randomNumber; //this number will be unique once we get here. dd it to the array.
        }
        return ticket;
    }

    public static boolean search(int[] array, int numberToSearchFor){
        for (int value : array) {
            if (value == numberToSearchFor) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] array, int numberToSearchFor) {
        Arrays.sort(array);

        int index = Arrays.binarySearch(array, numberToSearchFor);
        if (index >= 0){
            return true;
        }
        else return false;
    }

    public static void printTicket(int ticket[]) {
        for (int i=0; i<LENGTH; i++) {
            System.out.print(ticket[i] + " | ");
        }
    }
}
