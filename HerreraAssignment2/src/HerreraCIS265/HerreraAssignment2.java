package HerreraCIS265;

import java.util.Scanner;

/**
 * This program stores the information of n number of students in an array, of length n, of Student objects.
 * It is used to test the creation of Students objects and storing the pointers in an array.
 * This program includes the Bonus Feature
 * @author Carlos Herrera
 * @version 2.0
 */
public class HerreraAssignment2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //Declaring the scanner object to get the input from the user
        int numStudents = 0;
        boolean correctAmount = false; //Flag variable to verify the correct amount of students is being entered
        boolean differentId = true;

        System.out.println("Welcome to the student management system!"); //A warming welcome message :)

        //Creating the array
        do { //Getting the number of students to create the array
            System.out.println("Please, tell me how many students do yo have (1-10): ");
            numStudents = scan.nextInt();

            if (numStudents < 1 || numStudents > 10){ //Verifying if the amount of students is on the range
                System.out.println("I cannot create "+numStudents+" students!!");
            }else{
                correctAmount = true;
            }
        }while (!correctAmount);

        //Creating the array that will allocate the students information
        Student[] students = new Student[numStudents];

        //Populating the array
        for (int i = 0; i < students.length; i++){
            //Creating variables inside for to delete them after completing the loop (since they are temporary).
            String tempName;
            int tempId = 0;
            double tempGPA;

            System.out.print("Student "+(i+1)+" name: ");
            tempName= scan.next();

            //After the first student the program will check if there is any duplicate ID to reject it
            if (i == 0){
                System.out.print("Student "+(i+1)+" ID: ");
                tempId = scan.nextInt();
            }else{
                do {
                    System.out.print("Student "+(i+1)+" ID: ");
                    tempId = scan.nextInt();
                }while (checkIdIsRepeated(students, tempId, i));
            }

            System.out.print("Student "+(i+1)+" GPA: ");
            tempGPA = scan.nextDouble();

            students[i] = new Student(tempName,tempId,tempGPA); //Allocating their information in different objects inside the array
        }

        //Creating the linear search until the user inputs 0 as ID
        //Variables used to do the linear search
        int enteredId;
        boolean flag = true;

        while (flag){
            System.out.println("Enter a student ID (Enter 0 to quit): ");
            enteredId = scan.nextInt();

            if (enteredId == 0){ //If 0 is typed, the flag changes to false and exits the while
                flag = false;
            }else{
                linearSearch(students, enteredId);
            }
        }

        System.out.println("Goodbye!"); //The program is terminated
    }


    /**
     * This method does a linear search on the array of students (until the actual last value) to check if a certain ID was already typed before
     * @param student The array that contains the information of all the students objects
     * @param id The ID that was just enetered by the user to check if it's repetied
     * @param actualLength is the index of the last location with a value. (i.e. students[actualLength])
     */
    public static boolean checkIdIsRepeated(Student[] student, int id, int actualLength){
        boolean flag = true; //Meaning that it is repeated

        for (int i = 0; i < actualLength; i++){
            if (id == student[i].getId()){
                System.out.println("Student ID: "+id+" already exists! Please retry!");
                return true;
            }else{
                flag = false;
            }
        }
        return flag;
    }

    /**
     * This method does a linear search on the array of students
     * @param student The array that contains the information of all the students objects
     * @param id The ID that the user is looking for
     */
    public static void linearSearch(Student[] student, int id){
        boolean flag = false;
        for (Student actualStudent: student){
            if (actualStudent.getId() == id){
                actualStudent.printStudent();
                flag = true;
                break;
            }
        }

        if (flag == false){
            System.out.println("Student ID"+id+" not found.");
        }

    }
}