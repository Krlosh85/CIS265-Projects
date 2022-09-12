package hw01;

import java.util.Scanner;

/**
 * This program prompts the user to input any number from 0-100, and calculates the min, max, and avg
 * It stops until the user enters -1
 * @author Carlos Herrera
 * @version 1.0
 */
public class HerreraAssignment1 {
    public static void main(String[] args) {
        //Declaring and initializing all the variables required to get the number entered, min, max, and avg
        int counter = 0, max = 0, numEntered = 0, sum = 0;
        //Using min as 100 since the exercise provides a range where the biggest number is 100. So we can see which numbers are less than 100 and compare.
        int min = 100;
        double avg = 0.0;

        //Initializing the object scanner to get an input from the User
        Scanner scan = new Scanner(System.in);

        //Using a while loop to keep asking the user until -1 is typed
        while (numEntered != -1){
            System.out.println("Please input an integer 0-100 (-1 to stop): ");
            numEntered = scan.nextInt();

            //Checking if the first entered digit from the sequence is -1, if so, stop the program.
            if (counter == 0 && numEntered == -1){
                System.out.println("Good bye!!");
                System.exit(0);
            }

            //Evaluating if the num is -1 to break
            if (numEntered == -1){
                break;
            }else if (numEntered < 0 || numEntered > 100){ //Validating if the number is in the range (Non-negative and less than 101)
                System.out.println(numEntered+" is not a valid input.");
            }else{

                //Max
                //Evaluating if the number entered is bigger than the actual maximum to get the maximum value
                if (numEntered > max){
                    max = numEntered;
                }

                //Min
                //Evaluating if the number entered is bigger than the actual min to get the min value
                if (min > numEntered){
                    min = numEntered;
                }

                //Sum
                //Adding the numbers to a global variable, so we can use it later to calculate the avg
                sum += numEntered;

                //Adding one to the counter to keep track of the amount of numbers typed by the user
                counter++;
            }
        }

        //Getting the Avg and converting to double to make sure it doesn't drop the decimal
        avg = (double) (sum/counter);

        //Printing all the calculated values
        System.out.println("The minimum is: "+ min);
        System.out.println("The maximum value is: "+max);
        System.out.println("The average value is: "+avg);

    }
}
